package org.hiedacamellia.whispergrove.content.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;

import java.util.HashMap;

public class SpringingScreen extends AbstractContainerScreen<SpringingMenu> {

    private static final HashMap<String, Object> guistate = SpringingMenu.guistate;
    private final Level world;
    private final int x,y,z;
    private final BlockPos pos;
    private final Player entity;
    //Button button_confirm;
    Button button_confirm;

    public SpringingScreen(SpringingMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.pos = container.pos;
        this.entity = container.entity;
        this.imageWidth = 280;
        this.imageHeight = 166;
    }

    private static final ResourceLocation texture =ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "textures/screens/springing_background.png");

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth,
                this.imageHeight);
        RenderSystem.disableBlend();
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
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

    @Override
    public void init() {
        super.init();
        button_confirm = new ImageButton(220,23,234-220,37-23,
                new WidgetSprites(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,"textures/screens/springing_conform_button.png"),
                        ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID,"textures/screens/springing_conform_button_pressed.png")),
                    e -> {
//                        PacketDistributor.sendToServer(new CookingRangeUiButton(0, pos));
//                        CookingRangeUiButton.handleButtonAction(entity, 0, pos);
                    }){
            @Override
            public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
                if (true)
                    super.renderWidget(guiGraphics, gx, gy, ticks);
            }
        };



        guistate.put("button:button_confirm", button_confirm);
        this.addRenderableWidget(button_confirm);
    }
}
