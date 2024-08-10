package org.hiedacamellia.whispergrove.core.recipe.generalherbprocess;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.core.debug.Debug;

import java.util.List;

public record GeneralHerbProcessInput(BlockState state, List<ItemStack> stack)implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        if (slot >= size()) Debug.send("No item for index " + slot);
        return this.stack().get(slot);
    }

    @Override
    public int size() {
        return 5;
    }
}
