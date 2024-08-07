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
        add("mod.whispergrove", "淺草輕語");
        add("itemGroup.whispergrove", "淺草輕語");
        add("item.whispergrove.test_item", "Test Item");
        add("tooltip.whispergrove.test_item", "This is a test item");
        add("block.whispergrove.test_block", "Example Block");
        add("tooltip.whispergrove.test_block", "This is an example block");
    }
}
