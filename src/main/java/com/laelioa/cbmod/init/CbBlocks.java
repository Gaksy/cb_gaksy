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
@SuppressWarnings("unused")     //取消未使用警告
public class CbBlocks {
    /**
     * <h2>BLOCK/INCEPTION 初始化区域</h2>
     **/
    //blocks.inception
    public static final Block INC_CARPET = new BlockCarpet();
    public static final Block INC_CARPET_0 = new BlockCarpet0();
    public static final Block INC_CERAMIC = new BlockCeramic();
    public static final Block INC_CONCRETE = new BlockConcrete();
    public static final Block INC_MARBLE = new BlockMarble();
    public static final Block INC_FLOOR = new BlockFloor();
    public static final Block INC_ASPHALT = new BlockBase("inc_asphalt", ComfortBox.incTab, "inception/inc_asphalt");
    public static final Block INC_FROSTED_BLOCK = new BlockBase("inc_frosted_block", ComfortBox.incTab, "inception/inc_frosted_block");
    public static final Block INC_DECK = new BlockBase("inc_deck", ComfortBox.incTab, "inception/inc_deck");
    public static final Block INC_BAD_PLANK = new BlockBase("inc_bad_plank", ComfortBox.incTab, "inception/inc_bad_plank");
    public static final Block INC_COAL = new BlockBase("inc_coal", ComfortBox.incTab, "inception/inc_coal");
    public static final Block INC_CROCODILE_LEATHER = new BlockBase("inc_crocodile_leather", ComfortBox.incTab, "inception/inc_crocodile_leather");
    public static final Block INC_DAMASCUS_STEEL = new BlockBase("inc_damascus_steel", ComfortBox.incTab, "inception/inc_damascus_steel");
    public static final Block INC_FLANNEL = new BlockBase("inc_flannel", ComfortBox.incTab, "inception/inc_flannel");
    public static final Block INC_GOLD_BLOCK = new BlockBase("inc_gold_block", ComfortBox.incTab, "inception/inc_gold_block");
    public static final Block INC_GRANITE = new BlockBase("inc_granite", ComfortBox.incTab, "inception/inc_granite");
    public static final Block INC_HIGHLY_REFLECTIVE = new BlockBase("inc_highly_reflective", ComfortBox.incTab, "inception/inc_highly_reflective");
    public static final Block INC_ICE_BLOCK = new BlockBase("inc_ice_block", ComfortBox.incTab, "inception/inc_ice_block");
    public static final Block INC_IRON_BLOCK = new BlockBase("inc_iron_block", ComfortBox.incTab, "inception/inc_iron_block");
    public static final Block INC_LATEX_MATTRESS = new BlockBase("inc_latex_mattress", ComfortBox.incTab, "inception/inc_latex_mattress");
    public static final Block INC_LEATHER = new BlockBase("inc_leather", ComfortBox.incTab, "inception/inc_leather");
    public static final Block INC_LIMESTONE = new BlockBase("inc_limestone", ComfortBox.incTab, "inception/inc_limestone");
    public static final Block INC_LINEN = new BlockBase("inc_linen", ComfortBox.incTab, "inception/inc_linen");
    public static final Block INC_LOG_SMOOTH = new BlockBase("inc_log_smooth", ComfortBox.incTab, "inception/inc_log_smooth");
    public static final Block INC_LUXURIOUS_LEATHER = new BlockBase("inc_luxurious_leather", ComfortBox.incTab, "inception/inc_luxurious_leather");

    /**
     * <h2>ITEM_BLOCK/INCEPTION 初始化区域</h2>
     **/
    //items.inception
    public static final Item ITEM_INC_CARPET = new ItemBlockBase(INC_CARPET, true);
    public static final Item ITEM_INC_CARPET_0 = new ItemBlockBase(INC_CARPET_0, true);
    public static final Item ITEM_INC_CERAMIC = new ItemBlockBase(INC_CERAMIC, true);
    public static final Item ITEM_INC_CONCRETE = new ItemBlockBase(INC_CONCRETE, true);
    public static final Item ITEM_INC_MARBLE = new ItemBlockMarble();
    public static final Item ITEM_INC_FLOOR = new ItemBlockBase(INC_FLOOR, true);
    public static final Item ITEM_INC_ASPHALT = new ItemBlockBase(INC_ASPHALT, false);
    public static final Item ITEM_INC_FROSTED = new ItemBlockBase(INC_FROSTED_BLOCK, false);
    public static final Item ITEM_INC_DECK = new ItemBlockBase(INC_DECK, false);
    public static final Item ITEM_INC_BAD_PLANK = new ItemBlockBase(INC_BAD_PLANK, false);
    public static final Item ITEM_INC_COAL = new ItemBlockBase(INC_COAL, false);
    public static final Item ITEM_INC_CROCODILE_LEATHER = new ItemBlockBase(INC_CROCODILE_LEATHER, false);
    public static final Item ITEM_INC_DAMASCUS_STEEL = new ItemBlockBase(INC_DAMASCUS_STEEL, false);
    public static final Item ITEM_INC_FLANNEL = new ItemBlockBase(INC_FLANNEL, false);
    public static final Item ITEM_INC_GOLD_BLOCK = new ItemBlockBase(INC_GOLD_BLOCK, false);
    public static final Item ITEM_INC_GRANITE = new ItemBlockBase(INC_GRANITE, false);
    public static final Item ITEM_INC_HIGHLY_REFLECTIVE = new ItemBlockBase(INC_HIGHLY_REFLECTIVE, false);
    public static final Item ITEM_INC_ICE_BLOCK = new ItemBlockBase(INC_ICE_BLOCK, false);
    public static final Item ITEM_INC_IRON_BLOCK = new ItemBlockBase(INC_IRON_BLOCK, false);
    public static final Item ITEM_INC_LATEX_MATTRESS = new ItemBlockBase(INC_LATEX_MATTRESS, false);
    public static final Item ITEM_INC_LEATHER = new ItemBlockBase(INC_LEATHER, false);
    public static final Item ITEM_INC_LIMESTONE = new ItemBlockBase(INC_LIMESTONE, false);
    public static final Item ITEM_INC_LOG_SMOOTH = new ItemBlockBase(INC_LOG_SMOOTH, false);
    public static final Item ITEM_INC_LUXURIOUS_LEATHER = new ItemBlockBase(INC_LUXURIOUS_LEATHER, false);

    /**
     * <h2>BLOCK/ROAD 初始化区域</h2>
     **/
    //blocks
    public static final BlockBase ASPHALT = new BlockAsphalt();

    /**
     * <h2>ITEM_BLOCK/ROAD 初始化区域</h2>
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
