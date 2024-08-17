package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blockentities.SpringingBlockEntity;

import java.util.function.Supplier;

public class WGBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WhisperGrove.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SPRINGING = register("springing", WGBlock.SPRINGING, SpringingBlockEntity::new);


    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block,? extends Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
        return BLOCK_ENTITIES.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPRINGING.get(), (blockEntity, side) -> ((SpringingBlockEntity ) blockEntity).getItemHandler());
    }
}
