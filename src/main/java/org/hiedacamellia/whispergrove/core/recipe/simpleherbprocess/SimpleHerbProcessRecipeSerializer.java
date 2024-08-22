package org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleHerbProcessRecipeSerializer implements RecipeSerializer<SimpleHerbProcessRecipe> {
    public static final MapCodec<SimpleHerbProcessRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockState.CODEC.fieldOf("state").forGetter(SimpleHerbProcessRecipe::getInputState),
            Ingredient.CODEC.fieldOf("ingredient").forGetter(SimpleHerbProcessRecipe::getInputItem),
            Codec.INT.fieldOf("processtime").forGetter(SimpleHerbProcessRecipe::getProcesstime),
            ItemStack.CODEC.fieldOf("result").forGetter(SimpleHerbProcessRecipe::getResult)
    ).apply(inst, SimpleHerbProcessRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, SimpleHerbProcessRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), SimpleHerbProcessRecipe::getInputState,
                    Ingredient.CONTENTS_STREAM_CODEC, SimpleHerbProcessRecipe::getInputItem,
                    ByteBufCodecs.INT, SimpleHerbProcessRecipe::getProcesstime,
                    ItemStack.STREAM_CODEC, SimpleHerbProcessRecipe::getResult,
                    SimpleHerbProcessRecipe::new
            );

    // Return our map codec.
    @Override
    public MapCodec<SimpleHerbProcessRecipe> codec() {
        return CODEC;
    }

    // Return our stream codec.
    @Override
    public StreamCodec<RegistryFriendlyByteBuf, SimpleHerbProcessRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
