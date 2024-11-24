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

        addWithTooltip(WGItem.MILKVETCH.get(),"Milkvetch","Taste：slightly sweet§nClinical Indications：§n1. Perspiration caused by weakness or from no apparent cause§n2. Chronic diarrhoea, rectal prolapse§n3. General fatigue");
        addWithTooltip(WGItem.ACTINOLITE.get(),"Actinolite","Taste：mild§nClinical Indications：§n1. Impotence§n2. Weakness of the loins and knees");
        addWithTooltip(WGItem.FLUORITE.get(),"Fluorite","Taste：mild§nClinical Indications：§n1. Insomina, excessive dreams, palpitation§n2. Cough, asthma§n3. Infertility");
        addWithTooltip(WGItem.ROSE.get(),"Rose"," Taste：slightly bitter and astringent§nClinical Indications：§n1. Menstrual disorders, dysmenorrhoea§n2. Trauma with ecchymosis and swellings, carbuncles, scrofula (not ruptured) (external use)");
        addWithTooltip(WGItem.CASSIA_TWIG_BARK.get(),"Cassia Twig Bark","Taste：sweet and slightly acrid, cortex with a stronger taste§nClinical Indications：§n1. Common cold, cough, dizziness§n2. Palpitation, precordial pain§n3. Arthralgia§n4. Amenorrhoea, dysmenorrhoea§n5. Dysuria, oedema");
        addWithTooltip(WGItem.ROASTED_REHMANNIA.get(),"Roasted Rehmannia","Taste：slightly sweet§nClinical Indications：Dried:§n1. Haemoptysis, epistaxis, menorrhagia§n2. Menstrual disorders, constipation§nProcessed:§n1. Anaemia, weakness§n2. Nocturnal emission§n3. Low-grade afternoon fever§n4. Night sweating, menorrhagia");
        addWithTooltip(WGItem.ROASTED_CUTTLEFLSH_BONE.get(),"Roasted Cuttlefish Bone","Taste：slightly salty§nClinical Indications：§n1. Bleeding§n2. Nocturnal emission, leukorrhagia§n3. Peptic ulcer, stomachache with acid regurgitation§n4. Goiter§n5. Pyogenic skin infection, unhealed skin lesion, eczema");
        addWithTooltip(WGItem.MONKSHOOD.get(),"Monkshood","Taste：numbing, tongue-pricking§nClinical Indications：§n1. Shock§n2. Impotence, emission§n3. Urinary frequency, oedema§n4. Diarrhoea, constipation§n5. Arthralgia, periarthritis of shoulder joint");
        addWithTooltip(WGItem.CLOVE.get(),"Clove"," Taste：pungent and tongue-numbing§nClinical Indications：§n1. Vomiting, hiccup, anorexia, loose stool§n2. Impotence");
        addWithTooltip(WGItem.SCHISANDRA_CHINENSIS.get(),"Shisandra Chinensis"," Taste：sarcocarp: faint, seeds: acrid, slightly bitter§nClinical Indications：§n1. Neurasthenia§n2. Spontaneous sweating, night sweating, seminal emissions§n3. General fatigue");
        addWithTooltip(WGItem.PREPARED_LICORICE.get(),"Prepared Licorice","Taste：sweet and distinctive§nClinical Indications：§n1. Sore throat, cough§n2. Gastric hyposecretion, gastroduodenal ulcer§n3. Hysteria§n4. Dermatitis and boils§n5. Drug and food poisoning");
        addWithTooltip(WGItem.GINSENG.get(),"Ginseng","Taste：slightly bitter, gradually sweet§nClinical Indications：§n1. General weakness, palpitations, forgetfulness§n2. Thirst and hyperhidrosis, anorexia§n3. All kinds of chronic disease, post-haemorrhagic shock, collapse");
        addWithTooltip(WGItem.PORIA_COCOS.get(),"Poria Cocos","Taste：mild§nClinical Indications：§n1. Oedema, dysuria§n2. Leukorrhagia§n3. Cough§n4. Diarrhoea, jaundice§n5. Palpitaton, insomnia, dizziness, chronic schizophrenia");
        addWithTooltip(WGItem.MALT.get(),"Malt","Taste：slightly bitter");
        addWithTooltip(WGItem.DONKEY_HIDE_GELATIN.get(),"Donkey Hide Gelatin","Taste：slightly sweet§nClinical Indications：§n1. Anaemia, leukopenia, thrombocytopenia purpura§n2. Bleeding§n3. Amenorrhoea, menstrual disorders, threatened abortion§n4. Vexation, insomnia§n5. Muscular spasm§n6. Cough and thirst");
        addWithTooltip(WGItem.CALCINED_DRAGON_BONE.get(),"Calcined Dragon Bone","Taste：tasteless; sticky when chewed§nClinical Indications：§n. Dizziness, headache, hypertension, irritability, palpitation, insomnia, epilesy, insanity§n2. Nocturnal emission, enuresis§n3. Menstrual disorders§n4. Sweating§n5. Exudative prurigo, chronic ulcer");
        addWithTooltip(WGItem.ALBIZIA_BARK.get(),"Albizia Bark","Taste：mild, slightly astringent and tongue-pricking, then throat-irritating§nClinical Indications：§n1. Anxiety and insomnia§n2. Pulmonary abscess, expectoration§n3. Trauma§n4. Carbuncle and boils");
        addWithTooltip(WGItem.BAMBOO_LEAF.get(),"Bamboo leaf"," Taste：mild§nClinical Indications：§n1. Hyperpyrexia, anxiety, thirst§n2. Aphthous ulcer, gingivitis§n3. Urethritis, ardour urinae, deep yellow or reddish urine");
        addWithTooltip(WGItem.BAMBOO_SHAVINGS.get(),"Bamboo Shavings","Taste：slightly sweet§nClinical Indications：§n1. Cough with thick and yellow sputum§n2. Vexation, feeling of oppression in the chest, insomnia, palpitation§n3. Vomiting, bitter taste in the mouth§n4. Bleeding");
        addWithTooltip(WGItem.GENTIAN.get(),"Gentian","Taste：quite bitter§nClinical Indications：§n1. Jaundice, hypochondriac pain, bitter taste in the mouth§n2. Leukorrhoea, vulvitis, eczema§n3. Headache, flushed face, red eyes restlessness, hypertension§n4. High fever with convulsion");
        addWithTooltip(WGItem.GYPSUM_RUBRUM.get(),"Gypsum Rubrum","Taste: pungent and salty, cold in nature");
        addWithTooltip(WGItem.TORTOISE_PLASTRON_GLUE.get(),"Tortoise Plastron Glue","Taste: salty, sweet, cool in nature");
        add(WGItem.DRYING_REHMANNIA.get(),"Drying Rehmannia");
        add(WGItem.DRYING_LICORICE.get(),"Drying Licorice");
        add(WGItem.ROASTED_MONKSHOOD.get(),"Roasted Monkshood");

        add(WGItem.SLICED_MILKVETCH.get(),"Sliced Milkvetch");
        add(WGItem.SLICED_CASSIA_TWIG.get(),"Sliced Cassia Twig");
        add(WGItem.CASSIA_TWIG.get(),"Cassia Twig");
        add(WGItem.REHMANNIA.get(),"Rehmannia");
        add(WGItem.LICORICE.get(),"Licorice");
        add(WGItem.SLICED_GINSENG.get(),"Sliced Ginseng");
        add(WGItem.SLICED_GENTIAN.get(),"Sliced Gentian");
        add(WGItem.CUTTLEBONE.get(),"Cuttlebone");
        add(WGItem.BONE_FRAGMENT.get(),"Bone Fragment");

        add(WGItem.CROP_SEED_ITEMS.get("rehmannia").get(),"Rehmannia Seed");
        add(WGItem.CROP_SEED_ITEMS.get("licorice").get(),"Licorice Seed");
        add(WGItem.CROP_SEED_ITEMS.get("milkvetch").get(),"Milkvetch Seed");
        add(WGItem.CROP_SEED_ITEMS.get("gentian").get(),"Gentian Seed");
        add(WGItem.CROP_SEED_ITEMS.get("ginseng").get(),"Ginseng Seed");

        add(WGBlockItem.CASSIA_LEAVES.get(),"Cassia Leaves");
        add(WGBlockItem.CASSIA_LOG.get(),"Cassia Log");
        add(WGBlockItem.CASSIA_STRIPPED_LOG.get(),"Cassia Stripped Log");
        add(WGBlockItem.CASSIA_PLANKS.get(),"Cassia Planks");
        add(WGBlockItem.CASSIA_SLAB.get(),"Cassia Slab");
        add(WGBlockItem.CASSIA_STAIRS.get(),"Cassia Stairs");

        add(WGBlockItem.ROLLER.get(),"Roller");
        add(WGBlockItem.CUTTER.get(),"Cutter");
        add(WGBlockItem.POT.get(),"Pot");
        add(WGBlockItem.SPRINGING.get(),"Springing");

        add(WGItem.SOUP.get(),"Unnamed Medicinal soup");

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
