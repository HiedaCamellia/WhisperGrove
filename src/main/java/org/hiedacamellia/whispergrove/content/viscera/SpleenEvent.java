package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.Config;
import org.hiedacamellia.whispergrove.core.codec.record.Spleen;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

public class SpleenEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.SPLEEN)) {
            return;
        }

        Spleen spleen = player.getData(WGAttachment.SPLEEN);
        double diff = spleen.yang() / spleen.yin();

        player.removeEffect(WGEffect.SPLEEN_HYPERACTIVITY);
        player.removeEffect(WGEffect.SPLEEN_DETERIORATED);

        if (diff >= Config.diseaseCritical) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 2));
            return;
        }
        if (diff >= Config.diseaseModerate) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= Config.diseaseMild) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ Config.diseaseCritical) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_DETERIORATED, 300 , 2));
            return;
        }
        if (diff <= 1/Config.diseaseModerate) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/Config.diseaseMild) {
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
        if (diff >= 100.0) {

            return Component.translatable("desc.whispergrove.spleen.hyperactivity.level.3").getString();
        }
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.spleen.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.spleen.hyperactivity.level.1").getString();
        }
        if (diff <= -100.0) {

            return Component.translatable("desc.whispergrove.spleen.deteriorated.level.3").getString();
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
