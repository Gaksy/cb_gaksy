package com.laelioa.cbmod.items;

import com.laelioa.cbmod.blocks.BlockAsphalt;
import com.laelioa.cbmod.init.CbObjects;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockAsphalt</h2>
 * 沥青
 * @author RMSCA
 * */
public class ItemBlockAsphalt extends ItemBlockBase {
    public ItemBlockAsphalt() {
        super(CbObjects.BLOCK_ASPHALT, true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + BlockAsphalt.AsphaltType.byMetadata(stack.getMetadata()).getName();
    }
}
