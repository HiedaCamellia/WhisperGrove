package org.hiedacamellia.whispergrove.content.client.screen;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.*;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;
import org.hiedacamellia.whispergrove.core.debug.Debug;
import org.hiedacamellia.whispergrove.core.entry.WGTickableBlockEntity;
import org.hiedacamellia.whispergrove.core.entry.gui.WGImageButton;
import org.hiedacamellia.whispergrove.core.network.PlayerMenuC2SPacket;


@OnlyIn(Dist.CLIENT)
public class SpringingScreen extends AbstractContainerScreen<SpringingMenu> {

    private static final ResourceLocation TEXTURE = WhisperGrove.prefix("textures/screens/springing_background.png");
    private final Level world;
    private final int x, y, z;
    private final BlockPos pos;
    private final Player entity;
    public final ContainerData containerData;
    private Button confirm;
    private EditBox name;

    public SpringingScreen(SpringingMenu container, Inventory inventory, Component title) {
        super(container, inventory, title);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.containerData = container.containerData;
        this.pos = container.pos;
        this.entity = container.entity;
        this.imageWidth = 252;
        this.imageHeight = 183;
    }

    @Override
    public void init() {
        super.init();
        confirm = new WGImageButton(leftPos + 220, topPos + 23, 14, 14,
                new WidgetSprites(WhisperGrove.prefix("textures/screens/springing_conform_button.png"),
                        WhisperGrove.prefix("textures/screens/springing_conform_button_pressed.png")), e -> {
            PacketDistributor.sendToServer(new PlayerMenuC2SPacket(pos, 0, name.getValue()));
            containerData.set(1, 400);
        });

        name = new EditBox(font, leftPos + 157, topPos + 23, 56, 15, Component.nullToEmpty("Name"));

        this.addRenderableWidget(confirm);
        this.addRenderableWidget(name);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
            //Debug.getLogger().debug("tickCount: " + p);
            if (containerData.get(1) != 0) {
                float width = 38 * (1 - ((float) containerData.get(1) / 400));
                guiGraphics.blit(WhisperGrove.prefix("textures/screens/springing_arrow_progress.png"), this.leftPos + 163, this.topPos + 41, 0, 0, (int)width, 14, 38, 14);
            }

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
        InputConstants.Key mouseKey = InputConstants.getKey(keyCode, scanCode);
        if (keyCode == 256) {
            this.minecraft.player.closeContainer();
            return true;
        }
        if (this.minecraft.options.keyInventory.isActiveAndMatches(mouseKey) && name.isFocused()) {
            return true;
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void containerTick() {
        super.containerTick();
        if (containerData.get(1) > 0)
            containerData.set(1, containerData.get(1) - 1);
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