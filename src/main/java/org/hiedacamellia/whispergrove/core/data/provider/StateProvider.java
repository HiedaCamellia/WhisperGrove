package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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

        axisBlock(WGBlock.RouGuiLog.get(),modLoc("block/rou_gui_log"),modLoc("block/rou_gui_log_top"));
        simpleBlockItem(WGBlock.RouGuiLog.get(),models().cubeTop("rou_gui_log",modLoc("block/rou_gui_log"),modLoc("block/rou_gui_log_top")));

        axisBlock(WGBlock.RouGuiStrippedLog.get(),modLoc("block/rou_gui_stripped_log"),modLoc("block/rou_gui_log_top"));
        simpleBlockItem(WGBlock.RouGuiStrippedLog.get(),models().cubeTop("rou_gui_stripped_log",modLoc("block/rou_gui_stripped_log"),modLoc("block/rou_gui_log_top")));

        simpleBlockWithItem(WGBlock.RouGuiLeaves.get(), models().leaves("rou_gui_leaves", modLoc("block/rou_gui_leaves")));

        simpleBlockWithItem(WGBlock.RouGuiPlanks.get(), cubeAll(WGBlock.RouGuiPlanks.get()));

        slabBlock(WGBlock.RouGuiSlab.get(),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiSlab.get(),models().slab("rou_gui_slab",modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks")));

        stairsBlock(WGBlock.RouGuiStair.get(),modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiStair.get(),models().stairs("rou_gui_stair",modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks"),modLoc("block/rou_gui_planks")));

        simpleBlock(WGBlock.Roller.get(),this.models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "roller")));
        simpleBlockItem(WGBlock.Roller.get(), this.models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "roller")));
    }
}
