package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import net.minecraft.block.properties.PropertyEnum;
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
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * <h2>Class BlockAsphalt</h2>
 * <p>沥青方块，Road Tab</p>
 *
 * <p>相关文档：</p>
 * <p>
 *     {@link net.minecraft.block.Block}：
 *     [juanmuscaria] Material Docs |
 *     <a href="https://github.juanmuscaria.com/DocsMC/net/minecraft/block/Block.html">en-us</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.Block#getPickBlock}：
 *     [知乎] 掉落物与方块 |
 *     <a href="https://zhuanlan.zhihu.com/p/445378825">zh-cn</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.properties.PropertyEnum}：
 *     [Forge docs] Block States |
 *     <a href="https://docs.minecraftforge.net/en/1.20.x/blocks/states/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/blocks/states/">zh-cn</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.properties.PropertyEnum}：
 *     [teamcovertdragon docs] Block States |
 *     <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-05/block-state.html">zh-cn</a>
 * </p>
 *
 * @author RMSCA
 * */
public class BlockAsphalt extends BlockBase {

    /**
     * <h2>PropertyEnum&lt;E extends Enum&lt;E&gt;&gt;</h2>
     * 实现了 IProperty<E>, 定义可以采用Enum类列举的值的属性。 调用PropertyEnum.create("name", <enum_class>)来创建;
     * 首先我们需要一个枚举类，并让这个枚举类实现 IStringSerializable，然后我们才能通过 PropertyEnum.create(propertyName, enumClass)
     * 拿到一个 PropertyEnum。
     * <br>补充：PropertyEnum.create 有两个重载，允许你只使用一部分你的枚举类的值。它通常代表某种进度（机器工作进度、设备生长进度）或某种测量值
     * （信号强度）。
     * */
    private static final PropertyEnum<AsphaltType> TYPE = PropertyEnum.create("type", AsphaltType.class);

    public BlockAsphalt() {
        super("asphalt", ComfortBox.roadTab);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    /**<h2>getStateFromMeta #191</h2>
     * 用于将序列化方块状态的值转换为方块的meta。
     * @author RMSCA
     * */
    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, AsphaltType.values()[meta]);
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
        for (AsphaltType type : AsphaltType.values()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
            //ordinal 返回当前type的序列化值
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
        state.getBlock();
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    /**
     * <h2>沥青方块的状态</h2>
     * Road Tab，对应于不同的道路标线
     * */
    public enum AsphaltType implements IStringSerializable {
        DEFAULT, NEW, WHITE, YELLOW, WHITE_LINE, YELLOW_LINE,
        DOUBLE_WHITE_LINE, DOUBLE_YELLOW_LINE,
        SLANTED_WHITE_LINE, SLANTED_YELLOW_LINE, SLANTED_DOUBLE_WHITE_LINE,
        SLANTED_DOUBLE_YELLOW_LINE;

        public static AsphaltType byMetadata(int meta) {
            if (meta < 0 || meta >= values().length) {
                meta = 0;
            }
            return values()[meta];
        }

        @Nonnull
        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }


}
