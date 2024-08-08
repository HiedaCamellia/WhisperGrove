package org.hiedacamellia.whispergrove.api.viscera;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public record VisceraHolder(double yin, double yang) {

    public VisceraHolder getHeart(Player player){
        if(player.hasData(WGAttachment.HEART)){
            return fromHeart(player.getData(WGAttachment.HEART));
        }
        return new VisceraHolder(100, 100);
    }

    public VisceraHolder getHeart(ItemStack itemStack){
        return fromHeart(itemStack.getOrDefault(WGDataComponent.HEART.get(), new Heart(100.0, 100.0)));
    }

    public VisceraHolder getKidney(Player player){
        if(player.hasData(WGAttachment.KIDNEY)){
            return fromKidney(player.getData(WGAttachment.KIDNEY));
        }
        return new VisceraHolder(100, 100);
    }

    public VisceraHolder getKidney(ItemStack itemStack){
        return fromKidney(itemStack.getOrDefault(WGDataComponent.KIDNEY.get(), new Kidney(100.0, 100.0)));
    }

    public VisceraHolder getLiver(Player player){
        if(player.hasData(WGAttachment.LIVER)){
            return fromLiver(player.getData(WGAttachment.LIVER));
        }
        return new VisceraHolder(100, 100);
    }

    public VisceraHolder getLiver(ItemStack itemStack){
        return fromLiver(itemStack.getOrDefault(WGDataComponent.LIVER.get(), new Liver(100.0, 100.0)));
    }

    public VisceraHolder getLung(Player player){
        if(player.hasData(WGAttachment.LUNG)){
            return fromLung(player.getData(WGAttachment.LUNG));
        }
        return new VisceraHolder(100, 100);
    }

    public VisceraHolder getLung(ItemStack itemStack){
        return fromLung(itemStack.getOrDefault(WGDataComponent.LUNG.get(), new Lung(100.0, 100.0)));
    }

    public VisceraHolder getSpleen(Player player){
        if(player.hasData(WGAttachment.SPLEEN)){
            return fromSpleen(player.getData(WGAttachment.SPLEEN));
        }
        return new VisceraHolder(100, 100);
    }

    public VisceraHolder getSpleen(ItemStack itemStack){
        return fromSpleen(itemStack.getOrDefault(WGDataComponent.SPLEEN.get(), new Spleen(100.0, 100.0)));
    }

    public void setHeart(Player player){
        player.setData(WGAttachment.HEART, toHeart());
    }

    public ItemStack setHeart(ItemStack itemStack){
        itemStack.set(WGDataComponent.HEART.get(), toHeart());
        return itemStack;
    }

    public void setKidney(Player player){
        player.setData(WGAttachment.KIDNEY, toKidney());
    }

    public ItemStack setKidney(ItemStack itemStack){
        itemStack.set(WGDataComponent.KIDNEY.get(), toKidney());
        return itemStack;
    }

    public void setLiver(Player player){
        player.setData(WGAttachment.LIVER, toLiver());
    }

    public ItemStack setLiver(ItemStack itemStack){
        itemStack.set(WGDataComponent.LIVER.get(), toLiver());
        return itemStack;
    }

    public void setLung(Player player){
        player.setData(WGAttachment.LUNG, toLung());
    }

    public ItemStack setLung(ItemStack itemStack){
        itemStack.set(WGDataComponent.LUNG.get(), toLung());
        return itemStack;
    }

    public void setSpleen(Player player){
        player.setData(WGAttachment.SPLEEN, toSpleen());
    }

    public ItemStack setSpleen(ItemStack itemStack){
        itemStack.set(WGDataComponent.SPLEEN.get(), toSpleen());
        return itemStack;
    }

    private VisceraHolder fromHeart(Heart heart){
        return new VisceraHolder(heart.yin(), heart.yang());
    }

    private Heart toHeart(){
        return new Heart(yin, yang);
    }

    private VisceraHolder fromKidney(Kidney kidney){
        return new VisceraHolder(kidney.yin(), kidney.yang());
    }

    private Kidney toKidney(){
        return new Kidney(yin, yang);
    }

    private VisceraHolder fromLiver(Liver liver){
        return new VisceraHolder(liver.yin(), liver.yang());
    }

    private Liver toLiver(){
        return new Liver(yin, yang);
    }

    private VisceraHolder fromLung(Lung lung){
        return new VisceraHolder(lung.yin(), lung.yang());
    }

    private Lung toLung(){
        return new Lung(yin, yang);
    }

    private VisceraHolder fromSpleen(Spleen spleen){
        return new VisceraHolder(spleen.yin(), spleen.yang());
    }

    private Spleen toSpleen(){
        return new Spleen(yin, yang);
    }

}