package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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

/**
 * <h2>BlockAsphalt</h2>
 * 沥青方块，该方块拥有多种状态
 * @author RMSCA
 * */
public class BlockAsphalt extends Block {

    /**
     * <h2>PropertyEnum&lt;E extends Enum&lt;E&gt;&gt;</h2>
     * 实现了 IProperty<E>, 定义可以采用Enum类列举的值的属性。 调用PropertyEnum.create("name", <enum_class>)来创建;
     * 首先我们需要一个枚举类，并让这个枚举类实现 IStringSerializable，然后我们才能通过 PropertyEnum.create(propertyName, enumClass)
     * 拿到一个 PropertyEnum。
     * <a href="https://mcforge-ko.readthedocs.io/zh/latest/blocks/states/"> 中文官方文档翻译 </a>
     * <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-05/block-state.html"> Harbinger文档 </a>
     * <br>补充：PropertyEnum.create 有两个重载，允许你只使用一部分你的枚举类的值。。
     * */
    private static final PropertyEnum<AsphaltType> TYPE = PropertyEnum.create("type", AsphaltType.class);

    public BlockAsphalt() {
        super(Material.ROCK);
        setRegistryName(Reference.MODID, "asphalt");     //设置注册名称
        setUnlocalizedName("asphalt_unlocalized");             //设置本地化键名
        setCreativeTab(ComfortBox.roadTab);                    //物品所在的创造模式物品栏
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    /**<h2>getStateFromMeta</h2>
     * Override {@link Block#getStateFromMeta(int)}, 用于将序列化方块状态的值转换为方块的meta。
     * @author RMSCA
     * */
    @Nonnull
    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, AsphaltType.values()[meta]);
    }

    /**
     * <h2>getMetaFromState</h2>
     * Override {@link Block#getMetaFromState(IBlockState)}，用于将方块的meta转换为序列化方块状态的值
     * @author RMSCA
     * */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(TYPE).ordinal();
    }

    /**
     * <h2>getSubBlocks</h2>
     * Override {@link Block#getSubBlocks(CreativeTabs, NonNullList)}
     * <br><a href="https://github.juanmuscaria.com/DocsMC/net/minecraft/block/Block.html">可能的文档</a>
     * <br>returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     * <br>返回具有相同ID但不同元数据（例如：wood返回4个方块）的方块列表。
     * @author RMSCA
     * */
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        for (AsphaltType type : AsphaltType.values()) {
            items.add(new ItemStack(this, 1, type.ordinal()));
            //ordinal 返回当前type的序列化值
        }
    }

    /**
     * <h2>getPickBlock</h2>
     * 这个方法的作用是给创造模式鼠标中键选择方块提供物品
     * <br>
     * <a href="https://zhuanlan.zhihu.com/p/445378825">来自知乎的文档-掉落物与方块</a>
     * @author RMSCA
     * */
    @Nonnull
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        //FIXME
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    public enum AsphaltType implements IStringSerializable {
        DEFAULT,
        NEW,
        WHITE,
        YELLOW,
        WHITE_LINE,
        YELLOW_LINE,
        DOUBLE_WHITE_LINE,
        DOUBLE_YELLOW_LINE,
        SLANTED_WHITE_LINE,
        SLANTED_YELLOW_LINE,
        SLANTED_DOUBLE_WHITE_LINE,
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
