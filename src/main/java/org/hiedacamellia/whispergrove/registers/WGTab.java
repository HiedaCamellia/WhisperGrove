package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;

public class WGTab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhisperGrove.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WG_TAB = TABS.register("whispergrove", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.whispergrove")).withTabsBefore(CreativeModeTabs.COMBAT).icon(WGItem.BAMBOO_LEAF::toStack)
            .displayItems((parameters, output) -> WGItem.ITEMS.getEntries().forEach(holder -> output.accept(holder.get()))).build());

}