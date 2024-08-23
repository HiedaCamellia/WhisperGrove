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
        add("network.whispergrove.failed","Failed to handle network data: %s");
        add("cmd.whispergrove.modify.success","Modify Value success: %f");
        add("cmd.whispergrove.modify.failed","Modify Value failed: %s");
        add("cmd.whispergrove.set.success","Set Value success: %f");
        add("cmd.whispergrove.set.failed","Set Value failed: %s");
        add("cmd.whispergrove.get.success","Get Value success: %f");
        add("cmd.whispergrove.get.failed","Get Value failed: %s");
        add("cmd.whispergrove.reset.success","Reset Value success");
        add("cmd.whispergrove.reset.failed","Reset Value failed");

        Map<String,String> desc = new DescGen().gendesc_en();
        for (Map.Entry<String, String> entry : desc.entrySet()) {
            add(entry.getKey(),entry.getValue());
        }

        Map<String,String> eff = new EffectGen().geneffect_en();
        for (Map.Entry<String, String> entry : eff.entrySet()) {
            add(entry.getKey(),entry.getValue());
        }

        add("item.whispergrove.huang_qi","Radix Astragali");
        add("tooltip.whispergrove.huang_qi","");
        add("item.whispergrove.yang_qi_shi","Actinolite");
        add("tooltip.whispergrove.yang_qi_shi","");
        add("item.whispergrove.zi_shi_ying","Amethyst");
        add("tooltip.whispergrove.zi_shi_ying","");
        add("item.whispergrove.gui_zhi","Cassia Twig");
        add("tooltip.whispergrove.gui_zhi","");
        add("item.whispergrove.gan_mei_gui","Dried Rose");
        add("tooltip.whispergrove.gan_mei_gui","");
        add("item.whispergrove.shu_di_huang","Roasted Rehmannia");
        add("tooltip.whispergrove.shu_di_huang","");
        add("item.whispergrove.hai_piao_xiao","Roasted Cuttleflsh Bone");
        add("tooltip.whispergrove.hai_piao_xiao","");
        add("item.whispergrove.fu_zi","Prepared Common Monkshood Daughter Root");
        add("tooltip.whispergrove.fu_zi","");
        add("item.whispergrove.chao_ding_xiang","Dried Lilac");
        add("tooltip.whispergrove.chao_ding_xiang","");
        add("item.whispergrove.wu_wei_zi","Schisandra chinensis");
        add("tooltip.whispergrove.wu_wei_zi","");
        add("item.whispergrove.zhi_gan_cao","Roasted Liquorice Root");
        add("tooltip.whispergrove.zhi_gan_cao","");
        add("item.whispergrove.ren_shen","Panax ginseng");
        add("tooltip.whispergrove.ren_shen","");
        add("item.whispergrove.fu_ling","Poria");
        add("tooltip.whispergrove.fu_ling","");
        add("item.whispergrove.mai_ya","Malt");
        add("tooltip.whispergrove.mai_ya","");
        add("item.whispergrove.e_jiao","Donkey-hide Glue");
        add("tooltip.whispergrove.e_jiao","");
        add("item.whispergrove.duan_long_gu","Fossilizid bone");
        add("tooltip.whispergrove.duan_long_gu","");
        add("item.whispergrove.he_huan_pi","Albizzia Bark");
        add("tooltip.whispergrove.he_huan_pi","");
        add("item.whispergrove.zhu_ye","bamboo leaf");
        add("tooltip.whispergrove.zhu_ye","");
        add("item.whispergrove.long_dan_cao","Gentian");
        add("tooltip.whispergrove.long_dan_cao","");
        add("item.whispergrove.pu_gong_ying","Dandelion");
        add("tooltip.whispergrove.pu_gong_ying","");
        add("item.whispergrove.zhu_gu","Bamboo Shavings");
        add("tooltip.whispergrove.zhu_gu","");
        add("item.whispergrove.kun_bu","kelp");
        add("tooltip.whispergrove.kun_bu","");
        add("item.whispergrove.han_shui_shi","Gypsum");
        add("tooltip.whispergrove.han_shui_shi","");
        add("item.whispergrove.gui_ban_jiao","Glue of Tortoise Plastron");
        add("tooltip.whispergrove.gui_ban_jiao","");
        add("item.whispergrove.sheng_di_huang","Drying Rehmannia Root");
        add("tooltip.whispergrove.sheng_di_huang","");
        add("item.whispergrove.sheng_gan_cao","Drying Licorice Root");
        add("tooltip.whispergrove.sheng_gan_cao","");

        add("item.whispergrove.sliced_huang_qi","Sliced Radix Astragali");
        add("tooltip.whispergrove.sliced_huang_qi","");
        add("item.whispergrove.sliced_gui_zhi","Sliced Cassia Twig");
        add("tooltip.whispergrove.sliced_gui_zhi","");
        add("item.whispergrove.gui_zhi_pi","Cassia Twig Bark");
        add("tooltip.whispergrove.gui_zhi_pi","");
        add("item.whispergrove.di_huang","Rehmannia Root");
        add("tooltip.whispergrove.di_huang","");
        add("item.whispergrove.gan_cao","Licorice Root");
        add("tooltip.whispergrove.gan_cao","");
        add("item.whispergrove.sliced_ren_shen","Sliced Panax ginseng");
        add("tooltip.whispergrove.sliced_ren_shen","");
        add("item.whispergrove.sliced_long_dan_cao","SLiced Gentian");
        add("tooltip.whispergrove.sliced_long_dan_cao","");
        add("item.whispergrove.mo_yu_gu","Cuttleflsh Bone");
        add("tooltip.whispergrove.mo_yu_gu","");
        add("item.whispergrove.shu_fu_pian","Roasted Prepared Common Monkshood Daughter Root");
        add("tooltip.whispergrove.shu_fu_pian","");
        add("item.whispergrove.bone_fragment","Bone Fragment");
        add("tooltip.whispergrove.bone_fragment","");

        add("item.whispergrove.roller","roller");
        add("tooltip.whispergrove.roller","");

        add("block.whispergrove.rou_gui_log","Cinnamon  Log");
        add("tooltip.whispergrove.rou_gui_log","");
        add("block.whispergrove.rou_gui_stripped_log","Stripped Cinnamon Log");
        add("tooltip.whispergrove.rou_gui_stripped_log","");
        add("block.whispergrove.rou_gui_leaves","Cinnamon Leaves");
        add("tooltip.whispergrove.rou_gui_leaves","");
        add("block.whispergrove.rou_gui_planks","Cinnamon Blank");
        add("tooltip.whispergrove.rou_gui_planks","");
        add("block.whispergrove.rou_gui_slab","Cinnamon Slab");
        add("tooltip.whispergrove.rou_gui_slab","");
        add("block.whispergrove.rou_gui_stair","Cinnamon Stair");
        add("tooltip.whispergrove.rou_gui_stair","");

        add("block.whispergrove.springing","Springing");
        add("tooltip.whispergrove.springing","");

        add("config.whispergrove.title","Whisper Grove Config");
        add("config.whispergrove.comfirm","Comfirm");
        add("config.whispergrove.debug","Debug");
        add("config.whispergrove.debug.desc","Set to true to enable debug info");
        add("config.whispergrove.disease_mild","Get the ratio of yin and yang points of mild disease");
        add("config.whispergrove.disease_moderate","Get the ratio of yin and yang points of moderate disease");
        add("config.whispergrove.disease_critical","Get the ratio of yin and yang points of Critical disease");
        add("config.whispergrove.viscera_constant","The multiply of changed points of viscera");
    }
}
