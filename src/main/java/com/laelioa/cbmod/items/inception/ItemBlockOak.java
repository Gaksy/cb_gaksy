package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockOak extends ItemBlockBase {
    public ItemBlockOak() {
        super(CbBlocks.INC_OAK, true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + (stack.getMetadata() == 1 ? "smooth" : "default");
    }
}
