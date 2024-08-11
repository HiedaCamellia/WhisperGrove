package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blocks.*;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;
import org.hiedacamellia.whispergrove.core.entry.BaseLogBlock;

public class WGBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WhisperGrove.MODID);

    //public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.register("test_block",() -> new TestBlock("test_block"));

    public static final DeferredBlock<BaseLogBlock> RouGuiLog = BLOCKS.register("rou_gui_log",() -> new RouGuiLogBlock("rou_gui_log"));
    public static final DeferredBlock<BaseLogBlock> RouGuiStrippedLog = BLOCKS.register("rou_gui_stripped_log",() -> new RouGuiStrippedLogBlock("rou_gui_stripped_log"));
    public static final DeferredBlock<BaseBlock> RouGuiLeaves = BLOCKS.register("rou_gui_leaves",() -> new RouGuiLeavesBlock("rou_gui_leaves"));
    public static final DeferredBlock<BaseBlock> RouGuiBlanks = BLOCKS.register("rou_gui_planks",() -> new RouGuiBlanksBlock("rou_gui_planks"));

}
