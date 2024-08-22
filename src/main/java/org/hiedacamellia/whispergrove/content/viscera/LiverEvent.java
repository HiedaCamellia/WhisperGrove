package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.core.config.Config;
import org.hiedacamellia.whispergrove.core.codec.record.Liver;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

public class LiverEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return;
        }

        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() / liver.yin();

        player.removeEffect(WGEffect.LIVER_HYPERACTIVITY);
        player.removeEffect(WGEffect.LIVER_DETERIORATED);

        if (diff >= Config.DISEASE_CRITICAL.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 2));
            return;
        }
        if (diff >= Config.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= Config.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ Config.DISEASE_CRITICAL.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 2));
            return;
        }
        if (diff <= 1/Config.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/Config.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LIVER_DETERIORATED, 300 , 0));
            return;
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return "";
        }
        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() - liver.yin();
        if (diff >= 100.0) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.3").getString();
        }
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.liver.hyperactivity.level.1").getString();
        }
        if (diff <= -100.0) {

            return Component.translatable("desc.whispergrove.liver.deteriorated.level.3").getString();
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
