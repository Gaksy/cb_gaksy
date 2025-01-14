package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.proxy.ClientProxy;
import net.minecraft.block.material.Material;
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
public class BlockPropertyInteger extends BlockBase{
    private final PropertyInteger TYPE;
    private final int MAX_STATES;

    /**
     * <h2>BlockBaseStatuePropertyInteger({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link PropertyInteger} STATUS_TYPE,
     * int max)</h2>
     *
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param TYPE 物品的状态
     * @param maxStates 物品的最大状态值
     * @param resourcePath 资源文件路径
     *
     * @author gaksy
     * */
    public BlockPropertyInteger(String name, CreativeTabs tab, PropertyInteger TYPE, int maxStates, String resourcePath) {
        super(name, tab, resourcePath);
        this.TYPE = TYPE;
        MAX_STATES = maxStates;
    }

    /**
     * <h2>BlockBaseStatuePropertyInteger({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link PropertyInteger} STATUS_TYPE,
     * int max)</h2>
     *
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param material 物品的材质
     * @param TYPE 物品的状态
     * @param maxStates 物品的最大状态值
     * @param resourcePath 资源文件路径
     *
     * @author gaksy
     * */
    public BlockPropertyInteger(String name, CreativeTabs tab, Material material, PropertyInteger TYPE, int maxStates, String resourcePath) {
        super(name, tab, material, resourcePath);
        this.TYPE = TYPE;
        MAX_STATES = maxStates;
    }

    /**
     * <h2>registryModel(String path)</h2>
     * 详情参考Interface {@link IHasModel}，注意该接口仅被ClientProxy调用。
     * @author gaksy
     * */
    @Override
    public void registerModel() {
        for(int meta = 0; meta <= MAX_STATES; meta++){
            ((ClientProxy) ComfortBox.proxy).register(this.getResourcePath() + meta, this, meta);
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
        return getDefaultState().withProperty(TYPE, meta);
    }

    /**
     * <h2>getMetaFromState #196</h2>
     * 用于将方块的meta转换为序列化方块状态的值
     * @author RMSCA
     * */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE);
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
        for (int meta = 0; meta <= MAX_STATES; meta++) {
            items.add(new ItemStack(this, 1, meta));
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
