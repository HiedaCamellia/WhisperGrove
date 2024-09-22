package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class WGTickableBlock extends Block implements EntityBlock {
    public WGTickableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if(blockEntity instanceof WGTickableBlockEntity tickableBlockEntity){
            tickableBlockEntity.tick(state, level, pos, random);
            if(tickableBlockEntity.getTickCount()>0)
                level.scheduleTick(pos, state.getBlock(), 1);
        }
    }

}
