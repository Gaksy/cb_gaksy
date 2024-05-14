package com.laelioa.cbmod.proxy;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.gui.GUIHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public abstract class CommonProxy {
    public void preInit() {}

    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(ComfortBox.instance, new GUIHandler());
    }

    public void postInit() {}

    abstract public void registerBlockModels();
}
