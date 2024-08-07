package org.hiedacamellia.whispergrove.content.common.mobeffects;

import net.minecraft.world.effect.MobEffectCategory;
import org.hiedacamellia.whispergrove.core.entry.BaseEffect;

public class KidneyDeterioratedEffect extends BaseEffect {
    public KidneyDeterioratedEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00, "effect.whispergrove.kidney.hyperactivity");
    }
}
