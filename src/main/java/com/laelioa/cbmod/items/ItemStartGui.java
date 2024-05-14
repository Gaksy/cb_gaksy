package com.laelioa.cbmod.items;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.init.RegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemStartGui extends Item {
    public ItemStartGui(){
        super();
        setUnlocalizedName("cbmod_start_gui");
        setRegistryName("cbmod_start_gui_");
        RegistryHandler.addItem("cbmod_start_gui_", this);
        setCreativeTab(ComfortBox.incTab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {


                BlockPos pos = playerIn.getPosition();
                int id = 1;
                playerIn.openGui(ComfortBox.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());


        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
