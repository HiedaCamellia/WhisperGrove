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

    //羊鞭 sheep whip
    //yang bian
    public static final DeferredItem<BaseItem> YANG_BIAN = ITEMS.register("yang_bian",
            () -> new BaseItemBuilder().regname("yang_bian").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //煅龙骨 Fossilizid
    //duan long gu
    public static final DeferredItem<BaseItem> DUAN_LONG_GU = ITEMS.register("duan_long_gu",
            () -> new BaseItemBuilder().regname("duan_long_gu").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //寒水石 Gypsum
    //han shui shi
    public static final DeferredItem<BaseItem> HAN_SHUI_SHI = ITEMS.register("han_shui_shi",
            () -> new BaseItemBuilder().regname("han_shui_shi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //昆布 kelp
    //kun bu
    public static final DeferredItem<BaseItem> KUN_BU = ITEMS.register("kun_bu",
            () -> new BaseItemBuilder().regname("kun_bu").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //海螵蛸 Cuttlebone
    //hai piao xiao
    public static final DeferredItem<BaseItem> HAI_PIAO_XIAO = ITEMS.register("hai_piao_xiao",
            () -> new BaseItemBuilder().regname("hai_piao_xiao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //麦芽 malt
    //mai ya
    public static final DeferredItem<BaseItem> MAI_YA = ITEMS.register("mai_ya",
            () -> new BaseItemBuilder().regname("mai_ya").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //合欢皮 Albizzia Bark
    //he huan pi
    public static final DeferredItem<BaseItem> HE_HUAN_PI = ITEMS.register("he_huan_pi",
            () -> new BaseItemBuilder().regname("he_huan_pi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //玫瑰花 rose
    //mei gui hua
    public static final DeferredItem<BaseItem> MEI_GUI_HUA = ITEMS.register("mei_gui_hua",
            () -> new BaseItemBuilder().regname("mei_gui_hua").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //丁香 clove
    //ding xiang
    public static final DeferredItem<BaseItem> DING_XIANG = ITEMS.register("ding_xiang",
            () -> new BaseItemBuilder().regname("ding_xiang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //竹叶 bamboo leaf
    //zhu ye
    public static final DeferredItem<BaseItem> ZHU_YE = ITEMS.register("zhu_ye",
            () -> new BaseItemBuilder().regname("zhu_ye").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //竹茹 bamboo shoot
    //zhu ru
    public static final DeferredItem<BaseItem> ZHU_RU = ITEMS.register("zhu_ru",
            () -> new BaseItemBuilder().regname("zhu_ru").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //蒲公英 dandelion
    //pu gong ying
    public static final DeferredItem<BaseItem> PU_GONG_YING = ITEMS.register("pu_gong_ying",
            () -> new BaseItemBuilder().regname("pu_gong_ying").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //蜂蜜 honey
    //feng mi
    public static final DeferredItem<BaseItem> FENG_MI = ITEMS.register("feng_mi",
            () -> new BaseItemBuilder().regname("feng_mi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //阿胶 donkey-hide gelatin
    //a jiao
    public static final DeferredItem<BaseItem> A_JIAO = ITEMS.register("a_jiao",
            () -> new BaseItemBuilder().regname("a_jiao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //龟板胶 Glue of Tortoise Plastron
    //gui ban jiao
    public static final DeferredItem<BaseItem> GUI_BAN_JIAO = ITEMS.register("gui_ban_jiao",
            () -> new BaseItemBuilder().regname("gui_ban_jiao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //茯苓 Poria
    //fu ling
    public static final DeferredItem<BaseItem> FU_LING = ITEMS.register("fu_ling",
            () -> new BaseItemBuilder().regname("fu_ling").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //附子 Aconite
    //fu zi
    public static final DeferredItem<BaseItem> FU_ZI = ITEMS.register("fu_zi",
            () -> new BaseItemBuilder().regname("fu_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //五味子 Schisandra
    //wu wei zi
    public static final DeferredItem<BaseItem> WU_WEI_ZI = ITEMS.register("wu_wei_zi",
            () -> new BaseItemBuilder().regname("wu_wei_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //肉桂 cinnamon
    //rou gui
    public static final DeferredItem<BaseItem> ROU_GUI = ITEMS.register("rou_gui",
            () -> new BaseItemBuilder().regname("rou_gui").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //白术 Largehead Atractylodes Rhizome
    //bai zhu
    public static final DeferredItem<BaseItem> BAI_ZHU = ITEMS.register("bai_zhu",
            () -> new BaseItemBuilder().regname("bai_zhu").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());


    //甘草 liquorice
    //gan cao
    public static final DeferredItem<BaseItem> GAN_CAO = ITEMS.register("gan_cao",
            () -> new BaseItemBuilder().regname("gan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //炙甘草 Roasted Liquorice
    //zhi gan cao
    public static final DeferredItem<BaseItem> ZHI_GAN_CAO = ITEMS.register("zhi_gan_cao",
            () -> new BaseItemBuilder().regname("zhi_gan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //地黄 Rehmannia
    //di huang
    public static final DeferredItem<BaseItem> DI_HUANG = ITEMS.register("di_huang",
            () -> new BaseItemBuilder().regname("di_huang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //熟地黄 Roasted Rehmannia
    //shu di huang
    public static final DeferredItem<BaseItem> SHU_DI_HUANG = ITEMS.register("shu_di_huang",
            () -> new BaseItemBuilder().regname("shu_di_huang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //人参 ginseng
    //ren shen
    public static final DeferredItem<BaseItem> REN_SHEN = ITEMS.register("ren_shen",
            () -> new BaseItemBuilder().regname("ren_shen").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //麦冬 Ophiopogon
    //mai dong
    public static final DeferredItem<BaseItem> MAI_DONG = ITEMS.register("mai_dong",
            () -> new BaseItemBuilder().regname("mai_dong").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //黄芪 Astragalus
    //huang qi
    public static final DeferredItem<BaseItem> HUANG_QI = ITEMS.register("huang_qi",
            () -> new BaseItemBuilder().regname("huang_qi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //防风 Ledebouriella
    //fang feng
    public static final DeferredItem<BaseItem> FANG_FENG = ITEMS.register("fang_feng",
            () -> new BaseItemBuilder().regname("fang_feng").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //生姜 Ginger
    //sheng jiang
    public static final DeferredItem<BaseItem> SHENG_JIANG = ITEMS.register("sheng_jiang",
            () -> new BaseItemBuilder().regname("sheng_jiang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //当归 Chinese Angelica
    //dang gui
    public static final DeferredItem<BaseItem> DANG_GUI = ITEMS.register("dang_gui",
            () -> new BaseItemBuilder().regname("dang_gui").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //枸杞 Goji
    //gou qi
    public static final DeferredItem<BaseItem> GOU_QI = ITEMS.register("gou_qi",
            () -> new BaseItemBuilder().regname("gou_qi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //龙胆草 Gentian
    //long dan cao
    public static final DeferredItem<BaseItem> LONG_DAN_CAO = ITEMS.register("long_dan_cao",
            () -> new BaseItemBuilder().regname("long_dan_cao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //栀子 Gardenia
    //zhi zi
    public static final DeferredItem<BaseItem> ZHI_ZI = ITEMS.register("zhi_zi",
            () -> new BaseItemBuilder().regname("zhi_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //山药 Chinese Yam
    //shan yao
    public static final DeferredItem<BaseItem> SHAN_YAO = ITEMS.register("shan_yao",
            () -> new BaseItemBuilder().regname("shan_yao").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //菟丝子 Dodder Seed
    //tu si zi
    public static final DeferredItem<BaseItem> TU_SI_ZI = ITEMS.register("tu_si_zi",
            () -> new BaseItemBuilder().regname("tu_si_zi").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //苓桂术甘汤
    //ling gui shu gan tang
    public static final DeferredItem<BaseItem> LING_GUI_SHU_GAN_TANG = ITEMS.register("ling_gui_shu_gan_tang",
            () -> new BaseItemBuilder().regname("ling_gui_shu_gan_tang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //导赤散
    //dao chi san
    public static final DeferredItem<BaseItem> DAO_CHI_SAN = ITEMS.register("dao_chi_san",
            () -> new BaseItemBuilder().regname("dao_chi_san").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //生脉饮
    //sheng mai yin
    public static final DeferredItem<BaseItem> SHENG_MAI_YIN = ITEMS.register("sheng_mai_yin",
            () -> new BaseItemBuilder().regname("sheng_mai_yin").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //玉屏风散
    //yu ping feng san
    public static final DeferredItem<BaseItem> YU_PING_FENG_SAN = ITEMS.register("yu_ping_feng_san",
            () -> new BaseItemBuilder().regname("yu_ping_feng_san").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //参附丸
    //shen fu wan
    public static final DeferredItem<BaseItem> SHEN_FU_WAN = ITEMS.register("shen_fu_wan",
            () -> new BaseItemBuilder().regname("shen_fu_wan").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //麦门冬汤
    //mai men dong tang
    public static final DeferredItem<BaseItem> MAI_MEN_DONG_TANG = ITEMS.register("mai_men_dong_tang",
            () -> new BaseItemBuilder().regname("mai_men_dong_tang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //龙胆泻肝汤
    //long dan xie gan tang
    public static final DeferredItem<BaseItem> LONG_DAN_XIE_GAN_TANG = ITEMS.register("long_dan_xie_gan_tang",
            () -> new BaseItemBuilder().regname("long_dan_xie_gan_tang").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //左归丸
    //zuo gui wan
    public static final DeferredItem<BaseItem> ZUO_GUI_WAN = ITEMS.register("zuo_gui_wan",
            () -> new BaseItemBuilder().regname("zuo_gui_wan").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());

    //右归丸
    //you gui wan
    public static final DeferredItem<BaseItem> YOU_GUI_WAN = ITEMS.register("you_gui_wan",
            () -> new BaseItemBuilder().regname("you_gui_wan").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).build());
}
