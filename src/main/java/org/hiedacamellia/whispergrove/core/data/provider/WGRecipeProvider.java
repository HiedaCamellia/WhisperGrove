package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.hiedacamellia.whispergrove.core.recipe.RightClickRicipeBuilder;
import org.hiedacamellia.whispergrove.core.recipe.generalherbprocess.GeneralHerbProcessRecipeBuilder;
import org.hiedacamellia.whispergrove.core.recipe.generalherbprocess.IngredientHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WGRecipeProvider extends RecipeProvider {
    public WGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Add your recipes here.
        new RightClickRicipeBuilder(
                // Our constructor parameters. This example adds the ever-popular dirt -> diamond conversion.
                new ItemStack(Items.DIAMOND),
                Blocks.DIRT.defaultBlockState(),
                Ingredient.of(Items.IRON_INGOT)
        )
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);

        new GeneralHerbProcessRecipeBuilder(
                // Our constructor parameters. This example adds the ever-popular dirt -> diamond conversion.
                new ItemStack(Items.DIAMOND),
                Blocks.DIRT.defaultBlockState(),
                100,
                IngredientHelper.add(Ingredient.of(Items.IRON_INGOT)).build()
        )
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);
    }
}
