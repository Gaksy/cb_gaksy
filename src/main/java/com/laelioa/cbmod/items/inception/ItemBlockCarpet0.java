package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbObject;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockCarpet0</h2>
 * 地毯 方块状态上限16种，这是第17种
 * @author RMSCA
 * */
public class ItemBlockCarpet0 extends ItemBlockBase {
    public ItemBlockCarpet0() {
        super(CbObject.BLOCK_INC_CARPET_0, true);
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
