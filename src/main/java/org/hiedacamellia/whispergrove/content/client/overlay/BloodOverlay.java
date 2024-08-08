package org.hiedacamellia.whispergrove.content.client.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.registers.WGEffect;

import java.util.Objects;

@EventBusSubscriber({ Dist.CLIENT })
public class BloodOverlay {

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {

        GuiGraphics guiGraphics = event.getGuiGraphics();
        int w = guiGraphics.guiWidth();
        int h = guiGraphics.guiHeight();
        Player player = Minecraft.getInstance().player;

        if (player != null && (player.hasEffect(WGEffect.LUNG_HYPERACTIVITY)||player.hasEffect(WGEffect.LUNG_DETERIORATED))) {
            if (Objects.requireNonNull(player.getEffect(WGEffect.LUNG_HYPERACTIVITY)).getAmplifier() == 2 || Objects.requireNonNull(player.getEffect(WGEffect.LUNG_DETERIORATED)).getAmplifier() == 2){
                guiGraphics.blit(ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "textures/gui/blood_overlay.png")
                        , 0, 0, w, h, 0.0f, 0.0f, w, h, 1080, 720);
            }
        }

    }
}
