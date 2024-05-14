package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyInteger;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;

import javax.annotation.Nonnull;

public class BlockFloor extends BlockPropertyInteger {
    private final static PropertyInteger TYPE = PropertyInteger.create("type", 0, 1);

    public BlockFloor() {
        super("inc_floor", ComfortBox.incTab, TYPE, 1);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }
}
