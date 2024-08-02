package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTabEntry {
    private final DeferredRegister<CreativeModeTab> creativeTabRegister;

    private String id;
    private CreativeModeTab.Builder builder;

    public CreativeTabEntry(DeferredRegister<CreativeModeTab> creativeTabRegister) {
        this.creativeTabRegister = creativeTabRegister;
    }

    public CreativeTabEntry id(String id) {
        this.id = id;
        return this;
    }

    public CreativeTabEntry builder(CreativeModeTab.Builder builder) {
        this.builder = builder;
        return this;
    }

    public CreativeTabEntry build() {
        creativeTabRegister.register(id, () -> builder.build());
        return this;
    }
}
