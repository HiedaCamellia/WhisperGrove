package org.hiedacamellia.camellialib.core.base;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class BaseItem extends Item {

    private final UseAnim useAnimation;
    private final int useDuration;
    private final String regname;

    public BaseItem(int stacks, Rarity rarity, UseAnim useAnimation, int useDuration, String regname) {
        super(new Item.Properties().stacksTo(stacks).rarity(rarity));
        this.useAnimation = useAnimation;
        this.useDuration = useDuration;
        this.regname = regname;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return useAnimation;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return useDuration;
    }


    @Override
    public void appendHoverText(ItemStack itemstack, TooltipContext ctx, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, ctx, list, flag);
        if (!Screen.hasShiftDown()) {
            list.add(Component.literal(
                    "§7§o" + Component.translatable("tooltip.camellialib.press_shift").getString() + "§r"));
        } else {
            String[] description = Component.translatable("tooltip.whispergrove."+this.regname).getString().split("§n");
            for (String line : description) {
                list.add(Component.literal(line));
            }
        }
    }

}