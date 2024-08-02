package org.hiedacamellia.camellialib.core.entry.common;

import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CamelliaConfigBuilder extends ModConfigSpec.Builder {

    private String modId;
    private ModConfig.Type type;

    public CamelliaConfigBuilder modId(String modId) {
        this.modId = modId;
        return this;
    }

    public CamelliaConfigBuilder side(ModConfig.Type type) {
        this.type = type;
        return this;
    }

    public String getModId() {
        return modId;
    }

    public ModConfig.Type getType() {
        return type;
    }

    public String getFileName() {
        return getModId() + ".toml";
    }

    public static CamelliaConfigBuilder create() {
        return new CamelliaConfigBuilder();
    }

}
