package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blocks.*;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;
import org.hiedacamellia.whispergrove.core.entry.BaseCropBlock;
import org.hiedacamellia.whispergrove.core.entry.BaseLogBlock;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WGBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WhisperGrove.MODID);

    //public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.register("test_block",() -> new TestBlock("test_block"));

    public static final DeferredBlock<BaseLogBlock> RouGuiLog = BLOCKS.register("rou_gui_log", () -> new RouGuiLogBlock("rou_gui_log"));
    public static final DeferredBlock<BaseLogBlock> RouGuiStrippedLog = BLOCKS.register("rou_gui_stripped_log", () -> new RouGuiStrippedLogBlock("rou_gui_stripped_log"));
    public static final DeferredBlock<BaseBlock> RouGuiPlanks = BLOCKS.register("rou_gui_planks", () -> new RouGuiPlanksBlock("rou_gui_planks"));
    public static final DeferredBlock<SlabBlock> RouGuiSlab = BLOCKS.register("rou_gui_slab", () -> new RouGuiSlabBlock("rou_gui_slab"));
    public static final DeferredBlock<LeavesBlock> RouGuiLeaves = BLOCKS.register("rou_gui_leaves", () -> new RouGuiLeavesBlock("rou_gui_leaves"));
    public static final DeferredBlock<StairBlock> RouGuiStair = BLOCKS.register("rou_gui_stair", () -> new RouGuiStairsBlock("rou_gui_stair"));

    public static final DeferredBlock<RollerBlock> Roller = BLOCKS.register("roller", () -> new RollerBlock("roller"));

    public static final Map<String, DeferredBlock<BaseCropBlock>> CROP_BLOCKS = Stream.of(
                    "di_huang",
                    "gan_cao",
                    "huang_qi",
                    "long_dan_cao",
                    "ren_shen"
            )
            .collect(Collectors.toMap(
                    s -> s,
                    s -> BLOCKS.register(s, () -> new BaseCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES), s))
            ));

    public static final  DeferredBlock<BaseBlock> SPRINGING = BLOCKS.register("springing", () -> new SpringingBlock("springing"));
}
