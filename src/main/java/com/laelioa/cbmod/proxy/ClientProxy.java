package com.laelioa.cbmod.proxy;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.blocks.BlockBase;
import com.laelioa.cbmod.blocks.inception.BlockMarble;
import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.init.IhasModel;
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
        CbBlocks.ASPHALT.registryModel("asphalt/asphalt_");

        CbBlocks.INC_CARPET.registryModel("inception/carpet/inc_carpet_");
        CbBlocks.INC_CARPET_0.registryModel("inception/carpet/inc_carpet0_");
        CbBlocks.INC_CONCRETE.registryModel("inception/concrete/inc_concrete_");
        CbBlocks.INC_CERAMIC.registryModel("inception/ceramic/inc_ceramic_");
        CbBlocks.INC_MARBLE.registryModel("inception/marble/inc_marble_");
        CbBlocks.INC_FLOOR.registryModel("inception/floor/inc_floor_");

        CbBlocks.INC_ASPHALT.registryModel("inception/inc_asphalt");
        CbBlocks.INC_FROSTED_BLOCK.registryModel("inception/inc_frosted_block");
        CbBlocks.INC_DECK.registryModel("inception/inc_deck");
    }

    /**
     * <h2>pubRegisterModel</h2>
     * 将私有的 registerModel 封装为 public
     * @param path 路径
     * @param currentBlock 目标方块
     * @param meta 状态
     * @author gaksy
     * */
    public void pubRegisterModel(String path, Block currentBlock, int meta){
        registerModel(path, currentBlock, meta);
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
