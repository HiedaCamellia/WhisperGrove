package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;

import java.util.function.Supplier;

public class WGBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, WhisperGrove.MODID);

}
