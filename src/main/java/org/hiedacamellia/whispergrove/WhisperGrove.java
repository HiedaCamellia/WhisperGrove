package org.hiedacamellia.whispergrove;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.hiedacamellia.whispergrove.core.data.Data;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.registers.*;


@Mod(WhisperGrove.MODID)
public class WhisperGrove {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "whispergrove";

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public WhisperGrove(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(Data::onGatherData);

        WGBlock.BLOCKS.register(modEventBus);
        WGBlockItem.ITEMS.register(modEventBus);
        WGItem.ITEMS.register(modEventBus);
        WGTab.TABS.register(modEventBus);
        WGAttachment.ATTACHMENTS.register(modEventBus);
        WGDataComponent.DATA_COMPONENTS.register(modEventBus);
        WGEffect.EFFECTS.register(modEventBus);
        WGMenu.MENUS.register(modEventBus);


        NeoForge.EVENT_BUS.register(this);


        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        Debug.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            Debug.info("HELLO FROM CLIENT SETUP");
            Debug.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
