package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;
import org.hiedacamellia.whispergrove.core.entry.builder.BaseItemBuilder;


public class WGItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    //黄芪 Radix Astragali
    //huang qi
    public static final DeferredItem<BaseItem> HUANG_QI = ITEMS.register("huang_qi",
            () -> new BaseItemBuilder().regname("huang_qi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build()
    );

    //阳起石 actinolite
    //yang qi shi
    public static final DeferredItem<BaseItem> YANG_QI_SHI = ITEMS.register("yang_qi_shi",
            () -> new BaseItemBuilder().regname("yang_qi_shi").properties(
                    new Item.Properties().rarity(Rarity.UNCOMMON)
            ).build()
    );

    //紫石英 Fluorite
    //zi shi ying
    public static final DeferredItem<BaseItem> ZI_SHI_YING = ITEMS.register("zi_shi_ying",
            () -> new BaseItemBuilder().regname("zi_shi_ying").properties(
                    new Item.Properties().rarity(Rarity.UNCOMMON)
            ).build()
    );

    //桂枝 Cassia Twig
    //gui zhi
    public static final DeferredItem<BaseItem> GUI_ZHI = ITEMS.register("gui_zhi",
            () -> new BaseItemBuilder().regname("gui_zhi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //玫瑰花 Rose
    //mei gui hua
    public static final DeferredItem<BaseItem> GAN_MEI_GUI = ITEMS.register("gan_mei_gui",
            () -> new BaseItemBuilder().regname("gan_mei_gui").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //熟地黄 Roasted Rehmannia
    //shu di huang
    public static final DeferredItem<BaseItem> SHU_DI_HUANG = ITEMS.register("shu_di_huang",
            () -> new BaseItemBuilder().regname("shu_di_huang").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
                    ).build()
    );

    //海螵蛸 Roasted Cuttleflsh Bone
    //hai piao xiao
    public static final DeferredItem<BaseItem> HAI_PIAO_XIAO = ITEMS.register("hai_piao_xiao",
            () -> new BaseItemBuilder().regname("hai_piao_xiao").properties(
                    new Item.Properties().rarity(Rarity.UNCOMMON)
            ).build()
    );

    //附子 Prepared Common Monkshood Daughter Root
    //fu zi
    public static final DeferredItem<BaseItem> FU_ZI = ITEMS.register("fu_zi",
            () -> new BaseItemBuilder().regname("fu_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //丁香 Clove
    //ding xiang
    public static final DeferredItem<BaseItem> CHAO_DING_XIANG = ITEMS.register("chao_ding_xiang",
            () -> new BaseItemBuilder().regname("chao_ding_xiang").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //五味子 Schisandra chinensis
    //wu wei zi
    public static final DeferredItem<BaseItem> WU_WEI_ZI = ITEMS.register("wu_wei_zi",
            () -> new BaseItemBuilder().regname("wu_wei_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build()
    );

    //炙甘草 Roasted Liquorice Root
    //zhi gan cao
    public static final DeferredItem<BaseItem> ZHI_GAN_CAO = ITEMS.register("zhi_gan_cao",
            () -> new BaseItemBuilder().regname("zhi_gan_cao").properties(
                    new Item.Properties().rarity(Rarity.UNCOMMON)
            ).build()
    );

    //人参 Panax ginseng
    //ren shen
    public static final DeferredItem<BaseItem> REN_SHEN = ITEMS.register("ren_shen",
            () -> new BaseItemBuilder().regname("ren_shen").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build()
    );

    //茯苓 Poria
    //fu ling
    public static final DeferredItem<BaseItem> FU_LING = ITEMS.register("fu_ling",
            () -> new BaseItemBuilder().regname("fu_ling").properties(
                    new Item.Properties().rarity(Rarity.UNCOMMON)
            ).build()
    );

    //蜂蜜 Honey 原版

    //麦芽 Malt
    //mai ya
    public static final DeferredItem<BaseItem> MAI_YA = ITEMS.register("mai_ya",
            () -> new BaseItemBuilder().regname("mai_ya").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //阿胶 Donkey-hide Glue
    //e jiao
    public static final DeferredItem<BaseItem> E_JIAO = ITEMS.register("e_jiao",
            () -> new BaseItemBuilder().regname("e_jiao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //煅龙骨 Fossilizid
    //duan long gu
    public static final DeferredItem<BaseItem> DUAN_LONG_GU = ITEMS.register("duan_long_gu",
            () -> new BaseItemBuilder().regname("duan_long_gu").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //合欢皮 Albizzia Bark
    //he huan pi
    public static final DeferredItem<BaseItem> HE_HUAN_PI = ITEMS.register("he_huan_pi",
            () -> new BaseItemBuilder().regname("he_huan_pi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //竹叶 bamboo leaf
    //zhu ye
    public static final DeferredItem<BaseItem> ZHU_YE = ITEMS.register("zhu_ye",
            () -> new BaseItemBuilder().regname("zhu_ye").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //龙胆草 Gentian
    //long dan cao
    public static final DeferredItem<BaseItem> LONG_DAN_CAO = ITEMS.register("long_dan_cao",
            () -> new BaseItemBuilder().regname("long_dan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

//    //蒲公英 Dandelion
//    //pu gong ying
//    public static final DeferredItem<BaseItem> PU_GONG_YING = ITEMS.register("pu_gong_ying",
//            () -> new BaseItemBuilder().regname("pu_gong_ying").properties(
//                    new Item.Properties().rarity(Rarity.COMMON)
//            ).build()
//    );

    //竹茹 Bamboo Shavings
    //zhu gu
    public static final DeferredItem<BaseItem> ZHU_GU = ITEMS.register("zhu_gu",
            () -> new BaseItemBuilder().regname("zhu_gu").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

//    //昆布 kelp
//    //kun bu
//    public static final DeferredItem<BaseItem> KUN_BU = ITEMS.register("kun_bu",
//            () -> new BaseItemBuilder().regname("kun_bu").properties(
//                    new Item.Properties().rarity(Rarity.COMMON)
//            ).build()
//    );

    //寒水石 Gypsum
    //han shui shi
    public static final DeferredItem<BaseItem> HAN_SHUI_SHI = ITEMS.register("han_shui_shi",
            () -> new BaseItemBuilder().regname("han_shui_shi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //龟板胶 Glue of Tortoise Plastron
    //gui ban jiao
    public static final DeferredItem<BaseItem> GUI_BAN_JIAO = ITEMS.register("gui_ban_jiao",
            () -> new BaseItemBuilder().regname("gui_ban_jiao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //生地黄 Drying Rehmannia Root
    //sheng di huang
    public static final DeferredItem<BaseItem> SHENG_DI_HUANG = ITEMS.register("sheng_di_huang",
            () -> new BaseItemBuilder().regname("sheng_di_huang").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //生甘草 Drying Licorice Root
    //sheng gan cao
    public static final DeferredItem<BaseItem> SHENG_GAN_CAO = ITEMS.register("sheng_gan_cao",
            () -> new BaseItemBuilder().regname("sheng_gan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );


    //黄芪切片 Sliced Radix Astragali
    //Sliced huang qi
    public static final DeferredItem<BaseItem> SLICED_HUANG_QI = ITEMS.register("sliced_huang_qi",
            () -> new BaseItemBuilder().regname("sliced_huang_qi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build()
    );

    //桂枝切片 Sliced Cassia Twig
    //Sliced Gui Zhi
    public static final DeferredItem<BaseItem> SLICED_GUI_ZHI = ITEMS.register("sliced_gui_zhi",
            () -> new BaseItemBuilder().regname("sliced_gui_zhi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //桂枝皮 Cassia Twig Bark
    //Gui zhi pi
    public static final DeferredItem<BaseItem> GUI_ZHI_PI = ITEMS.register("gui_zhi_pi",
            () -> new BaseItemBuilder().regname("gui_zhi_pi").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //地黄 Rehmannia Root
    //di huang
    public static final DeferredItem<BaseItem> DI_HUANG = ITEMS.register("di_huang",
            () -> new BaseItemBuilder().regname("di_huang").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //甘草 Licorice Root
    public static final DeferredItem<BaseItem> GAN_CAO = ITEMS.register("gan_cao",
            () -> new BaseItemBuilder().regname("gan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //人参切片 Sliced Panax ginseng
    //Sliced ren shen
    public static final DeferredItem<BaseItem> SLICED_REN_SHEN = ITEMS.register("sliced_ren_shen",
            () -> new BaseItemBuilder().regname("sliced_ren_shen").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(2).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build()
    );

    //龙胆草切片 SLiced Gentian
    //sliced long dan cao
    public static final DeferredItem<BaseItem> SLICED_LONG_DAN_CAO = ITEMS.register("sliced_long_dan_cao",
            () -> new BaseItemBuilder().regname("sliced_long_dan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //墨鱼骨 Cuttleflsh Bone
    //mo yu gu
    public static final DeferredItem<BaseItem> MO_YU_GU = ITEMS.register("mo_yu_gu",
            () -> new BaseItemBuilder().regname("mo_yu_gu").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //熟附片 Roasted Prepared Common Monkshood Daughter Root
    //shu fu pian
    public static final DeferredItem<BaseItem> SHU_FU_PIAN = ITEMS.register("shu_fu_pian",
            () -> new BaseItemBuilder().regname("shu_fu_pian").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );

    //骨头碎片 bone fragment
    //bone fragment
    public static final DeferredItem<BaseItem> BONE_FRAGMENT = ITEMS.register("bone_fragment",
            () -> new BaseItemBuilder().regname("bone_fragment").properties(
                    new Item.Properties().rarity(Rarity.COMMON)
            ).build()
    );
}
