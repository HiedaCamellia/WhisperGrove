package org.hiedacamellia.whispergrove.core.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.blocks.TestBlock;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGBlockItem;

public class StateProvider extends BlockStateProvider {
    public StateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(WGBlock.TEST_BLOCK.get(), cubeAll(WGBlock.TEST_BLOCK.get()));
        simpleBlockItem(WGBlock.TEST_BLOCK.get(), cubeAll(WGBlock.TEST_BLOCK.get()));
    }
}
