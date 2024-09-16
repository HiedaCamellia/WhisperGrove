package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class WGBlockItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    public static final DeferredItem<BlockItem> CASSIA_LEAVES = ITEMS.register("cassia_leaves", () -> new BlockItem(WGBlock.CASSIA_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CASSIA_LOG = ITEMS.register("cassia_log", () -> new BlockItem(WGBlock.CASSIA_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CASSIA_STRIPPED_LOG = ITEMS.register("cassia_stripped_log", () -> new BlockItem(WGBlock.CASSIA_STRIPPED_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CASSIA_PLANKS = ITEMS.register("cassia_planks", () -> new BlockItem(WGBlock.CASSIA_PLANKS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CASSIA_SLAB = ITEMS.register("cassia_slab", () -> new BlockItem(WGBlock.CASSIA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CASSIA_STAIRS = ITEMS.register("cassia_stairs", () -> new BlockItem(WGBlock.CASSIA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROLLER = ITEMS.register("roller", () -> new BlockItem(WGBlock.ROLLER.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> CUTTER = ITEMS.register("cutter", () -> new BlockItem(WGBlock.CUTTER.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> POT = ITEMS.register("pot", () -> new BlockItem(WGBlock.POT.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> SPRINGING = ITEMS.register("springing", () -> new BlockItem(WGBlock.SPRINGING.get(), new Item.Properties()));

}
