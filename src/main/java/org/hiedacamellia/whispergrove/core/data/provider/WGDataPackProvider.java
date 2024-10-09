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
                            bootstrap.register(
                                    WGFeature.WG_MED_KEY,
                                    WGFeature.WG_MED
                            );
                        }).add(Registries.PLACED_FEATURE, bootstrap -> {
                            bootstrap.register(
                                    WGFeature.CASSIA_TREE_PLACED_KEY,
                                    WGFeature.CASSIA_TREE_PLACED
                            );
                            bootstrap.register(
                                    WGFeature.WG_MED_PLACED_KEY,
                                    WGFeature.WG_MED_PLACED
                            );
                        }).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, bootstrap -> {
                            HolderGetter<Biome> biomes = bootstrap.lookup(Registries.BIOME);
                            HolderGetter<PlacedFeature> placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);

                            bootstrap.register(WGBiomeModifier.CASSIA_TREE,
                                    new BiomeModifiers.AddFeaturesBiomeModifier(
                                            HolderSet.direct(List.of(biomes.getOrThrow(Biomes.DARK_FOREST),biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.BIRCH_FOREST))),
                                            HolderSet.direct(placedFeatures.getOrThrow(WGFeature.CASSIA_TREE_PLACED_KEY)),
                                            GenerationStep.Decoration.SURFACE_STRUCTURES
                                    )
                            );
//                            bootstrap.register(WGBiomeModifier.WG_MED,
//                                    new BiomeModifiers.AddFeaturesBiomeModifier(
//                                            HolderSet.direct(List.of(biomes.getOrThrow(Biomes.DARK_FOREST),biomes.getOrThrow(Biomes.FOREST),biomes.getOrThrow(Biomes.BIRCH_FOREST))),
//                                            HolderSet.direct(placedFeatures.getOrThrow(WGFeature.WG_MED_PLACED_KEY)),
//                                            GenerationStep.Decoration.VEGETAL_DECORATION
//                                    )
//                            );
                        }),
                Set.of(WhisperGrove.MODID));
    }

}
