package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.blocks.inception.BlockMarble;
import com.laelioa.cbmod.init.CbObjects;
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
        super(CbObjects.BLOCK_INC_MARBLE, true);
    }
}
