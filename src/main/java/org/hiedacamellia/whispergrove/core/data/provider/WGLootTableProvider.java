package org.hiedacamellia.whispergrove.core.data.provider;

import com.google.common.collect.Iterables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.registries.DeferredHolder;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static org.hiedacamellia.whispergrove.registers.WGBlock.*;

public class WGLootTableProvider extends LootTableProvider {

    public WGLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Set.of(), List.of(new SubProviderEntry(WGBlockLoot::new, LootContextParamSets.BLOCK)), registries);
    }

    public static class WGBlockLoot extends BlockLootSubProvider {

        protected WGBlockLoot(HolderLookup.Provider lookupProvider) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
        }

        @Override
        protected void generate() {
            this.dropSelf(CASSIA_LOG.get());
            this.dropSelf(CASSIA_STRIPPED_LOG.get());
            this.dropSelf(CASSIA_PLANKS.get());
            this.dropSelf(CASSIA_SLAB.get());
            this.dropSelf(CASSIA_STAIRS.get());
            this.dropSelf(ROLLER.get());
            this.add(CASSIA_LEAVES.get(), block -> this.createSilkTouchOrShearsDispatchTable(block,
                            this.applyExplosionCondition(block, LootItem.lootTableItem(CASSIA_LEAVES))));
        }

        @Nonnull
        @Override
        protected Iterable<Block> getKnownBlocks() {
            // 模组自定义的方块战利品表必须覆盖此方法，以绕过对原版方块战利品表的检查（此处返回该模组的所有方块）
            return Iterables.transform(BLOCKS.getEntries(), DeferredHolder::get);
        }

    }

}