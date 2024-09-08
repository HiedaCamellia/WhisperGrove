package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
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


        player.removeEffect(WGEffect.SPLEEN_HYPERACTIVITY);
        player.removeEffect(WGEffect.SPLEEN_DETERIORATED);

        if (diff >= CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 1));
            return;
        }
        if (diff >= CommonConfig.DISEASE_MILD.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_HYPERACTIVITY, 300 , 0));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MODERATE.get()) {
            player.addEffect(new MobEffectInstance(WGEffect.SPLEEN_DETERIORATED, 300 , 1));
            return;
        }
        if (diff <= 1/ CommonConfig.DISEASE_MILD.get()) {
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
