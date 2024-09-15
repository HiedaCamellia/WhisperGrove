package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;
import org.hiedacamellia.whispergrove.core.entry.builder.BaseItemBuilder;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WGItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    //黄芪 Radix Astragali
    //huang qi
    public static final DeferredItem<BaseItem> MILKVETCH = ITEMS.register("milkvetch",
            () -> new BaseItemBuilder().properties(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.8f).alwaysEdible().build())).build());

    //阳起石 actinolite
    //yang qi shi
    public static final DeferredItem<BaseItem> ACTINOLITE = ITEMS.register("actinolite",
            () -> new BaseItemBuilder().properties(new Item.Properties().rarity(Rarity.UNCOMMON)).build());

    //紫石英 Fluorite
    //zi shi ying
    public static final DeferredItem<BaseItem> FLUORITE = ITEMS.register("fluorite",
            () -> new BaseItemBuilder().properties(new Item.Properties().rarity(Rarity.UNCOMMON)).build());

    //桂枝 Cassia Twig
    //gui zhi
    public static final DeferredItem<BaseItem> CASSIA_TWIG = ITEMS.register("cassia_twig", () -> new BaseItemBuilder().build());

    //玫瑰花 Rose
    //mei gui hua
    public static final DeferredItem<BaseItem> ROSE = ITEMS.register("rose", () -> new BaseItemBuilder().build());

    //熟地黄 Roasted Rehmannia
    //shu di huang
    public static final DeferredItem<BaseItem> ROASTED_REHMANNIA = ITEMS.register("roasted_rehmannia", () -> new BaseItemBuilder().build());

    //海螵蛸 Roasted Cuttleflsh Bone
    //hai piao xiao
    public static final DeferredItem<BaseItem> ROASTED_CUTTLEFLSH_BONE = ITEMS.register("roasted_cuttleflsh_bone",
            () -> new BaseItemBuilder().properties(new Item.Properties().rarity(Rarity.UNCOMMON)).build());

    //附子 Prepared Common Monkshood Daughter Root
    //fu zi
    public static final DeferredItem<BaseItem> MONKSHOOD = ITEMS.register("monkshood", () -> new BaseItemBuilder().build());

    //丁香 Clove
    //ding xiang
    public static final DeferredItem<BaseItem> CLOVE = ITEMS.register("clove", () -> new BaseItemBuilder().build());

    //五味子 Schisandra chinensis
    //wu wei zi
    public static final DeferredItem<BaseItem> SCHISANDRA_CHINENSIS = ITEMS.register("schisandra_chinensis",
            () -> new BaseItemBuilder().properties(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.8f).alwaysEdible().build())).build());

    //炙甘草 Roasted Liquorice Root
    //zhi gan cao
    public static final DeferredItem<BaseItem> PREPARED_LICORICE = ITEMS.register("prepared_licorice",
            () -> new BaseItemBuilder().properties(new Item.Properties().rarity(Rarity.UNCOMMON)).build());

    //人参 Panax ginseng
    //ren shen
    public static final DeferredItem<BaseItem> GINSENG = ITEMS.register("ginseng",
            () -> new BaseItemBuilder().properties(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.8f).alwaysEdible().build())).build());

    //茯苓 Poria
    //fu ling
    public static final DeferredItem<BaseItem> PORIA_COCOS = ITEMS.register("poria_cocos",
            () -> new BaseItemBuilder().properties(new Item.Properties().rarity(Rarity.UNCOMMON)).build());

    //麦芽 Malt
    //mai ya
    public static final DeferredItem<BaseItem> MALT = ITEMS.register("malt", () -> new BaseItemBuilder().build());

    //阿胶 Donkey-hide Glue
    //e jiao
    public static final DeferredItem<BaseItem> DONKEY_HIDE_GELATIN = ITEMS.register("donkey_hide_gelatin", () -> new BaseItemBuilder().build());

    //煅龙骨 Fossilizid
    //duan long gu
    public static final DeferredItem<BaseItem> CALCINED_DRAGON_BONE = ITEMS.register("calcined_dragon_bone", () -> new BaseItemBuilder().build());

    //合欢皮 Albizzia Bark
    //he huan pi
    public static final DeferredItem<BaseItem> ALBIZIA_BARK = ITEMS.register("albizia_bark", () -> new BaseItemBuilder().build());

    //竹叶 bamboo leaf
    //zhu ye
    public static final DeferredItem<BaseItem> BAMBOO_LEAF = ITEMS.register("bamboo_leaf", () -> new BaseItemBuilder().build());

    //龙胆草 Gentian
    //long dan cao
    public static final DeferredItem<BaseItem> GENTIAN = ITEMS.register("gentian", () -> new BaseItemBuilder().build());

//
//    //蒲公英 Dandelion
//    //pu gong ying
//    public static final DeferredItem<BaseItem> DANDELION = ITEMS.register("dandelion", () -> new BaseItemBuilder().build());

    //竹茹 Bamboo Shavings
    //zhu gu
    public static final DeferredItem<BaseItem> BAMBOO_SHAVINGS = ITEMS.register("bamboo_shavings", () -> new BaseItemBuilder().build());

//    //昆布 kelp
//    //kun bu
//    public static final DeferredItem<BaseItem> SEA_TANGLE = ITEMS.register("sea_tangle", () -> new BaseItemBuilder().build());

    //寒水石 Gypsum
    //han shui shi
    public static final DeferredItem<BaseItem> GYPSUM_RUBRUM = ITEMS.register("gypsum_rubrum", () -> new BaseItemBuilder().build());

    //龟板胶 Glue of Tortoise Plastron
    //gui ban jiao
    public static final DeferredItem<BaseItem> TORTOISE_PLASTRON_GLUE = ITEMS.register("tortoise_plastron_glue", () -> new BaseItemBuilder().build());

    //生地黄 Drying Rehmannia Root
    //sheng di huang
    public static final DeferredItem<BaseItem> DRYING_REHMANNIA = ITEMS.register("drying_rehmannia", () -> new BaseItemBuilder().build());

    //生甘草 Drying Licorice Root
    //sheng gan cao
    public static final DeferredItem<BaseItem> DRYING_LICORICE = ITEMS.register("drying_licorice", () -> new BaseItemBuilder().build());

    //黄芪切片 Sliced Radix Astragali
    //Sliced huang qi
    public static final DeferredItem<BaseItem> SLICED_MILKVETCH = ITEMS.register("sliced_milkvetch",
            () -> new BaseItemBuilder().properties(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.8f).alwaysEdible().build())).build());

    //桂枝切片 Sliced Cassia Twig
    //Sliced Gui Zhi
    public static final DeferredItem<BaseItem> SLICED_CASSIA_TWIG = ITEMS.register("sliced_cassia_twig", () -> new BaseItemBuilder().build());

    //桂枝皮 Cassia Twig Bark
    //Gui zhi pi
    public static final DeferredItem<BaseItem> CASSIA_TWIG_BARK = ITEMS.register("cassia_twig_bark", () -> new BaseItemBuilder().build());

    //地黄 Rehmannia Root
    //di huang
    public static final DeferredItem<BaseItem> REHMANNIA = ITEMS.register("rehmannia", () -> new BaseItemBuilder().build());

    //甘草 Licorice Root
    public static final DeferredItem<BaseItem> LICORICE = ITEMS.register("licorice", () -> new BaseItemBuilder().build());

    //人参切片 Sliced Panax ginseng
    //Sliced ren shen
    public static final DeferredItem<BaseItem> SLICED_GINSENG = ITEMS.register("sliced_ginseng",
            () -> new BaseItemBuilder().properties(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.8f).alwaysEdible().build())).build());

    //龙胆草切片 SLiced Gentian
    //sliced long dan cao
    public static final DeferredItem<BaseItem> SLICED_GENTIAN = ITEMS.register("sliced_gentian", () -> new BaseItemBuilder().build());

    //墨鱼骨 Cuttleflsh Bone
    //mo yu gu
    public static final DeferredItem<BaseItem> CUTTLEBONE = ITEMS.register("cuttlebone", () -> new BaseItemBuilder().build());

    //熟附片 Roasted Prepared Common Monkshood Daughter Root
    //shu fu pian
//    public static final DeferredItem<BaseItem> SHU_FU_PIAN = ITEMS.register("roasted_monkshood", () -> new BaseItemBuilder().build());

    //骨头碎片 bone fragment
    //bone fragment
    public static final DeferredItem<BaseItem> BONE_FRAGMENT = ITEMS.register("bone_fragment", () -> new BaseItemBuilder().build());

    public static final String[] CROP_NAMES = {"rehmannia", "licorice", "milkvetch", "gentian", "ginseng" };

    public static Map<String, DeferredItem<Item>> CROP_SEED_ITEMS = Arrays.stream(CROP_NAMES)
            .collect(Collectors.toMap(s -> s, s -> ITEMS.register(s + "_seed", () -> new BlockItem(WGBlock.CROP_BLOCKS.get(s).get(), new Item.Properties()))));

    public static Item getGrowCropItem(String name) {
        switch (name) {
            case "rehmannia":
                return REHMANNIA.get();
            case "licorice":
                return LICORICE.get();
            case "milkvetch":
                return MILKVETCH.get();
            case "gentian":
                return GENTIAN.get();
            case "ginseng":
                return GINSENG.get();
            default:
                throw new IllegalArgumentException("Unknown crop name: " + name);
        }
    }
}