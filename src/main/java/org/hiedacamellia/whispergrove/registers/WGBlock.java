package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blocks.TestBlock;

public class WGBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WhisperGrove.MODID);

    public static final DeferredBlock<Block> TEST_BLOCK = BLOCKS.register("test_block",() -> new TestBlock("test_block"));
}
