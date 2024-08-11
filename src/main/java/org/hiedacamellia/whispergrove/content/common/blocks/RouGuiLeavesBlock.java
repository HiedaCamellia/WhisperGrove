package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.datafix.fixes.LeavesFix;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;

import java.util.List;

public class RouGuiLeavesBlock extends LeavesBlock {
    private final String regname;

    public RouGuiLeavesBlock(String regname) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).noOcclusion());
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
