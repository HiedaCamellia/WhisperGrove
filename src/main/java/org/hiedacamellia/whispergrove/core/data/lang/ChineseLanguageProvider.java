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

            add("item.whispergrove.yang_bian", "羊鞭");
            add("tooltip.whispergrove.yang_bian", "");
            add("item.whispergrove.duan_long_gu", "煅龙骨");
            add("tooltip.whispergrove.duan_long_gu", "");
            add("item.whispergrove.han_shui_shi", "寒水石");
            add("tooltip.whispergrove.han_shui_shi", "");
            add("item.whispergrove.kun_bu", "昆布");
            add("tooltip.whispergrove.kun_bu", "");
            add("item.whispergrove.hai_piao_xiao", "海螵蛸");
            add("tooltip.whispergrove.hai_piao_xiao", "");
            add("item.whispergrove.mai_ya", "麦芽");
            add("tooltip.whispergrove.mai_ya", "");
            add("item.whispergrove.he_huan_pi", "合欢皮");
            add("tooltip.whispergrove.he_huan_pi", "");
            add("item.whispergrove.mei_gui_hua", "玫瑰花");
            add("tooltip.whispergrove.mei_gui_hua", "");
            add("item.whispergrove.ding_xiang", "丁香");
            add("tooltip.whispergrove.ding_xiang", "");
            add("item.whispergrove.zhu_ye", "竹叶");
            add("tooltip.whispergrove.zhu_ye", "");
            add("item.whispergrove.zhu_ru", "竹茹");
            add("tooltip.whispergrove.zhu_ru", "");
            add("item.whispergrove.pu_gong_ying", "蒲公英");
            add("tooltip.whispergrove.pu_gong_ying", "");
            add("item.whispergrove.feng_mi", "蜂蜜");
            add("tooltip.whispergrove.feng_mi", "");
            add("item.whispergrove.a_jiao", "阿胶");
            add("tooltip.whispergrove.a_jiao", "");
            add("item.whispergrove.gui_ban_jiao", "龟板胶");
            add("tooltip.whispergrove.gui_ban_jiao", "");
            add("item.whispergrove.fu_ling", "茯苓");
            add("tooltip.whispergrove.fu_ling", "");
            add("item.whispergrove.fu_zi", "附子");
            add("tooltip.whispergrove.fu_zi", "");
            add("item.whispergrove.wu_wei_zi", "五味子");
            add("tooltip.whispergrove.wu_wei_zi", "");
            add("item.whispergrove.rou_gui", "肉桂");
            add("tooltip.whispergrove.rou_gui", "");
            add("item.whispergrove.bai_zhu", "白术");
            add("tooltip.whispergrove.bai_zhu", "");
            add("item.whispergrove.gan_cao", "甘草");
            add("tooltip.whispergrove.gan_cao", "");
            add("item.whispergrove.zhi_gan_cao", "炙甘草");
            add("tooltip.whispergrove.zhi_gan_cao", "");
            add("item.whispergrove.di_huang", "地黄");
            add("tooltip.whispergrove.di_huang", "");
            add("item.whispergrove.shu_di_huang", "熟地黄");
            add("tooltip.whispergrove.shu_di_huang", "");
            add("item.whispergrove.ren_shen", "人参");
            add("tooltip.whispergrove.ren_shen", "");
            add("item.whispergrove.mai_dong", "麦冬");
            add("tooltip.whispergrove.mai_dong", "");
            add("item.whispergrove.huang_qi", "黄芪");
            add("tooltip.whispergrove.huang_qi", "");
            add("item.whispergrove.fang_feng", "防风");
            add("tooltip.whispergrove.fang_feng", "");
            add("item.whispergrove.sheng_jiang", "生姜");
            add("tooltip.whispergrove.sheng_jiang", "");
            add("item.whispergrove.dang_gui", "当归");
            add("tooltip.whispergrove.dang_gui", "");
            add("item.whispergrove.gou_qi", "枸杞");
            add("tooltip.whispergrove.gou_qi", "");
            add("item.whispergrove.long_dan_cao", "龙胆草");
            add("tooltip.whispergrove.long_dan_cao", "");
            add("item.whispergrove.zhi_zi", "栀子");
            add("tooltip.whispergrove.zhi_zi", "");
            add("item.whispergrove.shan_yao", "山药");
            add("tooltip.whispergrove.shan_yao", "");
            add("item.whispergrove.tu_si_zi", "菟丝子");
            add("tooltip.whispergrove.tu_si_zi", "");
            add("item.whispergrove.ling_gui_shu_gan_tang", "苓桂术甘汤");
            add("tooltip.whispergrove.ling_gui_shu_gan_tang", "");
            add("item.whispergrove.dao_chi_san", "导赤散");
            add("tooltip.whispergrove.dao_chi_san", "");
            add("item.whispergrove.sheng_mai_yin", "生脉饮");
            add("tooltip.whispergrove.sheng_mai_yin", "");
            add("item.whispergrove.yu_ping_feng_san", "玉屏风散");
            add("tooltip.whispergrove.yu_ping_feng_san", "");
            add("item.whispergrove.shen_fu_wan", "参附丸");
            add("tooltip.whispergrove.shen_fu_wan", "");
            add("item.whispergrove.mai_men_dong_tang", "麦门冬汤");
            add("tooltip.whispergrove.mai_men_dong_tang", "");
            add("item.whispergrove.long_dan_xie_gan_tang", "龙胆泻肝汤");
            add("tooltip.whispergrove.long_dan_xie_gan_tang", "");
            add("item.whispergrove.zuo_gui_wan", "左归丸");
            add("tooltip.whispergrove.zuo_gui_wan", "");
            add("item.whispergrove.you_gui_wan", "右归丸");
            add("tooltip.whispergrove.you_gui_wan", "");


        }
}
