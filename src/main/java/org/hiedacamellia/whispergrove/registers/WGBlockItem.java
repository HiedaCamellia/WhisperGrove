package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blockitems.*;

public class WGBlockItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    //public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block", TestBlockItem::new);

    public static final DeferredItem<BlockItem> RouGuiLog = ITEMS.register("rou_gui_log", RouGuiLogBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiStrippedLog = ITEMS.register("rou_gui_stripped_log", RouGuiStrippedLogBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiLeaves = ITEMS.register("rou_gui_leaves", RouGuiLeavesBlockItem::new);
    public static final DeferredItem<BlockItem> RouGuiBlanks = ITEMS.register("rou_gui_planks", RouGuiBlanksBlockItem::new);
}
