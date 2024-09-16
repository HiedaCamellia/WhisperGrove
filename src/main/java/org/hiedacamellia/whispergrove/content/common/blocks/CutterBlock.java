package org.hiedacamellia.whispergrove.content.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess.SimpleHerbProcessApplier;

public class CutterBlock extends Block {

    public CutterBlock() {
        super(Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .sound(SoundType.STONE)
                .destroyTime(2.5f)
                .explosionResistance(6.0f)
                .noOcclusion());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.join(box(5, 0, 0, 15, 3, 16),
                box(2, 3, 5, 15, 7, 6)
                        .move(0,0,0), BooleanOp.OR);
    }

    @Override
    public ItemInteractionResult useItemOn(
            ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        SimpleHerbProcessApplier.apply(state, stack, level, pos);
        return ItemInteractionResult.SUCCESS;
    }

}
