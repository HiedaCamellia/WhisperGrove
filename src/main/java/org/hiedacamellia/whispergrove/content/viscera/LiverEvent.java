package org.hiedacamellia.whispergrove.content.viscera;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.core.codec.record.Liver;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

public class LiverEvent {

    public static void Check(Player player) {
        if (!player.hasData(WGAttachment.LIVER)) {
            return;
        }

        Liver liver = player.getData(WGAttachment.LIVER);
        double diff = liver.yang() - liver.yin();
        if (diff >= 100.0) {

            return;
        }
        if (diff >= 60.0) {

            return;
        }
        if (diff >= 30.0) {

            return;
        }
        if (diff <= -100.0) {

            return;
        }
        if (diff <= -60.0) {

            return;
        }
        if (diff <= -30.0) {

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
