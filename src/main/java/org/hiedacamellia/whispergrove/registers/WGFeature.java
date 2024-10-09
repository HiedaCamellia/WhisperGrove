package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseThresholdProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.hiedacamellia.whispergrove.WhisperGrove;

import java.util.List;

public class WGFeature {
    public static final ResourceKey<ConfiguredFeature<?,?>> CASSIA_TREE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            WhisperGrove.prefix("cassia_tree")
    );

    public static final ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>> CASSIA_TREE = new ConfiguredFeature<>(Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(WGBlock.CASSIA_LOG.get()),
            new StraightTrunkPlacer(4, 2, 0),
            BlockStateProvider.simple(WGBlock.CASSIA_LEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),3),
            new TwoLayersFeatureSize(1, 0, 2)
    ).forceDirt().build());

    public static final ResourceKey<PlacedFeature> CASSIA_TREE_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, WhisperGrove.prefix("cassia_tree"));

    public static final PlacedFeature CASSIA_TREE_PLACED = new PlacedFeature(Holder.direct(CASSIA_TREE),
            List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                    InSquarePlacement.spread(), CountPlacement.of(1), BiomeFilter.biome(),
                    SurfaceWaterDepthFilter.forMaxDepth(0),
                    PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)));

    public static final ResourceKey<ConfiguredFeature<?, ?>> WG_MED_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, WhisperGrove.prefix("wg_med"));

    public static final ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>> WG_MED = new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(
            64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseThresholdProvider(496156461L,
            new NormalNoise.NoiseParameters(0, 1.0), 0.005F, -0.8F, 0.33333334F, Blocks.DANDELION.defaultBlockState(),
            List.of(WGBlock.CROP_BLOCKS.get("rehmannia").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("licorice").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("milkvetch").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("gentian").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("ginseng").get().defaultBlockState()),
            List.of(WGBlock.CROP_BLOCKS.get("rehmannia").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("licorice").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("milkvetch").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("gentian").get().defaultBlockState(),
                    WGBlock.CROP_BLOCKS.get("ginseng").get().defaultBlockState()))))));

    public static final ResourceKey<PlacedFeature> WG_MED_PLACED_KEY = ResourceKey.create(Registries.PLACED_FEATURE, WhisperGrove.prefix("wg_med"));

    public static final PlacedFeature WG_MED_PLACED = new PlacedFeature(Holder.direct(WG_MED),
            List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                    InSquarePlacement.spread(), CountPlacement.of(1), BiomeFilter.biome(),
                    SurfaceWaterDepthFilter.forMaxDepth(0),
                    PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING),
                    RarityFilter.onAverageOnceEvery(10)));

}