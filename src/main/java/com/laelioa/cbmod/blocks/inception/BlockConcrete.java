package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockBase;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * <h2>BlockConcrete</h2>
 * 混凝土
 * @author Howell Zhu
 * */
public class BlockConcrete extends BlockBase {
    /**
     * <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-05/block-state.html">参考文档</a>
     * <br>
     * 只需要调用 PropertyInteger.create(propertyName, minValue, maxValue) 即可获得一个全新的 PropertyInteger 对象，
     * 它通常代表某种进度（机器工作进度、设备生长进度）或某种测量值（信号强度）。
     * */
    private static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 7);

    public BlockConcrete() {
        super("inc_concrete", ComfortBox.incTab);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        //meta在C++/C中返回了一个临时变量，会多占用一个int类型的空间，++meta则返回引用，仅一个指针大小，不知道Java里有没有这样的区别。
        for (int meta = 0; meta < 8; meta++) {
            items.add(new ItemStack(this, 1, meta));
        }
    }

    @Nonnull
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }
}
