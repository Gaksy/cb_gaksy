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
public class CbObject {

    /**
     * <h2>BLOCK/INCEPTION 初始化区域</h2>
     * <p>Goto {@link CbObject#ITEM_BLOCK_INC_CARPET ITEM_BLOCK/INCEPTION}</p>
     **/
    //blocks.inception
    public static final BlockCarpet BLOCK_INC_CARPET = new BlockCarpet();
    public static final BlockCarpet0 BLOCK_INC_CARPET_0 = new BlockCarpet0();
    public static final BlockCeramic BLOCK_INC_CERAMIC = new BlockCeramic();
    public static final BlockConcrete BLOCK_INC_CONCRETE = new BlockConcrete();
    public static final BlockMarble BLOCK_INC_MARBLE = new BlockMarble();
    public static final BlockBase BLOCK_INC_ASPHALT = new BlockBase("inc_asphalt", ComfortBox.incTab);
    public static final BlockBase BLOCK_INC_FROSTED = new BlockBase("inc_frosted_block", ComfortBox.incTab);

    /**
     * <h2>BLOCK/ROAD 初始化区域</h2>
     * <p>Goto {@link CbObject#ITEM_BLOCK_ASPHALT ITEM_BLOCK/ROAD}</p>
     **/
    //blocks
    public static final BlockAsphalt BLOCK_ASPHALT = new BlockAsphalt();

    /**
     * <h2>ITEM_BLOCK/INCEPTION 初始化区域</h2>
     * <p>Goto {@link CbObject#BLOCK_INC_CARPET BLOCK/INCEPTION}</p>
     **/
    //items.inception
    public static final ItemBlockCarpet ITEM_BLOCK_INC_CARPET = new ItemBlockCarpet();
    public static final ItemBlockCarpet0 ITEM_BLOCK_INC_CARPET_0 = new ItemBlockCarpet0();
    public static final ItemBlockCeramic ITEM_BLOCK_INC_CERAMIC = new ItemBlockCeramic();
    public static final ItemBlockConcrete ITEM_BLOCK_INC_CONCRETE = new ItemBlockConcrete();
    public static final ItemBlockMarble ITEM_BLOCK_INC_MARBLE = new ItemBlockMarble();
    public static final ItemBlockBase ITEM_BLOCK_INC_ASPHALT = new ItemBlockBase(BLOCK_INC_ASPHALT, true);
    public static final ItemBlockBase ITEM_BLOCK_INC_FROSTED = new ItemBlockBase(BLOCK_INC_FROSTED, true);

    /**
     * <h2>ITEM_BLOCK/ROAD 初始化区域</h2>
     * <p>Goto {@link CbObject#BLOCK_ASPHALT BLOCK/ROAD}</p>
     **/
    //items
    public static final ItemBlockAsphalt ITEM_BLOCK_ASPHALT = new ItemBlockAsphalt();




    /**
     * <h2>registerBlocks({@link IForgeRegistry<Block>} registry)</h2>
     *
     * <p>{@link IForgeRegistry<Block>} registry: 方块注册表</p>
     *
     * <p>描述：额外需要注册的方块</p>
     *
     * @author gaksy
     * */
    public static void registerBlocks(IForgeRegistry<Block> registry) {

    }

    /**
     * <h2>registerItemBlocks({@link IForgeRegistry<Item>} registry)</h2>
     *
     * <p>{@link IForgeRegistry<Item>} registry: 物品注册表</p>
     *
     * <p>描述：额外需要注册的物品</p>
     *
     * @author gaksy
     * */
    public static void registerItemBlocks(IForgeRegistry<Item> registry) {

    }

}
