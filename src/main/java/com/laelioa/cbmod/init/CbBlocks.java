package com.laelioa.cbmod.init;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.blocks.BlockBase;
import com.laelioa.cbmod.blocks.inception.*;
import com.laelioa.cbmod.items.ItemBlockAsphalt;
import com.laelioa.cbmod.items.ItemBlockBase;
import com.laelioa.cbmod.items.inception.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

//BLOCK | INCEPTION
//      | ROAD
//
//ITEM_BLOCK | INCEPTION
//           | ROAD

/**
 * <h2>Class CbObject</h2>
 * <p>该类负责将所有对象（方块、物品）进行初始化</p>
 * <p>当方块或物品初始化后，他会自动调用Registrant，向其待注册列表添加对应的方块或物品，当注册事件触发后会自动注册</p>
 *
 * @author gaksy
 * */
@SuppressWarnings("unused")     //取消未使用警告
public class CbBlocks {
    /**
     * <h2>BLOCK/INCEPTION 初始化区域</h2>
     * <p>Goto {@link CbBlocks#ITEM_INC_CARPET ITEM_BLOCK/INCEPTION}</p>
     **/
    //blocks.inception
    public static final BlockBase INC_CARPET = new BlockCarpet();
    public static final BlockBase INC_CARPET_0 = new BlockCarpet0();
    public static final BlockBase INC_CERAMIC = new BlockCeramic();
    public static final BlockBase INC_CONCRETE = new BlockConcrete();
    public static final BlockBase INC_MARBLE = new BlockMarble();
    public static final BlockBase INC_ASPHALT = new BlockBase("inc_asphalt", ComfortBox.incTab);
    public static final BlockBase INC_FROSTED = new BlockBase("inc_frosted_block", ComfortBox.incTab);

    /**
     * <h2>BLOCK/ROAD 初始化区域</h2>
     * <p>Goto {@link CbBlocks#ITEM_ASPHALT ITEM_BLOCK/ROAD}</p>
     **/
    //blocks
    public static final BlockBase ASPHALT = new BlockAsphalt();


    /**
     * <h2>ITEM_BLOCK/INCEPTION 初始化区域</h2>
     * <p>Goto {@link CbBlocks#INC_CARPET BLOCK/INCEPTION}</p>
     **/
    //items.inception
    public static final ItemBlock ITEM_INC_CARPET = new ItemBlockCarpet();
    public static final ItemBlock ITEM_INC_CARPET_0 = new ItemBlockCarpet0();
    public static final ItemBlock ITEM_INC_CERAMIC = new ItemBlockCeramic();
    public static final ItemBlock ITEM_INC_CONCRETE = new ItemBlockConcrete();
    public static final ItemBlock ITEM_INC_MARBLE = new ItemBlockMarble();
    public static final ItemBlock ITEM_INC_ASPHALT = new ItemBlockBase(INC_ASPHALT, false);
    public static final ItemBlock ITEM_INC_FROSTED = new ItemBlockBase(INC_FROSTED, false);

    /**
     * <h2>ITEM_BLOCK/ROAD 初始化区域</h2>
     * <p>Goto {@link CbBlocks#ASPHALT BLOCK/ROAD}</p>
     **/
    //items
    public static final ItemBlockAsphalt ITEM_ASPHALT = new ItemBlockAsphalt();

    /**
     * <h2>registerBlocks({@link IForgeRegistry<Block>} registry)</h2>
     *
     * <p>{@link IForgeRegistry<Block>} registry: 方块注册表</p>
     *
     * <p>描述：额外需要注册的方块</p>
     *
     * @author gaksy
     * */
    public static void registerBlocks(IForgeRegistry<Block> registry) {}

    /**
     * <h2>registerItemBlocks({@link IForgeRegistry<Item>} registry)</h2>
     *
     * <p>{@link IForgeRegistry<Item>} registry: 物品注册表</p>
     *
     * <p>描述：额外需要注册的物品</p>
     *
     * @author gaksy
     * */
    public static void registerItemBlocks(IForgeRegistry<Item> registry) {}
}
