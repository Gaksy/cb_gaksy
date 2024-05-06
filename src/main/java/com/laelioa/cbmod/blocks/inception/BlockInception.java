package com.laelioa.cbmod.blocks.inception;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.init.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInception extends Block {
    public BlockInception(String name) {
        super(Material.ROCK);
        setRegistryName(Reference.MODID, name);
        setUnlocalizedName(name + "_unlocalized");
        setCreativeTab(ComfortBox.incTab);
        RegistryHandler.BLOCKS.add(this);
    }
}
