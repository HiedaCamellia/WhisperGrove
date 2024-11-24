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

            addWithTooltip(WGItem.MILKVETCH.get(),"黄芪","性味：味甘，性微温§n功效：益气升阳 固表止汗 利水消肿 托毒生肌");
            addWithTooltip(WGItem.ACTINOLITE.get(),"阳起石","性味：味咸，性温§n功效：温肾壮阳");
            addWithTooltip(WGItem.FLUORITE.get(),"紫石英","性味：味甘，性温§n功效：镇心定惊 温肺降逆 散寒暖宫");
            addWithTooltip(WGItem.ROSE.get(),"干玫瑰","性味：味甘、微苦，性温§n功效：理气解郁 和血散瘀");
            addWithTooltip(WGItem.CASSIA_TWIG_BARK.get(),"桂枝皮","性味：味辛、甘，性温§n功效：散寒解表 温通经脉 通阳化气");
            addWithTooltip(WGItem.ROASTED_REHMANNIA.get(),"熟地黄","性味：味甘，性寒§n功效：清热凉血 养阴生津");
            addWithTooltip(WGItem.ROASTED_CUTTLEFLSH_BONE.get(),"海螵蛸","性味：味咸，性微§n温功效：收敛 制酸 止血 固精止带");
            addWithTooltip(WGItem.MONKSHOOD.get(),"附子","性味：味辛、甘，性热；有毒§n功效：回阳救逆 助阳补火 散寒止痛");
            addWithTooltip(WGItem.CLOVE.get(),"炒丁香","性味：味辛，性温§n功效：温中降逆 补肾助阳");
            addWithTooltip(WGItem.SCHISANDRA_CHINENSIS.get(),"五味子","性味：味酸，性温§n功效：益气敛肺 滋肾涩精 生津止渴 止泻敛汗");
            addWithTooltip(WGItem.PREPARED_LICORICE.get(),"炙甘草","性味：味甘，性平§n功效：补脾益气 清热解毒 祛痰止咳 调和诸药");
            addWithTooltip(WGItem.GINSENG.get(),"人参","性味：味甘、微苦，性温§n功效：大补元气 强心固脱 安神生津");
            addWithTooltip(WGItem.PORIA_COCOS.get(),"茯苓","性味：味淡，性平§n功效：利水渗湿 健脾安神");
            addWithTooltip(WGItem.MALT.get(),"麦芽","性味：味甘，性平§n功效：行气消食 健脾开胃 回乳");
            addWithTooltip(WGItem.DONKEY_HIDE_GELATIN.get(),"阿胶","性味：味甘，性平§n功效：补血止血 滋阴润燥");
            addWithTooltip(WGItem.CALCINED_DRAGON_BONE.get(),"煅龙骨","性味：味甘、涩，性平§n功效：内服：镇惊安神 收敛涩精；外用：生肌敛疮");
            addWithTooltip(WGItem.ALBIZIA_BARK.get(),"合欢皮","性味：味甘，性平§n功效：解郁安神 活血消肿");
            addWithTooltip(WGItem.BAMBOO_LEAF.get(),"竹叶","性味：味甘、淡，性寒§n功效：清热除烦 利尿");
            addWithTooltip(WGItem.BAMBOO_SHAVINGS.get(),"竹茹","性味：味凉，性甘§n功效：清热化痰 除烦止呕 安胎凉血");
            addWithTooltip(WGItem.GENTIAN.get(),"龙胆草","性味：味苦，性寒§n功效：清热燥湿 泻肝胆火");
            addWithTooltip(WGItem.GYPSUM_RUBRUM.get(),"寒水石","性味：味辛咸，性寒§n功效：清热降火 利窍 消肿");
            addWithTooltip(WGItem.TORTOISE_PLASTRON_GLUE.get(),"龟板胶","性味：味咸、甘，性凉§n功效：滋阴 补血 止血");
            add(WGItem.DRYING_REHMANNIA.get(),"生地黄");
            add(WGItem.DRYING_LICORICE.get(),"生甘草");
            add(WGItem.ROASTED_MONKSHOOD.get(),"熟附片");

            add(WGItem.CASSIA_TWIG.get(),"桂枝");
            add(WGItem.SLICED_MILKVETCH.get(),"黄芪切片");
            add(WGItem.SLICED_CASSIA_TWIG.get(),"桂枝切片");
            add(WGItem.REHMANNIA.get(),"地黄");
            add(WGItem.LICORICE.get(),"甘草");
            add(WGItem.SLICED_GINSENG.get(),"人参切片");
            add(WGItem.SLICED_GENTIAN.get(),"龙胆草切片");
            add(WGItem.CUTTLEBONE.get(),"墨鱼骨");
            add(WGItem.BONE_FRAGMENT.get(),"骨头碎片");

            add(WGItem.CROP_SEED_ITEMS.get("rehmannia").get(),"地黄种子");
            add(WGItem.CROP_SEED_ITEMS.get("licorice").get(),"甘草种子");
            add(WGItem.CROP_SEED_ITEMS.get("milkvetch").get(),"黄芪种子");
            add(WGItem.CROP_SEED_ITEMS.get("gentian").get(),"龙胆草种子");
            add(WGItem.CROP_SEED_ITEMS.get("ginseng").get(),"人参种子");

            add(WGBlockItem.CASSIA_LEAVES.get(),"肉桂树叶");
            add(WGBlockItem.CASSIA_LOG.get(),"肉桂原木");
            add(WGBlockItem.CASSIA_STRIPPED_LOG.get(),"去皮肉桂原木");
            add(WGBlockItem.CASSIA_PLANKS.get(),"肉桂木板");
            add(WGBlockItem.CASSIA_SLAB.get(),"肉桂台阶");
            add(WGBlockItem.CASSIA_STAIRS.get(),"肉桂楼梯");

            add(WGBlockItem.ROLLER.get(),"药碾");
            add(WGBlockItem.CUTTER.get(),"药铡");
            add(WGBlockItem.POT.get(),"大锅");
            add(WGBlockItem.SPRINGING.get(),"药壶");

            add(WGItem.SOUP.get(),"未命名药汤");

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
