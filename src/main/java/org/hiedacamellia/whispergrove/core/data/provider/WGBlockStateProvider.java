package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGBlock;

public class WGBlockStateProvider extends BlockStateProvider {

    public WGBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {

        axisBlock((RotatedPillarBlock) WGBlock.CASSIA_LOG.get(), modLoc("block/cassia_log"), modLoc("block/cassia_log_top"));
        simpleBlockItem(WGBlock.CASSIA_LOG.get(), models().cubeTop("cassia_log", modLoc("block/cassia_log"), modLoc("block/cassia_log_top")));

        axisBlock((RotatedPillarBlock) WGBlock.CASSIA_STRIPPED_LOG.get(), modLoc("block/cassia_stripped_log"), modLoc("block/cassia_log_top"));
        simpleBlockItem(WGBlock.CASSIA_STRIPPED_LOG.get(), models().cubeTop("cassia_stripped_log", modLoc("block/cassia_stripped_log"), modLoc("block/cassia_log_top")));

        simpleBlockWithItem(WGBlock.CASSIA_LEAVES.get(), models().leaves("cassia_leaves", modLoc("block/cassia_leaves")));

        simpleBlockWithItem(WGBlock.CASSIA_PLANKS.get(), cubeAll(WGBlock.CASSIA_PLANKS.get()));

        slabBlock(WGBlock.CASSIA_SLAB.get(), modLoc("block/cassia_planks"), modLoc("block/cassia_planks"));
        simpleBlockItem(WGBlock.CASSIA_SLAB.get(), models().slab("cassia_slab", modLoc("block/cassia_planks"), modLoc("block/cassia_planks"), modLoc("block/cassia_planks")));

        stairsBlock(WGBlock.CASSIA_STAIRS.get(), modLoc("block/cassia_planks"));
        simpleBlockItem(WGBlock.CASSIA_STAIRS.get(), models().stairs("cassia_stair", modLoc("block/cassia_planks"), modLoc("block/cassia_planks"), modLoc("block/cassia_planks")));

        simpleBlockWithItem(WGBlock.ROLLER.get(), this.models().getExistingFile(modLoc("roller")));
        simpleBlockWithItem(WGBlock.CUTTER.get(), this.models().getExistingFile(modLoc("cutter")));
        simpleBlockWithItem(WGBlock.POT.get(), this.models().getExistingFile(modLoc("pot")));
        simpleBlockWithItem(WGBlock.SPRINGING.get(), this.models().getExistingFile(modLoc("springing")));

        WGBlock.CROP_BLOCKS.forEach((s, baseCropBlockDeferredBlock) -> registerCropBlockModels(baseCropBlockDeferredBlock.get(), s));

        WGBlock.WILD_CROP_BLOCKS.forEach((s, baseCropBlockDeferredBlock) ->
                simpleBlockWithItem(baseCropBlockDeferredBlock.get(), models().crop(s, modLoc("block/" + s)).renderType("minecraft:translucent")));

    }

    private void registerCropBlockModels(Block block, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(CropBlock.AGE);
            return ConfiguredModel.builder()
                    .modelFile(models().crop(getCropBlockModelName(name, age), getCropBlockModelLocation(name, age)).renderType("minecraft:translucent"))
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