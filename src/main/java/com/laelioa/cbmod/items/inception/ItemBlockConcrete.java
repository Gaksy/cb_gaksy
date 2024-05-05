package com.laelioa.cbmod.items.inception;

import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.blocks.inception.BlockConcrete;
import com.laelioa.cbmod.init.CbBlocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemBlockConcrete extends ItemBlock {
    public ItemBlockConcrete() {
        super(CbBlocks.INC_CONCRETE);
        setRegistryName(Reference.MODID, "inc_concrete");
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." +
                BlockConcrete.ConcreteType.byMetadata(stack.getMetadata()).getName();
    }
}
