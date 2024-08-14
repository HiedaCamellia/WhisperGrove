package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGBlock;

public class StateProvider extends BlockStateProvider {
    public StateProvider(PackOutput gen, ExistingFileHelper helper) {
        super(gen, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        axisBlock(WGBlock.RouGuiLog.get(), modLoc("block/rou_gui_log"), modLoc("block/rou_gui_log_top"));
        simpleBlockItem(WGBlock.RouGuiLog.get(), models().cubeTop("rou_gui_log", modLoc("block/rou_gui_log"), modLoc("block/rou_gui_log_top")));

        axisBlock(WGBlock.RouGuiStrippedLog.get(), modLoc("block/rou_gui_stripped_log"), modLoc("block/rou_gui_log_top"));
        simpleBlockItem(WGBlock.RouGuiStrippedLog.get(), models().cubeTop("rou_gui_stripped_log", modLoc("block/rou_gui_stripped_log"), modLoc("block/rou_gui_log_top")));

        simpleBlockWithItem(WGBlock.RouGuiLeaves.get(), models().leaves("rou_gui_leaves", modLoc("block/rou_gui_leaves")));

        simpleBlockWithItem(WGBlock.RouGuiPlanks.get(), cubeAll(WGBlock.RouGuiPlanks.get()));

        slabBlock(WGBlock.RouGuiSlab.get(), modLoc("block/rou_gui_planks"), modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiSlab.get(), models().slab("rou_gui_slab", modLoc("block/rou_gui_planks"), modLoc("block/rou_gui_planks"), modLoc("block/rou_gui_planks")));

        stairsBlock(WGBlock.RouGuiStair.get(), modLoc("block/rou_gui_planks"));
        simpleBlockItem(WGBlock.RouGuiStair.get(), models().stairs("rou_gui_stair", modLoc("block/rou_gui_planks"), modLoc("block/rou_gui_planks"), modLoc("block/rou_gui_planks")));

        simpleBlock(WGBlock.Roller.get(), this.models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "roller")));
        simpleBlockItem(WGBlock.Roller.get(), this.models().getExistingFile(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "roller")));

        WGBlock.CROP_BLOCKS.forEach((s, baseCropBlockDeferredBlock) -> registerCropBlockModels(baseCropBlockDeferredBlock.get(), s));
    }

    private void registerCropBlockModels(Block block, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(CropBlock.AGE);
            return ConfiguredModel.builder()
                    .modelFile(models().crop(getCropBlockModelName(name, age), getCropBlockModelLocation(name, age)))
                    .build();
        });

    }

    private ResourceLocation getCropBlockModelLocation(String name, int age) {
        return ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, getCropBlockModelName(name, age));
    }

    private String getCropBlockModelName(String name, int age) {
        return "block/" + name + "_stage" + switch (age) {
            case 0, 1 -> 0;
            case 2, 3 -> 1;
            case 4, 5, 6 -> 2;
            case 7 -> 3;
            default -> throw new IllegalArgumentException("Invalid age: " + age);
        };
    }
}
