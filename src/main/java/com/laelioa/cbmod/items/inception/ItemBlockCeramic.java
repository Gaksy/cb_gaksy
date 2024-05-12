package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbObject;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockCeramic</h2>
 * 陶瓷
 * @author RMSCA
 * */
public class ItemBlockCeramic extends ItemBlockBase {
    public ItemBlockCeramic() {
        super(CbObject.BLOCK_INC_CERAMIC, true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "_" + stack.getMetadata();
    }
}
