package org.hiedacamellia.whispergrove.registers;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.screen.SpringingScreen;
import org.hiedacamellia.whispergrove.content.client.screen.VisceraScreen;

@EventBusSubscriber(modid = WhisperGrove.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WGScreen {

    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {
        event.register(WGMenu.VISCERA.get(), VisceraScreen::new);
        event.register(WGMenu.SPRINGING.get(), SpringingScreen::new);
    }

}