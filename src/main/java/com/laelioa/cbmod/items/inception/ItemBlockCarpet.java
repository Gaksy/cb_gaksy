package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbObject;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockCarpet</h2>
 * 地毯
 * @author RMSCA
 * */
public class ItemBlockCarpet extends ItemBlockBase {
    public ItemBlockCarpet() {
        super(CbObject.BLOCK_INC_CARPET, true);
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
