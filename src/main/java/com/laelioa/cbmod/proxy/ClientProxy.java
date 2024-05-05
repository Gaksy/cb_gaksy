package com.laelioa.cbmod.proxy;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.blocks.inception.BlockConcrete;
import com.laelioa.cbmod.blocks.inception.BlockMarble;
import com.laelioa.cbmod.init.CbBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    @Override
    public void registerBlockModels() {
        for (BlockAsphalt.AsphaltType type : BlockAsphalt.AsphaltType.values()) {
            registerModel("asphalt/asphalt_" + type.getName(), CbBlocks.ASPHALT, type.ordinal());
        }

        for (int meta = 0; meta < 16; meta++) {
            registerModel("inception/carpet/inc_carpet_" + meta, CbBlocks.INC_CARPET, meta);
        }

        for (int meta = 0; meta < 2; meta++) {
            registerModel("inception/carpet/inc_carpet0_" + meta, CbBlocks.INC_CARPET0, meta);
        }

        for (BlockMarble.MarbleType type : BlockMarble.MarbleType.values()) {
            registerModel("inception/marble/inc_marble_" + type.getName(), CbBlocks.INC_MARBLE, type.ordinal());
        }

        for (BlockConcrete.ConcreteType type : BlockConcrete.ConcreteType.values()) {
            registerModel("inception/concrete/inc_concrete_" + type.getName(), CbBlocks.INC_CONCRETE, type.ordinal());
        }

        registerModel("inception/inc_asphalt", CbBlocks.INC_ASPHALT, 0);
        registerModel("inception/inc_frosted_block", CbBlocks.INC_FROSTED_BLOCK, 0);
    }

    private void registerModel(String path, Block block, int meta) {
        ResourceLocation resourceLocation = new ResourceLocation(Reference.MODID, path);
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, modelResourceLocation);
    }
}
