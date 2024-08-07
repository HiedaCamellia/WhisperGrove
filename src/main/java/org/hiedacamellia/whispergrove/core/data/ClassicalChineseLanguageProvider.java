package org.hiedacamellia.whispergrove.core.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class ClassicalChineseLanguageProvider extends LanguageProvider {

    public ClassicalChineseLanguageProvider(PackOutput output) {
        super(output, WhisperGrove.MODID, "lzh");
    }

    @Override
    protected void addTranslations() {
        add("tooltip.whispergrove.press_shift","按住變鍵以示詳情。");
        add("itemGroup.whispergrove", "淺草輕語");
    }
}
