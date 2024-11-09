package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;
import org.hiedacamellia.whispergrove.registers.WGBlockItem;
import org.hiedacamellia.whispergrove.registers.WGItem;

import java.util.Map;

public class EnglishLanguageProvider extends CamelliaLanguageProvider {

    public EnglishLanguageProvider(PackOutput output) {
        super(output, WhisperGrove.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("tooltip.whispergrove.press_shift","Press Shift to display more information");
        add("itemGroup.whispergrove", "Whisper Grove");
        add("menu.whispergrove.viscera_tab","Viscera");
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

        addWithTooltip(WGItem.MILKVETCH.get(),"Milkvetch","");
        addWithTooltip(WGItem.ACTINOLITE.get(),"Actinolite","");
        addWithTooltip(WGItem.FLUORITE.get(),"Fluorite","");
        addWithTooltip(WGItem.CASSIA_TWIG.get(),"Cassia Twig","");
        addWithTooltip(WGItem.ROSE.get(),"Rose","");
        addWithTooltip(WGItem.ROASTED_REHMANNIA.get(),"Roasted Rehmannia","");
        addWithTooltip(WGItem.ROASTED_CUTTLEFLSH_BONE.get(),"Roasted Cuttlefish Bone","");
        addWithTooltip(WGItem.MONKSHOOD.get(),"Monkshood","");
        addWithTooltip(WGItem.CLOVE.get(),"Clove","");
        addWithTooltip(WGItem.SCHISANDRA_CHINENSIS.get(),"Shisandra Chinensis","");
        addWithTooltip(WGItem.PREPARED_LICORICE.get(),"Prepared Licorice","");
        addWithTooltip(WGItem.GINSENG.get(),"Ginseng","");
        addWithTooltip(WGItem.PORIA_COCOS.get(),"Poria Cocos","");
        addWithTooltip(WGItem.MALT.get(),"Malt","");
        addWithTooltip(WGItem.DONKEY_HIDE_GELATIN.get(),"Donkey Hide Gelatin","");
        addWithTooltip(WGItem.CALCINED_DRAGON_BONE.get(),"Calcined Dragon Bone","");
        addWithTooltip(WGItem.ALBIZIA_BARK.get(),"Albizia Bark","");
        addWithTooltip(WGItem.BAMBOO_LEAF.get(),"Bamboo leaf","");
        addWithTooltip(WGItem.BAMBOO_SHAVINGS.get(),"Bamboo Shavings","");
        addWithTooltip(WGItem.GENTIAN.get(),"Gentian","");
        addWithTooltip(WGItem.GYPSUM_RUBRUM.get(),"Gypsum Rubrum","");
        addWithTooltip(WGItem.TORTOISE_PLASTRON_GLUE.get(),"Tortoise Plastron Glue","");
        addWithTooltip(WGItem.DRYING_REHMANNIA.get(),"Drying Rehmannia","");
        addWithTooltip(WGItem.DRYING_LICORICE.get(),"Drying Licorice","");
        addWithTooltip(WGItem.ROASTED_MONKSHOOD.get(),"Roasted Monkshood","");

        addWithTooltip(WGItem.SLICED_MILKVETCH.get(),"Sliced Milkvetch","");
        addWithTooltip(WGItem.SLICED_CASSIA_TWIG.get(),"Sliced Cassia Twig","");
        addWithTooltip(WGItem.CASSIA_TWIG_BARK.get(),"Cassia Twig Bark","");
        addWithTooltip(WGItem.REHMANNIA.get(),"Rehmannia","");
        addWithTooltip(WGItem.LICORICE.get(),"Licorice","");
        addWithTooltip(WGItem.SLICED_GINSENG.get(),"Sliced Ginseng","");
        addWithTooltip(WGItem.SLICED_GENTIAN.get(),"Sliced Gentian","");
        addWithTooltip(WGItem.CUTTLEBONE.get(),"Cuttlebone","");
        addWithTooltip(WGItem.BONE_FRAGMENT.get(),"Bone Fragment","");

        addWithTooltip(WGItem.CROP_SEED_ITEMS.get("rehmannia").get(),"Rehmannia Seed","");
        addWithTooltip(WGItem.CROP_SEED_ITEMS.get("licorice").get(),"Licorice Seed","");
        addWithTooltip(WGItem.CROP_SEED_ITEMS.get("milkvetch").get(),"Milkvetch Seed","");
        addWithTooltip(WGItem.CROP_SEED_ITEMS.get("gentian").get(),"Gentian Seed","");
        addWithTooltip(WGItem.CROP_SEED_ITEMS.get("ginseng").get(),"Ginseng Seed","");

        addWithTooltip(WGBlockItem.CASSIA_LEAVES.get(),"Cassia Leaves","");
        addWithTooltip(WGBlockItem.CASSIA_LOG.get(),"Cassia Log","");
        addWithTooltip(WGBlockItem.CASSIA_STRIPPED_LOG.get(),"Cassia Stripped Log","");
        addWithTooltip(WGBlockItem.CASSIA_PLANKS.get(),"Cassia Planks","");
        addWithTooltip(WGBlockItem.CASSIA_SLAB.get(),"Cassia Slab","");
        addWithTooltip(WGBlockItem.CASSIA_STAIRS.get(),"Cassia Stairs","");

        addWithTooltip(WGBlockItem.ROLLER.get(),"Roller","");
        addWithTooltip(WGBlockItem.CUTTER.get(),"Cutter","");
        addWithTooltip(WGBlockItem.POT.get(),"Pot","");
        addWithTooltip(WGBlockItem.SPRINGING.get(),"Springing","");

        addWithTooltip(WGItem.SOUP.get(),"Unnamed Medicinal soup","");

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

        add("tooltip.whispergrove.heart","Heart ");
        add("tooltip.whispergrove.liver","Liver ");
        add("tooltip.whispergrove.lung","Lung ");
        add("tooltip.whispergrove.kidney","Kidney ");
        add("tooltip.whispergrove.spleen","Spleen ");
        add("tooltip.whispergrove.yin","Cold %d");
        add("tooltip.whispergrove.yang","Warm %d");
        add("tooltip.whispergrove.ping","Balance %d");
        add("viscera.whispergrove.hover.yin","Yin: %d Points");
        add("viscera.whispergrove.hover.yang","Yang: %d Points");
    }
}
