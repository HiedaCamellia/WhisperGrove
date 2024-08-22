package org.hiedacamellia.whispergrove.core.config;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ConfigScreen extends Screen {

    EditBox disease_mild;
    EditBox disease_moderate;
    EditBox disease_critical;
    EditBox viscera_constant;

    public ConfigScreen() {
        super(Component.translatable("config.whispergrove.title"));
    }

    @Override
    protected void init() {
        super.init();

        this.addRenderableWidget(new Button.Builder(Component.literal(Config.DEBUG.get().toString()),e -> {
            Config.DEBUG.set(!Config.DEBUG.get());
            e.setMessage(Component.literal(Config.DEBUG.get().toString()));
        }).bounds(this.width - 60, 60,40,15)
                .tooltip(Tooltip.create(Component.translatable("config.whispergrove.debug.desc"))).build());

        disease_mild = new EditBox(this.font, this.width  - 60, 80,40,15, Component.literal(Config.DISEASE_MILD.get().toString()));
        disease_moderate = new EditBox(this.font, this.width  - 60, 100,40,15, Component.literal(Config.DISEASE_MODERATE.get().toString()));
        disease_critical = new EditBox(this.font, this.width  - 60, 120,40,15, Component.literal(Config.DISEASE_CRITICAL.get().toString()));
        viscera_constant = new EditBox(this.font, this.width  - 60, 140,40,15, Component.literal(Config.VISCERA_CONSTANT.get().toString()));
        disease_mild.setMaxLength(10);
        disease_moderate.setMaxLength(10);
        disease_critical.setMaxLength(10);
        viscera_constant.setMaxLength(10);
        disease_mild.setValue(Config.DISEASE_MILD.get().toString());
        disease_moderate.setValue(Config.DISEASE_MODERATE.get().toString());
        disease_critical.setValue(Config.DISEASE_CRITICAL.get().toString());
        viscera_constant.setValue(Config.VISCERA_CONSTANT.get().toString());
        this.addRenderableWidget(disease_mild);
        this.addRenderableWidget(disease_moderate);
        this.addRenderableWidget(disease_critical);
        this.addRenderableWidget(viscera_constant);
        
        
        this.addRenderableWidget(new Button.Builder(Component.translatable("config.whispergrove.comfirm"),e -> {
            onClose();
        }).bounds(this.width/2 - 20  , this.height-30,40,15).build());
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics,mouseX,mouseY,partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
        int h = graphics.guiHeight();
        int w = graphics.guiWidth();

        String titleStr = Component.translatable("config.whispergrove.title").getString();
        graphics.drawString(this.font, titleStr, w / 2 - font.width(titleStr) / 2,  20, 0xFFFFFF,false);

        String showDateHud = Component.translatable("config.whispergrove.debug").getString();
        graphics.drawString(this.font, showDateHud, 20,  60, 0xFFFFFF,false);
        String disease_mild = Component.translatable("config.whispergrove.disease_mild").getString();
        graphics.drawString(this.font, disease_mild, 20,  80, 0xFFFFFF,false);
        String disease_moderate = Component.translatable("config.whispergrove.disease_moderate").getString();
        graphics.drawString(this.font, disease_moderate, 20,  100, 0xFFFFFF,false);
        String disease_critical = Component.translatable("config.whispergrove.disease_critical").getString();
        graphics.drawString(this.font, disease_critical, 20,  120, 0xFFFFFF,false);
        String viscera_constant = Component.translatable("config.whispergrove.viscera_constant").getString();
        graphics.drawString(this.font, viscera_constant, 20,  140, 0xFFFFFF,false);
    }

    @Override
    public void onClose() {
        super.onClose();
        Config.DISEASE_MILD.set(Double.valueOf(disease_mild.getValue()));
        Config.DISEASE_MODERATE.set(Double.valueOf(disease_moderate.getValue()));
        Config.DISEASE_CRITICAL.set(Double.valueOf(disease_critical.getValue()));

    }

}
