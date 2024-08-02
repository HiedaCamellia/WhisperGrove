package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RecipeEntry<R extends Recipe<?>> {
    private final DeferredRegister<RecipeType<?>> recipeTypeRegister;
    private final DeferredRegister<RecipeSerializer<?>> recipeSerializerRegister;
    private final String modId;

    private String id;
    private Supplier<RecipeSerializer<?>> recipeSerializerSupplier;
    private DeferredHolder<RecipeType<?>,RecipeType<Recipe<?>>> recipeTypeObject;
    private DeferredHolder<RecipeSerializer<?>,? extends RecipeSerializer<?>> recipeSerializerObject;

    public RecipeEntry(DeferredRegister<RecipeType<?>> recipeTypeRegister, DeferredRegister<RecipeSerializer<?>> recipeSerializerRegister, String modId) {
        this.recipeTypeRegister = recipeTypeRegister;
        this.recipeSerializerRegister = recipeSerializerRegister;
        this.modId = modId;
    }

    public RecipeEntry<R> id(String id) {
        this.id = id;
        return this;
    }

    public RecipeEntry<R> serializer(Supplier<RecipeSerializer<?>> recipeSerializerSupplier) {
        this.recipeSerializerSupplier = recipeSerializerSupplier;
        return this;
    }

    private <T extends Recipe<?>> RecipeType<T> getRecipeType() {
        return new RecipeType<>()
        {
            public String toString() {
                return modId + ":" + id;
            }
        };
    }

    @SuppressWarnings("unchecked")
    public <I extends R> RecipeEntry<I> build() {
        this.recipeTypeObject = recipeTypeRegister.register(id, this::getRecipeType);
        this.recipeSerializerObject = recipeSerializerRegister.register(id, recipeSerializerSupplier);
        return (RecipeEntry<I>) this;
    }

    public RecipeType<?> get() {
        return recipeTypeObject.get();
    }

    public RecipeSerializer<?> getSerializer() {
        return recipeSerializerObject.get();
    }

}
