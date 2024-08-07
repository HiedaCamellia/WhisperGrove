package org.hiedacamellia.whispergrove.core.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class ChineseLanguageProvider extends LanguageProvider {

        public ChineseLanguageProvider(PackOutput output) {
            super(output, WhisperGrove.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            add("tooltip.whispergrove.press_shift","按住Shift键以显示更多信息");
            add("mod.whispergrove", "浅草轻语");
            add("itemGroup.whispergrove", "浅草轻语");
            add("item.whispergrove.test_item", "Test Item");
            add("tooltip.whispergrove.test_item", "This is a test item");
            add("block.whispergrove.test_block", "Example Block");
            add("tooltip.whispergrove.test_block", "This is an example block");
            add("network.whispergrove.failed","无法处理网络数据: %s");
            add("cmd.whispergrove.modify.success","修改值成功：%f");
            add("cmd.whispergrove.modify.failed","修改值失败：%s");
            add("cmd.whispergrove.set.success","设置值成功：%f");
            add("cmd.whispergrove.set.failed","设置值失败：%s");
            add("cmd.whispergrove.get.success","获取值成功：%f");
            add("cmd.whispergrove.get.failed","获取值失败：%s");
        }
}