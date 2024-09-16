package org.hiedacamellia.whispergrove.core.util;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

import java.util.ArrayList;
import java.util.List;

public class GetPropertiesDesc {

    public static List<Component> fromItemStack(ItemStack itemStack) {
        List<Component> components = new ArrayList<>();

        Heart heart = itemStack.getOrDefault(WGDataComponent.HEART, new Heart(0.0, 0.0, 0.0));
        components.add(getComponent(Component.translatable("tooltip.whispergrove.heart"), heart.yin(), heart.yang(), heart.ping()));
        Liver liver = itemStack.getOrDefault(WGDataComponent.LIVER, new Liver(0.0, 0.0, 0.0));
        components.add(getComponent(Component.translatable("tooltip.whispergrove.liver"), liver.yin(), liver.yang(), liver.ping()));
        Lung lung = itemStack.getOrDefault(WGDataComponent.LUNG, new Lung(0.0, 0.0, 0.0));
        components.add(getComponent(Component.translatable("tooltip.whispergrove.lung"), lung.yin(), lung.yang(), lung.ping()));
        Kidney kidney = itemStack.getOrDefault(WGDataComponent.KIDNEY, new Kidney(0.0, 0.0, 0.0));
        components.add(getComponent(Component.translatable("tooltip.whispergrove.kidney"), kidney.yin(), kidney.yang(), kidney.ping()));
        Spleen spleen = itemStack.getOrDefault(WGDataComponent.SPLEEN, new Spleen(0.0, 0.0, 0.0));
        components.add(getComponent(Component.translatable("tooltip.whispergrove.spleen"), spleen.yin(), spleen.yang(), spleen.ping()));
        components.forEach(e->{
            if(e.equals(Component.empty())){
                components.remove(e);
            }
        });

        return components;
    }

    private static Component getComponent(Component c, double yin, double yang, double ping) {
        Component component = c.copy();
        if (yin != 0) {
            component = component.copy().append(Component.translatable("tooltip.whispergrove.yin", (int) yin)).withStyle(ChatFormatting.BLUE);
        } else if (yang != 0) {
            component = component.copy().append(Component.translatable("tooltip.whispergrove.yang", (int) yang).withStyle(ChatFormatting.RED));
        } else if(ping!= 0){
            component = component.copy().append(Component.translatable("tooltip.whispergrove.ping", (int) ping).withStyle(ChatFormatting.GRAY));
        }else {
            component = Component.empty();
        }
        return component;
    }

}
