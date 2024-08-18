package org.hiedacamellia.whispergrove.content.common.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;
import org.hiedacamellia.whispergrove.registers.WGBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.stream.IntStream;

public class SpringingBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {

    private final Handler handler = new Handler(10);
    private final ContainerData containerData = new Data();

    public SpringingBlockEntity(BlockPos position, BlockState state) {
        super(WGBlockEntity.SPRINGING.get(), position, state);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.handler.deserializeNBT(registries, tag);
        ContainerHelper.loadAllItems(tag, this.handler.getStacks(), registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", this.handler.serializeNBT(registries));
        ContainerHelper.saveAllItems(tag, this.handler.getStacks(), registries);
    }

    @Override
    public int [] getSlotsForFace(Direction direction) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return true;
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("springing");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.handler.getStacks();
    }

    @Override
    protected void setItems(NonNullList<ItemStack> stacks) {
        this.handler.setStacks(stacks);
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        ContainerLevelAccess access = ContainerLevelAccess.create(this.level, this.worldPosition);
        return new SpringingMenu(i, inventory, access, this.handler, this.containerData);
    }

    @Override
    public int getContainerSize() {
        return this.handler.getSlots();
    }

    protected class Handler extends ItemStackHandler {

        public Handler(int size) {
            super(size);
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        public NonNullList<ItemStack> getStacks() {
            return this.stacks;
        }

        public void setStacks(NonNullList<ItemStack> items) {
            this.stacks = items;
        }

    }

    private class Data implements ContainerData {

        @Override
        public int get(int index) {
            return 0;
        }

        @Override
        public void set(int index, int value) {}

        @Override
        public int getCount() {
            return 0;
        }

    }

}