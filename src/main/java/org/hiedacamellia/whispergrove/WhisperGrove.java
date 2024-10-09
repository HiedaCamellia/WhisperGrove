package org.hiedacamellia.whispergrove;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.event.WGEvent;
import org.hiedacamellia.whispergrove.registers.*;

import java.util.Locale;

@Mod(WhisperGrove.MODID)
public class WhisperGrove {

    public static final String MODID = "whispergrove";

    public WhisperGrove(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(WGEvent::onCommonSetup);

        WGBlock.BLOCKS.register(modEventBus);
        WGItem.ITEMS.register(modEventBus);
        WGBlockItem.ITEMS.register(modEventBus);
        WGTab.TABS.register(modEventBus);
        WGAttachment.ATTACHMENTS.register(modEventBus);
        WGDataComponent.DATA_COMPONENTS.register(modEventBus);
        WGEffect.EFFECTS.register(modEventBus);
        WGMenu.MENUS.register(modEventBus);
        WGRicipe.RECIPE_TYPES.register(modEventBus);
        WGRicipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
        WGBlockEntity.BLOCK_ENTITIES.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
        if(FMLLoader.getDist().isClient())
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }

}