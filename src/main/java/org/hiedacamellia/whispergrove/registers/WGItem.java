package org.hiedacamellia.whispergrove.registers;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.items.TestItem;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;


public class WGItem {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);


    public static final DeferredItem<BaseItem> TEST_ITEM = ITEMS.register("test_item",() -> new TestItem("test_item"));



}
