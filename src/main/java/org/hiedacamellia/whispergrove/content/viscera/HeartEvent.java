package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentInternals;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Heart;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeartEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.HEART)) {
            return;
        }

        Heart heart = player.getData(WGAttachment.HEART);
        double diff = heart.yang() / heart.yin();

        AttributeInstance attributeInstance = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.MAX_HEALTH));
        attributeInstance.addOrReplacePermanentModifier(new AttributeModifier(WhisperGrove.prefix("heart"), ((heart.yang()+ heart.yin())/100-20), AttributeModifier.Operation.ADD_VALUE));

        player.removeEffect(WGEffect.HEART_HYPERACTIVITY);
        player.removeEffect(WGEffect.HEART_DETERIORATED);

        AttributeInstance speed = Objects.requireNonNull(player.getAttributes().getInstance(Attributes.MOVEMENT_SPEED));

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.sleepCounter = 0;
            speed.removeModifier(WhisperGrove.prefix("speed"));
            player.addEffect(new MobEffectInstance(WGEffect.HEART_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            speed.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("speed"), 1.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.HEART_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            player.hurt(player.damageSources().wither(),0.5F);
            speed.removeModifier(WhisperGrove.prefix("speed"));
            player.addEffect(new MobEffectInstance(WGEffect.HEART_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            speed.addOrUpdateTransientModifier(new AttributeModifier(WhisperGrove.prefix("speed"), 0.75, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            player.addEffect(new MobEffectInstance(WGEffect.HEART_DETERIORATED, 300 , 0));
            return;
        }
    }

    public static Component getdesc(Player player) {
        if (!player.hasData(WGAttachment.HEART)) {
            return Component.empty();
        }
        Heart heart = player.getData(WGAttachment.HEART);
        double diff = heart.yang() / heart.yin();
        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {

            return Component.translatable("desc.whispergrove.heart.hyperactivity.level.2");
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {

            return Component.translatable("desc.whispergrove.heart.hyperactivity.level.1");
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {

            return Component.translatable("desc.whispergrove.heart.deteriorated.level.2");
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {

            return Component.translatable("desc.whispergrove.heart.deteriorated.level.1");
        }

        return Component.translatable("desc.whispergrove.heart.normal");
    }

    public static List<Component> getHover(Player player) {
        if (!player.hasData(WGAttachment.HEART)) {
            return List.of();
        }
        Heart heart = player.getData(WGAttachment.HEART);

        List<Component> raw = new ArrayList<>();

        raw.add(Component.translatable("viscera.whispergrove.hover.yin", heart.yin()));
        raw.add(Component.translatable("viscera.whispergrove.hover.yang", heart.yang()));

        return raw;
    }
}
