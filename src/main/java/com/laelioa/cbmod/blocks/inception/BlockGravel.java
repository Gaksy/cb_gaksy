package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyEnum;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockGravel extends BlockPropertyEnum<BlockGravel.GravelType> {

    private static final PropertyEnum<GravelType> TYPE = PropertyEnum.create("type", BlockGravel.GravelType.class);
    public BlockGravel(){
        super("inc_gravel", ComfortBox.incTab, TYPE, "inception/gravel/inc_gravel_");
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    public enum GravelType implements IStringSerializable {
        DEFAULT, BROKEN;

        public static GravelType byMetadata(int meta) {
            if (meta < 0 || meta >= values().length) {
                meta = 0;
            }
            return values()[meta];
        }

        @Nonnull
        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }
}
