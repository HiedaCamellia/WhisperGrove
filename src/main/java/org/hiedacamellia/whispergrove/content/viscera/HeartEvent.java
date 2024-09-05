package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.codec.record.Heart;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGEffect;

public class HeartEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.HEART)) {
            return;
        }

        Heart heart = player.getData(WGAttachment.HEART);
        double diff = heart.yang() / heart.yin();

        float score = (float) ((heart.yang()+ heart.yin())/100.0);

        player.setHealth(score);



        player.removeEffect(WGEffect.HEART_HYPERACTIVITY);
        player.removeEffect(WGEffect.HEART_DETERIORATED);

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.HEART_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.HEART_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.HEART_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.HEART_DETERIORATED, 300 , 0));
            return;
        }
    }

    public String getdesc(Player player) {
        if (!player.hasData(WGAttachment.HEART)) {
            return "";
        }
        Heart heart = player.getData(WGAttachment.HEART);
        double diff = heart.yang() - heart.yin();
        if (diff >= 60.0) {

            return Component.translatable("desc.whispergrove.heart.hyperactivity.level.2").getString();
        }
        if (diff >= 30.0) {

            return Component.translatable("desc.whispergrove.heart.hyperactivity.level.1").getString();
        }
        if (diff <= -60.0) {

            return Component.translatable("desc.whispergrove.heart.deteriorated.level.2").getString();
        }
        if (diff <= -30.0) {

            return Component.translatable("desc.whispergrove.heart.deteriorated.level.1").getString();
        }

        return Component.translatable("desc.whispergrove.heart.normal").getString();
    }
}
