package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ItemEntry<I extends Item> {
    private final DeferredRegister<Item> itemRegister;
    private String id;
    private Supplier<I> itemSupplier;
    private DeferredHolder<Item,I> itemObject;
    private boolean condition = true;

    public ItemEntry(DeferredRegister<Item> itemRegister) {
        this.itemRegister = itemRegister;
    }

    public ItemEntry<I> id(String id) {
        this.id = id;
        return this;
    }

    public ItemEntry<I> bound(Supplier<I> itemSupplier) {
        this.itemSupplier = itemSupplier;
        return this;
    }

    public ItemEntry<I> condition(boolean condition) {
        this.condition = condition;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends I> ItemEntry<T> build() {
        if (condition) {
            this.itemObject = itemRegister.register(id, itemSupplier);
        }
        return (ItemEntry<T>) this;
    }

    public I get() {
        return itemObject.get();
    }

    public DeferredHolder<Item,I> getObject() {
        return itemObject;
    }

    public boolean isPresent() {
        return condition && getObject() != null;
    }
}
