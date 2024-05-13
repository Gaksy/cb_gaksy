package com.laelioa.cbmod.blocks;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * <h2>Class BlockBaseStatuePropertyInteger</h2>
 * <p>需要使用PropertyInteger的方块可以继承此类</p>
 * <p>在构造参数种必须传递PropertyInteger与其最大数量</p>
 * @author gaksy
 * */
public class BlockPropertyInteger extends BlockBase {
    private final PropertyInteger TYPE;
    private final int MAX_STATES;

    /**
     * <h2>BlockBaseStatuePropertyInteger({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link PropertyInteger} STATUS_TYPE,
     * int max)</h2>
     *
     * <p>{@link String} block_name: 指定方块名称</p>
     * <p>{@link net.minecraft.creativetab.CreativeTabs} creative_tab: 指定方块的物品栏</p>
     * <p>{@link PropertyInteger} STATUS_TYPE: 状态类型</p>
     * <p>int max: 状态最大值(从0开始)</p>
     *
     * @author gaksy
     * */
    public BlockPropertyInteger(String name, CreativeTabs tab, PropertyInteger TYPE, int maxStates) {
        super(name, tab);
        this.TYPE = TYPE;
        MAX_STATES = maxStates + 1;
    }

    /**<h2>getStateFromMeta</h2>
     * 用于将序列化方块状态的值转换为方块的meta。
     * @author RMSCA
     * */
    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, meta);
    }

    /**
     * <h2>getMetaFromState</h2>
     * 用于将方块的meta转换为序列化方块状态的值
     * @author RMSCA
     * */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE);
    }

    /**
     * <h2>getSubBlocks</h2>
     * <p>returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)</p>
     * <p>返回具有相同ID但不同元数据（例如：wood返回4个方块）的方块列表。</p>
     * @author RMSCA
     * */
    @ParametersAreNonnullByDefault
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        //meta在C++/C中返回了一个临时变量，会多占用一个int类型的空间，++meta则返回引用，仅一个指针大小，不知道Java里有没有这样的区别。
        for (int meta = 0; meta < MAX_STATES; meta++) {
            items.add(new ItemStack(this, 1, meta));
        }
    }

    /**
     * <h2>getPickBlock</h2>
     * 这个方法的作用是给创造模式鼠标中键选择方块提供物品，注意state
     * @author RMSCA
     * */
    @Nonnull
    @ParametersAreNonnullByDefault
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }
}
