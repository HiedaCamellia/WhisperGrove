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

        RecipeManager recipes = level.getRecipeManager();

        if (level.isClientSide()) return;
        // Create an input and query the recipe.
        GeneralHerbProcessInput input = new GeneralHerbProcessInput(blockState, itemStacks);

        var optional = recipes.getRecipeFor(
                // The recipe type to get the recipe for. In our case, we use the crafting type.
                WGRicipe.GENERAL_HERB_PROCESS.get(),
                // Our recipe input.
                input,
                // Our level context.
                level
        );

        ItemStack result = optional
                .map(RecipeHolder::value)
                .map(e -> e.assemble(input, level.registryAccess()))
                .orElse(ItemStack.EMPTY);
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
}
