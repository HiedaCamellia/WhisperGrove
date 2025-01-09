package org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public record GeneralPrescriptProcessInput(BlockState state, List<ItemStack> stack)implements RecipeInput {

    @Override
    public ItemStack getItem(int slot) {
        if(slot>=stack().size())
            return ItemStack.EMPTY;
        return this.stack().get(slot);
    }

    @Override
    public int size() {
        return 9;
    }

}