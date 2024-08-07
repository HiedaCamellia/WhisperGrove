package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class ModelProvider extends ItemModelProvider {
    public ModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WhisperGrove.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture("test_item",
                ResourceLocation.withDefaultNamespace("item/generated"),
                "layer0",
                ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,
                "item/" + "test_item"));
    }
}
