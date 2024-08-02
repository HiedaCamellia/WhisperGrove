package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FluidEntry {

    private final DeferredRegister<Fluid> fluidRegister;
    private final DeferredRegister<FluidType> fluidTypeRegister;
    private final DeferredRegister<Item> itemRegister;
    private final DeferredRegister<Block> blockRegister;
    private final String modId;

    private ResourceLocation spriteStill;
    private ResourceLocation spriteFlowing;
    private ResourceLocation spriteOverlay;
    private boolean defaultSprite;
    private int color;
    private String id;
    private Supplier<LiquidBlock> blockSupplier;
    private Supplier<FlowingFluid> stillSupplier;
    private Supplier<FlowingFluid> flowingSupplier;
    private Supplier<Item> bucketSupplier;
    private Supplier<FluidType> fluidTypeSupplier;
    private DeferredHolder<Block, LiquidBlock> fluidBlock;
    private DeferredHolder<Fluid, FlowingFluid> fluidFlowing;
    private DeferredHolder<Fluid, FlowingFluid> fluidStill;
    private DeferredHolder<Item,? extends Item> fluidBucket;
    private DeferredHolder<FluidType,? extends FluidType> fluidType;

    public FluidEntry(DeferredRegister<Fluid> fluidRegister, DeferredRegister<FluidType> fluidTypeRegister, DeferredRegister<Item> itemRegister, DeferredRegister<Block> blockRegister, String modId) {
        this.fluidRegister = fluidRegister;
        this.fluidTypeRegister = fluidTypeRegister;
        this.itemRegister = itemRegister;
        this.blockRegister = blockRegister;
        this.modId = modId;
        this.defaultSprite = false;
        this.color = 0xFFFFFFFF;
    }

    public FluidEntry id(String id) {
        this.id = id;
        return this;
    }

    public FluidEntry bound(Supplier<LiquidBlock> blockSupplier) {
        this.blockSupplier = blockSupplier;
        return this;
    }

    public FluidEntry still(Supplier<FlowingFluid> stillSupplier) {
        this.stillSupplier = stillSupplier;
        return this;
    }

    public FluidEntry flowing(Supplier<FlowingFluid> flowingSupplier) {
        this.flowingSupplier = flowingSupplier;
        return this;
    }

    public FluidEntry bucket(Supplier<Item> bucketSupplier) {
        this.bucketSupplier = bucketSupplier;
        return this;
    }

    public FluidEntry waterLike() {
        this.defaultSprite = true;
        return this;
    }

    public FluidEntry color(int color) {
        this.color = color;
        return this;
    }

    public FluidEntry fluidType(Supplier<FluidType> fluidTypeSupplier) {
        this.fluidTypeSupplier = fluidTypeSupplier;
        return this;
    }

    public FluidEntry build() {
        fluidBlock = blockRegister.register(id, blockSupplier);
        fluidStill = fluidRegister.register(id, stillSupplier);
        fluidFlowing = fluidRegister.register(id + "_flowing", flowingSupplier);
        if (bucketSupplier != null) fluidBucket = itemRegister.register(id + "_bucket", bucketSupplier);

        fluidType = fluidTypeRegister.register(id, fluidTypeSupplier);

        return this;
    }

    public LiquidBlock getBlock() {
        return fluidBlock.get();
    }

    public FlowingFluid getStill() {
        return fluidStill.get();
    }

    public FlowingFluid getFlowing() {
        return fluidFlowing.get();
    }

    public Item getBucket() {
        return fluidBucket.get();
    }

    public FluidType getType() {
        return fluidType.get();
    }

    public DeferredHolder<Block, LiquidBlock> getBlockObject() {
        return fluidBlock;
    }

    public DeferredHolder<Fluid, FlowingFluid> getStillObject() {
        return fluidStill;
    }

    public DeferredHolder<Fluid, FlowingFluid> getFlowingObject() {
        return fluidFlowing;
    }

    public DeferredHolder<Item,? extends Item> getBucketObject() {
        return fluidBucket;
    }

    public DeferredHolder<FluidType,? extends FluidType> getTypeObject() {
        return fluidType;
    }
}
