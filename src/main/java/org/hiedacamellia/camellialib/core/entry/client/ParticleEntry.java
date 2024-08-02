package org.hiedacamellia.camellialib.core.entry.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.function.Supplier;

public class ParticleEntry<P extends ParticleOptions>{
    private final DeferredRegister<ParticleType<?>> particleRegister;
    private String id;
    private Supplier<ParticleType<? extends P>> particleSupplier;
    private ParticleEngine.SpriteParticleRegistration<?> provider;
    private DeferredHolder<ParticleType<?>, ParticleType<? extends P>> particleTypeObject;

    public ParticleEntry(DeferredRegister<ParticleType<?>> particleRegister) {
        this.particleRegister = particleRegister;
    }

    public ParticleEntry<P> id(String id) {
        this.id = id;
        return this;
    }

    public ParticleEntry<P> bound(Supplier<ParticleType<? extends P>> particleSupplier) {
        this.particleSupplier = particleSupplier;
        return this;
    }

    public <T extends ParticleOptions> ParticleEntry<P> provider(ParticleEngine.SpriteParticleRegistration<T> provider) {
        this.provider = provider;
        return this;
    }

    public <T extends ParticleOptions> ParticleEntry<?> build() {
        this.particleTypeObject = particleRegister.register(id, particleSupplier);
        if (FMLEnvironment.dist.isClient()) {
            CamelliaLib.modEventBus.addListener(this::registerParticleProviders);
        }
        return this;
    }

    public void registerParticleProviders(RegisterParticleProvidersEvent event) {
        ParticleEngine engine = Minecraft.getInstance().particleEngine;
        engine.register(getR(), provider);
    }

    public ParticleType<? extends P> get() {
        return particleTypeObject.get();
    }

    private <T extends ParticleOptions> ParticleType<T> getR() {
        return (ParticleType<T>) particleTypeObject.get();
    }
}
