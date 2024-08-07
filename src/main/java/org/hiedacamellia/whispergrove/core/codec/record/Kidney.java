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

//肾
public record Kidney(Double yin, Double yang)implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new Kidney(this.yin, this.yang));
    }

    public static final CustomPacketPayload.Type<Kidney> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "kidney"));

    public static final StreamCodec<ByteBuf, Kidney> STREAM_CODEC = StreamCodec.of((ByteBuf buffer, Kidney message) -> {
        buffer.writeDouble(message.yin);
        buffer.writeDouble(message.yang);
    }, (ByteBuf buffer) -> {
        double yin = buffer.readDouble();
        double yang = buffer.readDouble();
        return new Kidney(yin, yang);
    });

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final Kidney data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(WGAttachment.KIDNEY, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.whispergrove.failed", e.getMessage()));
                    return null;
                });
    }
}
