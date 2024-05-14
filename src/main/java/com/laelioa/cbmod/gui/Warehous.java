package com.laelioa.cbmod.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class Warehous extends Container {
    public Warehous(EntityPlayer playerIn){
        super();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }


}
