package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundEntry {
    private final DeferredRegister<SoundEvent> soundRegister;
    private final String modId;

    private String name;
    private DeferredHolder<SoundEvent,? extends SoundEvent> soundObject;

    public SoundEntry(DeferredRegister<SoundEvent> soundRegister, String modId) {
        this.soundRegister = soundRegister;
        this.modId = modId;
    }

    public SoundEntry name(String name) {
        this.name = name;
        return this;
    }

    public SoundEntry build() {
        this.soundObject = soundRegister.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(modId, name)));
        return this;
    }

    public SoundEvent get() {
        return soundObject.get();
    }

}
