package org.hiedacamellia.whispergrove.core.codec.record;

import com.mojang.serialization.Codec;
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
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.List;
import java.util.Map;

public record NameMap(List<Map<List<String>, String>> nameMap) implements CustomPacketPayload {
    public void sync(Player player){
        if (player instanceof ServerPlayer serverPlayer)
            PacketDistributor.sendToPlayer(serverPlayer, new NameMap(this.nameMap));
    }

    public static final CustomPacketPayload.Type<NameMap> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "namemap"));


    @Override
    public CustomPacketPayload.@NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handleData(final NameMap data, final IPayloadContext context) {
        context.enqueueWork(() -> {
                    context.player().setData(WGAttachment.NAMEMAP, data);
                })
                .exceptionally(e -> {
                    context.disconnect(Component.translatable("network.whispergrove.failed", e.getMessage()));
                    return null;
                });
    }

    public static final StreamCodec<ByteBuf, NameMap> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.unboundedMap(Codec.list(Codec.STRING), Codec.STRING))),
            NameMap::nameMap,
            NameMap::new
    );

    public String matchName(List<String> key) {
        for (Map<List<String>, String> map : nameMap()) {
            if (map.containsKey(key)) {
                return map.get(key);
            }
        }
        return null;
    }

    public void addName(List<String> key, String value) {
        nameMap().add(Map.of(key, value));
    }

    public void rename(List<String> key, String value) {
        for (Map<List<String>, String> map : nameMap()) {
            if (map.containsKey(key)) {
                map.put(key, value);
            }
        }
    }
}
