package org.hiedacamellia.whispergrove.core.recipe.generalherbprocess;

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

public class GeneralHerbProcessRecipeSerializer implements RecipeSerializer<GeneralHerbProcessRecipe> {
    public static final MapCodec<GeneralHerbProcessRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockState.CODEC.fieldOf("state").forGetter(GeneralHerbProcessRecipe::getInputState),
            Codec.list(Ingredient.CODEC).fieldOf("ingredient").forGetter(GeneralHerbProcessRecipe::getInputItems),
            Codec.INT.fieldOf("processtime").forGetter(GeneralHerbProcessRecipe::getProcesstime),
            ItemStack.CODEC.fieldOf("result").forGetter(GeneralHerbProcessRecipe::getResult)
    ).apply(inst, GeneralHerbProcessRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, GeneralHerbProcessRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), GeneralHerbProcessRecipe::getInputState,
                    ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), GeneralHerbProcessRecipe::getInputItems,
                    ByteBufCodecs.INT, GeneralHerbProcessRecipe::getProcesstime,
                    ItemStack.STREAM_CODEC, GeneralHerbProcessRecipe::getResult,
                    GeneralHerbProcessRecipe::new
            );

    // Return our map codec.
    @Override
    public MapCodec<GeneralHerbProcessRecipe> codec() {
        return CODEC;
    }

    // Return our stream codec.
    @Override
    public StreamCodec<RegistryFriendlyByteBuf, GeneralHerbProcessRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
