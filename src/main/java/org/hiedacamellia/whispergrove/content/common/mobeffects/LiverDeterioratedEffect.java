package org.hiedacamellia.whispergrove.content.common.mobeffects;

import net.minecraft.world.effect.MobEffectCategory;
import org.hiedacamellia.whispergrove.core.entry.BaseEffect;

public class LiverDeterioratedEffect extends BaseEffect {
    public LiverDeterioratedEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00, "effect.whispergrove.liver.hyperactivity");
    }
}
