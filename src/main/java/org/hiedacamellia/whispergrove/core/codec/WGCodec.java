package org.hiedacamellia.whispergrove.core.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import org.hiedacamellia.whispergrove.core.codec.record.*;

public class WGCodec {
    public static final Codec<Heart> HEART_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Heart::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Heart::yang)
            ).apply(instance, Heart::new)
    );

    public static final Codec<Kidney> KIDNEY_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Kidney::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Kidney::yang)
            ).apply(instance, Kidney::new)
    );

    public static final Codec<Liver> LIVER_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Liver::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Liver::yang)
            ).apply(instance, Liver::new)
    );

    public static final Codec<Lung> LUNG_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Lung::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Lung::yang)
            ).apply(instance, Lung::new)
    );

    public static final Codec<Spleen> SPLEEN_CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.DOUBLE.fieldOf("yin").forGetter(Spleen::yin),
                    Codec.DOUBLE.fieldOf("yang").forGetter(Spleen::yang)
            ).apply(instance, Spleen::new)
    );
}
