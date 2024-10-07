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

public record PlayerMenuC2SPacket(BlockPos pos,int rtype,String name) implements CustomPacketPayload {

    public static final Type<PlayerMenuC2SPacket> TYPE = new Type<>(WhisperGrove.prefix("network.menu"));
    public static final StreamCodec<ByteBuf, PlayerMenuC2SPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, PlayerMenuC2SPacket::pos,
            ByteBufCodecs.INT, PlayerMenuC2SPacket::rtype,
            ByteBufCodecs.STRING_UTF8, PlayerMenuC2SPacket::name,
            PlayerMenuC2SPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(PlayerMenuC2SPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            Player player = context.player();
            Level level = player.level();
            if (level instanceof ServerLevel serverLevel) {
                action(serverLevel,packet.pos(), packet.rtype(), packet.name());
            }

        });
    }

    public static void action(Level level, BlockPos pos, int rtype, String name) {
        if (rtype == 0) {
            if(!level.isClientSide()) {
                BlockState blockState = level.getBlockState(pos);
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof WGTickableBlockEntity wgTickableBlockEntity) {
                    wgTickableBlockEntity.tryAssemble(blockState, level, name);
                    level.scheduleTick(pos, blockState.getBlock(), 1);
                }
            }
        }
    }
}
