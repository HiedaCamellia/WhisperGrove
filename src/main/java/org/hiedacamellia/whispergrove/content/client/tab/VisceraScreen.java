package org.hiedacamellia.whispergrove.content.client.tab;

import dev.xkmc.l2core.util.Proxy;
import dev.xkmc.l2tabs.tabs.contents.BaseTextScreen;
import dev.xkmc.l2tabs.tabs.core.TabManager;
import dev.xkmc.l2tabs.tabs.inventory.InvTabData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.hiedacamellia.whispergrove.registers.WGClientTab;

import java.util.List;
import java.util.Optional;

public class VisceraScreen extends BaseTextScreen {

    private final int page;

    protected VisceraScreen(Component title) {
        this(title, 0);
    }

    protected VisceraScreen(Component title, int page) {
        super(title, ResourceLocation.fromNamespaceAndPath("l2tabs", "textures/gui/empty.png"));
        this.page = page;
    }

    @Override
    public void init() {
        super.init();
        new TabManager<>(this, new InvTabData()).init(this::addRenderableWidget, WGClientTab.TAB_VISCERA.get());
    }


    @Override
    public void render(GuiGraphics g, int mx, int my, float ptick) {
        super.render(g, mx, my, ptick);
        Player player = Proxy.getClientPlayer();
        int x = leftPos + 8;
        int y = topPos + 6;
        var all = ViscerEntry.aggregate(player);
        //Debug.getLogger().debug("all: " + all);
        List<Component> hover = null;
        Font font = Minecraft.getInstance().font;
        for (var pair : all) {
            //Debug.getLogger().debug("pair: " + pair);
            int index = all.indexOf(pair);
            g.blit(pair.icon(), x , y+ index*32, 0, 0, 16, 16, 16, 16);
            g.drawString(font, pair.content().getString(), x, y  + index*32 +16, 0,false);

            //Debug.getLogger().debug("pair: " + pair);
            int row = y + index * 32 +16;
            int column = x;
            int rowAft = y + index * 32 + 26;
            int columnAft = x + font.width(pair.content());
            if (my >= row && my < rowAft && mx >= column && mx < columnAft) {
                hover = pair.hover();
            }

        }
        if (hover != null) {
            g.renderTooltip(font, hover, Optional.empty(), mx, my);
        }
    }


}
