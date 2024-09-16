package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class WGTickableBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {

    private int tickCount;

    protected WGTickableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        tickCount = 0;
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        tickCount = tag.getInt("tickCount");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("tickCount", tickCount);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random){
        if(tickCount==0)
            return;
        if(tickCount==1){
            assemble(state, level, pos, random);
        }
        if(tickCount>=1)
            tickCount--;
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    public abstract void assemble(BlockState state, ServerLevel level, BlockPos pos, RandomSource random);

    public abstract void tryAssemble(BlockState state, ServerLevel level);
}
