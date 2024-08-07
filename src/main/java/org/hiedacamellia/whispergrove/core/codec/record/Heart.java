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

//心
public record Heart(Double yin, Double yang) implements CustomPacketPayload {

    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new Heart(this.yin, this.yang));
    }

    public static final CustomPacketPayload.Type<Heart> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "heart"));

    public static final StreamCodec<ByteBuf, Heart> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE,
            Heart::yin,
            ByteBufCodecs.DOUBLE,
            Heart::yang,
            Heart::new
    );

    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final Heart data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(WGAttachment.HEART, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.whispergrove.failed", e.getMessage()));
                    return null;
                });
    }
}
