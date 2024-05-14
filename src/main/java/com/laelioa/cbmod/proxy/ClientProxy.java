package com.laelioa.cbmod.proxy;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.blocks.inception.BlockMarble;
import com.laelioa.cbmod.init.CbBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy {

    /**
     * <h2>处理Mod加载的三个阶段：预初始化、初始化和后初始化</h2>
     * <p>参考文档：</p>
     * <p>"Loading Stages" 文档
     * <a href="https://mcforge-ko.readthedocs.io/zh/latest/conventions/loadstages/">| en-us |</a>
     * <a href="https://docs.minecraftforge.net/en/1.12.x/conventions/loadstages/">| zh-cn |</a>
     * </p>
     * */
    @Override
    public void preInit() { super.preInit(); }

    @Override
    public void init(FMLInitializationEvent event) { super.init(event); }

    @Override
    public void postInit() {
        super.postInit();
    }

    /**
     * <h2>registerBlockModels</h2>
     * <p>注册方块模型，对各种需要的方块进行特化处理，变化的部分</p>
     * @author RMSCA, Zhu
     * */
    @Override
    public void registerBlockModels() {
        for (BlockAsphalt.AsphaltType type : BlockAsphalt.AsphaltType.values()) {
            registerModel("asphalt/asphalt_" + type.getName(), CbBlocks.ASPHALT, type.ordinal());
        }

        for (int meta = 0; meta < 16; meta++) {
            registerModel("inception/carpet/inc_carpet_" + meta, CbBlocks.INC_CARPET, meta);
        }

        for (int meta = 0; meta < 2; meta++) {
            registerModel("inception/carpet/inc_carpet0_" + meta, CbBlocks.INC_CARPET_0, meta);
        }

        for (BlockMarble.MarbleType type : BlockMarble.MarbleType.values()) {
            registerModel("inception/marble/inc_marble_" + type.getName(), CbBlocks.INC_MARBLE, type.ordinal());
        }

        for (int meta = 0; meta < 8; meta++) {
            registerModel("inception/concrete/inc_concrete_" + meta, CbBlocks.INC_CONCRETE, meta);
        }

        for (int meta = 0; meta < 10; meta++) {
            registerModel("inception/ceramic/inc_ceramic_" + meta, CbBlocks.INC_CERAMIC, meta);
        }

        registerModel("inception/inc_asphalt", CbBlocks.INC_ASPHALT, 0);
        registerModel("inception/inc_frosted_block", CbBlocks.INC_FROSTED, 0);
    }

    /**
     * <h2>registerModel</h2>
     * <p>用于注册模型的标准流程</p>
     * @author RMSCA
     * */
    private void registerModel(String path, Block block, int meta) {
        ResourceLocation resourceLocation = new ResourceLocation(Reference.MODID, path);
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, modelResourceLocation);
    }
}
