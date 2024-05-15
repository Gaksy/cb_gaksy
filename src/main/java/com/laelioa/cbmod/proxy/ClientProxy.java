package com.laelioa.cbmod.proxy;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockBase;
import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.init.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

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
    public void init() { super.init(); }

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
        for (Block block : RegistryHandler.getBlocks()) {
            ((BlockBase)block).registerModel();
        }
    }

    /**
     * <h2>registerModel</h2>
     * <p>用于注册模型的标准流程</p>
     * @author RMSCA
     * */
    public void register(String path, Block block, int meta) {
        ResourceLocation resourceLocation = new ResourceLocation(Reference.MODID, path);
        ModelResourceLocation modelResourceLocation = new ModelResourceLocation(resourceLocation, "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, modelResourceLocation);
    }
}
