package org.hiedacamellia.whispergrove.core.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, WhisperGrove.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("tooltip.whispergrove.press_shift","Press Shift to display more information");
        add("mod.whispergrove", "Whisper Grove");
        add("itemGroup.whispergrove", "Whisper Grove");
        add("item.whispergrove.test_item", "Test Item");
        add("tooltip.whispergrove.test_item", "This is a test item");
        add("block.whispergrove.test_block", "Example Block");
        add("tooltip.whispergrove.test_block", "This is an example block");
        add("network.whispergrove.failed","Failed to handle network data: %s");
    }
}
