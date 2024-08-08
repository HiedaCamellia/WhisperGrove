package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.hiedacamellia.whispergrove.api.viscera.Updater;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

import java.util.List;

public class BaseItem extends Item {

    private final String regname;

    public BaseItem(Properties properties, String regname) {
        super(properties);
        this.regname = regname;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext ctx, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, ctx, list, flag);
        if (!Screen.hasShiftDown()) {
            list.add(Component.literal(
                    "§7§o" + Component.translatable("tooltip.whispergrove.press_shift").getString() + "§r"));
        } else {
            String[] description = Component.translatable("tooltip.whispergrove."+this.regname).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        FoodProperties foodproperties = stack.getFoodProperties(livingEntity);
        if (livingEntity instanceof Player player){
            Updater.updateHeart(stack, player);
            Updater.updateKidney(stack, player);
            Updater.updateLiver(stack, player);
            Updater.updateLung(stack, player);
            Updater.updateSpleen(stack, player);
        }
        return foodproperties != null ? livingEntity.eat(level, stack, foodproperties) : stack;
    }

    public Heart getHeart(){
        return this.components().get(WGDataComponent.HEART.get());
    }

    public Kidney getKidney(){
        return this.components().get(WGDataComponent.KIDNEY.get());
    }

    public Liver getLiver(){
        return this.components().get(WGDataComponent.LIVER.get());
    }

    public Lung getLung(){
        return this.components().get(WGDataComponent.LUNG.get());
    }

    public Spleen getSpleen(){
        return this.components().get(WGDataComponent.SPLEEN.get());
    }

    public String getReg() {
        return regname;
    }
}


