package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.function.Supplier;


public class AttributeEntry {
    private final String modId;
    private final DeferredRegister<Attribute> register;

    private String id;
    private Supplier<? extends Attribute> attributeSup;
    private boolean applyToLivingEntity;
    private DeferredHolder<Attribute,? extends Attribute> attributeObject;

    public AttributeEntry(DeferredRegister<Attribute> register, String modId) {
        this.register = register;
        this.modId = modId;
    }

    public AttributeEntry id(String id) {
        this.id = id;
        return this;
    }

    public AttributeEntry bound(Supplier<? extends Attribute> attributeSup) {
        this.attributeSup = attributeSup;
        return this;
    }

    public AttributeEntry boundRanged(double defaultValue, double min, double max) {
        attributeSup = () -> new RangedAttribute( "attribute" + "." + modId + "." + id, defaultValue, min, max);
        return this;
    }

    public AttributeEntry applyToLivingEntity() {
        this.applyToLivingEntity = true;
        return this;
    }

    public AttributeEntry build() {
        attributeObject = register.register(id, attributeSup);
        CamelliaLib.modEventBus.addListener(this::applyAttribute);
        return this;
    }

    public Holder<Attribute> get() {
        return attributeObject;
    }

    public DeferredHolder<Attribute,? extends Attribute> getObject() {
        return attributeObject;
    }

    @SubscribeEvent
    public void applyAttribute(EntityAttributeModificationEvent event) {
        if (applyToLivingEntity) {
            for (var entity : event.getTypes()) {
                event.add(entity, get());
            }
        }
    }
}
