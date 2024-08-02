package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.function.Supplier;

public class BlockEntityEntry<E extends BlockEntity> {

    private final DeferredRegister<BlockEntityType<?>> blockEntityRegister;

    private String id;
    private Supplier<Block[]> validBlocks;
    private BlockEntityType.BlockEntitySupplier<E> blockEntitySupplier;
    private Supplier<? extends BlockEntityRendererProvider<? extends E>> blockEntityRendererSupplier;
    private DeferredHolder<BlockEntityType<?>,BlockEntityType<E>> blockEntityTypeObject;

    public BlockEntityEntry(DeferredRegister<BlockEntityType<?>> blockEntityRegister) {
        this.blockEntityRegister = blockEntityRegister;
    }

    public BlockEntityEntry<E> id(String id) {
        this.id = id;
        return this;
    }

    public final BlockEntityEntry<E> validBlock(Supplier<Block> validBlock) {
        this.validBlocks = () -> new Block[]{validBlock.get()};
        return this;
    }

    public final BlockEntityEntry<E> validBlocks(Supplier<Block[]> validBlocks) {
        this.validBlocks = validBlocks;
        return this;
    }

    public BlockEntityEntry<E> bound(BlockEntityType.BlockEntitySupplier<E> blockEntitySupplier) {
        this.blockEntitySupplier = blockEntitySupplier;
        return this;
    }

    // 没办法在共线使用，BlockEntityRendererProvider只能在客户端被读取，但是我暂时没想到别的方法把这个renderer方法专门分到客户端又不用移出这个注册表
    public <T extends E> BlockEntityEntry<E> renderer(Supplier<BlockEntityRendererProvider<T>> blockEntityRendererSupplier) {
        this.blockEntityRendererSupplier = blockEntityRendererSupplier;
        return this;
    }

    public <T extends E> BlockEntityEntry<T> build() {
        this.blockEntityTypeObject = blockEntityRegister.register(id, () ->
                BlockEntityType.Builder.of(blockEntitySupplier, validBlocks.get())
                        .build(null));
        IEventBus bus = CamelliaLib.modEventBus;
        if (FMLEnvironment.dist.isClient()) {
            bus.addListener(this::registerEntityRenderers);
        }
        return (BlockEntityEntry<T>) this;
    }

    public BlockEntityType<E> get() {
        return blockEntityTypeObject.get();
    }

    public DeferredHolder<BlockEntityType<?>,BlockEntityType<E>> getObject() {
        return blockEntityTypeObject;
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        if (blockEntityRendererSupplier != null) {
            event.registerBlockEntityRenderer(get(), (BlockEntityRendererProvider<E>) blockEntityRendererSupplier.get());
        }
    }
}
