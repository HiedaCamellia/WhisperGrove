package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class WGTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhisperGrove.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WG_TAB = TABS.register("whispergrove", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.whispergrove")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(WGItem.TEST_ITEM::toStack)
            .displayItems((parameters, tab) -> {
                for(DeferredHolder<Item, ? extends Item> item:WGItem.ITEMS.getEntries()){
                    tab.accept(item.get());
                }
                for(DeferredHolder<Item, ? extends Item> item:WGBlockItem.ITEMS.getEntries()){
                    tab.accept(item.get());
                }
            }).build());
}
