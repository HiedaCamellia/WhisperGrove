package org.hiedacamellia.whispergrove.registers;

import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class WGBiomeModifier {
    public static final ResourceKey<BiomeModifier> CASSIA_TREE = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS, // The registry this key is for
            WhisperGrove.prefix("cassia_tree") // The registry name
    );
    public static final ResourceKey<BiomeModifier> WG_MED = ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS, // The registry this key is for
            WhisperGrove.prefix("wg_med") // The registry name
    );
}
