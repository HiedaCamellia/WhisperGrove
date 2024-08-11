package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;
import org.hiedacamellia.whispergrove.core.entry.BaseLogBlock;

public class RouGuiLogBlock extends BaseLogBlock {
    public RouGuiLogBlock(String regname) {
        super(Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD), regname);
    }
}
