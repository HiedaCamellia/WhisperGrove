package org.hiedacamellia.whispergrove.content.blockitems;

import net.minecraft.world.item.BlockItem;
import org.hiedacamellia.whispergrove.core.entry.BaseBlockItem;
import org.hiedacamellia.whispergrove.registers.WGBlock;

public class TestBlockItem extends BaseBlockItem {
    public TestBlockItem() {
        super(WGBlock.TEST_BLOCK.get(),new Properties());
    }
}
