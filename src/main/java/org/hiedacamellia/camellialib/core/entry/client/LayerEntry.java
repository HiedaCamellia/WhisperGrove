package org.hiedacamellia.camellialib.core.entry.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public class LayerEntry {

    private final String modId;

    private String id;
    private Supplier<LayerDefinition> layerSupplier;
    private String layerId;
    private ModelLayerLocation layer;

    public LayerEntry(String modId) {
        this.modId = modId;
        layerId = "main";
    }

    public LayerEntry id(String id) {
        this.id = id;
        return this;
    }

    public LayerEntry bound(Supplier<LayerDefinition> layerSupplier) {
        if (FMLEnvironment.dist.isClient()) {
            this.layerSupplier = layerSupplier;
        }
        return this;
    }

    public LayerEntry layerId(String layerId) {
        this.layerId = layerId;
        return this;
    }

    public LayerEntry build() {
        if (FMLEnvironment.dist.isClient()) {
            this.layer = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(modId, id), layerId);
            CamelliaLib.modEventBus.addListener(this::initLayers);
        }
        return this;
    }

    public ModelLayerLocation get() {
        return layer;
    }

    public void initLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(layer, layerSupplier);
    }
}
