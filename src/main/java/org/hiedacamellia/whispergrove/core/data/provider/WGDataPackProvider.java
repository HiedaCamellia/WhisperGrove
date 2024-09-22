package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGBiomeModifier;
import org.hiedacamellia.whispergrove.registers.WGFeature;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WGDataPackProvider extends DatapackBuiltinEntriesProvider {
    public WGDataPackProvider(PackOutput output,CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output,
                lookupProvider,
                new RegistrySetBuilder()
                        .add(Registries.CONFIGURED_FEATURE, bootstrap -> {
                            bootstrap.register(
                                    WGFeature.CASSIA_TREE_KEY,
                                    WGFeature.CASSIA_TREE
                            );
                        }).add(Registries.PLACED_FEATURE, bootstrap -> {
                            bootstrap.register(
                                    WGFeature.CASSIA_TREE_PLACED_KEY,
                                    WGFeature.CASSIA_TREE_PLACED
                            );
                        }).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, bootstrap -> {
                            // Lookup any necessary registries.
                            // Static registries only need to be looked up if you need to grab the tag data.
                            HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
                            HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

                            // Register the biome modifiers.
                            bootstrap.register(WGBiomeModifier.CASSIA_TREE,
                                    new BiomeModifiers.AddFeaturesBiomeModifier(
                                            // The biome(s) to generate within
                                            HolderSet.direct(List.of(biomes.getOrThrow(Biomes.DARK_FOREST),biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.BIRCH_FOREST))),
                                            // The feature(s) to generate within the biomes
                                            HolderSet.direct(placedFeatures.getOrThrow(WGFeature.CASSIA_TREE_PLACED_KEY)),
                                            // The generation step
                                            GenerationStep.Decoration.SURFACE_STRUCTURES
                                    )
                            );
                        }),
                Set.of(WhisperGrove.MODID));
    }

}
