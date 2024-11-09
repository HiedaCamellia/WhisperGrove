package org.hiedacamellia.whispergrove.core.data.lang;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.data.lang.gen.DescGen;
import org.hiedacamellia.whispergrove.core.data.lang.gen.EffectGen;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGBlockItem;
import org.hiedacamellia.whispergrove.registers.WGItem;

import java.util.Map;

public class ChineseLanguageProvider extends CamelliaLanguageProvider {

        public ChineseLanguageProvider(PackOutput output) {
            super(output, WhisperGrove.MODID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            add("tooltip.whispergrove.press_shift","按住Shift键以显示更多信息");
            add("itemGroup.whispergrove", "浅草轻语");
            add("menu.whispergrove.viscera_tab","脏腑");
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

            addWithTooltip(WGItem.MILKVETCH.get(),"黄芪","");
            addWithTooltip(WGItem.ACTINOLITE.get(),"阳起石","");
            addWithTooltip(WGItem.FLUORITE.get(),"紫石英","");
            addWithTooltip(WGItem.CASSIA_TWIG.get(),"桂枝","");
            addWithTooltip(WGItem.ROSE.get(),"干玫瑰","");
            addWithTooltip(WGItem.ROASTED_REHMANNIA.get(),"熟地黄","");
            addWithTooltip(WGItem.ROASTED_CUTTLEFLSH_BONE.get(),"海螵蛸","");
            addWithTooltip(WGItem.MONKSHOOD.get(),"附子","");
            addWithTooltip(WGItem.CLOVE.get(),"炒丁香","");
            addWithTooltip(WGItem.SCHISANDRA_CHINENSIS.get(),"五味子","");
            addWithTooltip(WGItem.PREPARED_LICORICE.get(),"炙甘草","");
            addWithTooltip(WGItem.GINSENG.get(),"人参","");
            addWithTooltip(WGItem.PORIA_COCOS.get(),"茯苓","");
            addWithTooltip(WGItem.MALT.get(),"麦芽","");
            addWithTooltip(WGItem.DONKEY_HIDE_GELATIN.get(),"阿胶","");
            addWithTooltip(WGItem.CALCINED_DRAGON_BONE.get(),"煅龙骨","");
            addWithTooltip(WGItem.ALBIZIA_BARK.get(),"合欢皮","");
            addWithTooltip(WGItem.BAMBOO_LEAF.get(),"竹叶","");
            addWithTooltip(WGItem.BAMBOO_SHAVINGS.get(),"竹茹","");
            addWithTooltip(WGItem.GENTIAN.get(),"龙胆草","");
            addWithTooltip(WGItem.GYPSUM_RUBRUM.get(),"寒水石","");
            addWithTooltip(WGItem.TORTOISE_PLASTRON_GLUE.get(),"龟板胶","");
            addWithTooltip(WGItem.DRYING_REHMANNIA.get(),"生地黄","");
            addWithTooltip(WGItem.DRYING_LICORICE.get(),"生甘草","");
            addWithTooltip(WGItem.ROASTED_MONKSHOOD.get(),"熟附片","");

            addWithTooltip(WGItem.SLICED_MILKVETCH.get(),"黄芪切片","");
            addWithTooltip(WGItem.SLICED_CASSIA_TWIG.get(),"桂枝切片","");
            addWithTooltip(WGItem.CASSIA_TWIG_BARK.get(),"桂枝皮","");
            addWithTooltip(WGItem.REHMANNIA.get(),"地黄","");
            addWithTooltip(WGItem.LICORICE.get(),"甘草","");
            addWithTooltip(WGItem.SLICED_GINSENG.get(),"人参切片","");
            addWithTooltip(WGItem.SLICED_GENTIAN.get(),"龙胆草切片","");
            addWithTooltip(WGItem.CUTTLEBONE.get(),"墨鱼骨","");
            addWithTooltip(WGItem.BONE_FRAGMENT.get(),"骨头碎片","");

            addWithTooltip(WGItem.CROP_SEED_ITEMS.get("rehmannia").get(),"地黄种子","");
            addWithTooltip(WGItem.CROP_SEED_ITEMS.get("licorice").get(),"甘草种子","");
            addWithTooltip(WGItem.CROP_SEED_ITEMS.get("milkvetch").get(),"黄芪种子","");
            addWithTooltip(WGItem.CROP_SEED_ITEMS.get("gentian").get(),"龙胆草","");
            addWithTooltip(WGItem.CROP_SEED_ITEMS.get("ginseng").get(),"人参种子","");

            addWithTooltip(WGBlockItem.CASSIA_LEAVES.get(),"肉桂树叶","");
            addWithTooltip(WGBlockItem.CASSIA_LOG.get(),"肉桂原木","");
            addWithTooltip(WGBlockItem.CASSIA_STRIPPED_LOG.get(),"去皮肉桂原木","");
            addWithTooltip(WGBlockItem.CASSIA_PLANKS.get(),"肉桂木板","");
            addWithTooltip(WGBlockItem.CASSIA_SLAB.get(),"肉桂台阶","");
            addWithTooltip(WGBlockItem.CASSIA_STAIRS.get(),"肉桂楼梯","");

            addWithTooltip(WGBlockItem.ROLLER.get(),"药碾","");
            addWithTooltip(WGBlockItem.CUTTER.get(),"药铡","");
            addWithTooltip(WGBlockItem.POT.get(),"大锅","");
            addWithTooltip(WGBlockItem.SPRINGING.get(),"药壶","");

            addWithTooltip(WGItem.SOUP.get(),"未命名药汤","");

            add("whispergrove.configuration.title","浅草轻语 配置");
            add("whispergrove.configuration.debug","调试");
            add("whispergrove.configuration.disease_mild","轻度疾病");
            add("whispergrove.configuration.disease_moderate","中度疾病");
            add("whispergrove.configuration.disease_critical","重度疾病");
            add("whispergrove.configuration.viscera_constant","脏腑变化常数");
            add("whispergrove.configuration.ecliptic_compact", "节气联动");
            add("whispergrove.configuration.debug.tooltip","设置为true以启用调试信息");
            add("whispergrove.configuration.disease_mild.tooltip","获得轻度疾病的阴阳点数比例");
            add("whispergrove.configuration.disease_moderate.tooltip","获得中度疾病的阴阳点数比例");
            add("whispergrove.configuration.disease_critical.tooltip","获得重度疾病的阴阳点数比例(弃用)");
            add("whispergrove.configuration.viscera_constant.tooltip","脏腑变化点数的倍数");
            add("whispergrove.configuration.ecliptic_compact.tooltip", "设置为true以启用节气的联动");
            add("whispergrove.configuration.section.whispergrove.common.toml", "通用配置");
            add("whispergrove.configuration.section.whispergrove.common.toml.title", "浅草轻语 通用配置");

            add("neoforge.configuration.uitext.undo","撤销");
            add("neoforge.configuration.uitext.reset","重置");

            add("tooltip.whispergrove.heart","心经 ");
            add("tooltip.whispergrove.liver","肝经 ");
            add("tooltip.whispergrove.lung","肺经 ");
            add("tooltip.whispergrove.kidney","肾经 ");
            add("tooltip.whispergrove.spleen","脾经 ");
            add("tooltip.whispergrove.yin","寒%d");
            add("tooltip.whispergrove.yang","温%d");
            add("tooltip.whispergrove.ping","平%d");
            add("viscera.whispergrove.hover.yin","阴：%d点数");
            add("viscera.whispergrove.hover.yang","阳：%d点数");
        }
}
