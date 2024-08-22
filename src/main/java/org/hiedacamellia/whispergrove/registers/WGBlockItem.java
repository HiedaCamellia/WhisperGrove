package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class WGBlockItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    public static final DeferredItem<BlockItem> ROU_GUI_LEAVES = ITEMS.register("rou_gui_leaves", () -> new BlockItem(WGBlock.CASSIA_LEAVES.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROU_GUI_LOG = ITEMS.register("rou_gui_log", () -> new BlockItem(WGBlock.CASSIA_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROU_GUI_STRIPPED_LOG = ITEMS.register("rou_gui_stripped_log", () -> new BlockItem(WGBlock.CASSIA_STRIPPED_LOG.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROU_GUI_PLANKS = ITEMS.register("rou_gui_planks", () -> new BlockItem(WGBlock.CASSIA_PLANKS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROU_GUI_SLAB = ITEMS.register("rou_gui_slab", () -> new BlockItem(WGBlock.CASSIA_SLAB.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROU_GUI_STAIR = ITEMS.register("rou_gui_stair", () -> new BlockItem(WGBlock.CASSIA_STAIRS.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> ROLLER = ITEMS.register("roller", () -> new BlockItem(WGBlock.ROLLER.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> SPRINGING = ITEMS.register("springing", () -> new BlockItem(WGBlock.SPRINGING.get(), new Item.Properties()));

}
