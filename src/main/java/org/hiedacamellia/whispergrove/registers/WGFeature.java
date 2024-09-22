package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.hiedacamellia.whispergrove.WhisperGrove;

import java.util.List;

public class WGFeature {
    public static final ResourceKey<ConfiguredFeature<?,?>> CASSIA_TREE_KEY = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, // The registry this key is for
            WhisperGrove.prefix("cassia_tree") // The registry name
    );

    public static final ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>> CASSIA_TREE = new ConfiguredFeature<>(Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(WGBlock.CASSIA_LOG.get()),
            new StraightTrunkPlacer(5, 2, 0),
            BlockStateProvider.simple(WGBlock.CASSIA_LEAVES.get()),
            new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1),3),
            new TwoLayersFeatureSize(1, 0, 2)
    ).build());

    public static final ResourceKey<PlacedFeature> CASSIA_TREE_PLACED_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, // The registry this key is for
            WhisperGrove.prefix("cassia_tree_place") // The registry name
    );
    public static final PlacedFeature CASSIA_TREE_PLACED = new PlacedFeature(DeferredHolder.create(CASSIA_TREE_KEY),
            List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                    InSquarePlacement.spread(),
                    CountPlacement.of(4),
                    BiomeFilter.biome(),
                    BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.DIRT.defaultBlockState(), Vec3i.ZERO))
            ));
}
