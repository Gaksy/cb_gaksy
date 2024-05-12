package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.init.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * <h2>Class BlockBase</h2>
 * <p>所有方块都应该继承此类，该类会自动将方块添加到指定的物品栏并注册，且自动设置本地化键名</p>
 * <p>相关文档：</p>
 * <p>
 *     {@link net.minecraft.block.material.Material}：
 *     [juanmuscaria] Material Docs |
 *     <a href="https://github.juanmuscaria.com/DocsMC/net/minecraft/block/material/Material.html">en-us</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.Block#setUnlocalizedName}：
 *     [FORGE docs] Internationalization and Localization |
 *     <a href="https://docs.minecraftforge.net/en/latest/concepts/internationalization/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/concepts/internationalization/">zh-cn</a>
 * </p>
 * @author gaksy
 * */
public class BlockBase extends Block {
    private String block_name;

    /**
     * <h2>BaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link net.minecraft.block.material.Material} dec_material)</h2>
     *
     * <p>{@link String} block_name: 指定方块名称</p>
     * <p>{@link net.minecraft.creativetab.CreativeTabs} creative_tab: 指定方块的物品栏</p>
     * <p>{@link net.minecraft.block.material.Material} dec_material: 指定方块的 material</p>
     *
     * @author gaksy
     * */
    public BlockBase(String block_name, CreativeTabs creative_tab, Material dec_material){
        super(dec_material);
        iniBlockBase(block_name, creative_tab);
    }

    /**
     * <h2>BaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab)</h2>
     *
     * <p>{@link String} block_name: 指定方块名称</p>
     * <p>{@link net.minecraft.creativetab.CreativeTabs} creative_tab: 指定方块的物品栏</p>
     *
     * <p>描述：Material默认为ROCK</p>
     *
     * @author gaksy
     * */
    public BlockBase(String block_name, CreativeTabs creative_tab){
        super(Material.ROCK);
        iniBlockBase(block_name, creative_tab);
    }

    /**
     * <h2>iniBaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab)</h2>
     *
     * <p>{@link String} block_name: 指定方块名称</p>
     * <p>{@link net.minecraft.creativetab.CreativeTabs} creative_tab: 指定方块的物品栏/p>
     *
     * <p>描述：标准Inception物品的初始化流程</p>
     *
     * @author gaksy
     * */
    private void iniBlockBase(String block_name, CreativeTabs crateive_tab){
        this.block_name = block_name;                       //存储block name

        setRegistryName(Reference.MODID, block_name);       //设置其注册名称 示例：cbmod::block_name
        setUnlocalizedName(block_name + "_unlocalized");    //设置本地化键名 示例：block_name_unlocalized

        setCreativeTab(crateive_tab);                             //设置方块所在的创造模式物品栏

        RegistryHandler.addBlock(block_name, this);      //将自身添加到注册列表
    }

    /**
     * <h2>getBlockName()</h2>
     *
     * <p>return {@link String}: 方块名称</p>
     *
     * <p>描述：返回方块的名称</p>
     *
     * @author gaksy
     * */
    public String getBlockName(){
        return block_name;
    }
}
