package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.init.IhasModel;
import com.laelioa.cbmod.init.RegistryHandler;
import com.laelioa.cbmod.proxy.ClientProxy;
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
public class BlockBase extends Block implements IhasModel {
    private String name;

    /**
     * <h2>BaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab,
     * {@link net.minecraft.block.material.Material} dec_material)</h2>
     *
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param material 指定的物品材质
     *
     * @author gaksy
     * */
    public BlockBase(String name, CreativeTabs tab, Material material) {
        super(material);
        init(name, tab);
    }

    /**
     * <h2>BaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab)</h2>
     *
     * <p>描述：Material默认为ROCK</p>
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @author gaksy
     * */
    public BlockBase(String name, CreativeTabs tab) {
        super(Material.ROCK);
        init(name, tab);
    }

    /**
     * <h2>iniBaseBlock({@link String} block_name,
     * {@link net.minecraft.creativetab.CreativeTabs} creative_tab)</h2>
     *
     * <p>描述：标准Inception物品的初始化流程</p>
     * @param name 指定方块的名称
     * @param tab 指定的创造物品栏
     * @author gaksy
     * */
    private void init(String name, CreativeTabs tab) {
        this.name = name;                                //存储block name
        setRegistryName(Reference.MODID, name);          //设置其注册名称 示例：cbmod:block_name
        setUnlocalizedName(name + "_unlocalized");       //设置本地化键名 示例：block_name_unlocalized
        setCreativeTab(tab);                             //设置方块所在的创造模式物品栏
        RegistryHandler.addBlock(name, this);      //将自身添加到注册列表
    }

    /**
     * <h2>registryModel(String path)</h2>
     * 详情参考Interface {@link com.laelioa.cbmod.init.IhasModel}，注意该接口仅被ClientProxy调用。
     * @author gaksy
     * */
    @Override
    public void registryModel(String path) {
        ((ClientProxy)ComfortBox.proxy).pubRegisterModel(path, this, 0);
    }

    /**
     * <h2>getBlockName()</h2>
     * @return 方块的名称
     * @author gaksy
     * */
    public String getName() {
        return name;
    }
}
