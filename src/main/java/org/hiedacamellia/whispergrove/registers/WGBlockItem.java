package org.hiedacamellia.whispergrove.registers;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.blockitems.TestBlockItem;

public class WGBlockItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WhisperGrove.MODID);

    public static final DeferredItem<BlockItem> TEST_BLOCK_ITEM = ITEMS.register("test_block", TestBlockItem::new);

}
