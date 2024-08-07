package org.hiedacamellia.whispergrove.content.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.hiedacamellia.whispergrove.content.client.menu.VisceraMenu;

public class VisceraScreen extends AbstractContainerScreen<VisceraMenu> {

    public VisceraScreen(VisceraMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {

    }
}
