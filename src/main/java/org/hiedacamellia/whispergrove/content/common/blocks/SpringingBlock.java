package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.hiedacamellia.whispergrove.content.common.blockentities.SpringingBlockEntity;
import org.hiedacamellia.whispergrove.core.entry.WGTickableBlock;

public class SpringingBlock extends WGTickableBlock {

    public SpringingBlock() {
        super(BlockBehaviour.Properties.of());
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            player.openMenu(state.getMenuProvider(world, pos), extraData -> extraData.writeBlockPos(pos));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof SpringingBlockEntity scrapper) {
                Containers.dropContents(level, pos, scrapper);
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SpringingBlockEntity(pos, state);
    }

}