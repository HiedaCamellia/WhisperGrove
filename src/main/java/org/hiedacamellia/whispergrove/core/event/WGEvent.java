package org.hiedacamellia.whispergrove.core.event;


import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.hiedacamellia.whispergrove.core.debug.Debug;

@EventBusSubscriber
public class WGEvent {

    @SubscribeEvent
    public void onCommonSetup(final FMLCommonSetupEvent event) {
        Debug.getLogger().debug("Ciallo～(∠・ω< )⌒★");
    }
}
