package org.hiedacamellia.whispergrove.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.core.entry.WGTickableBlockEntity;

public record PlayerMenuS2SPacket(BlockPos pos, int tick) implements CustomPacketPayload {

    public static final Type<PlayerMenuS2SPacket> TYPE = new Type<>(WhisperGrove.prefix("network.tick"));
    public static final StreamCodec<ByteBuf, PlayerMenuS2SPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, PlayerMenuS2SPacket::pos,
            ByteBufCodecs.INT, PlayerMenuS2SPacket::tick,
            PlayerMenuS2SPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(PlayerMenuS2SPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level level = player.level();
            action(level, packet.pos(), packet.tick());
//            Debug.getLogger().debug("Sync Tick:{}", packet.tick());
        });
    }

    public static void action(Level level, BlockPos pos, int tick) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof WGTickableBlockEntity wgTickableBlockEntity) {
            wgTickableBlockEntity.setTickCount(tick);
        }
    }
}
