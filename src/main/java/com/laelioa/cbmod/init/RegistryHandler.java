package com.laelioa.cbmod.init;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <h2>Class Registrant</h2>
 * <p>BlockBase会自动调用该类，该类负责注册每一种方块</p>
 * <p>注意，只有当方块在 <code>CbObject</code> 中初始化一遍， <code>BlockBase</code> 才会自动将方块添加到本类的待注册列表中</p>
 *
 * <p>相关文档：</p>
 * <p>
 *     [Harbiger] 注册表 Docs |
 *     <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-06/">zh-cn</a>
 * </p>
 * <p>
 *     [FORGE docs] Registering Things |
 *     <a href="https://docs.minecraftforge.net/en/1.12.x/concepts/registries/#registering-things">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/concepts/registries/#_2">zh-cn</a>
 * </p>
 *
 * <p>文档简述：<br>Forge 引入了一个注册表系统以接管原版的注册表系统。Forge 的系统与原版的系统相比多了 ID 自动分配、映射存储、映射重定义等好用的
 * 功能。其中映射存储更是使得跨整合的存档分享成为了可能。泛型事件的使用决定了你需要对每一种对象的注册都写一个订阅。你不能向方块的注册表里注册物品，反之
 * 亦然。</p>
 *
 * @author gaksy
 * */
@Mod.EventBusSubscriber(modid = Reference.MODID)
public class RegistryHandler {
    private static final Map<String, Block> BLOCKS = new HashMap<>();
    private static final Map<String, Item> ITEMS = new HashMap<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        CbBlocks.registerBlocks(event.getRegistry());     //额外的需要注册的方块
        event.getRegistry().registerAll(getBlocks());     //注册所有在列表里的方块
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        CbBlocks.registerItemBlocks(event.getRegistry());  //额外的需要注册的物品
        event.getRegistry().registerAll(getItems());       //注册所有在列表里的物品
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ComfortBox.proxy.registerBlockModels();
    }

    /**
     * 添加方块到注册列表，该列表具有去重功能，防止重复注册
     * @param block 方块
     *
     * @author gaksy
     * */
    public static void addBlock(Block block) {
        if(!BLOCKS.containsKey(Objects.requireNonNull(block.getRegistryName()).toString())) {
            BLOCKS.put(Objects.requireNonNull(block.getRegistryName()).toString(), block);
        }
    }

    /**
     * 添加物品到注册列表，该列表具有去重功能，防止重复注册
     * @param item 物品
     * @author gaksy
     * */
    public static void addItem(Item item) {
        if (!ITEMS.containsKey(Objects.requireNonNull(item.getRegistryName()).toString())) {
            ITEMS.put(Objects.requireNonNull(item.getRegistryName()).toString(), item);
        }
    }

    /**
     * @return 返回当前方块注册列表
     * @author gaksy
     * */
    public static Block[] getBlocks() {
        Block[] blockArray = new Block[BLOCKS.size()];
        int index = 0;
        for (String name : BLOCKS.keySet()) {
            blockArray[index] = BLOCKS.get(name);
            ++index;
        }
        return blockArray;
    }

    /**
     * @return 返回当前物品注册列表
     * @author gaksy
     * */
    public static Item[] getItems() {
        Item[] itemArray = new Item[ITEMS.size()];
        int index = 0;
        for (String name : ITEMS.keySet()) {
            itemArray[index] = ITEMS.get(name);
            ++index;
        }
        return itemArray;
    }
}
