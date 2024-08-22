package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessRecipe;
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessRecipeSerializer;
import org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess.SimpleHerbProcessRecipe;
import org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess.SimpleHerbProcessRecipeSerializer;

import java.util.function.Supplier;

public class WGRicipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, WhisperGrove.MODID);

    public static final Supplier<RecipeSerializer<SimpleHerbProcessRecipe>> SIMPLE_HERB_PROCESS =
            RECIPE_SERIALIZERS.register("simple_herb_process", SimpleHerbProcessRecipeSerializer::new);

    public static final Supplier<RecipeSerializer<GeneralPrescriptProcessRecipe>> GENERAL_PRESCRIPT_PROCESS =
            RECIPE_SERIALIZERS.register("general_prescript_process", GeneralPrescriptProcessRecipeSerializer::new);
}
