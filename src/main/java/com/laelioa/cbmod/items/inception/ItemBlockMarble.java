package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.blocks.inception.BlockMarble;
import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.items.ItemBlockBase;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockMarble</h2>
 * 大理石
 * @author RMSCA
 * */
public class ItemBlockMarble extends ItemBlockBase {
    public ItemBlockMarble() {
        super(CbBlocks.INC_MARBLE, true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + BlockMarble.MarbleType.byMetadata(stack.getMetadata()).getName();
    }
}
