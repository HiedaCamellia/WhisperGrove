package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.hiedacamellia.whispergrove.core.entry.BaseBlock;

public class RollerBlock extends BaseBlock {
    public RollerBlock(String regname) {
        super(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .sound(SoundType.STONE)
                .destroyTime(2.5f)
                .explosionResistance(6.0f)
                .noOcclusion(),
                regname);
    }
}
