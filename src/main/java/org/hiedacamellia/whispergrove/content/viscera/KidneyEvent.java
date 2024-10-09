package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Kidney;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

import java.util.Objects;

public class KidneyEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.KIDNEY)) {
            return;
        }

        Kidney kidney = player.getData(WGAttachment.KIDNEY);
        double diff = kidney.yang() / kidney.yin();

        AttributeInstance attributeInstance = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.ATTACK_DAMAGE));
        attributeInstance.addOrReplacePermanentModifier(new AttributeModifier(WhisperGrove.prefix("kidney"), (kidney.yang() + kidney.yin())/2000, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        AttributeInstance attackSpeed = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.ATTACK_SPEED));

        player.removeEffect(WGEffect.KIDNEY_HYPERACTIVITY);
        player.removeEffect(WGEffect.KIDNEY_DETERIORATED);

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.sleepCounter = 0;
            attributeInstance.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_kidney"), 0.8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.KIDNEY_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            attributeInstance.removeModifier(WhisperGrove.prefix("attack_kidney"));
            attackSpeed.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_speed_kidney"), 1.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.KIDNEY_HYPERACTIVITY, 300 , 0));
            return;
        }else {
            attackSpeed.removeModifier(WhisperGrove.prefix("attack_speed_kidney"));
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            player.hurt(player.damageSources().wither(),0.5F);
            attributeInstance.removeModifier(WhisperGrove.prefix("attack_kidney"));
            player.addEffect(new MobEffectInstance(WGEffect.KIDNEY_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            attributeInstance.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_kidney"), 0.8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.KIDNEY_DETERIORATED, 300 , 0));
            return;
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.KIDNEY)) {
            return "";
        }
        Kidney kidney = player.getData(WGAttachment.KIDNEY);
        double diff = kidney.yang() - kidney.yin();
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.kidney.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.kidney.hyperactivity.level.1").getString();
        }
        if (diff <= -60.0) {

            return Component.translatable("desc.whispergrove.kidney.deteriorated.level.2").getString();
        }
        if (diff <= -30.0) {

            return Component.translatable("desc.whispergrove.kidney.deteriorated.level.1").getString();
        }

        return Component.translatable("desc.whispergrove.kidney.normal").getString();
    }
}
