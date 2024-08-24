package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;
import org.hiedacamellia.whispergrove.registers.WGItem;

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

            add(WGItem.MILKVETCH.get(),"黄芪");
            add("tooltip.whispergrove.milkvetch","");
            add("item.whispergrove.actinolite","阳起石");
            add("tooltip.whispergrove.actinolite","");
            add("item.whispergrove.fluorite","紫石英");
            add("tooltip.whispergrove.fluorite","");
            add("item.whispergrove.cassia_twig","桂枝");
            add("tooltip.whispergrove.cassia_twig","");
            add("item.whispergrove.rose","干玫瑰");
            add("tooltip.whispergrove.rose","");
            add("item.whispergrove.roasted_rehmannia","熟地黄");
            add("tooltip.whispergrove.roasted_rehmannia","");
            add("item.whispergrove.roasted_cuttleflsh_bone","海螵蛸");
            add("tooltip.whispergrove.roasted_cuttleflsh_bone","");
            add("item.whispergrove.monkshood","附子");
            add("tooltip.whispergrove.monkshood","");
            add("item.whispergrove.clove","炒丁香");
            add("tooltip.whispergrove.clove","");
            add("item.whispergrove.schisandra_chinensis","五味子");
            add("tooltip.whispergrove.schisandra_chinensis","");
            add("item.whispergrove.prepared_licorice","炙甘草");
            add("tooltip.whispergrove.prepared_licorice","");
            add("item.whispergrove.ginseng","人参");
            add("tooltip.whispergrove.ginseng","");
            add("item.whispergrove.poria_cocos","茯苓");
            add("tooltip.whispergrove.poria_cocos","");
            add("item.whispergrove.malt","麦芽");
            add("tooltip.whispergrove.malt","");
            add("item.whispergrove.donkey_hide_gelatin","阿胶");
            add("tooltip.whispergrove.donkey_hide_gelatin","");
            add("item.whispergrove.calcined_dragon_bone","煅龙骨");
            add("tooltip.whispergrove.calcined_dragon_bone","");
            add("item.whispergrove.albizia_bark","合欢皮");
            add("tooltip.whispergrove.albizia_bark","");
            add("item.whispergrove.bamboo_leaf","竹叶");
            add("tooltip.whispergrove.bamboo_leaf","");
            add("item.whispergrove.gentian","龙胆草");
            add("tooltip.whispergrove.gentian","");
            add("item.whispergrove.bamboo_shavings","竹茹");
            add("tooltip.whispergrove.bamboo_shavings","");
            add("item.whispergrove.gypsum_rubrum","寒水石");
            add("tooltip.whispergrove.gypsum_rubrum","");
            add("item.whispergrove.tortoise_plastron_glue","龟板胶");
            add("tooltip.whispergrove.tortoise_plastron_glue","");
            add("item.whispergrove.drying_rehmannia","生地黄");
            add("tooltip.whispergrove.drying_rehmannia","");
            add("item.whispergrove.drying_licorice","生甘草");
            add("tooltip.whispergrove.drying_licorice","");

            add("item.whispergrove.sliced_milkvetch","黄芪切片");
            add("tooltip.whispergrove.sliced_milkvetch","");
            add("item.whispergrove.sliced_cassia_twig","桂枝切片");
            add("tooltip.whispergrove.sliced_cassia_twig","");
            add("item.whispergrove.cassia_twig_bark","桂枝皮");
            add("tooltip.whispergrove.cassia_twig_bark","");
            add("item.whispergrove.rehmannia","地黄");
            add("tooltip.whispergrove.rehmannia","");
            add("item.whispergrove.licorice","甘草");
            add("tooltip.whispergrove.licorice","");
            add("item.whispergrove.sliced_ginseng","人参切片");
            add("tooltip.whispergrove.sliced_ginseng","");
            add("item.whispergrove.sliced_gentian","龙胆草切片");
            add("tooltip.whispergrove.sliced_gentian","");
            add("item.whispergrove.cuttlebone","墨鱼骨");
            add("tooltip.whispergrove.cuttlebone","");
            add("item.whispergrove.bone_fragment","骨头碎片");
            add("tooltip.whispergrove.bone_fragment","");

            add("block.whispergrove.roller","药碾");
            add("tooltip.whispergrove.roller","");


            add("block.whispergrove.cassia_log","肉桂原木");
            add("tooltip.whispergrove.cassia_log","");
            add("block.whispergrove.cassia_stripped_log","去皮肉桂原木");
            add("tooltip.whispergrove.cassia_stripped_log","");
            add("block.whispergrove.cassia_leaves","肉桂树叶");
            add("tooltip.whispergrove.cassia_leaves","");
            add("block.whispergrove.cassia_planks","肉桂木板");
            add("tooltip.whispergrove.cassia_planks","");
            add("block.whispergrove.cassia_slab","肉桂台阶");
            add("tooltip.whispergrove.cassia_slab","");
            add("block.whispergrove.cassia_stairs","肉桂楼梯");
            add("tooltip.whispergrove.cassia_stairs","");

            add("block.whispergrove.springing","药壶");
            add("tooltip.whispergrove.springing","");


            add("config.whispergrove.title","浅草轻语 配置");
            add("config.whispergrove.comfirm","确认");
            add("config.whispergrove.debug","调试");
            add("config.whispergrove.debug.desc","是否开启调试模式");
            add("config.whispergrove.disease_mild","轻度疾病的阴阳点数比例");
            add("config.whispergrove.disease_moderate","中度疾病的阴阳点数比例");
            add("config.whispergrove.disease_critical","重度疾病的阴阳点数比例");
            add("config.whispergrove.viscera_constant","脏腑变化点数的倍数");
        }
}
