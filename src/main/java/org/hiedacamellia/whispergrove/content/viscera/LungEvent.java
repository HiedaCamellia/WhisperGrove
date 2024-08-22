package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.Config;
import org.hiedacamellia.whispergrove.core.codec.record.Lung;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

public class LungEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.LUNG)) {
            return;
        }

        Lung lung = player.getData(WGAttachment.LUNG);
        double diff = lung.yang() / lung.yin();

        player.removeEffect(WGEffect.LUNG_HYPERACTIVITY);
        player.removeEffect(WGEffect.LUNG_DETERIORATED);

        if (diff >= Config.DISEASE_CRITICAL.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_HYPERACTIVITY, 300 , 2));
            return;
        }
        if (diff >= Config.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= Config.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ Config.DISEASE_CRITICAL.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_DETERIORATED, 300 , 2));
            return;
        }
        if (diff <= 1/Config.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/Config.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.LUNG_DETERIORATED, 300 , 0));
            return;
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.LUNG)) {
            return "";
        }
        Lung lung = player.getData(WGAttachment.LUNG);
        double diff = lung.yang() - lung.yin();
        if (diff >= 100.0) {

            return Component.translatable("desc.whispergrove.lung.hyperactivity.level.3").getString();
        }
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.lung.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.lung.hyperactivity.level.1").getString();
        }
        if (diff <= -100.0) {

            return Component.translatable("desc.whispergrove.lung.deteriorated.level.3").getString();
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
