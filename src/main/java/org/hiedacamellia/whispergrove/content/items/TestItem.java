package org.hiedacamellia.whispergrove.content.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;

public class TestItem extends BaseItem {

    public TestItem(String regname) {
        super(new Properties().stacksTo(64)
                        .food(new FoodProperties.Builder().alwaysEdible().nutrition(3).saturationModifier(1.6f).build())
                , regname);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        WhisperGrove.DEBUG.send("TestItem#use");
        return super.use(level, player, hand);
    }
}
