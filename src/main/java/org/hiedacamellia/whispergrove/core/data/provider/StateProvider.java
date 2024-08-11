package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGBlock;

public class StateProvider extends BlockStateProvider {
    public StateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        logBlock(WGBlock.RouGuiLog.get());
        simpleBlockItem(WGBlock.RouGuiLog.get(),cubeAll(WGBlock.RouGuiLog.get()));

        logBlock(WGBlock.RouGuiStrippedLog.get());
        simpleBlockItem(WGBlock.RouGuiStrippedLog.get(),cubeAll(WGBlock.RouGuiStrippedLog.get()));

        simpleBlockWithItem(WGBlock.RouGuiLeaves.get(), models().leaves("rou_gui_leaves", modLoc("block/rou_gui_leaves")));

        simpleBlockWithItem(WGBlock.RouGuiPlanks.get(), cubeAll(WGBlock.RouGuiPlanks.get()));

        slabBlock(WGBlock.RouGuiSlab.get(),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiSlab.get(),models().slab("rou_gui_slab",modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks")));

        stairsBlock(WGBlock.RouGuiStair.get(),modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiStair.get(),models().stairs("rou_gui_stair",modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks")));
    }
}
