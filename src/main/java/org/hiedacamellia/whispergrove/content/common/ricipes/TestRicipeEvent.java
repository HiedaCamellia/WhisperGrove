package org.hiedacamellia.whispergrove.content.common.ricipes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;
import org.hiedacamellia.whispergrove.core.recipe.RightClickBlockRecipe;
import org.hiedacamellia.whispergrove.core.recipe.RightClickInput;
import org.hiedacamellia.whispergrove.registers.WGRicipe;

import java.util.Optional;

import static org.hiedacamellia.whispergrove.registers.WGRicipe.RIGHT_CLICK_BLOCK;


@SubscribeEvent
public static void TestRicipeEvent(UseItemOnBlockEvent event) {


    // Skip if we are not in the block-dictated phase of the event. See the event's javadocs for details.
    if (event.getUsePhase() != UseItemOnBlockEvent.UsePhase.BLOCK) return;
    // Get the parameters we need.
    UseOnContext context = event.getUseOnContext();
    Level level = context.getLevel();
    BlockPos pos = context.getClickedPos();
    RecipeManager recipes = level.getRecipeManager();
    BlockState blockState = context.getLevel().getBlockState(pos);
    ItemStack itemStack = context.getItemInHand();
    // If the level is not a server level, return.
    if (level.isClientSide()) return;
    // Create an input and query the recipe.
    RightClickInput input = new RightClickInput(blockState, itemStack);

    Optional<RecipeHolder<? extends Recipe<CraftingInput>>> optional = recipes.getRecipeFor(
            // The recipe type to get the recipe for. In our case, we use the crafting type.
            WGRicipe.RIGHT_CLICK_BLOCK.get(),
            // Our recipe input.
            input,
            // Our level context.
            level
    );
    ItemStack result = optional
            .map(RecipeHolder::value)
            .map(e -> e.assemble(input, level.registryAccess()))
            .orElse(ItemStack.EMPTY);
    // If there is a result, break the block and drop the result in the world.
    if (!result.isEmpty()) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
        ItemEntity entity = new ItemEntity(level,
                // Center of pos.
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                result);
        level.addFreshEntity(entity);
        // Cancel the event to stop the interaction pipeline.
        event.setCanceled(true);
    }
}

