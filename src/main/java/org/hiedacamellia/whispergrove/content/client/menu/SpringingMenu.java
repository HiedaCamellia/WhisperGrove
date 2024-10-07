package org.hiedacamellia.whispergrove.content.client.menu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.core.entry.WGTickableBlockEntity;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGMenu;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SpringingMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {

    public final Level world;
    public final Player entity;
    public int x, y, z;
    public BlockPos pos;
    private final ContainerLevelAccess access;
    public final ContainerData containerData;
    private final Map<Integer, Slot> customSlots = new HashMap<>();

    @SuppressWarnings("unused")
    public SpringingMenu(int containerId, Inventory inventory, RegistryFriendlyByteBuf buf) {
        this(containerId, inventory, ContainerLevelAccess.NULL,buf.readBlockPos());
    }

    public SpringingMenu(int containerId, Inventory inventory, BlockPos pos) {
        this(containerId, inventory, ContainerLevelAccess.NULL,pos);
    }

    public SpringingMenu(int containerId, Inventory inventory, ContainerLevelAccess access,BlockPos pos) {
        this(containerId, inventory, access, new ItemStackHandler(10), new SimpleContainerData(9),pos);
    }

    public SpringingMenu(int containerId, Inventory inventory, ContainerLevelAccess access, IItemHandler itemHandler, ContainerData containerData,BlockPos pos) {
        super(WGMenu.SPRINGING.get(), containerId);
        checkContainerSize(inventory, 10);
        this.access = access;
        this.containerData = containerData;
        this.entity = inventory.player;
        this.world = inventory.player.level();
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        if(world.getBlockEntity(pos) instanceof WGTickableBlockEntity blockEntity){
//            Debug.getLogger().debug("Tick:{}", blockEntity.getTickCount());
            containerData.set(1, blockEntity.getTickCount());
        }else {
            containerData.set(1, 0);
        }

        this.pos = pos;
        for (int ni = 0 ; ni < 3; ++ni) {
            for (int nj = 0; nj < 3; ++nj) {
                this.customSlots.put(ni * 3 + nj, this.addSlot(new SlotItemHandler(itemHandler, ni * 3 + nj, 97 + nj * 18, 24 + ni * 18)));
            }
        }

        this.customSlots.put(9, this.addSlot(new SlotItemHandler(itemHandler, 9,  209, 42){
            @Override
            public boolean mayPlace(ItemStack stack) {return false;}
        }));
        for (int si = 0; si < 3; ++si) {
            for (int sj = 0; sj < 9; ++sj) {
                this.addSlot(new Slot(inventory, sj + (si + 1) * 9, 84 + sj * 18, 100 + si * 18));
            }
        }

        for (int si = 0; si < 9; ++si) {
            this.addSlot(new Slot(inventory, si, 84 + si * 18, 159));
        }

        this.addDataSlots(containerData);

    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, WGBlock.SPRINGING.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();
            if (index < 9) {
                if (!this.moveItemStackTo(itemStack1, 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack1, itemStack);
            } else if (!this.moveItemStackTo(itemStack1, 0, 9, false)) {
                if (index < 9 + 27) {
                    if (!this.moveItemStackTo(itemStack1, 9 + 27, this.slots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if (!this.moveItemStackTo(itemStack1, 9, 9 + 27, false)) {
                        return ItemStack.EMPTY;
                    }
                }

                return ItemStack.EMPTY;
            }
            if (itemStack1.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemStack1);
        }
        return itemStack;
    }

    @Override
    protected boolean moveItemStackTo(ItemStack stack, int p_38905_, int p_38906_, boolean p_38907_) {
        boolean flag = false;
        int i = p_38905_;
        if (p_38907_) {
            i = p_38906_ - 1;
        }
        if (stack.isStackable()) {
            while (!stack.isEmpty() && (p_38907_ ? i >= p_38905_ : i < p_38906_)) {
                Slot slot = this.slots.get(i);
                ItemStack itemstack = slot.getItem();
                if (slot.mayPlace(itemstack) && !itemstack.isEmpty() && ItemStack.isSameItemSameComponents(stack, itemstack)) {
                    int j = itemstack.getCount() + stack.getCount();
                    int k = slot.getMaxStackSize(itemstack);
                    if (j <= k) {
                        stack.setCount(0);
                        itemstack.setCount(j);
                        slot.set(itemstack);
                        flag = true;
                    } else if (itemstack.getCount() < k) {
                        stack.shrink(k - itemstack.getCount());
                        itemstack.setCount(k);
                        slot.set(itemstack);
                        flag = true;
                    }
                }
                if (p_38907_) {
                    i--;
                } else {
                    i++;
                }
            }
        }
        if (!stack.isEmpty()) {
            if (p_38907_) {
                i = p_38906_ - 1;
            } else {
                i = p_38905_;
            }
            while (p_38907_ ? i >= p_38905_ : i < p_38906_) {
                Slot slot1 = this.slots.get(i);
                ItemStack itemstack1 = slot1.getItem();
                if (itemstack1.isEmpty() && slot1.mayPlace(stack)) {
                    int l = slot1.getMaxStackSize(stack);
                    slot1.setByPlayer(stack.split(Math.min(stack.getCount(), l)));
                    slot1.setChanged();
                    flag = true;
                    break;
                }
                if (p_38907_) {
                    i--;
                } else {
                    i++;
                }
            }
        }
        return flag;
    }

    public Map<Integer, Slot> get() {
        return customSlots;
    }

}