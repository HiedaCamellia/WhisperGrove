package org.hiedacamellia.whispergrove.content.common.mobeffects;

import net.minecraft.world.effect.MobEffectCategory;
import org.hiedacamellia.whispergrove.core.entry.BaseEffect;

public class SpleenDeterioratedEffect extends BaseEffect {
    public SpleenDeterioratedEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00, "effect.whispergrove.spleen.hyperactivity");
    }
}
