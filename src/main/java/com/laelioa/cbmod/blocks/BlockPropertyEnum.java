package com.laelioa.cbmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
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
import javax.annotation.ParametersAreNonnullByDefault;

public class BlockPropertyEnum<T extends Enum<T> & IStringSerializable> extends BlockBase {
    private final PropertyEnum<T> TYPE;

    public BlockPropertyEnum(String name, CreativeTabs tab, PropertyEnum<T> TYPE) {
        super(name, tab);
        this.TYPE = TYPE;
    }

    public BlockPropertyEnum(String name, CreativeTabs tab, Material material, PropertyEnum<T> TYPE) {
        super(name, tab, material);
        this.TYPE = TYPE;
    }

    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, TYPE.getValueClass().getEnumConstants()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).ordinal();
    }

    @ParametersAreNonnullByDefault
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (T type : TYPE.getValueClass().getEnumConstants()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    @Nonnull
    @ParametersAreNonnullByDefault
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }
}
