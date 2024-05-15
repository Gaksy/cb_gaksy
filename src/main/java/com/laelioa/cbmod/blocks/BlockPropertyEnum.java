package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.proxy.ClientProxy;
import com.laelioa.cbmod.proxy.CommonProxy;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
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

/**
 * <h2>Class BlockPropertyEnum</h2>
 * <p>需要使用PropertyEnum的方块可以继承此类</p>
 * <p>在构造参数种必须传递PropertyEnum</p>
 * @author RMSCA
 * */
public class BlockPropertyEnum<T extends Enum<T> & IStringSerializable> extends BlockBase {
    private final PropertyEnum<T> TYPE;

    /**
     * <h2>BlockPropertyEnum({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * PropertyEnum<T> TYPE)</h2>
     *
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param TYPE 物品的状态
     *
     * @author RMSCA
     * */
    public BlockPropertyEnum(String name, CreativeTabs tab, PropertyEnum<T> TYPE) {
        super(name, tab);
        this.TYPE = TYPE;
    }

    /**
     * <h2>BlockPropertyEnum({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link net.minecraft.block.material.Material} material,
     * PropertyEnum<T> TYPE)</h2>
     *
     * @param name 指定的方块名称
     * @param material 物品的材质
     * @param tab 指定的创造物品栏
     * @param TYPE 物品的状态
     *
     * @author RMSCA
     * */
    public BlockPropertyEnum(String name, CreativeTabs tab, Material material, PropertyEnum<T> TYPE) {
        super(name, tab, material);
        this.TYPE = TYPE;
    }

    /**
     * <h2>registryModel(String path)</h2>
     * 详情参考Interface {@link com.laelioa.cbmod.init.IhasModel}，注意该接口仅被ClientProxy调用。
     * @author gaksy
     * */
    @Override
    public void registryModel(String path) {
        for(T type: TYPE.getValueClass().getEnumConstants()){
            ((ClientProxy) ComfortBox.proxy).pubRegisterModel(path + type.getName(), this, type.ordinal());
        }
    }

    /**<h2>getStateFromMeta #191</h2>
     * 用于将序列化方块状态的值转换为方块的meta。
     * @author RMSCA
     * */
    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, TYPE.getValueClass().getEnumConstants()[meta]);
    }

    /**
     * <h2>getMetaFromState #196</h2>
     * 用于将方块的meta转换为序列化方块状态的值
     * @author RMSCA
     * */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).ordinal();
    }

    /**
     * <h2>getSubBlocks #835</h2>
     * <p>returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)</p>
     * <p>返回具有相同ID但不同元数据（例如：wood返回4个方块）的方块列表。</p>
     * @author RMSCA
     * */
    @ParametersAreNonnullByDefault
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (T type : TYPE.getValueClass().getEnumConstants()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
        }
    }

    /**
     * <h2>getPickBlock #1588</h2>
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, empty itemstack if nothing should be added.
     * @author RMSCA
     * */
    @Nonnull
    @ParametersAreNonnullByDefault
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }
}
