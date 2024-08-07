package org.hiedacamellia.whispergrove.core.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

public class WGPlayerEvent {

    @EventBusSubscriber
    public static class EventBusVariableHandlers {

        @SubscribeEvent
        public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            if (event.isWasDeath()){
                if (event.getOriginal().hasData(WGAttachment.HEART)) {
                    Heart heart = event.getOriginal().getData(WGAttachment.HEART);
                    event.getEntity().setData(WGAttachment.HEART, heart);
                }
                if (event.getOriginal().hasData(WGAttachment.KIDNEY)) {
                    Kidney kidney = event.getOriginal().getData(WGAttachment.KIDNEY);
                    event.getEntity().setData(WGAttachment.KIDNEY, kidney);
                }
                if (event.getOriginal().hasData(WGAttachment.LUNG)) {
                    Lung lung = event.getOriginal().getData(WGAttachment.LUNG);
                    event.getEntity().setData(WGAttachment.LUNG, lung);
                }
                if (event.getOriginal().hasData(WGAttachment.LIVER)) {
                    Liver liver = event.getOriginal().getData(WGAttachment.LIVER);
                    event.getEntity().setData(WGAttachment.LIVER, liver);
                }
                if (event.getOriginal().hasData(WGAttachment.SPLEEN)) {
                    Spleen spleen = event.getOriginal().getData(WGAttachment.SPLEEN);
                    event.getEntity().setData(WGAttachment.SPLEEN, spleen);
                }
            }
        }

        @SubscribeEvent
        public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            if(!event.getEntity().hasData(WGAttachment.HEART)){
                event.getEntity().setData(WGAttachment.HEART,new Heart(100.0,100.0));
            }
            if(!event.getEntity().hasData(WGAttachment.KIDNEY)){
                event.getEntity().setData(WGAttachment.KIDNEY,new Kidney(100.0,100.0));
            }
            if(!event.getEntity().hasData(WGAttachment.LUNG)){
                event.getEntity().setData(WGAttachment.LUNG,new Lung(100.0,100.0));
            }
            if(!event.getEntity().hasData(WGAttachment.LIVER)){
                event.getEntity().setData(WGAttachment.LIVER,new Liver(100.0,100.0));
            }
            if(!event.getEntity().hasData(WGAttachment.SPLEEN)){
                event.getEntity().setData(WGAttachment.SPLEEN,new Spleen(100.0,100.0));
            }
        }

        @SubscribeEvent
        public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {

        }
    }
}
