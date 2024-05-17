package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyBool;
import com.laelioa.cbmod.proxy.ClientProxy;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;

import javax.annotation.Nonnull;

public class BlockOak extends BlockPropertyBool {
    private static final PropertyBool SMOOTH = PropertyBool.create("smooth");

    public BlockOak(){
        super("inc_oak", ComfortBox.incTab, "inception/oak/inc_oak_", SMOOTH);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, SMOOTH);
    }

    @Override
    public void registerModel() {
        ((ClientProxy) ComfortBox.proxy).register(this.getResourcePath() + "default", this, 0);
        ((ClientProxy) ComfortBox.proxy).register(this.getResourcePath() + "smooth", this, 1);
    }
}
