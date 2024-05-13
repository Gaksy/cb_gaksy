package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.blocks.BlockPropertyEnum;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;

/**
 * <h2>Class BlockMarble</h2>
 * <p>大理石，Inception Tab</p>
 *
 * <p>相关文档：</p>
 * <p>
 *     {@link net.minecraft.block.Block}：
 *     [juanmuscaria] Material Docs |
 *     <a href="https://github.juanmuscaria.com/DocsMC/net/minecraft/block/Block.html">en-us</a>
 * </p>
 *
 * @author RMSCA
 * */
public class BlockMarble extends BlockPropertyEnum<BlockMarble.MarbleType> {
    private static final PropertyEnum<MarbleType> TYPE = PropertyEnum.create("type", MarbleType.class);

    public BlockMarble() {
        super("inc_marble", ComfortBox.incTab, TYPE);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    /**
     * <h2>大理石方块的状态</h2>
     * */
    public enum MarbleType implements IStringSerializable {
        DEFAULT, WHITE, BLACK, BLUE, GRAY,
        ROUGH_BLACK, DARK_GRAY, RANDOM;

        public static MarbleType byMetadata(int meta) {
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
