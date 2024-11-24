package org.hiedacamellia.whispergrove.content.client.tab;

import dev.xkmc.l2tabs.tabs.core.TabBase;
import dev.xkmc.l2tabs.tabs.core.TabManager;
import dev.xkmc.l2tabs.tabs.core.TabToken;
import dev.xkmc.l2tabs.tabs.inventory.InvTabData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.registers.WGItem;

public class VisceraTab extends TabBase<InvTabData, VisceraTab> {
    public VisceraTab(int index, TabToken<InvTabData, VisceraTab> token, TabManager<InvTabData> manager, Component title) {
        super(index, token, manager, title);
    }

    @Override
    public void onTabClicked() {
        Minecraft.getInstance().setScreen(new VisceraScreen(this.getMessage()));
    }

    @Override
    protected void renderIcon(GuiGraphics g) {
        ItemStack stack = WGItem.BAMBOO_LEAF.toStack();
        if (!stack.isEmpty()) {
            this.token.getType().drawIcon(g, this.getX(), this.getY(), stack);
        }
    }
}
