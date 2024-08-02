package org.hiedacamellia.camellialib.core.entry.common;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommonEventRegistry {
    private final List<Object> commonEvents;

    public BaseCommonEventRegistry() {
        this.commonEvents = new ArrayList<>();
    }

    /**
     * 用add()添加事件类型
     */
    public abstract void addRegistry();

    public void add(Object object) {
        commonEvents.add(object);
    }

    /**
     * 注册到总线
     */
    public void register() {
        addRegistry();
        CamelliaLib.modEventBus.addListener(this::onFMLCommonSetupEvent);
    }

    @SubscribeEvent
    public void onFMLCommonSetupEvent(final FMLCommonSetupEvent event) {
        for (Object e : commonEvents) {
            CamelliaLib.modEventBus.register(e);
        }
    }

}
