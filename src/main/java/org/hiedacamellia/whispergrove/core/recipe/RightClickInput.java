package org.hiedacamellia.whispergrove.core.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.core.debug.Debug;

public record RightClickInput(BlockState state, ItemStack stack)implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        if (slot != 0) Debug.send("No item for index " + slot);
        return this.stack();
    }

    @Override
    public int size() {
        return 1;
    }
}
