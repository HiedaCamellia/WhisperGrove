package org.hiedacamellia.camellialib.core.entry;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.camellialib.CamelliaLib;
import org.hiedacamellia.camellialib.core.entry.client.LayerEntry;
import org.hiedacamellia.camellialib.core.entry.client.ParticleEntry;
import org.hiedacamellia.camellialib.core.entry.common.*;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ObjectRegistry {

    private final String modId;
    private final boolean gatherData;

    public DeferredRegister<Item> itemRegister;
    public DeferredRegister<Block> blockRegister;
    public DeferredRegister<Fluid> fluidRegister;
    public DeferredRegister<FluidType> fluidTypeRegister;
    public DeferredRegister<BlockEntityType<?>> blockEntityRegister;
    public DeferredRegister<EntityType<?>> entityRegister;
    public DeferredRegister<RecipeType<?>> recipeTypeRegister;
    public DeferredRegister<RecipeSerializer<?>> recipeSerializerRegister;
    public DeferredRegister<MobEffect> effectRegister;
    public DeferredRegister<Attribute> attributeRegister;
    public DeferredRegister<ParticleType<?>> particleTypeRegister;
    public DeferredRegister<SoundEvent> soundRegister;
    public DeferredRegister<Feature<?>> featureRegister;
    public DeferredRegister<CreativeModeTab> creativeTabRegister;


    public ObjectRegistry(String modId, boolean gatherData) {
        this.modId = modId;
        this.gatherData = gatherData;
        this.itemRegister = DeferredRegister.createItems(modId);
        this.blockRegister = DeferredRegister.createBlocks(modId);
        this.fluidRegister = DeferredRegister.create(BuiltInRegistries.FLUID, modId);
        this.fluidTypeRegister = DeferredRegister.create(BuiltInRegistries.FLUID.getDefaultKey(), modId);
        this.blockEntityRegister = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, modId);
        this.entityRegister = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, modId);
        this.recipeTypeRegister = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, modId);
        this.recipeSerializerRegister = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, modId);
        this.effectRegister = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, modId);
        this.attributeRegister = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, modId);
        this.particleTypeRegister = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, modId);
        this.soundRegister = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, modId);
        this.featureRegister = DeferredRegister.create(BuiltInRegistries.FEATURE, modId);
        this.creativeTabRegister = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, modId);
        register(NeoForge.EVENT_BUS);
    }
    public void register(IEventBus bus) {
        this.itemRegister.register(bus);
        this.blockRegister.register(bus);
        this.fluidRegister.register(bus);
        this.fluidTypeRegister.register(bus);
        this.blockEntityRegister.register(bus);
        this.entityRegister.register(bus);
        this.recipeTypeRegister.register(bus);
        this.recipeSerializerRegister.register(bus);
        this.effectRegister.register(bus);
        this.attributeRegister.register(bus);
        this.particleTypeRegister.register(bus);
        this.soundRegister.register(bus);
        this.featureRegister.register(bus);
        this.creativeTabRegister.register(bus);
        if (gatherData) {
            bus.addListener(this::gatherData);
        }
    }
    public static ObjectRegistry create(String modId) {
        return new ObjectRegistry(modId, true);
    }

    /**
     * @param gatherData 是否启用rundata的数据自动处理。<br/>
     *                   注意，同一个模组只能运行一个rundata，因此如果是在同一模组下的兼容模组类中需要关闭此项。
     */
    public static ObjectRegistry create(String modId, boolean gatherData) {
        return new ObjectRegistry(modId, gatherData);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        RegistrySetBuilder builder = new RegistrySetBuilder();
        builder.add(Registries.CONFIGURED_FEATURE, FeatureEntry::configBootStrap);
        builder.add(Registries.PLACED_FEATURE, FeatureEntry::placedBootStrap);
        generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(output, lookupProvider, builder, Set.of(modId)));
    }

    public <I extends Item> ItemEntry<I> item() {
        return new ItemEntry<>(itemRegister);
    }

    public <T extends Block> BlockEntry<T> block() {
        return new BlockEntry<>(blockRegister);
    }

    public FluidEntry fluid() {
        return new FluidEntry(fluidRegister, fluidTypeRegister, itemRegister, blockRegister, modId);
    }

    public <E extends BlockEntity> BlockEntityEntry<E> blockEntity() {
        return new BlockEntityEntry<>(blockEntityRegister);
    }

    public <E extends Entity> EntityEntry<E> entity() {
        return new EntityEntry<>(entityRegister, modId);
    }

    public <R extends Recipe<?>> RecipeEntry<R> recipe() {
        return new RecipeEntry<>(recipeTypeRegister, recipeSerializerRegister, modId);
    }

    public EffectEntry effect() {
        return new EffectEntry(effectRegister);
    }

    public <P extends ParticleOptions> ParticleEntry<P> particle() {
        return new ParticleEntry<>(particleTypeRegister);
    }

    public DamageTypeEntry damageType() {
        return new DamageTypeEntry(modId);
    }

    public AttributeEntry attribute() {
        return new AttributeEntry(attributeRegister, modId);
    }

    public SoundEntry sound() {
        return new SoundEntry(soundRegister, modId);
    }

    public <F extends FeatureConfiguration> FeatureEntry<F> feature() {
        return new FeatureEntry<>(featureRegister, modId);
    }

    //1.21的网络咱是真的不会
//    public NetPackEntry netPack() {
//        return new NetPackEntry(modId);
//    }

    public CreativeTabEntry creativeTab() {
        return new CreativeTabEntry(creativeTabRegister);
    }

    public LayerEntry layer() {
        return new LayerEntry(modId);
    }

    public CamelliaConfigBuilder configBuilder(ModConfig.Type type) {
        return CamelliaConfigBuilder.create().modId(modId).side(type);
    }
}
