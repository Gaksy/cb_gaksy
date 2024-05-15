package com.laelioa.cbmod.init;

import com.laelioa.cbmod.proxy.ClientProxy;

/**
 * <h2>Interface IhasModel</h2>
 * BlockBase继承该接口，并提供默认注册模型方法。子基类可以对其经常重载，进行定制化处理。使用时只需调用方块的registryModel函数，并传递对应的
 * path即可。该方法仅在ClientProxy中被调用，所以可以通过ComfortBox进行强转。
 * 请勿在别处调用该函数，以免在错误的端侧执行该代码。
 * */
public interface IhasModel {
    /**
     * <h2>getIntPropertyMax</h2>
     * 如果处理的对象是PropertyInteger对象，可以获取该方块的最大值。然后从0开始遍历。
     * 注意其区间是[0,MAX]
     * @return 方块状态的最大值
     * */
    public void registryModel(String path);
}
