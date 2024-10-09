package org.hiedacamellia.whispergrove.api.viscera;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGAttachment;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public record VisceraHolder(double yin, double yang,double ping) {

    public VisceraHolder(){
        this(0.0, 0.0,0.0);
    }

    public boolean isYang(){
        return yang > yin;
    }

    public boolean isYin(){
        return yin > yang;
    }

    public VisceraHolder getYang(){
        return new VisceraHolder(0.0, yang - yin,0.0);
    }


    public VisceraHolder getYang(double mass){
        return new VisceraHolder(0.0, (yang - yin)*mass,0.0);
    }

    public VisceraHolder getYin(){
        return new VisceraHolder(yin - yang, 0.0,0.0);
    }

    public VisceraHolder getYin(double mass){
        return new VisceraHolder((yin - yang)*mass, 0.0,0.0);
    }

    public VisceraHolder update(VisceraHolder holder){
        return Updater.updateViscera(this, holder);
    }

    public VisceraHolder updateHeart(ItemStack itemStack){
        return update(VisceraHolder.getHeart(itemStack));
    }

    public VisceraHolder updateKidney(ItemStack itemStack){
        return update(VisceraHolder.getKidney(itemStack));
    }

    public VisceraHolder updateLiver(ItemStack itemStack){
        return update(VisceraHolder.getLiver(itemStack));
    }

    public VisceraHolder updateLung(ItemStack itemStack){
        return update(VisceraHolder.getLung(itemStack));
    }

    public VisceraHolder updateSpleen(ItemStack itemStack){
        return update(VisceraHolder.getSpleen(itemStack));
    }

    public VisceraHolder getHeart(Player player){
        if(player.hasData(WGAttachment.HEART)){
            return fromHeart(player.getData(WGAttachment.HEART));
        }
        return new VisceraHolder(0.0, 0.0,0.0);
    }

    public static VisceraHolder getHeart(ItemStack itemStack){
        return fromHeart(itemStack.getOrDefault(WGDataComponent.HEART.get(), new Heart(0.0, 0.0,0.0)));
    }

    public VisceraHolder getKidney(Player player){
        if(player.hasData(WGAttachment.KIDNEY)){
            return fromKidney(player.getData(WGAttachment.KIDNEY));
        }
        return new VisceraHolder(0.0, 0.0,0.0);
    }

    public static VisceraHolder getKidney(ItemStack itemStack){
        return fromKidney(itemStack.getOrDefault(WGDataComponent.KIDNEY.get(), new Kidney(0.0, 0.0,0.0)));
    }

    public VisceraHolder getLiver(Player player){
        if(player.hasData(WGAttachment.LIVER)){
            return fromLiver(player.getData(WGAttachment.LIVER));
        }
        return new VisceraHolder(0.0, 0.0,0.0);
    }

    public static VisceraHolder getLiver(ItemStack itemStack){
        return fromLiver(itemStack.getOrDefault(WGDataComponent.LIVER.get(), new Liver(0.0, 0.0,0.0)));
    }

    public VisceraHolder getLung(Player player){
        if(player.hasData(WGAttachment.LUNG)){
            return fromLung(player.getData(WGAttachment.LUNG));
        }
        return new VisceraHolder(0.0, 0.0,0.0);
    }

    public static VisceraHolder getLung(ItemStack itemStack){
        return fromLung(itemStack.getOrDefault(WGDataComponent.LUNG.get(), new Lung(0.0, 0.0,0.0)));
    }

    public VisceraHolder getSpleen(Player player){
        if(player.hasData(WGAttachment.SPLEEN)){
            return fromSpleen(player.getData(WGAttachment.SPLEEN));
        }
        return new VisceraHolder(0.0, 0.0,0.0);
    }

    public static VisceraHolder getSpleen(ItemStack itemStack){
        return fromSpleen(itemStack.getOrDefault(WGDataComponent.SPLEEN.get(), new Spleen(0.0, 0.0,0.0)));
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

    public ItemStack setSpleen(ItemStack itemStack) {
        return null;
    }

    private static VisceraHolder fromHeart(Heart heart){
        return new VisceraHolder(heart.yin(), heart.yang(),heart.ping());
    }

    public Heart toHeart(){
        return new Heart(yin, yang,ping);
    }

    private static VisceraHolder fromKidney(Kidney kidney){
        return new VisceraHolder(kidney.yin(), kidney.yang(),kidney.ping());
    }

    public Kidney toKidney(){
        return new Kidney(yin, yang,ping);
    }

    private static VisceraHolder fromLiver(Liver liver){
        return new VisceraHolder(liver.yin(), liver.yang(),liver.ping());
    }

    public Liver toLiver(){
        return new Liver(yin, yang,ping);
    }

    private static VisceraHolder fromLung(Lung lung){
        return new VisceraHolder(lung.yin(), lung.yang(),lung.ping());
    }

    public Lung toLung(){
        return new Lung(yin, yang,ping);
    }

    private static VisceraHolder fromSpleen(Spleen spleen){
        return new VisceraHolder(spleen.yin(), spleen.yang(),spleen.ping());
    }

    public Spleen toSpleen(){
        return new Spleen(yin, yang,ping);
    }

}
