package org.hiedacamellia.whispergrove.core.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.hiedacamellia.whispergrove.core.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.lang.ClassicalChineseLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.lang.EnglishLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.provider.WGItemModelProvider;
import org.hiedacamellia.whispergrove.core.data.provider.WGBlockStateProvider;
import org.hiedacamellia.whispergrove.core.data.provider.WGLootTableProvider;
import org.hiedacamellia.whispergrove.core.data.provider.WGRecipeProvider;

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
        gen.addProvider(event.includeClient(),new WGLootTableProvider(packOutput, lookupProvider));
    }

}
