package com.laelioa.cbmod.init;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryHandler {
    public static final List<Block> BLOCKS = new ArrayList<>();

    /**
     * Forge 引入了一个注册表系统以接管原版的注册表系统。Forge 的系统与原版的系统相比多了 ID 自动分配、映射存储、映射重定义等好用的功能。其
     * 中映射存储更是使得跨整合的存档分享成为了可能。
     * <br>
     * 泛型事件的使用决定了你需要对每一种对象的注册都写一个订阅。你不能向方块的注册表里注册物品，反之亦然。
     * <br>
     * <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-06/">Harbinger</a>
     * <a href="https://mcforge-ko.readthedocs.io/zh/latest/concepts/registries/#_2">Forge docs 中文版 </a>
     * <a href="https://docs.minecraftforge.net/en/1.12.x/concepts/registries/#registering-things">Forge docs 英文版</a>
     * */
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        CbBlocks.registerBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        CbBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ComfortBox.proxy.registerBlockModels();
    }
}
