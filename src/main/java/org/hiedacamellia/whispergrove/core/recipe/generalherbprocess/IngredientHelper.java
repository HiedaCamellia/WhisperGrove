package org.hiedacamellia.whispergrove.core.recipe.generalherbprocess;

import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class IngredientHelper {
    private static List<Ingredient> ingredients;

    public IngredientHelper(List<Ingredient> i) {
        ingredients = i;
    }

    public static IngredientHelper add(Ingredient ingredient) {
        ingredients.add(ingredient);
        return new IngredientHelper(ingredients);
    }

    public static List<Ingredient> build() {
        return ingredients;
    }
}
