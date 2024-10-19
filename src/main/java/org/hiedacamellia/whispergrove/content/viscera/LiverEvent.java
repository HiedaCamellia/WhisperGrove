package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        AttributeInstance attack = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.ATTACK_DAMAGE));
        AttributeInstance breakSpeed = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.BLOCK_BREAK_SPEED));

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20 , 1));
            breakSpeed.removeModifier(WhisperGrove.prefix("break_speed_liver"));
            attack.removeModifier(WhisperGrove.prefix("attack_liver"));
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            breakSpeed.removeModifier(WhisperGrove.prefix("break_speed_liver"));
            attack.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("attack_liver"), 1.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            breakSpeed.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("break_speed_liver"), 0.8, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            attack.removeModifier(WhisperGrove.prefix("attack_liver"));
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            breakSpeed.removeModifier(WhisperGrove.prefix("break_speed_liver"));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 , 1));
            attack.removeModifier(WhisperGrove.prefix("attack_liver"));
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 0));
            return;
        }
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingDamageEvent.Pre event) {
        if(CommonConfig.LIVER_CONTENT.get()){
            LivingEntity entity = event.getEntity();
            DamageSource damageSource = event.getSource();
            if(entity instanceof Player player) {
                Liver liver = player.getData(WGAttachment.LIVER);
                float damage = (float) (event.getNewDamage() / ((liver.yin() + liver.yang()) / 2000));
                if(damageSource.is(NeoForgeMod.POISON_DAMAGE))
                    damage = (float) (damage / ((liver.yin() + liver.yang()) / 2000));

                event.setNewDamage(damage);
            }
        }
    }

    public static Component getdesc(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return Component.empty();
        }
        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() / liver.yin();
        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.2");
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.1");
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {

            return Component.translatable("desc.whispergrove.liver.deteriorated.level.2");
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {

            return Component.translatable("desc.whispergrove.liver.deteriorated.level.1");
        }

        return Component.translatable("desc.whispergrove.liver.normal");
    }
    public static List<Component> getHover(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return List.of();
        }
        Liver liver = player.getData(WGAttachment.LIVER);

        List<Component> raw = new ArrayList<>();

        raw.add(Component.translatable("viscera.whispergrove.hover.yin", liver.yin()));
        raw.add(Component.translatable("viscera.whispergrove.hover.yang", liver.yang()));

        return raw;
    }
}
