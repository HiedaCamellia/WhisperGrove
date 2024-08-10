package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.recipe.generalherbprocess.GeneralHerbProcessRecipe;
import org.hiedacamellia.whispergrove.core.recipe.generalherbprocess.GeneralHerbProcessRecipeSerializer;
import org.hiedacamellia.whispergrove.core.recipe.RightClickBlockRecipe;
import org.hiedacamellia.whispergrove.core.recipe.RightClickBlockRecipeSerializer;

import java.util.function.Supplier;

public class WGRicipeSerializer {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, WhisperGrove.MODID);

    public static final Supplier<RecipeSerializer<RightClickBlockRecipe>> RIGHT_CLICK_BLOCK =
            RECIPE_SERIALIZERS.register("right_click_block", RightClickBlockRecipeSerializer::new);

    public static final Supplier<RecipeSerializer<GeneralHerbProcessRecipe>> GENERAL_HERB_PROCESS =
            RECIPE_SERIALIZERS.register("general_herb_process", GeneralHerbProcessRecipeSerializer::new);
}
