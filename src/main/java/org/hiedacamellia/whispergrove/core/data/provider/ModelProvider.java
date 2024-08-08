package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WhisperGrove.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

//        singleTexture("yang_bian",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "yang_bian"));
//
//        singleTexture("duan_long_gu",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "duan_long_gu"));
//
//        singleTexture("han_shui_shi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "han_shui_shi"));
//
//        singleTexture("kun_bu",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "kun_bu"));
//
//        singleTexture("hai_piao_xiao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "hai_piao_xiao"));
//
//        singleTexture("mai_ya",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "mai_ya"));
//
//        singleTexture("he_huan_pi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "he_huan_pi"));
//
//        singleTexture("mei_gui_hua",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "mei_gui_hua"));
//
//        singleTexture("ding_xiang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "ding_xiang"));
//
//        singleTexture("zhu_ye",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "zhu_ye"));
//
//        singleTexture("zhu_ru",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "zhu_ru"));
//
//        singleTexture("pu_gong_ding",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "pu_gong_ding"));
//
//        singleTexture("feng_mi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "feng_mi"));
//
//        singleTexture("a_jiao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "a_jiao"));
//
//        singleTexture("gui_ban_jiao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "gui_ban_jiao"));
//
//        singleTexture("fu_ling",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "fu_ling"));
//
//        singleTexture("fu_zi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "fu_zi"));
//
//        singleTexture("wu_wei_zi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "wu_wei_zi"));
//
//        singleTexture("rou_gui",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "rou_gui"));
//
//        singleTexture("bai_zhu",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "bai_zhu"));
//
//        singleTexture("gan_cao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "gan_cao"));
//
//        singleTexture("zhi_gan_cao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "zhi_gan_cao"));
//
//        singleTexture("di_huang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "di_huang"));
//
//        singleTexture("shu_di_huang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "shu_di_huang"));
//
//        singleTexture("ren_shen",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "ren_shen"));
//
//        singleTexture("mai_dong",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "mai_dong"));
//
//        singleTexture("huang_qi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "huang_qi"));
//
//        singleTexture("fang_feng",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "fang_feng"));
//
//        singleTexture("sheng_jiang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "sheng_jiang"));
//
//        singleTexture("dang_gui",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "dang_gui"));
//
//        singleTexture("gou_qi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "gou_qi"));
//
//        singleTexture("long_dan_cao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "long_dan_cao"));
//
//        singleTexture("zhi_zi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "zhi_zi"));
//
//        singleTexture("shan_yao",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "shan_yao"));
//
//        singleTexture("tu_si_zi",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "tu_si_zi"));
//
//        singleTexture("ling_gui_shu_gan_tang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "ling_gui_shu_gan_tang"));
//
//        singleTexture("dao_chi_san",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "dao_chi_san"));
//
//        singleTexture("sheng_mai_yin",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "sheng_mai_yin"));
//
//        singleTexture("yu_ping_feng_san",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                "item/" + "yu_ping_feng_san"));
//
//        singleTexture("can_fu_wan",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                        "item/" + "can_fu_wan"));
//
//        singleTexture("mai_men_dong_tang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                        "item/" + "mai_men_dong_tang"));
//
//        singleTexture("long_dan_xie_gan_tang",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                        "item/" + "long_dan_xie_gan_tang"));
//
//        singleTexture("zuo_gui_wan",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                        "item/" + "zuo_gui_wan"));
//
//        singleTexture("you_gui_wan",
//                ResourceLocation.withDefaultNamespace("item/generated"),
//                "layer0",
//                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
//                        "item/" + "you_gui_wan"));
    }
}
