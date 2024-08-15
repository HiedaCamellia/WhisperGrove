package org.hiedacamellia.whispergrove.core.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.hiedacamellia.whispergrove.core.codec.record.*;

public class WGCodec {
    public static final Codec<Heart> HEART_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Heart::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Heart::yang)
            ).apply(instance, Heart::new)
    );
    public static final StreamCodec<ByteBuf, Heart> HEART_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Heart::yin,
            ByteBufCodecs.DOUBLE, Heart::yang,
            Heart::new
    );

    public static final Codec<Kidney> KIDNEY_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Kidney::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Kidney::yang)
            ).apply(instance, Kidney::new)
    );
    public static final StreamCodec<ByteBuf, Kidney> KIDNEY_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Kidney::yin,
            ByteBufCodecs.DOUBLE, Kidney::yang,
            Kidney::new
    );


    public static final Codec<Liver> LIVER_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Liver::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Liver::yang)
            ).apply(instance, Liver::new)
    );
    public static final StreamCodec<ByteBuf, Liver> LIVER_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Liver::yin,
            ByteBufCodecs.DOUBLE, Liver::yang,
            Liver::new
    );

    public static final Codec<Lung> LUNG_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Lung::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Lung::yang)
            ).apply(instance, Lung::new)
    );
    public static final StreamCodec<ByteBuf, Lung> LUNG_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Lung::yin,
            ByteBufCodecs.DOUBLE, Lung::yang,
            Lung::new
    );

    public static final Codec<Spleen> SPLEEN_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Spleen::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Spleen::yang)
            ).apply(instance, Spleen::new)
    );
    public static final StreamCodec<ByteBuf, Spleen> SPLEEN_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.DOUBLE, Spleen::yin,
            ByteBufCodecs.DOUBLE, Spleen::yang,
            Spleen::new
    );

    public static final Codec<Refresh> REFRESH_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.INT.fieldOf("tick").forGetter(Refresh::tick)
            ).apply(instance, Refresh::new)
    );
    public static final StreamCodec<ByteBuf, Refresh> REFRESH_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, Refresh::tick,
            Refresh::new
    );

    public static final Codec<NameMap> NAMEMAP_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.list(Codec.unboundedMap(Codec.list(Codec.STRING), Codec.STRING)).fieldOf("nameMap").forGetter(NameMap::nameMap)
            ).apply(instance, NameMap::new)
    );
    public static final StreamCodec<ByteBuf, NameMap> NAMEMAP_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.fromCodec(Codec.list(Codec.unboundedMap(Codec.list(Codec.STRING), Codec.STRING))),
            NameMap::nameMap,
            NameMap::new
    );
}
