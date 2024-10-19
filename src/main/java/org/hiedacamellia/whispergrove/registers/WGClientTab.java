package org.hiedacamellia.whispergrove.registers;

import dev.xkmc.l2core.init.reg.simple.Val;
import dev.xkmc.l2tabs.init.L2Tabs;
import dev.xkmc.l2tabs.tabs.core.TabToken;
import dev.xkmc.l2tabs.tabs.inventory.InvTabData;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.whispergrove.content.client.tab.VisceraTab;

import static dev.xkmc.l2tabs.init.L2Tabs.TAB_REG;

@OnlyIn(Dist.CLIENT)
public class WGClientTab {
    public static Val<TabToken<InvTabData, VisceraTab>> TAB_VISCERA = TAB_REG.reg("viscera_tab",
            () -> L2Tabs.GROUP.registerTab(() -> VisceraTab::new,
                    Component.translatable("menu.whispergrove.viscera_tab")));
}
