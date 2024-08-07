package org.hiedacamellia.whispergrove.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.jetbrains.annotations.NotNull;

//心
public record Heart(Double yin, Double yang) implements CustomPacketPayload {

    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new Heart(this.yin, this.yang));
    }

    public static final CustomPacketPayload.Type<Heart> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "heart"));

    public static final StreamCodec<ByteBuf, Heart> STREAM_CODEC = StreamCodec.of((ByteBuf buffer, Heart message) -> {
        buffer.writeDouble(message.yin);
        buffer.writeDouble(message.yang);
    }, (ByteBuf buffer) -> {
        double yin = buffer.readDouble();
        double yang = buffer.readDouble();
        return new Heart(yin, yang);
    });

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
