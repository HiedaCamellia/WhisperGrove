package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGItem;

import java.util.stream.Collectors;

public class WGItemModelProvider extends ItemModelProvider {

    public WGItemModelProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, WhisperGrove.MODID, helper);
    }

    @Override
    protected void registerModels() {
        getKnownItems().forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            this.singleTexture(path, this.mcLoc("item/generated"), "layer0", this.modLoc("item/" + path));
        });
    }

    private static Iterable<Item> getKnownItems() {
        return WGItem.ITEMS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toSet());
    }

}