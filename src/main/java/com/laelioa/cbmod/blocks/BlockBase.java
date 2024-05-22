package com.laelioa.cbmod.blocks;

import com.laelioa.cbmod.ComfortBox;
import com.laelioa.cbmod.Reference;
import com.laelioa.cbmod.init.CbBlocks;
import com.laelioa.cbmod.init.RegistryHandler;
import com.laelioa.cbmod.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;


/**
 * <h2>Class BlockBase</h2>
 * <p>所有方块都应该继承此类，该类会自动将方块添加到指定的物品栏并注册，且自动设置本地化键名</p>
 * <p>相关文档：</p>
 * <p>
 *     {@link net.minecraft.block.material.Material}：
 *     [juanmuscaria] Material Docs |
 *     <a href="https://github.juanmuscaria.com/DocsMC/net/minecraft/block/material/Material.html">en-us</a>
 * </p>
 * <p>
 *     {@link net.minecraft.block.Block#setUnlocalizedName}：
 *     [FORGE docs] Internationalization and Localization |
 *     <a href="https://docs.minecraftforge.net/en/latest/concepts/internationalization/">en-us</a>
 *     <a href="https://mcforge-ko.readthedocs.io/zh/latest/concepts/internationalization/">zh-cn</a>
 * </p>
 * @author gaksy
 * */
public class BlockBase extends Block implements IHasModel {
    public static String CURRENT_BLOCK = "";
    private final String RESOURCE_PATH;
    private String varName;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.FIELD})
    public @interface NonFull { }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.FIELD})
    public @interface Transparent { }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(value = {ElementType.FIELD})
    public @interface UnableBreathe { }

    /**
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param material 指定的物品材质
     * @param resourcePath 资源文件地址
     *
     * @author gaksy
     * */
    public BlockBase(String name, CreativeTabs tab, Material material, String resourcePath) {
        super(material);
        init(name, tab);
        RESOURCE_PATH = resourcePath;
    }

    /**
     * <p>描述：Material默认为ROCK</p>
     * @param name 指定的方块名称
     * @param tab 指定的创造物品栏
     * @param resourcePath 资源文件路径
     * @author gaksy
     * */
    public BlockBase(String name, CreativeTabs tab, String resourcePath) {
        this(name, tab, Material.ROCK, resourcePath);
    }

    public String getResourcePath() {
        return RESOURCE_PATH;
    }

    /**
     * <p>描述：标准Inception物品的初始化流程</p>
     * @param name 指定方块的名称
     * @param tab 指定的创造物品栏
     * @author gaksy
     * */
    private void init(String name, CreativeTabs tab) {
        setRegistryName(Reference.MODID, name);          //设置其注册名称 示例：cbmod:block_name
        setUnlocalizedName(name + "_unlocalized");       //设置本地化键名 示例：block_name_unlocalized
        setCreativeTab(tab);                             //设置方块所在的创造模式物品栏
        RegistryHandler.addBlock(this);                  //将自身添加到注册列表
    }

    /**
     * <h2>registryModel(String path)</h2>
     * 详情参考Interface {@link IHasModel}，注意该接口仅被ClientProxy调用。
     * @author gaksy
     * */
    @Override
    public void registerModel() {
        ((ClientProxy)ComfortBox.proxy).register(RESOURCE_PATH, this, 0);
    }

    public void SetVarName(String varName){
        this.varName = varName;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        if(hasAnnotation(NonFull.class)){
            return false;
        }
        return true;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        if(hasAnnotation(Transparent.class)) {
            return BlockRenderLayer.CUTOUT;
        }
        return super.getBlockLayer();
    }

    @Nullable
    @Override
    public Boolean isEntityInsideMaterial(IBlockAccess world, BlockPos blockpos, IBlockState iblockstate, Entity entity, double yToTest, Material materialIn, boolean testingHead) {
        if(hasAnnotation(UnableBreathe.class)){
            return true;
        }
        return super.isEntityInsideMaterial(world, blockpos, iblockstate, entity, yToTest, materialIn, testingHead);
    }

    private<T extends java.lang.annotation.Annotation> boolean hasAnnotation(Class<T> a){
        Class<?> clazz = CbBlocks.class;
        Field[] fields = clazz.getDeclaredFields();

        for (Field field:fields){
            String checkName = CURRENT_BLOCK;
            if(varName != null){
                checkName = varName;
            }
            if(field.getName().equals(checkName)) {
                T annotation = field.getAnnotation(a);
                if (annotation != null) {
                    return true;
                }
            }
        }
        return false;
    }
}
