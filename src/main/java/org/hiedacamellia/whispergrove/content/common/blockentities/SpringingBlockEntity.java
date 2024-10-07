package org.hiedacamellia.whispergrove.content.common.blockentities;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.core.entry.WGTickableBlockEntity;
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessApplier;
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessRecipe;
import org.hiedacamellia.whispergrove.registers.WGBlockEntity;
import org.hiedacamellia.whispergrove.registers.WGItem;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SpringingBlockEntity extends WGTickableBlockEntity {

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
    public void assemble(BlockState state, Level level, BlockPos pos, RandomSource random,String name) {
        NonNullList<ItemStack> stacks = this.handler.getStacks();
        Debug.getLogger().debug("Assembling");
//        Debug.getLogger().debug("stacks: "+stacks);
        ItemStack result = GeneralPrescriptProcessApplier.result(state, new ArrayList<>(stacks.subList(0,8)), level);
        if(result.isEmpty()) {
//            Debug.getLogger().debug("result: "+result);
            List<ItemStack> inputs = new ArrayList<>(stacks.subList(0, 8));
            inputs.removeAll(List.of(ItemStack.EMPTY));
            //inputs.forEach(itemStack -> itemStack.setCount(1));
//            Debug.getLogger().debug("inputs: "+inputs);
            result = GeneralPrescriptProcessRecipe.ass(inputs, WGItem.SOUP.toStack());
//            Debug.getLogger().debug("real_result: "+result);
        }
        if(!name.isEmpty()) {
            result.set(DataComponents.CUSTOM_NAME, Component.literal(name).withStyle(ChatFormatting.WHITE,ChatFormatting.UNDERLINE));
//            Debug.getLogger().debug("name:"+name);
        }
        if (result != null) {
            stacks.set(9, result);
//            Debug.getLogger().debug("stacks: "+stacks);
//            Debug.getLogger().debug("set: " + stacks.get(9));
//            Debug.getLogger().debug("stacks: "+stacks);
            for (int i = 0; i < 9; i++) {
                ItemStack stack = stacks.get(i).copy();
                if (!stack.isEmpty()) {
//                    Debug.getLogger().debug("stack: "+stack);
//                    Debug.getLogger().debug("c: "+stack.getCount());
                    stack.setCount(stack.getCount()-1);
                    stacks.set(i,stack);
//                    Debug.getLogger().debug("nc: "+stack.getCount());
//                    Debug.getLogger().debug("nstack: "+stack);
                }
            }
//            Debug.getLogger().debug("out_stacks: "+stacks);
            this.handler.setStacks(stacks);
        }
    }

    @Override
    public void tryAssemble(BlockState state, Level level,String name) {
        int tick = GeneralPrescriptProcessApplier.getProcesstime(state, this.handler.getStacks().subList(0,8), level);
        //Debug.getLogger().debug("tick: "+tick);
        if(tick>0){
            this.setTickCount(tick);
            this.setSoupName(name);
        }
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
        return new SpringingMenu(i, inventory, access, this.handler, this.containerData, this.worldPosition);
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

    private static class Data implements ContainerData {

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