package org.hiedacamellia.camellialib.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import org.hiedacamellia.camellialib.CamelliaLib;
import org.hiedacamellia.camellialib.core.entry.common.CamelliaConfigBuilder;

import static net.neoforged.fml.config.ModConfig.Type.COMMON;

public class CamelliaConfig {
    //public static final CamelliaConfigBuilder builder = CamelliaLib.REGISTRY.configBuilder(COMMON);
    public static final CamelliaConfigBuilder builder = CamelliaConfigBuilder.create().modId(CamelliaLib.MODID).side(COMMON);

    public static final ModConfigSpec.ConfigValue<Boolean> DEBUG= builder.comment("Used for test")
                .comment("用于调试")
                .define("deBug", false);


    public static final ModConfigSpec SPEC = builder.build();

    public static boolean deBug;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        deBug=DEBUG.get();
    }
}
