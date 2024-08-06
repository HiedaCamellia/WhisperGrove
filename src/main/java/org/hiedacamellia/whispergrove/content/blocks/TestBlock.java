package org.hiedacamellia.whispergrove.content.blocks;

import net.minecraft.world.level.material.MapColor;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;

public class TestBlock extends BaseBlock {
    public TestBlock(String regname) {
        super(Properties.of().mapColor(MapColor.STONE), regname);
    }
}
