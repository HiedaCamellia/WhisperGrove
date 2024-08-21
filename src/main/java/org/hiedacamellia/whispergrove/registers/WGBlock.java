package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blocks.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WGBlock {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(WhisperGrove.MODID);
    public static final DeferredBlock<Block> CASSIA_LOG = BLOCKS.register("cassia_log", () -> Blocks.log(MapColor.WOOD, MapColor.COLOR_BROWN));
    public static final DeferredBlock<Block> CASSIA_STRIPPED_LOG = BLOCKS.register("cassia_stripped_log", () -> Blocks.log(MapColor.WOOD, MapColor.WOOD));
    public static final DeferredBlock<Block> CASSIA_PLANKS = BLOCKS.register("cassia_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<SlabBlock> CASSIA_SLAB = BLOCKS.register("cassia_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<Block> CASSIA_LEAVES = BLOCKS.register("cassia_leaves", () -> Blocks.leaves(SoundType.GRASS));
    public static final DeferredBlock<StairBlock> CASSIA_STAIRS = BLOCKS.register("cassia_stairs",
            () -> new StairBlock(CASSIA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<SpringingBlock> SPRINGING = BLOCKS.register("springing", SpringingBlock::new);
    public static final DeferredBlock<RollerBlock> ROLLER = BLOCKS.register("roller", RollerBlock::new);

    public static final Map<String, DeferredBlock<CropBlock>> CROP_BLOCKS = Stream.of(
            "rehmannia", "licorice", "milkvetch", "gentian", "ginseng").collect(Collectors.toMap(s -> s,
            s -> BLOCKS.register(s, () -> new CropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES)))));

}