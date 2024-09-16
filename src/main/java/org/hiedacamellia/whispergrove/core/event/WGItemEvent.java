package org.hiedacamellia.whispergrove.core.event;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.util.GetPropertiesDesc;

import java.util.List;

@EventBusSubscriber(modid = WhisperGrove.MODID)
public class WGItemEvent {

    @SubscribeEvent
    public static void onItemTooltips(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
        if (key.getNamespace().equals(WhisperGrove.MODID)) {
            List<Component> toolTip = event.getToolTip();
            if (!Screen.hasShiftDown()) {
                MutableComponent component = Component.translatable("tooltip.whispergrove.press_shift");
                toolTip.add(component.withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
            } else {
                toolTip.addAll(GetPropertiesDesc.fromItemStack(itemStack));
                toolTip.add(Component.translatable("tooltip.whispergrove." + key.getPath()));
            }
        }
    }

}