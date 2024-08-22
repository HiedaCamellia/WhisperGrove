package org.hiedacamellia.whispergrove.content.common.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

public record Viscera(ResourceLocation name, Double yin, Double yang) {

    public static final Codec<Viscera> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("name").forGetter(Viscera::name),
            Codec.DOUBLE.fieldOf("yin").forGetter(Viscera::yin),
            Codec.DOUBLE.fieldOf("yang").forGetter(Viscera::yang))
            .apply(instance, Viscera::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, Viscera> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC, Viscera::name,
            ByteBufCodecs.DOUBLE, Viscera::yin,
            ByteBufCodecs.DOUBLE, Viscera::yang, Viscera::new);

}