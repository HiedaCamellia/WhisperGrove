package org.hiedacamellia.whispergrove.core.codec.record;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
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

//肝
public record Liver(Double yin, Double yang,Double ping)implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new Liver(this.yin, this.yang, this.ping));
    }
    public static final StreamCodec<ByteBuf, Liver> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Liver::yin,
            ByteBufCodecs.DOUBLE, Liver::yang,
            ByteBufCodecs.DOUBLE, Liver::ping,
            Liver::new);

    public static final CustomPacketPayload.Type<Liver> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "liver"));

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
    public static void handleData(final Liver data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(WGAttachment.LIVER, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.whispergrove.failed", e.getMessage()));
                    return null;
                });
    }
}
