package org.hiedacamellia.whispergrove.core.util;

import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.api.viscera.VisceraHolder;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public class ItemStackHolder {
    private ItemStack itemStack;

    public ItemStackHolder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStackHolder() {
        this.itemStack = ItemStack.EMPTY;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public boolean isEmpty() {
        return itemStack.isEmpty();
    }

    public void setHeart(VisceraHolder holder) {
        itemStack.set(WGDataComponent.HEART.get(), holder.toHeart());
    }

    public void setKidney(VisceraHolder holder){
        itemStack.set(WGDataComponent.KIDNEY.get(), holder.toKidney());
    }

    public void setLiver(VisceraHolder holder){
        itemStack.set(WGDataComponent.LIVER.get(), holder.toLiver());
    }

    public void setLung(VisceraHolder holder){
        itemStack.set(WGDataComponent.LUNG.get(), holder.toLung());
    }

    public void setSpleen(VisceraHolder holder){
        itemStack.set(WGDataComponent.SPLEEN.get(), holder.toSpleen());
    }

}
