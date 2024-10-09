package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.fml.common.EventBusSubscriber;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Spleen;
import org.hiedacamellia.whispergrove.core.interfaces.FoodDataAccessor;
import org.hiedacamellia.whispergrove.core.mixin.FoodDataMixin;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

import java.util.Objects;

public class SpleenEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.SPLEEN)) {
            return;
        }

        Spleen spleen = player.getData(WGAttachment.SPLEEN);
        double diff = spleen.yang() / spleen.yin();

        FoodDataAccessor foodDataAccessor =((FoodDataAccessor) player.getFoodData());
        foodDataAccessor.whisperGrove$setMaxFoodLevel(Mth.clamp((int) (spleen.yin() + spleen.yang())/100, 0, 20));
        foodDataAccessor.whisperGrove$setFoodEfficiency((float) ((spleen.yin() + spleen.yang())/2000));

        AttributeInstance attack = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.ATTACK_DAMAGE));

        player.removeEffect(WGEffect.SPLEEN_HYPERACTIVITY);
        player.removeEffect(WGEffect.SPLEEN_DETERIORATED);

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            attack.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_spleen"), 0.8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            attack.removeModifier(WhisperGrove.prefix("attack_spleen"));
            player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20 , 0));
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            attack.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_spleen"), 0.6, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            attack.removeModifier(WhisperGrove.prefix("attack_spleen"));
            foodDataAccessor.whisperGrove$setFoodEfficiency(foodDataAccessor.whisperGrove$getMaxFoodLevel()*1.5f);
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_DETERIORATED, 300 , 0));
            return;
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.SPLEEN)) {
            return "";
        }
        Spleen spleen = player.getData(WGAttachment.SPLEEN);
        double diff = spleen.yang() - spleen.yin();
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.spleen.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.spleen.hyperactivity.level.1").getString();
        }
        if (diff <= -60.0) {

            return Component.translatable("desc.whispergrove.spleen.deteriorated.level.2").getString();
        }
        if (diff <= -30.0) {

            return Component.translatable("desc.whispergrove.spleen.deteriorated.level.1").getString();
        }

        return Component.translatable("desc.whispergrove.spleen.normal").getString();
    }
}
