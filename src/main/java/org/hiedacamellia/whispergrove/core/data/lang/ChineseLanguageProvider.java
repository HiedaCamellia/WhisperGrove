package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;

import java.util.Map;

public class ChineseLanguageProvider extends LanguageProvider {

        public ChineseLanguageProvider(PackOutput output) {
            super(output, WhisperGrove.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            add("tooltip.whispergrove.press_shift","按住Shift键以显示更多信息");
            add("itemGroup.whispergrove", "浅草轻语");
            add("network.whispergrove.failed","无法处理网络数据: %s");
            add("cmd.whispergrove.modify.success","修改值成功：%f");
            add("cmd.whispergrove.modify.failed","修改值失败：%s");
            add("cmd.whispergrove.set.success","设置值成功：%f");
            add("cmd.whispergrove.set.failed","设置值失败：%s");
            add("cmd.whispergrove.get.success","获取值成功：%f");
            add("cmd.whispergrove.get.failed","获取值失败：%s");
            add("cmd.whispergrove.reset.success","重设值成功");
            add("cmd.whispergrove.reset.failed","重设值失败");

            Map<String,String> desc = new DescGen().gendesc_zh();
            for (Map.Entry<String, String> entry : desc.entrySet()) {
                add(entry.getKey(),entry.getValue());
            }

            Map<String,String> eff = new EffectGen().geneffect_zh();
            for (Map.Entry<String, String> entry : eff.entrySet()) {
                add(entry.getKey(),entry.getValue());
            }

            add("item.whispergrove.huang_qi","黄芪");
            add("tooltip.whispergrove.huang_qi","");
            add("item.whispergrove.yang_qi_shi","阳起石");
            add("tooltip.whispergrove.yang_qi_shi","");
            add("item.whispergrove.zi_shi_ying","紫石英");
            add("tooltip.whispergrove.zi_shi_ying","");
            add("item.whispergrove.gui_zhi","桂枝");
            add("tooltip.whispergrove.gui_zhi","");
            add("item.whispergrove.gan_mei_gui","干玫瑰");
            add("tooltip.whispergrove.gan_mei_gui","");
            add("item.whispergrove.shu_di_huang","熟地黄");
            add("tooltip.whispergrove.shu_di_huang","");
            add("item.whispergrove.hai_piao_xiao","海螵蛸");
            add("tooltip.whispergrove.hai_piao_xiao","");
            add("item.whispergrove.fu_zi","附子");
            add("tooltip.whispergrove.fu_zi","");
            add("item.whispergrove.chao_ding_xiang","丁香");
            add("tooltip.whispergrove.chao_ding_xiang","");
            add("item.whispergrove.wu_wei_zi","五味子");
            add("tooltip.whispergrove.wu_wei_zi","");
            add("item.whispergrove.zhi_gan_cao","炙甘草");
            add("tooltip.whispergrove.zhi_gan_cao","");
            add("item.whispergrove.ren_shen","人参");
            add("tooltip.whispergrove.ren_shen","");
            add("item.whispergrove.fu_ling","茯苓");
            add("tooltip.whispergrove.fu_ling","");
            add("item.whispergrove.mai_ya","麦芽");
            add("tooltip.whispergrove.mai_ya","");
            add("item.whispergrove.e_jiao","阿胶");
            add("tooltip.whispergrove.e_jiao","");
            add("item.whispergrove.duan_long_gu","煅龙骨");
            add("tooltip.whispergrove.duan_long_gu","");
            add("item.whispergrove.he_huan_pi","合欢皮");
            add("tooltip.whispergrove.he_huan_pi","");
            add("item.whispergrove.zhu_ye","竹叶");
            add("tooltip.whispergrove.zhu_ye","");
            add("item.whispergrove.long_dan_cao","龙胆草");
            add("tooltip.whispergrove.long_dan_cao","");
            add("item.whispergrove.pu_gong_ying","蒲公英");
            add("tooltip.whispergrove.pu_gong_ying","");
            add("item.whispergrove.zhu_gu","竹茹");
            add("tooltip.whispergrove.zhu_gu","");
            add("item.whispergrove.kun_bu","昆布");
            add("tooltip.whispergrove.kun_bu","");
            add("item.whispergrove.han_shui_shi","寒水石");
            add("tooltip.whispergrove.han_shui_shi","");
            add("item.whispergrove.gui_ban_jiao","龟板胶");
            add("tooltip.whispergrove.gui_ban_jiao","");
            add("item.whispergrove.sheng_di_huang","生地黄");
            add("tooltip.whispergrove.sheng_di_huang","");
            add("item.whispergrove.sheng_gan_cao","生甘草");
            add("tooltip.whispergrove.sheng_gan_cao","");

            add("item.whispergrove.sliced_huang_qi","黄芪切片");
            add("tooltip.whispergrove.sliced_huang_qi","");
            add("item.whispergrove.sliced_gui_zhi","桂枝切片");
            add("tooltip.whispergrove.sliced_gui_zhi","");
            add("item.whispergrove.gui_zhi_pi","桂枝皮");
            add("tooltip.whispergrove.gui_zhi_pi","");
            add("item.whispergrove.di_huang","地黄");
            add("tooltip.whispergrove.di_huang","");
            add("item.whispergrove.gan_cao","甘草");
            add("tooltip.whispergrove.gan_cao","");
            add("item.whispergrove.sliced_ren_shen","人参切片");
            add("tooltip.whispergrove.sliced_ren_shen","");
            add("item.whispergrove.sliced_long_dan_cao","龙胆草切片");
            add("tooltip.whispergrove.sliced_long_dan_cao","");
            add("item.whispergrove.mo_yu_gu","墨鱼骨");
            add("tooltip.whispergrove.mo_yu_gu","");

            add("block.whispergrove.rou_gui_log","肉桂原木");
            add("tooltip.whispergrove.rou_gui_log","");
            add("block.whispergrove.rou_gui_stripped_log","去皮肉桂原木");
            add("tooltip.whispergrove.rou_gui_stripped_log","");
            add("block.whispergrove.rou_gui_leaves","肉桂树叶");
            add("tooltip.whispergrove.rou_gui_leaves","");
            add("block.whispergrove.rou_gui_planks","肉桂木板");
            add("tooltip.whispergrove.rou_gui_planks","");
            add("block.whispergrove.rou_gui_slab","肉桂台阶");
            add("tooltip.whispergrove.rou_gui_slab","");
            add("block.whispergrove.rou_gui_stair","肉桂楼梯");
            add("tooltip.whispergrove.rou_gui_stair","");
        }
}
