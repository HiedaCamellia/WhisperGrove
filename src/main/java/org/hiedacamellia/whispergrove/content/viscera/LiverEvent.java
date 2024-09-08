package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Liver;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

@EventBusSubscriber(modid = WhisperGrove.MODID)
public class LiverEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return;
        }

        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() / liver.yin();

        player.removeEffect(WGEffect.LIVER_HYPERACTIVITY);
        player.removeEffect(WGEffect.LIVER_DETERIORATED);

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 0));
            return;
        }
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent.Pre event) {
        LivingEntity entity = event.getEntity();
        DamageSource damageSource = event.getSource();
        if(entity instanceof Player player) {
            Liver liver = player.getData(WGAttachment.LIVER);
            float damage = (float) (event.getNewDamage() / (liver.yin() + liver.yang()) / 2000);
            if(damageSource.is(NeoForgeMod.POISON_DAMAGE))
                damage = (float) (damage / (liver.yin() + liver.yang()) / 2000);

            event.setNewDamage(damage);
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return "";
        }
        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() - liver.yin();
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.1").getString();
        }
        if (diff <= -60.0) {

            return Component.translatable("desc.whispergrove.liver.deteriorated.level.2").getString();
        }
        if (diff <= -30.0) {

            return Component.translatable("desc.whispergrove.liver.deteriorated.level.1").getString();
        }

        return Component.translatable("desc.whispergrove.liver.normal").getString();
    }
}
