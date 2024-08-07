package org.hiedacamellia.whispergrove.core.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.hiedacamellia.whispergrove.core.data.lang.ChineseLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.lang.ClassicalChineseLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.lang.EnglishLanguageProvider;
import org.hiedacamellia.whispergrove.core.data.provider.ModelProvider;
import org.hiedacamellia.whispergrove.core.data.provider.StateProvider;

public class Data {
    public static void onGatherData(GatherDataEvent event) {
        var gen = event.getGenerator();
        var packOutput = gen.getPackOutput();
        var helper = event.getExistingFileHelper();
        gen.addProvider(event.includeClient(), new EnglishLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ChineseLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ClassicalChineseLanguageProvider(packOutput));
        gen.addProvider(event.includeClient(), new ModelProvider(packOutput, helper));
        gen.addProvider(event.includeClient(), new StateProvider(packOutput, helper));
    }
}
