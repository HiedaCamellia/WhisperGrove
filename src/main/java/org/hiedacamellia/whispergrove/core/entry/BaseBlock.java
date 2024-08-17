package org.hiedacamellia.whispergrove.core.entry;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class BaseBlock extends Block {

    private final String regname;

    public BaseBlock(Properties properties,String regname) {
        super(properties);
        this.regname = regname;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext ctx, List<Component> list, TooltipFlag flag) {
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
}
