package org.hiedacamellia.whispergrove.registers;

import dev.xkmc.l2core.init.reg.simple.Val;
import dev.xkmc.l2tabs.init.L2Tabs;
import dev.xkmc.l2tabs.tabs.core.TabToken;
import dev.xkmc.l2tabs.tabs.inventory.InvTabData;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.tab.VisceraTab;

import static dev.xkmc.l2tabs.init.L2Tabs.TAB_REG;

public class WGTab {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhisperGrove.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WG_TAB = TABS.register("whispergrove", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.whispergrove")).withTabsBefore(CreativeModeTabs.COMBAT).icon(WGItem.BAMBOO_LEAF::toStack)
            .displayItems((parameters, output) -> {
                WGBlockItem.ITEMS.getEntries().forEach(holder -> output.accept(holder.get()));
                WGItem.ITEMS.getEntries().forEach(holder -> output.accept(holder.get()));
            }).build());

}