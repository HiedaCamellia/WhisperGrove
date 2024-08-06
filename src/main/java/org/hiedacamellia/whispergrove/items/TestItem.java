package org.hiedacamellia.whispergrove.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;

public class TestItem extends BaseItem {

    public TestItem(String regname) {
        super(64, Rarity.COMMON, UseAnim.BLOCK,  regname);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return super.use(level, player, hand);
    }
}
