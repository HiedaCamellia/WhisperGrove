package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.codec.WGCodec;
import org.hiedacamellia.whispergrove.core.codec.record.*;

public class WGDataComponent {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(WhisperGrove.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Heart>> HEART = DATA_COMPONENTS.registerComponentType(
            "heart",
            builder -> builder
                    .persistent(WGCodec.HEART_CODEC)
                    .networkSynchronized(WGCodec.HEART_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Kidney>> KIDNEY = DATA_COMPONENTS.registerComponentType(
            "kidney",
            builder -> builder
                    .persistent(WGCodec.KIDNEY_CODEC)
                    .networkSynchronized(WGCodec.KIDNEY_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Liver>> LIVER = DATA_COMPONENTS.registerComponentType(
            "liver",
            builder -> builder
                    .persistent(WGCodec.LIVER_CODEC)
                    .networkSynchronized(WGCodec.LIVER_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Lung>> LUNG = DATA_COMPONENTS.registerComponentType(
            "lung",
            builder -> builder
                    .persistent(WGCodec.LUNG_CODEC)
                    .networkSynchronized(WGCodec.LUNG_STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Spleen>> SPLEEN = DATA_COMPONENTS.registerComponentType(
            "spleen",
            builder -> builder
                    .persistent(WGCodec.SPLEEN_CODEC)
                    .networkSynchronized(WGCodec.SPLEEN_STREAM_CODEC)
    );
}
