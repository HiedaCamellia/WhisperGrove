package org.hiedacamellia.whispergrove;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = WhisperGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue DEBUG = BUILDER
            .comment("Set to true to enable debug info")
            .comment("设置为true以启用调试信息")
            .define("debug", true);

    private static final ModConfigSpec.DoubleValue DISEASE_MILD = BUILDER
            .comment("Get the ratio of yin and yang points of mild disease")
            .comment("获得轻度疾病的阴阳点数比例")
            .defineInRange("disease_mild", 1.3,1.0,Double.MAX_VALUE);

    private static final ModConfigSpec.DoubleValue DISEASE_MODERATE = BUILDER
            .comment("Get the ratio of yin and yang points of moderate disease")
            .comment("获得中度疾病的阴阳点数比例")
            .defineInRange("disease_moderate", 1.6,1.0,Double.MAX_VALUE);

    private static final ModConfigSpec.DoubleValue DISEASE_CRITICAL = BUILDER
            .comment("Get the ratio of yin and yang points of Critical disease")
            .comment("获得重度疾病的阴阳点数比例")
            .defineInRange("disease_Critical", 2.0,1.0,Double.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean debug;
    public static double diseaseMild;
    public static double diseaseModerate;
    public static double diseaseCritical;

    public static void setDebug(boolean debug){
        DEBUG.set(debug);
    }


//    private static boolean validateItemName(final Object obj)
//    {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
//    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        debug = DEBUG.get();
        diseaseMild = DISEASE_MILD.get();
        diseaseModerate = DISEASE_MODERATE.get();
        diseaseCritical = DISEASE_CRITICAL.get();
    }
}
