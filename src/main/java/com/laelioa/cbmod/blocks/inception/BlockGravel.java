package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyBool;
import com.laelioa.cbmod.proxy.ClientProxy;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;

import javax.annotation.Nonnull;

public class BlockGravel extends BlockPropertyBool {

    private static final PropertyBool BROKEN = PropertyBool.create("broken");
    public BlockGravel(){
        super("inc_gravel", ComfortBox.incTab, "inception/gravel/inc_gravel_", BROKEN);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, BROKEN);
    }

    @Override
    public void registerModel() {
        ((ClientProxy) ComfortBox.proxy).register(this.getResourcePath() + "default", this, 0);
        ((ClientProxy) ComfortBox.proxy).register(this.getResourcePath() + "broken", this, 1);
    }
}
