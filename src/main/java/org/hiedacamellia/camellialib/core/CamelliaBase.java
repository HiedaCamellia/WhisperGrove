package org.hiedacamellia.camellialib.core;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.loading.FMLEnvironment;

public abstract class CamelliaBase {
    public static IEventBus modEventBus ;
    public static ModContainer modContainer;


    public CamelliaBase(IEventBus Bus, ModContainer Container) {
        modEventBus = Bus;
        modContainer = Container;
        if(FMLEnvironment.dist.isClient()) {
            objectsClientOnly();
            eventObjectsClientOnly();
        } else {
            objects();
            eventObjects();
            xData();
            compats();
        }
    }

    /**
     * 原版各项必须只在客户端的实例
     */
    public abstract void objectsClientOnly();

    /**
     * 原版各项实例
     */
    public abstract void objects();

    /**
     * 基于forge事件的必须只在客户端的实例
     */
    public abstract void eventObjectsClientOnly();

    /**
     * 基于forge事件的实例
     */
    public abstract void eventObjects();

    /**
     * 外部数据
     */
    public abstract void xData();

    /**
     * 联动实例
     */
    public abstract void compats();
}
