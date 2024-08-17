package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blockitems.*;
import org.hiedacamellia.whispergrove.content.common.blocks.SpringingBlock;

public class WGBlockItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    //public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block", TestBlockItem::new);

    public static final DeferredItem<BlockItem> RouGuiLeaves = ITEMS.register("rou_gui_leaves", RouGuiLeavesBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiLog = ITEMS.register("rou_gui_log", RouGuiLogBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiStrippedLog = ITEMS.register("rou_gui_stripped_log", RouGuiStrippedLogBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiPlanks = ITEMS.register("rou_gui_planks", RouGuiPlanksBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiSlab = ITEMS.register("rou_gui_slab", RouGuiSlabBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiButton = ITEMS.register("rou_gui_stair", RouGuiStairsBlockItem::new);
    public static final DeferredItem<BlockItem> Roller = ITEMS.register("roller",RollerBlockItem::new);
    public static final DeferredItem<BlockItem> SPRINGING = ITEMS.register("springing",SpringingBlockItem::new);
}
