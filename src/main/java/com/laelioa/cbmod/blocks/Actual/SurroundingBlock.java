package com.laelioa.cbmod.blocks.Actual;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * <h2>Class SurroundingBlock</h2>
 * 用户获取指定位置紧邻的方块（上、下、南、北、东和西）
 * @author gaksy
 * */
public class SurroundingBlock {
    private final Block top;
    private final Block bottom;
    private final Block north;
    private final Block south;
    private final Block east;
    private final Block west;

    /**
     * <h2>SurroundingBlock(IBlockAccess worldIn, BlockPos currentPos)</h2>
     * @param worldIn 用于访问世界
     * @param currentPos 目标方块的坐标
     * @author gaksy
     * */
    public SurroundingBlock(IBlockAccess worldIn, BlockPos currentPos){
        top = ActualPublic.getBlockFromPos(worldIn,currentPos.offset(EnumFacing.UP));
        bottom = ActualPublic.getBlockFromPos(worldIn,currentPos.offset(EnumFacing.DOWN));
        north = ActualPublic.getBlockFromPos(worldIn,currentPos.offset(EnumFacing.NORTH));
        south = ActualPublic.getBlockFromPos(worldIn, currentPos.offset(EnumFacing.SOUTH));
        east = ActualPublic.getBlockFromPos(worldIn, currentPos.offset(EnumFacing.EAST));
        west = ActualPublic.getBlockFromPos(worldIn, currentPos.offset(EnumFacing.WEST));
    }

    public Block getTop() { return top; }

    public Block getBottom() { return bottom; }

    public Block getNorth() { return north; }

    public Block getSouth() { return south; }

    public Block getEast() { return east; }

    public Block getWest() { return west; }
}
