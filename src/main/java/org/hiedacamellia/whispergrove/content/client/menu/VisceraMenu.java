package org.hiedacamellia.whispergrove.content.client.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.registers.WGMenu;
import org.jetbrains.annotations.NotNull;

public class VisceraMenu extends AbstractContainerMenu {

    public VisceraMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        super(WGMenu.VISCERA.get(), id);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player playerIn, int index) {
        return ItemStack.EMPTY;
    }

}