package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockBaseStatuePropertyInteger;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;

import javax.annotation.Nonnull;

/**
 * <h2>Class BlockCeramic</h2>
 * <p>陶瓷方块，Inception Tab</p>
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
public class BlockCeramic extends BlockBaseStatuePropertyInteger {
    private final static PropertyInteger STATUS_TYPE = PropertyInteger.create("type", 0, 9);
    public BlockCeramic() {
        super("inc_ceramic", ComfortBox.incTab, STATUS_TYPE, 9);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STATUS_TYPE);
    }
}
