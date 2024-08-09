package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;

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

            Map<String,String> eff = new EffectGen().geneffect_zh();
            for (Map.Entry<String, String> entry : eff.entrySet()) {
                add(entry.getKey(),entry.getValue());
            }

            add("item.whispergrove.huang_qi","黄芪");
            add("tooltip.whispergrove.huang_qi","");
            add("item.whispergrove.yang_qi_shi","阳起石");
            add("tooltip.whispergrove.yang_qi_shi","");
            add("item.whispergrove.zi_shi_ying","紫石英");
            add("tooltip.whispergrove.zi_shi_ying","");
            add("item.whispergrove.gui_zhi","桂枝");
            add("tooltip.whispergrove.gui_zhi","");
            add("item.whispergrove.mei_gui_hua","玫瑰花");
            add("tooltip.whispergrove.mei_gui_hua","");
            add("item.whispergrove.shu_di_huang","熟地黄");
            add("tooltip.whispergrove.shu_di_huang","");
            add("item.whispergrove.hai_piao_xiao","海螵蛸");
            add("tooltip.whispergrove.hai_piao_xiao","");
            add("item.whispergrove.fu_zi","附子");
            add("tooltip.whispergrove.fu_zi","");
            add("item.whispergrove.ding_xiang","丁香");
            add("tooltip.whispergrove.ding_xiang","");
            add("item.whispergrove.wu_wei_zi","五味子");
            add("tooltip.whispergrove.wu_wei_zi","");
            add("item.whispergrove.zhi_gan_cao","炙甘草");
            add("tooltip.whispergrove.zhi_gan_cao","");
            add("item.whispergrove.ren_shen","人参");
            add("tooltip.whispergrove.ren_shen","");
            add("item.whispergrove.fu_ling","茯苓");
            add("tooltip.whispergrove.fu_ling","");
            add("item.whispergrove.mai_ya","麦芽");
            add("tooltip.whispergrove.mai_ya","");
            add("item.whispergrove.e_jiao","阿胶");
            add("tooltip.whispergrove.e_jiao","");
            add("item.whispergrove.duan_long_gu","煅龙骨");
            add("tooltip.whispergrove.duan_long_gu","");
            add("item.whispergrove.he_huan_pi","合欢皮");
            add("tooltip.whispergrove.he_huan_pi","");
            add("item.whispergrove.zhu_ye","竹叶");
            add("tooltip.whispergrove.zhu_ye","");
            add("item.whispergrove.long_dan_cao","龙胆草");
            add("tooltip.whispergrove.long_dan_cao","");
            add("item.whispergrove.pu_gong_ying","蒲公英");
            add("tooltip.whispergrove.pu_gong_ying","");
            add("item.whispergrove.zhu_gu","竹茹");
            add("tooltip.whispergrove.zhu_gu","");
            add("item.whispergrove.kun_bu","昆布");
            add("tooltip.whispergrove.kun_bu","");
            add("item.whispergrove.han_shui_shi","寒水石");
            add("tooltip.whispergrove.han_shui_shi","");
            add("item.whispergrove.gui_ban_jiao","龟板胶");
            add("tooltip.whispergrove.gui_ban_jiao","");
            add("item.whispergrove.sheng_di_huang","生地黄");
            add("tooltip.whispergrove.sheng_di_huang","");
            add("item.whispergrove.sheng_gan_cao","生甘草");
            add("tooltip.whispergrove.sheng_gan_cao","");

        }
}
