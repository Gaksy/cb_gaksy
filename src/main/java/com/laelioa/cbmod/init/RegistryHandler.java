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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * <h2>addBlock({@link String} block_name, {@link net.minecraft.block.Block} dec_block)</h2>
     *
     * <p>{@link String} block_name: 方块ID</p>
     * <p>{@link net.minecraft.block.Block} dec_block: 要添加的方块</p>
     *
     * <p>描述：添加方块到注册列表，该列表具有去重功能，防止重复注册</p>
     *
     * @author gaksy
     * */
    public static void addBlock(String block_name, Block dec_block){
        if(!BLOCKS.containsKey(block_name)){
            BLOCKS.put(block_name, dec_block);
        }
    }

    /**
     * <h2>addItem({@link String} item_name, {@link net.minecraft.item.Item} dec_item)</h2>
     *
     * <p>{@link String} item_name: 物品ID</p>
     * <p>{@link net.minecraft.block.Block} dec_item: 要添加的物品</p>
     *
     * <p>描述：添加物品到注册列表，该列表具有去重功能，防止重复注册</p>
     *
     * @author gaksy
     * */
    public static void addItem(String item_name, Item dec_item){
        if (!ITEMS.containsKey(item_name)) {
            ITEMS.put(item_name, dec_item);
        }
    }

    /**
     * <h2>getBlocks()</h2>
     *
     * <p>return {@link List<net.minecraft.block.Block>}: 返回当前方块注册列表</p>
     *
     * @author gaksy
     * */
    public static List<Block> getBlocks(){
        List<Block> block_list = new ArrayList<>();
        for (String block_name : BLOCKS.keySet()){
            block_list.add(BLOCKS.get(block_name));
        }
        return block_list;
    }

    /**
     * <h2>getItems()</h2>
     *
     * <p>return {@link List<net.minecraft.item.Item>}: 返回当前物品注册列表</p>
     *
     * @author gaksy
     * */
    public static List<Item> getItems(){
        List<Item> item_list = new ArrayList<>();
        for (String item_name : ITEMS.keySet()){
            item_list.add(ITEMS.get(item_name));
        }
        return item_list;
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        CbObjects.registerBlocks(event.getRegistry());                           //额外的需要注册的方块
        event.getRegistry().registerAll(getBlocks().toArray(new Block[0]));     //注册所有在列表里的方块
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        CbObjects.registerItemBlocks(event.getRegistry());                       //额外的需要注册的物品
        event.getRegistry().registerAll(getItems().toArray(new Item[0]));       //注册所有在列表里的物品
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ComfortBox.proxy.registerBlockModels();
    }
}
