package org.hiedacamellia.whispergrove.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.jetbrains.annotations.NotNull;

//肺
public record Lung(Double yin, Double yang)implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new Lung(this.yin, this.yang));
    }

    public static final CustomPacketPayload.Type<Lung> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "lung"));

    public static final StreamCodec<ByteBuf, Lung> STREAM_CODEC = StreamCodec.of((ByteBuf buffer, Lung message) -> {
        buffer.writeDouble(message.yin);
        buffer.writeDouble(message.yang);
    }, (ByteBuf buffer) -> {
        double yin = buffer.readDouble();
        double yang = buffer.readDouble();
        return new Lung(yin, yang);
    });

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    public static void handleData(final Lung data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(WGAttachment.LUNG, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.whispergrove.failed", e.getMessage()));
                    return null;
                });
    }
}