package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessRecipe;
import org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess.SimpleHerbProcessRecipe;

public class WGRicipe {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, WhisperGrove.MODID);

    public static final DeferredHolder<RecipeType<?>,RecipeType<SimpleHerbProcessRecipe>> SIMPLE_HERB_PROCESS =
            RECIPE_TYPES.register(
                    "simple_herb_process",
                    // We need the qualifying generic here due to generics being generics.
                    () -> RecipeType.<SimpleHerbProcessRecipe>simple(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "simple_herb_process"))
            );

    public static final DeferredHolder<RecipeType<?>,RecipeType<GeneralPrescriptProcessRecipe>> GENERAL_PRESCRIPT_PROCESS =
            RECIPE_TYPES.register(
                    "general_prescript_process",
                    () -> RecipeType.<GeneralPrescriptProcessRecipe>simple(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "general_prescript_process"))
            );

}
