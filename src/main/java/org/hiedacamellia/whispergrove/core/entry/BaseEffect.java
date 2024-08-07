package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import org.jetbrains.annotations.NotNull;

public class BaseEffect extends MobEffect {

    private final String id;

    public BaseEffect(MobEffectCategory category, int color,String id) {
        super(category, color);
        this.id = id;
    }

    @Override
    public @NotNull String getDescriptionId() {
        return id;
    }
}
