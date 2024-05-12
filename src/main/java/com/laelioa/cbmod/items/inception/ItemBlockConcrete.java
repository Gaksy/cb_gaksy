package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbObjects;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockConcrete</h2>
 * 混凝土
 * @author RMSCA
 * */
public class ItemBlockConcrete extends ItemBlockBase {
    public ItemBlockConcrete() {
        super(CbObjects.BLOCK_INC_CONCRETE, true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "_" + stack.getMetadata();
    }
}
