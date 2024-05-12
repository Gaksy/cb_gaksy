package com.laelioa.cbmod.items;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockBase;
import com.laelioa.cbmod.init.RegistryHandler;
import net.minecraft.item.ItemBlock;

/**
 * <h2>Class ItemBlockBase</h2>
 * <p>所有方块物品都应该继承此类，该类会自动将物品添加到指定的物品栏并注册，自动设置本地化键名</p>
 * <p>相关文档：</p>
 * <p>
 *     {@link net.minecraft.item.ItemBlock}：
 *     [Forge docs] Items Docs |
 *     <a href="https://docs.minecraftforge.net/en/1.12.x/items/items/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/items/items/">zh-cn</a>
 * </p>
 * <p>
 *     {@link net.minecraft.item.ItemBlock#setUnlocalizedName}：
 *     [FORGE docs] Internationalization and Localization |
 *     <a href="https://docs.minecraftforge.net/en/latest/concepts/internationalization/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/concepts/internationalization/">zh-cn</a>
 * </p>
 * @author gaksy
 * */
public class ItemBlockBase extends ItemBlock {
    public ItemBlockBase(BlockBase dec_block, boolean has_sub_types){
        super(dec_block);

        setRegistryName(Reference.MODID, dec_block.getBlockName()); //设置注册名称
        setHasSubtypes(has_sub_types);                              //设置...

        RegistryHandler.addItem(dec_block.getBlockName(), this); //将物品添加到注册列表
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }
}
