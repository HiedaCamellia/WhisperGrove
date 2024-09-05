package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;
import org.hiedacamellia.whispergrove.registers.WGItem;

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

        add(WGItem.MILKVETCH.get(),"Milkvetch");
        add("tooltip.whispergrove.milkvetch","");
        add("item.whispergrove.actinolite","Actinolite");
        add("tooltip.whispergrove.actinolite","");
        add("item.whispergrove.fluorite","Fluorite");
        add("tooltip.whispergrove.fluorite","");
        add("item.whispergrove.cassia_twig","Cassia Twig");
        add("tooltip.whispergrove.cassia_twig","");
        add("item.whispergrove.rose","Rose");
        add("tooltip.whispergrove.rose","");
        add("item.whispergrove.roasted_rehmannia","Roasted Rehmannia");
        add("tooltip.whispergrove.roasted_rehmannia","");
        add("item.whispergrove.roasted_cuttleflsh_bone","Roasted Cuttlefish Bone");
        add("tooltip.whispergrove.roasted_cuttleflsh_bone","");
        add("item.whispergrove.monkshood","Monkshood");
        add("tooltip.whispergrove.monkshood","");
        add("item.whispergrove.clove","Clove");
        add("tooltip.whispergrove.clove","");
        add("item.whispergrove.schisandra_chinensis","Shisandra Chinensis");
        add("tooltip.whispergrove.schisandra_chinensis","");
        add("item.whispergrove.prepared_licorice","Prepared Licorice");
        add("tooltip.whispergrove.prepared_licorice","");
        add("item.whispergrove.ginseng","Ginseng");
        add("tooltip.whispergrove.ginseng","");
        add("item.whispergrove.poria_cocos","Poria Cocos");
        add("tooltip.whispergrove.poria_cocos","");
        add("item.whispergrove.malt","Malt");
        add("tooltip.whispergrove.malt","");
        add("item.whispergrove.donkey_hide_gelatin","Donkey Hide Gelatin");
        add("tooltip.whispergrove.donkey_hide_gelatin","");
        add("item.whispergrove.calcined_dragon_bone","Calcined Dragon Bone");
        add("tooltip.whispergrove.calcined_dragon_bone","");
        add("item.whispergrove.albizia_bark","Albizia Bark");
        add("tooltip.whispergrove.albizia_bark","");
        add("item.whispergrove.bamboo_leaf","Bamboo leaf");
        add("tooltip.whispergrove.bamboo_leaf","");
        add("item.whispergrove.gentian","Gentian");
        add("tooltip.whispergrove.gentian","");
        add("item.whispergrove.bamboo_shavings","Bamboo Shavings");
        add("tooltip.whispergrove.bamboo_shavings","");
        add("item.whispergrove.gypsum_rubrum","Gypsum Rubrum");
        add("tooltip.whispergrove.gypsum_rubrum","");
        add("item.whispergrove.tortoise_plastron_glue","Tortoise Plastron Glue");
        add("tooltip.whispergrove.tortoise_plastron_glue","");
        add("item.whispergrove.drying_rehmannia","Drying Rehmannia");
        add("tooltip.whispergrove.drying_rehmannia","");
        add("item.whispergrove.drying_licorice","Drying Licorice");
        add("tooltip.whispergrove.drying_licorice","");

        add("item.whispergrove.sliced_milkvetch","Sliced Milkvetch");
        add("tooltip.whispergrove.sliced_milkvetch","");
        add("item.whispergrove.sliced_cassia_twig","Sliced Cassia Twig");
        add("tooltip.whispergrove.sliced_cassia_twig","");
        add("item.whispergrove.cassia_twig_bark","Cassia Twig Bark");
        add("tooltip.whispergrove.cassia_twig_bark","");
        add("item.whispergrove.rehmannia","Rehmannia");
        add("tooltip.whispergrove.rehmannia","");
        add("item.whispergrove.licorice","Licorice");
        add("tooltip.whispergrove.licorice","");
        add("item.whispergrove.sliced_ginseng","Sliced Ginseng");
        add("tooltip.whispergrove.sliced_ginseng","");
        add("item.whispergrove.sliced_gentian","Sliced Gentian");
        add("tooltip.whispergrove.sliced_gentian","");
        add("item.whispergrove.cuttlebone","Cuttlebone");
        add("tooltip.whispergrove.cuttlebone","");
        add("item.whispergrove.bone_fragment","Bone Fragment");
        add("tooltip.whispergrove.bone_fragment","");

        add("block.whispergrove.roller","Roller");
        add("tooltip.whispergrove.roller","");


        add("block.whispergrove.cassia_log","Cassia Log");
        add("tooltip.whispergrove.cassia_log","");
        add("block.whispergrove.cassia_stripped_log","Cassia Stripped Log");
        add("tooltip.whispergrove.cassia_stripped_log","");
        add("block.whispergrove.cassia_leaves","Cassia Leaves");
        add("tooltip.whispergrove.cassia_leaves","");
        add("block.whispergrove.cassia_planks","Cassia Planks");
        add("tooltip.whispergrove.cassia_planks","");
        add("block.whispergrove.cassia_slab","Cassia_Slab");
        add("tooltip.whispergrove.cassia_slab","");
        add("block.whispergrove.cassia_stairs","Cassia Stairs");
        add("tooltip.whispergrove.cassia_stairs","");

        add("block.whispergrove.springing","Springing");
        add("tooltip.whispergrove.springing","");

        add("whispergrove.configuration.title","Whisper Grove Config");
        add("whispergrove.configuration.debug","Debug");
        add("whispergrove.configuration.disease_mild","mild disease");
        add("whispergrove.configuration.disease_moderate","moderate disease");
        add("whispergrove.configuration.disease_critical","Critical disease");
        add("whispergrove.configuration.viscera_constant","The viscera constant value");
        add("whispergrove.configuration.ecliptic_compact", "Ecliptic Compact");
        add("whispergrove.configuration.debug.tooltip","Set to true to enable debug info");
        add("whispergrove.configuration.disease_mild.tooltip","Get the ratio of yin and yang points of mild disease");
        add("whispergrove.configuration.disease_moderate.tooltip","Get the ratio of yin and yang points of moderate disease");
        add("whispergrove.configuration.disease_critical.tooltip","Get the ratio of yin and yang points of Critical disease(Deprecated)");
        add("whispergrove.configuration.viscera_constant.tooltip","The multiply of changed points of viscera");
        add("whispergrove.configuration.ecliptic_compact.tooltip", "Set to true to enable the compact of the Ecliptic");
        add("whispergrove.configuration.section.whispergrove.common.toml", "Common Config");
        add("whispergrove.configuration.section.whispergrove.common.toml.title", "Whisper Grove Common Config");
    }
}
