package com.laelioa.cbmod;

import com.laelioa.cbmod.init.CbObject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * <h2>Class CbTabs</h2>
 * <p>该类仅有一个有参构造，接受一个 String 类型的 Label。</p>
 * <p>该Label用于确定物品栏</p>
 * @author RMSCA
 * */
public class CbTab extends CreativeTabs {
    private final String LABEL;

    public CbTab(String label) {
        super(label);
        LABEL = label;
    }

    /**
     * <h2>getTabIconItem</h2>
     * <p>用于获取创造模式物品栏图标（通过获取物品，将该物品作为物品栏的图标）</p>
     * <p>该函数 Override {@link CreativeTabs#getTabIconItem()}</p>
     * <p></p>
     * <h3>
     * <a href="https://teamcovertdragon.github.io/Harbinger/63/chapter-04/item-stack.html"> "ItemStack" 文档 </a>
     * 其简述：</h3>
     * <p>原型：protected ItemStack(@NotNull {@link net.minecraft.block.Block} type, int amount, int meta)</p>
     * <p>说明：一个 ItemStack 的实例代表了“一堆特定物品",ItemStack 还有携带一个 NBT 标签的能力，
     * 这允许 ItemStack 携带更多的自定义数据。</p>
     * <p>参数：{@link net.minecraft.block.Block} type: 物品种类 | int amount: 堆叠数量 | int meta: 方块的meta</p>
     * @author RMSCA
     * */
    @Nonnull
    @Override
    public ItemStack getTabIconItem() {
        switch (LABEL) {
            case "road":
                return new ItemStack(CbObject.BLOCK_ASPHALT, 1, 4);
            case "inc":
                return new ItemStack(CbObject.BLOCK_INC_CARPET, 1, 0);
            default:
                return new ItemStack(Items.AIR);

        }
    }
}
