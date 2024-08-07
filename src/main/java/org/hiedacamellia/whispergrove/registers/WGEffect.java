package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.mobeffects.*;

public class WGEffect {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, WhisperGrove.MODID);

    public static final DeferredHolder<MobEffect, MobEffect> HEART_HYPERACTIVITY = EFFECTS.register("heart_hyperactivity", HeartHyperactivityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> HEART_DETERIORATED = EFFECTS.register("heart_deteriorated", HeartDeterioratedEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> KIDNEY_HYPERACTIVITY = EFFECTS.register("kidney_hyperactivity", KidneyHyperactivityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> KIDNEY_DETERIORATED = EFFECTS.register("kidney_deteriorated", KidneyDeterioratedEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> LIVER_HYPERACTIVITY = EFFECTS.register("liver_hyperactivity", LiverHyperactivityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> LIVER_DETERIORATED = EFFECTS.register("liver_deteriorated", LiverDeterioratedEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> LUNG_HYPERACTIVITY = EFFECTS.register("lung_hyperactivity", LungHyperactivityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> LUNG_DETERIORATED = EFFECTS.register("lung_deteriorated", LungDeterioratedEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> SPLEEN_HYPERACTIVITY = EFFECTS.register("spleen_hyperactivity", SpleenHyperactivityEffect::new);
    public static final DeferredHolder<MobEffect, MobEffect> SPLEEN_DETERIORATED = EFFECTS.register("spleen_deteriorated", SpleenDeterioratedEffect::new);

}
