package org.hiedacamellia.whispergrove.content.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;

@OnlyIn(Dist.CLIENT)
public class SpringingScreen extends AbstractContainerScreen<SpringingMenu> {

    private static final ResourceLocation TEXTURE = WhisperGrove.prefix("textures/screens/springing_background.png");
    private final Level world;
    private final int x, y, z;
    private final BlockPos pos;
    private final Player entity;

    public SpringingScreen(SpringingMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.pos = container.pos;
        this.entity = container.entity;
        this.imageWidth = 252;
        this.imageHeight = 183;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        poseStack.popPose();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void containerTick() {
        super.containerTick();
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, "", 44, 29, -1, false);
    }

    @Override
    public void onClose() {
        super.onClose();
    }

}