package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.recipe.RightClickBlockRecipe;

import java.util.function.Supplier;

public class WGRicipe {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, WhisperGrove.MODID);

    public static final DeferredHolder<RecipeType<?>,RecipeType<RightClickBlockRecipe>> RIGHT_CLICK_BLOCK =
            RECIPE_TYPES.register(
                    "right_click_block",
                    // We need the qualifying generic here due to generics being generics.
                    () -> RecipeType.<RightClickBlockRecipe>simple(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "right_click_block"))
            );
}
