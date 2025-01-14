package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyInteger;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;

import javax.annotation.Nonnull;

/**
 * <h2>Class BlockCarpet</h2>
 * <p>地毯方块，Inception Tab</p>
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
 *     {@link net.minecraft.block.properties.PropertyInteger}：
 *     [Forge docs] Block States |
 *     <a href="https://docs.minecraftforge.net/en/1.20.x/blocks/states/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/blocks/states/">zh-cn</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.properties.PropertyInteger}：
 *     [teamcovertdragon docs] Block States |
 *     <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-05/block-state.html">zh-cn</a>
 * </p>
 * @author RMSCA
 * */
public class BlockCarpet extends BlockPropertyInteger {
    private final static PropertyInteger TYPE = PropertyInteger.create("type", 0, 15);

    public BlockCarpet() {
        super("inc_carpet", ComfortBox.incTab, TYPE, 15, "inception/carpet/inc_carpet_");
    }

    /**
     * <h2>createBlockState #898</h2>
     * 创建方块状态
     * */
    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }
}

