package org.hiedacamellia.whispergrove.content.common.blockitems;

import org.hiedacamellia.whispergrove.core.entry.BaseBlockItem;
import org.hiedacamellia.whispergrove.registers.WGBlock;

public class RollerBlockItem extends BaseBlockItem {
    public RollerBlockItem() {
        super(WGBlock.Roller.get(),new Properties());
    }
}
