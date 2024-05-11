package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.init.CbBlocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>ItemBlockCeramic</h2>
 * 陶瓷
 * @author RMSCA
 * */
public class ItemBlockCeramic extends ItemBlock {
    public ItemBlockCeramic() {
        super(CbBlocks.INC_CERAMIC);
        setRegistryName(Reference.MODID, "inc_ceramic");
        setHasSubtypes(true);
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
