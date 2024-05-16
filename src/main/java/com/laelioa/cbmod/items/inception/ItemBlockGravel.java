package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockGravel extends ItemBlockBase {
    public ItemBlockGravel() {
        super(CbBlocks.INC_GRAVEL, true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getMetadata() == 1 ? "broken" : "default");
    }
}
