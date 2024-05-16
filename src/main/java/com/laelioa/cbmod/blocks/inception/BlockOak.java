package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyEnum;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

public class BlockOak extends BlockPropertyEnum<BlockOak.OakType> {
    private static final PropertyEnum<OakType> TYPE = PropertyEnum.create("type", BlockOak.OakType.class);
    public BlockOak(){
        super("inc_oak", ComfortBox.incTab, TYPE, "inception/oak/inc_oak_");
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    public enum OakType implements IStringSerializable {
        DEFAULT, SMOOTH;

        public static OakType byMetadata(int meta) {
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
