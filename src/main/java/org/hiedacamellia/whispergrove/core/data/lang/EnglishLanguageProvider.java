package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;

import java.util.Map;

public class EnglishLanguageProvider extends LanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, WhisperGrove.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("tooltip.whispergrove.press_shift","Press Shift to display more information");
        add("itemGroup.whispergrove", "Whisper Grove");
        add("item.whispergrove.test_item", "Test Item");
        add("tooltip.whispergrove.test_item", "This is a test item");
        add("block.whispergrove.test_block", "Example Block");
        add("tooltip.whispergrove.test_block", "This is an example block");
        add("network.whispergrove.failed","Failed to handle network data: %s");
        add("cmd.whispergrove.modify.success","Modify Value success: %f");
        add("cmd.whispergrove.modify.failed","Modify Value failed: %s");
        add("cmd.whispergrove.set.success","Set Value success: %f");
        add("cmd.whispergrove.set.failed","Set Value failed: %s");
        add("cmd.whispergrove.get.success","Get Value success: %f");
        add("cmd.whispergrove.get.failed","Get Value failed: %s");

        Map<String,String> desc = new DescGen().gendesc_en();
        for (Map.Entry<String, String> entry : desc.entrySet()) {
            add(entry.getKey(),entry.getValue());
        }

        Map<String,String> eff = new EffectGen().geneffect_en();
        for (Map.Entry<String, String> entry : eff.entrySet()) {
            add(entry.getKey(),entry.getValue());
        }

        add("item.whispergrove.yang_bian", "Sheep Whip");
        add("tooltip.whispergrove.yang_bian", "");
        add("item.whispergrove.duan_long_gu", "Fossilizid");
        add("tooltip.whispergrove.duan_long_gu", "");
        add("item.whispergrove.han_shui_shi", "Gypsum");
        add("tooltip.whispergrove.han_shui_shi", "");
        add("item.whispergrove.kun_bu", "kelp");
        add("tooltip.whispergrove.kun_bu", "");
        add("item.whispergrove.hai_piao_xiao", "Cuttlebone");
        add("tooltip.whispergrove.hai_piao_xiao", "");
        add("item.whispergrove.mai_ya", "Malt");
        add("tooltip.whispergrove.mai_ya", "");
        add("item.whispergrove.he_huan_pi", "Albizzia Bark");
        add("tooltip.whispergrove.he_huan_pi", "");
        add("item.whispergrove.mei_gui_hua", "Rose");
        add("tooltip.whispergrove.mei_gui_hua", "");
        add("item.whispergrove.ding_xiang", "Clove");
        add("tooltip.whispergrove.ding_xiang", "");
        add("item.whispergrove.zhu_ye", "Bamboo Leaf");
        add("tooltip.whispergrove.zhu_ye", "");
        add("item.whispergrove.zhu_ru", "Bamboo Shoot");
        add("tooltip.whispergrove.zhu_ru", "");
        add("item.whispergrove.pu_gong_ying", "Dandelion");
        add("tooltip.whispergrove.pu_gong_ying", "");
        add("item.whispergrove.feng_mi", "Honey");
        add("tooltip.whispergrove.feng_mi", "");
        add("item.whispergrove.a_jiao", "Donkey-hide Gelatin");
        add("tooltip.whispergrove.a_jiao", "");
        add("item.whispergrove.gui_ban_jiao", "Glue of Tortoise Plastron");
        add("tooltip.whispergrove.gui_ban_jiao", "");
        add("item.whispergrove.fu_ling", "Poria");
        add("tooltip.whispergrove.fu_ling", "");
        add("item.whispergrove.fu_zi", "Aconite");
        add("tooltip.whispergrove.fu_zi", "");
        add("item.whispergrove.wu_wei_zi", "Schisandra");
        add("tooltip.whispergrove.wu_wei_zi", "");
        add("item.whispergrove.rou_gui", "Cinnamon");
        add("tooltip.whispergrove.rou_gui", "");
        add("item.whispergrove.bai_zhu", "Largehead Atractylodes Rhizome");
        add("tooltip.whispergrove.bai_zhu", "");
        add("item.whispergrove.gan_cao", "Liquorice");
        add("tooltip.whispergrove.gan_cao", "");
        add("item.whispergrove.zhi_gan_cao", "Roasted Liquorice");
        add("tooltip.whispergrove.zhi_gan_cao", "");
        add("item.whispergrove.di_huang", "Rehmannia");
        add("tooltip.whispergrove.di_huang", "");
        add("item.whispergrove.shu_di_huang", "Roasted Rehmannia");
        add("tooltip.whispergrove.shu_di_huang", "");
        add("item.whispergrove.ren_shen", "Ginseng");
        add("tooltip.whispergrove.ren_shen", "");
        add("item.whispergrove.mai_dong", "Ophiopogon");
        add("tooltip.whispergrove.mai_dong", "");
        add("item.whispergrove.huang_qi", "Astragalus");
        add("tooltip.whispergrove.huang_qi", "");
        add("item.whispergrove.fang_feng", "Ledebouriella");
        add("tooltip.whispergrove.fang_feng", "");
        add("item.whispergrove.sheng_jiang", "Ginger");
        add("tooltip.whispergrove.sheng_jiang", "");
        add("item.whispergrove.dang_gui", "Chinese Angelica");
        add("tooltip.whispergrove.dang_gui", "");
        add("item.whispergrove.gou_qi", "Goji");
        add("tooltip.whispergrove.gou_qi", "");
        add("item.whispergrove.long_dan_cao", "Gentian");
        add("tooltip.whispergrove.long_dan_cao", "");
        add("item.whispergrove.zhi_zi", "Gardenia");
        add("tooltip.whispergrove.zhi_zi", "");
        add("item.whispergrove.shan_yao", "Chinese Yam");
        add("tooltip.whispergrove.shan_yao", "");
        add("item.whispergrove.tu_si_zi", "Dodder Seed");
        add("tooltip.whispergrove.tu_si_zi", "");
        add("item.whispergrove.ling_gui_shu_gan_tang", "Linggui zhugan decoction");
        add("tooltip.whispergrove.ling_gui_shu_gan_tang", "");
        add("item.whispergrove.dao_chi_san", "Red-Guiding Powder");
        add("tooltip.whispergrove.dao_chi_san", "");
        add("item.whispergrove.sheng_mai_yin", "Sheng Mai Yin");
        add("tooltip.whispergrove.sheng_mai_yin", "");
        add("item.whispergrove.yu_ping_feng_san", "Jade Windscreen Powder");
        add("tooltip.whispergrove.yu_ping_feng_san", "");
        add("item.whispergrove.shen_fu_wan", "Shenfu Wan");
        add("tooltip.whispergrove.shen_fu_wan", "");
        add("item.whispergrove.mai_men_dong_tang", "Mai Men Dong Decoction");
        add("tooltip.whispergrove.mai_men_dong_tang", "");
        add("item.whispergrove.long_dan_xie_gan_tang", "bolus of gentian for purging liver-fire");
        add("tooltip.whispergrove.long_dan_xie_gan_tang", "");
        add("item.whispergrove.zuo_gui_wan", "ZuoGuiWan");
        add("tooltip.whispergrove.zuo_gui_wan", "");
        add("item.whispergrove.you_gui_wan", "YouGuiWan");
        add("tooltip.whispergrove.you_gui_wan", "");
    }
}
