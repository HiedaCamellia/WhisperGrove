package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.items.TestItem;
import org.hiedacamellia.whispergrove.core.codec.record.Heart;
import org.hiedacamellia.whispergrove.core.codec.record.Kidney;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;
import org.hiedacamellia.whispergrove.core.entry.builder.BaseItemBuilder;


public class WGItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    //public static final DeferredItem<BaseItem> TEST_ITEM = ITEMS.register("test_item",() -> new TestItem("test_item"));

    public static final DeferredItem<BaseItem> LIQUORICE = ITEMS.register("liquorice",
            () -> new BaseItemBuilder().regname("liquorice").properties(
                    new Item.Properties().rarity(Rarity.COMMON).food(
                            new FoodProperties.Builder().nutrition(3).saturationModifier(0.8f).alwaysEdible().build()
                    )
            ).heart(1.0, 1.0).kidney(1.0, 1.0).lung(1.0,1.0)
                    .liver(1.0,1.0).spleen(1.0,1.0).build());

}
