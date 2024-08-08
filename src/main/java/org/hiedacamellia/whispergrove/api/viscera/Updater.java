package org.hiedacamellia.whispergrove.api.viscera;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public class Updater {

    public static Heart updateHeart(Heart item, Heart player){
        return new Heart(item.yin() + player.yin(), item.yang() + player.yang());
    }

    public static void updateHeart(ItemStack itemStack, Player player){
        Heart itemheart = itemStack.get(WGDataComponent.HEART.get());
        Heart playerheart = player.getData(WGAttachment.HEART);
        player.setData(WGAttachment.HEART, updateHeart(itemheart, playerheart));
    }

    public static Kidney updateKidney(Kidney item, Kidney player){
        return new Kidney(item.yin() + player.yin(), item.yang() + player.yang());
    }

    public static void updateKidney(ItemStack itemStack, Player player){
        Kidney itemkidney = itemStack.get(WGDataComponent.KIDNEY.get());
        Kidney playerkidney = player.getData(WGAttachment.KIDNEY);
        player.setData(WGAttachment.KIDNEY, updateKidney(itemkidney, playerkidney));
    }

    public static Liver updateLiver(Liver item, Liver player){
        return new Liver(item.yin() + player.yin(), item.yang() + player.yang());
    }

    public static void updateLiver(ItemStack itemStack, Player player){
        Liver itemliver = itemStack.get(WGDataComponent.LIVER.get());
        Liver playerliver = player.getData(WGAttachment.LIVER);
        player.setData(WGAttachment.LIVER, updateLiver(itemliver, playerliver));
    }

    public static Lung updateLung(Lung item, Lung player){
        return new Lung(item.yin() + player.yin(), item.yang() + player.yang());
    }

    public static void updateLung(ItemStack itemStack, Player player){
        Lung itemlung = itemStack.get(WGDataComponent.LUNG.get());
        Lung playerlung = player.getData(WGAttachment.LUNG);
        player.setData(WGAttachment.LUNG, updateLung(itemlung, playerlung));
    }

    public static Spleen updateSpleen(Spleen item, Spleen player){
        return new Spleen(item.yin() + player.yin(), item.yang() + player.yang());
    }

    public static void updateSpleen(ItemStack itemStack, Player player){
        Spleen itemspleen = itemStack.get(WGDataComponent.SPLEEN.get());
        Spleen playerspleen = player.getData(WGAttachment.SPLEEN);
        player.setData(WGAttachment.SPLEEN, updateSpleen(itemspleen, playerspleen));
    }

    public static VisceraHolder updateViscera(VisceraHolder item, VisceraHolder player){
        return new VisceraHolder(item.yin() + player.yin(), item.yang() + player.yang());
    }

}
