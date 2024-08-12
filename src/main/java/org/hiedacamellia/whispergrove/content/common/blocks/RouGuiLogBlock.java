package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;
import org.hiedacamellia.whispergrove.core.entry.BaseLogBlock;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGItem;

public class RouGuiLogBlock extends BaseLogBlock {
    public RouGuiLogBlock(String regname) {
        super(Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD), regname);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(stack.getItem() instanceof AxeItem) {
            stack.use(level, player, hand);
            stack.setDamageValue(stack.getDamageValue() - 1);
            level.setBlock(pos , WGBlock.RouGuiStrippedLog.get().defaultBlockState(), Block.UPDATE_ALL);
            //level.playLocalSound(pos, SoundEvent.createFixedRangeEvent(, 1.0F, 1.0F), player);
            ItemEntity entity = new ItemEntity(level,
                    // Center of pos.
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    new ItemStack(WGItem.GUI_ZHI_PI.get()));
            level.addFreshEntity(entity);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

}
