package com.laelioa.cbmod.init;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.blocks.inception.*;
import com.laelioa.cbmod.items.ItemBlockAsphalt;
import com.laelioa.cbmod.items.inception.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class CbBlocks {
    // Road
    public static final Block ASPHALT;

    // Inception
    public static final Block INC_CARPET, INC_CARPET0, INC_MARBLE, INC_CONCRETE, INC_CERAMIC, INC_ASPHALT,
            INC_FROSTED_BLOCK;

    //静态初始化static复合语句，初始化且仅初始化一次
    static {
        // Road
        ASPHALT = new BlockAsphalt();

        // Inception
        INC_CARPET = new BlockCarpet();
        INC_CARPET0 = new BlockCarpet0();
        INC_MARBLE = new BlockMarble();
        INC_CONCRETE = new BlockConcrete();
        INC_CERAMIC = new BlockCeramic();
        INC_ASPHALT = new BlockInception("inc_asphalt");
        INC_FROSTED_BLOCK = new BlockInception("inc_frosted_block");
    }

    /**
     * 注册方块
     * <br>由 {@link RegistryHandler} 调用
     * @author RMSCA, Zhu
     * */
    public static void registerBlocks(IForgeRegistry<Block> registry) {
        // Road
        registry.register(ASPHALT);

        // Inception
        registry.registerAll(RegistryHandler.BLOCKS.toArray(new Block[0]));
    }

    /**
     * 注册物品
     * <br>由 {@link RegistryHandler} 调用
     * @author RMSCA, Zhu, RMSCA*
     * */
    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        // Road
        registry.register(new ItemBlockAsphalt());

        // Inception
        registry.register(new ItemBlockCarpet());
        registry.register(new ItemBlockCarpet0());
        registry.register(new ItemBlockMarble());
        registry.register(new ItemBlockConcrete());
        registry.register(new ItemBlockCeramic());
        registry.register(new ItemBlock(INC_ASPHALT).setRegistryName(Reference.MODID, "inc_asphalt"));
        registry.register(new ItemBlock(INC_FROSTED_BLOCK).setRegistryName(Reference.MODID, "inc_frosted_block"));
    }
}
