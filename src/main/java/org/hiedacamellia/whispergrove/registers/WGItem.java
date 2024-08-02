package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.items.TestItem;


public class WGItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);


    public static final DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item",() -> new TestItem("test_item"));


    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", WGBlock.EXAMPLE_BLOCK);


}
