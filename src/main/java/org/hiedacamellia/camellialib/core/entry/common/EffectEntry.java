package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EffectEntry {
    private final DeferredRegister<MobEffect> effectRegister;

    private String id;
    private Supplier<MobEffect> effectSupplier;
    private DeferredHolder<MobEffect,? extends MobEffect> effectObject;

    public EffectEntry(DeferredRegister<MobEffect> effectRegister) {
        this.effectRegister = effectRegister;
    }

    public EffectEntry id(String id) {
        this.id = id;
        return this;
    }

    public EffectEntry bound(Supplier<MobEffect> effectSupplier) {
        this.effectSupplier = effectSupplier;
        return this;
    }

    public EffectEntry build() {
        this.effectObject = effectRegister.register(id, effectSupplier);
        return this;
    }

    public MobEffect get() {
        return effectObject.get();
    }

}
