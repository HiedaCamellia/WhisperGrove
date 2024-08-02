package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntry<T extends Block> {
    private final DeferredRegister<Block> blockRegister;

    private String id;
    private Supplier<T> blockSupplier;
    private DeferredHolder<Block,T> blockObject;
    private boolean condition = true;

    public BlockEntry(DeferredRegister<Block> blockRegister) {
        this.blockRegister = blockRegister;
    }

    public BlockEntry<T> id(String id) {
        this.id = id;
        return this;
    }

    public BlockEntry<T> condition(boolean condition) {
        this.condition = condition;
        return this;
    }

    public BlockEntry<T> bound(Supplier<T> blockSupplier) {
        this.blockSupplier = blockSupplier;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <I extends T> BlockEntry<I> build() {
        if (condition) {
            this.blockObject =  blockRegister.register(id, blockSupplier);
        }
        return (BlockEntry<I>) this;
    }

    public T get() {
        return blockObject.get();
    }

    public DeferredHolder<Block,T> getObject() {
        return blockObject;
    }

    public boolean isPresent() {
        return condition && getObject() != null;
    }
}
