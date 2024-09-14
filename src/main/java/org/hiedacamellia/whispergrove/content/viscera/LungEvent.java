package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Lung;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

import java.util.Objects;

@EventBusSubscriber(modid = WhisperGrove.MODID)
public class LungEvent {

    private static float a=1.0F;

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.LUNG)) {
            return;
        }

        Lung lung = player.getData(WGAttachment.LUNG);
        double diff = lung.yang() / lung.yin();

        player.removeEffect(WGEffect.LUNG_HYPERACTIVITY);
        player.removeEffect(WGEffect.LUNG_DETERIORATED);

        AttributeInstance attack = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.ATTACK_DAMAGE));

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            a=1.0f;
            attack.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack"), 0.4, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            a=1.0f;
            attack.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack"), 0.8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            a=0.8f;
            attack.removeModifier(WhisperGrove.prefix("attack"));
            player.hurt(player.damageSources().inFire(),0.5F);
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            a=0.8f;
            attack.removeModifier(WhisperGrove.prefix("attack"));
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_DETERIORATED, 300 , 0));
            return;
        }
    }

    @SubscribeEvent
    public static void onPlayerHeal(LivingHealEvent event) {
        LivingEntity entity = event.getEntity();
        if(entity instanceof Player player) {
            Lung lung = player.getData(WGAttachment.LUNG);
            event.setAmount((float) (event.getAmount() * (lung.yin() + lung.yang()) / 2000) * a);
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.LUNG)) {
            return "";
        }
        Lung lung = player.getData(WGAttachment.LUNG);
        double diff = lung.yang() - lung.yin();
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.lung.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.lung.hyperactivity.level.1").getString();
        }
        if (diff <= -60.0) {

            return Component.translatable("desc.whispergrove.lung.deteriorated.level.2").getString();
        }
        if (diff <= -30.0) {

            return Component.translatable("desc.whispergrove.lung.deteriorated.level.1").getString();
        }

        return Component.translatable("desc.whispergrove.lung.normal").getString();
    }
}
