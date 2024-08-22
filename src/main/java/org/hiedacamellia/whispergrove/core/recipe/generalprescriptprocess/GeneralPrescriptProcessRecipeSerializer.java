package org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess;

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

public class GeneralPrescriptProcessRecipeSerializer implements RecipeSerializer<GeneralPrescriptProcessRecipe> {
    public static final MapCodec<GeneralPrescriptProcessRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockState.CODEC.fieldOf("state").forGetter(GeneralPrescriptProcessRecipe::getInputState),
            Codec.list(Ingredient.CODEC).fieldOf("ingredient").forGetter(GeneralPrescriptProcessRecipe::getInputItems),
            Codec.INT.fieldOf("processtime").forGetter(GeneralPrescriptProcessRecipe::getProcesstime),
            Codec.BOOL.fieldOf("ordered").forGetter(GeneralPrescriptProcessRecipe::isOrdered),
            ItemStack.CODEC.fieldOf("result").forGetter(GeneralPrescriptProcessRecipe::getResult)
    ).apply(inst, GeneralPrescriptProcessRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, GeneralPrescriptProcessRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.idMapper(Block.BLOCK_STATE_REGISTRY), GeneralPrescriptProcessRecipe::getInputState,
                    ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), GeneralPrescriptProcessRecipe::getInputItems,
                    ByteBufCodecs.INT, GeneralPrescriptProcessRecipe::getProcesstime,
                    ByteBufCodecs.BOOL, GeneralPrescriptProcessRecipe::isOrdered,
                    ItemStack.STREAM_CODEC, GeneralPrescriptProcessRecipe::getResult,
                    GeneralPrescriptProcessRecipe::new
            );

    // Return our map codec.
    @Override
    public MapCodec<GeneralPrescriptProcessRecipe> codec() {
        return CODEC;
    }

    // Return our stream codec.
    @Override
    public StreamCodec<RegistryFriendlyByteBuf, GeneralPrescriptProcessRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
