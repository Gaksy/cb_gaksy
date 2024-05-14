package com.laelioa.cbmod.blocks.Actual;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * <h2>Class ActualPublic</h2>
 * 对于有关Actua的公共方法
 * @author gaksy
 * */
public class ActualPublic {

    /**
     * <h2>getPosOffset(BlockPos currentPos, EnumFacing[] offsetArray)</h2>
     * @param currentPos 当前方块的坐标
     * @param offsetArray 要执行的偏移数组
     * @return 偏移后的BlockPos
     * */
    public static BlockPos getPosOffset(BlockPos currentPos, EnumFacing[] offsetArray){
        BlockPos nowPos = currentPos;                   //用于进行偏移操作的BlockPos
        for(EnumFacing currentOffset: offsetArray){     //读取偏移数组中的操作
            nowPos = nowPos.offset(currentOffset);      //进行偏移
        }
        return nowPos;                                  //返回偏移后的位置
    }

    /**
     * <h2>getBlockFromPos(IBlockAccess worldIn, BlockPos currentPos)</h2>
     * @param worldIn 访问世界的IBlockAccess
     * @param currentPos 要访问的坐标
     * @return 返回currentPos位置的方块
     * */
    public static Block getBlockFromPos(IBlockAccess worldIn, BlockPos currentPos){
        return worldIn.getBlockState(currentPos).getBlock();
    }

}
