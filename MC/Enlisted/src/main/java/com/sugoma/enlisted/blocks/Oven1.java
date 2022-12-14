package com.sugoma.enlisted.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class Oven1 extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(8, 15, 5, 9, 21, 6),
            Block.makeCuboidShape(7, 8, 4, 10, 15, 7),
            Block.makeCuboidShape(3, 0, 1, 12, 8, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(10, 15, 8, 11, 21, 9),
            Block.makeCuboidShape(9, 8, 7, 12, 15, 10),
            Block.makeCuboidShape(1, 0, 3, 15, 8, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(6, 15, 10, 7, 21, 11),
            Block.makeCuboidShape(5, 8, 9, 8, 15, 12),
            Block.makeCuboidShape(3, 0, 1, 12, 8, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(5, 15, 7, 6, 21, 8),
            Block.makeCuboidShape(4, 8, 6, 7, 15, 9),
            Block.makeCuboidShape(1, 0, 4, 15, 8, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1,v2,IBooleanFunction.OR);}).get();








    public Oven1() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(6.0f, 30.0f).sound(SoundType.LANTERN).harvestLevel(0).setRequiresTool().harvestTool(ToolType.PICKAXE));
    }

    //have the block rotate towards us
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            case SOUTH:
                return SHAPE_S;
            default:
                return SHAPE_N;
        }
    }
}
