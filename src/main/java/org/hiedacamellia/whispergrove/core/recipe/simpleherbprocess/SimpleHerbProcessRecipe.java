package org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.registers.WGRicipe;
import org.hiedacamellia.whispergrove.registers.WGRicipeSerializer;

public class SimpleHerbProcessRecipe implements Recipe<SimpleHerbProcessInput> {
    // An in-code representation of our recipe data. This can be basically anything you want.
    // Common things to have here is a processing time integer of some kind, or an experience reward.
    // Note that we now use an ingredient instead of an item stack for the input.
    private final BlockState inputState;
    private final Ingredient inputItem;
    private final int processtime;
    private final ItemStack result;

    // Add a constructor that sets all properties.
    public SimpleHerbProcessRecipe(BlockState inputState, Ingredient inputItem, int processtime, ItemStack result) {
        this.inputState = inputState;
        this.inputItem = inputItem;
        this.result = result;
        this.processtime = processtime;
    }

    // A list of our ingredients. Does not need to be overridden if you have no ingredients
    // (the default implementation returns an empty list here). It makes sense to cache larger lists in a field.
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return WGRicipeSerializer.SIMPLE_HERB_PROCESS.get();
    }

    @Override
    public RecipeType<?> getType() {
        return WGRicipe.SIMPLE_HERB_PROCESS.get();
    }

    // Grid-based recipes should return whether their recipe can fit in the given dimensions.
    // We don't have a grid, so we just return if any item can be placed in there.
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 1;
    }

    // Check whether the given input matches this recipe. The first parameter matches the generic.
    // We check our blockstate and our item stack, and only return true if both match.
    @Override
    public boolean matches(SimpleHerbProcessInput input, Level level) {
        return this.inputState == input.state() && this.inputItem.test(input.stack());
    }

    // Return an UNMODIFIABLE version of your result here. The result of this method is mainly intended
    // for the recipe book, and commonly used by JEI and other recipe viewers as well.
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    // Return the result of the recipe here, based on the given input. The first parameter matches the generic.
    // IMPORTANT: Always call .copy() if you use an existing result! If you don't, things can and will break,
    // as the result exists once per recipe, but the assembled stack is created each time the recipe is crafted.
    @Override
    public ItemStack assemble(SimpleHerbProcessInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }


    // This example outlines the most important methods. There is a number of other methods to override.
    // Check the class definition of Recipe to view them all.


    public Ingredient getInputItem() {
        return inputItem;
    }

    public BlockState getInputState() {
        return inputState;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getProcesstime() {
        return processtime;
    }

}
