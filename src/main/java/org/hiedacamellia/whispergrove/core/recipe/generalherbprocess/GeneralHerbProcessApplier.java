package org.hiedacamellia.whispergrove.core.recipe.generalherbprocess;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.registers.WGRicipe;

import java.util.List;

public class GeneralHerbProcessApplier {

    public static void apply(BlockState blockState, List<ItemStack> itemStacks,Level level, BlockPos pos) {

        if (level.isClientSide()) return;

        ItemStack result = result(blockState, itemStacks, level, pos);
        // If there is a result, break the block and drop the result in the world.
        if (!result.isEmpty()) {
            //level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            ItemEntity entity = new ItemEntity(level,
                    // Center of pos.
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    result);
            level.addFreshEntity(entity);

        }
    }

    public static ItemStack result(BlockState blockState, List<ItemStack> itemStacks,Level level, BlockPos pos){

        RecipeManager recipes = level.getRecipeManager();

        GeneralHerbProcessInput input = new GeneralHerbProcessInput(blockState, itemStacks);

        var optional = recipes.getRecipeFor(
                WGRicipe.GENERAL_HERB_PROCESS.get(),
                input,
                level
        );

        ItemStack result = optional
                .map(RecipeHolder::value)
                .map(e -> e.assemble(input, level.registryAccess()))
                .orElse(ItemStack.EMPTY);
        if (!result.isEmpty()) {
            return result;
        }else {
            return ItemStack.EMPTY;
        }

    }
}
