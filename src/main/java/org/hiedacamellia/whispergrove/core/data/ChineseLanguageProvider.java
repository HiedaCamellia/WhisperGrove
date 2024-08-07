package org.hiedacamellia.whispergrove.core.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.gen.DescGen;

import java.util.Map;

public class ChineseLanguageProvider extends LanguageProvider {

        public ChineseLanguageProvider(PackOutput output) {
            super(output, WhisperGrove.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            add("tooltip.whispergrove.press_shift","按住Shift键以显示更多信息");
            add("itemGroup.whispergrove", "浅草轻语");
            add("network.whispergrove.failed","无法处理网络数据: %s");
            add("cmd.whispergrove.modify.success","修改值成功：%f");
            add("cmd.whispergrove.modify.failed","修改值失败：%s");
            add("cmd.whispergrove.set.success","设置值成功：%f");
            add("cmd.whispergrove.set.failed","设置值失败：%s");
            add("cmd.whispergrove.get.success","获取值成功：%f");
            add("cmd.whispergrove.get.failed","获取值失败：%s");

            Map<String,String> desc = new DescGen().gendesc_zh();
            for (Map.Entry<String, String> entry : desc.entrySet()) {
                add(entry.getKey(),entry.getValue());
            }
        }
}
