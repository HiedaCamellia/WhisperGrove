package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;

public class RouGuiBlanksBlock extends BaseBlock {
    public RouGuiBlanksBlock(String regname) {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD), regname);
    }
}
