package com.laelioa.cbmod;

import com.laelioa.cbmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * <h2>参考文档</h2>
 * <p><a href="https://blog.csdn.net/GAA775/article/details/118220023">[csdn] Minecragt 1.12.2 Mod Forge 开发帮助文档</a></p>
 * <p><a href="https://blog.csdn.net/GAA775/article/details/118247904">[csdn] Minecraft Forge API 类帮助文档(1.12.2)</a></p>
 * <p><a href="https://blog.csdn.net/GAA775/article/details/118273939">[csdn] Minecraft Forge API 注解帮助文档(1.12.2)</a></p>
 * <p><a href="https://mcforge-ko.readthedocs.io/zh/latest/">Forge docs (1.12.x) 中文版</a></p>
 * <p><a href="https://docs.minecraftforge.net/en/1.12.x/">Forge docs (1.12.x)</a></p>
 * <p><a href="https://teamcovertdragon.github.io/Harbinger/63/">Harbinger</a></p>
 * */

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class ComfortBox {
    /**
     * <h2>根据物理端类型实例化其中一个对应的类</h2>
     * <p>参考文档：</p>
     * <p>"sides in Minecraft" 文档
     * <a href="https://docs.minecraftforge.net/en/latest/concepts/sides/">| en-us |</a>
     * <a href="https://mcforge-cn.readthedocs.io/zh/latest/concepts/sides/">| zh-cn |</a>
     * </p>
     * <p>其它说明：</p>
     * <p>{@link CommonProxy} proxy 会自动选用当前运行的物理客户端类型。</p>
     */
    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy proxy;

    public static CreativeTabs roadTab = new CbTab("road");
    public static CreativeTabs incTab = new CbTab("inc");
    public static CreativeTabs plankTab = new CbTab("plank");


    /**
     * <h2>处理Mod加载的三个阶段：预初始化、初始化和后初始化</h2>
     * <p>参考文档：</p>
     * <p>"Loading Stages" 文档
     * <a href="https://mcforge-ko.readthedocs.io/zh/latest/conventions/loadstages/">| en-us |</a>
     * <a href="https://docs.minecraftforge.net/en/1.12.x/conventions/loadstages/">| zh-cn |</a>
     * </p>
     * <p><a href="https://blog.csdn.net/GAA775/article/details/118273939#EventHandler__23">"@EventHandler" 文档</a></p>
     * */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) { proxy.preInit(); }

    @EventHandler
    public void init(FMLInitializationEvent event) { proxy.init(); }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) { proxy.postInit(); }
}
