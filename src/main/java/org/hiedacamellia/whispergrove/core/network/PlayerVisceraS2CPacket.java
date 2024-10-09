package org.hiedacamellia.whispergrove.core.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.components.Viscera;

public record PlayerVisceraS2CPacket(ResourceLocation name, Double yin, Double yang,Double ping) implements CustomPacketPayload {

    public static final Type<PlayerVisceraS2CPacket> TYPE = new Type<>(WhisperGrove.prefix("network.viscera"));
    public static final StreamCodec<ByteBuf, PlayerVisceraS2CPacket> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC, PlayerVisceraS2CPacket::name,
            ByteBufCodecs.DOUBLE, PlayerVisceraS2CPacket::yin,
            ByteBufCodecs.DOUBLE, PlayerVisceraS2CPacket::yang,
            ByteBufCodecs.DOUBLE, PlayerVisceraS2CPacket::ping,
            PlayerVisceraS2CPacket::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    @SuppressWarnings("unchecked")
    public static void handleData(PlayerVisceraS2CPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            AttachmentType<Viscera> type = (AttachmentType<Viscera>) NeoForgeRegistries.ATTACHMENT_TYPES.get(packet.name);
            if (type != null) {
                context.player().setData(type, new Viscera(packet.name, packet.yin, packet.yang, packet.ping));
            }
        });
    }

}