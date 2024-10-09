package org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.registers.WGItem;
import org.hiedacamellia.whispergrove.registers.WGRicipe;

import java.util.List;

public class GeneralPrescriptProcessApplier {

    public static void apply(BlockState blockState, List<ItemStack> itemStacks,Level level, BlockPos pos) {

        if (level.isClientSide()) return;

        ItemStack result = result(blockState, itemStacks, level);
        if (!result.isEmpty()) {
            ItemEntity entity = new ItemEntity(level,
                    // Center of pos.
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    result);
            level.addFreshEntity(entity);

        }
    }

    public static ItemStack result(BlockState blockState, List<ItemStack> itemStacks,Level level){

        RecipeManager recipes = level.getRecipeManager();

        GeneralPrescriptProcessInput input = new GeneralPrescriptProcessInput(blockState, itemStacks);

        var optional = recipes.getRecipeFor(
                WGRicipe.GENERAL_PRESCRIPT_PROCESS.get(),
                input,
                level
        );
        return optional
                .map(RecipeHolder::value)
                .map(e -> e.assemble(input, level.registryAccess()))
                .orElse(ItemStack.EMPTY);

    }

    public static int getProcesstime(BlockState blockState, List<ItemStack> itemStacks,Level level){
        RecipeManager recipes = level.getRecipeManager();

        boolean isAllEmpty = true;

        for (ItemStack itemStack : itemStacks) {
            if (!itemStack.isEmpty()) {
                isAllEmpty = false;
                break;
            }
        }

        if(isAllEmpty){
            Debug.getLogger().debug("All empty");
            return 0;
        }

        GeneralPrescriptProcessInput input = new GeneralPrescriptProcessInput(blockState, itemStacks);

        var optional = recipes.getRecipeFor(
                WGRicipe.GENERAL_PRESCRIPT_PROCESS.get(),
                input,
                level
        );

        return optional.map(generalPrescriptProcessRecipeRecipeHolder -> generalPrescriptProcessRecipeRecipeHolder.value().getProcesstime()).orElse(400);

    }
}
