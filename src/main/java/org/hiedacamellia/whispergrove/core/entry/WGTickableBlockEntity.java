package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.core.debug.Debug;

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

    public void tick(BlockState state,Level level, BlockPos pos, RandomSource random){
        if(tickCount==0)
            return;
        if(tickCount==1){
            Debug.getLogger().debug("Assemble");
            assemble(state, level, pos, random);
        }
        if(tickCount>=1) {
            //Debug.getLogger().debug("tick: "+tickCount);
            tickCount--;
        }
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    public int getTickCount() {
        return tickCount;
    }

    public abstract void assemble(BlockState state,Level level, BlockPos pos, RandomSource random);

    public abstract void tryAssemble(BlockState state, Level level);
}
