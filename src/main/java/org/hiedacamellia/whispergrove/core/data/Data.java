package org.hiedacamellia.whispergrove.core.data;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.*;
import org.hiedacamellia.whispergrove.core.data.provider.*;

@EventBusSubscriber(modid = WhisperGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Data {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        var lookupProvider = event.getLookupProvider();
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ClassicalChineseLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new WGItemModelProvider(packOutput, helper));
        gen.addProvider(event.includeClient(), new WGBlockStateProvider(packOutput, helper));
        gen.addProvider(event.includeServer(), new WGRecipeProvider(packOutput, lookupProvider));
        gen.addProvider(event.includeServer(), new WGDataPackProvider(packOutput, lookupProvider));
        //gen.addProvider(event.includeClient(), new WGLootTableProvider(packOutput, lookupProvider));
    }

}
