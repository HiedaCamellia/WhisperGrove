package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;

import java.util.List;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerModels() {
        List.of(
                "huang_qi",
                "yang_qi_shi",
                "gui_zhi",
                "zi_shi_ying",
                "gan_mei_gui",
                "shu_di_huang",
                "hai_piao_xiao",
                "fu_zi",
                "chao_ding_xiang",
                "wu_wei_zi",
                "zhi_gan_cao",
                "ren_shen",
                "fu_ling",
                "mai_ya",
                "e_jiao",
                "duan_long_gu",
                "he_huan_pi",
                "zhu_ye",
                "long_dan_cao",
                "zhu_gu",
                "han_shui_shi",
                "gui_ban_jiao",
                "sheng_di_huang",
                "sheng_gan_cao",
                "sliced_huang_qi",
                "sliced_gui_zhi",
                "gui_zhi_pi",
                "di_huang",
                "gan_cao",
                "sliced_ren_shen",
                "sliced_long_dan_cao"
                ,"mo_yu_gu",
                //"shu_fu_pian",
                "bone_fragment"
        ).forEach(s -> this.singleTexture(s,
                ResourceLocation.withDefaultNamespace("item/generated"), "layer0",
                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "item/" + s)));
    }
}
