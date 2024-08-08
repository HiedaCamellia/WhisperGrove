package org.hiedacamellia.whispergrove.content.common.mobeffects;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.hiedacamellia.whispergrove.core.entry.BaseEffect;

public class HeartDeterioratedEffect extends BaseEffect {
    public HeartDeterioratedEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00, "effect.whispergrove.heart.hyperactivity");
    }
}
