package org.hiedacamellia.camellialib.core.entry.common;

import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import org.hiedacamellia.camellialib.CamelliaLib;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataPackRegistry {
    private final List<PreparableReloadListener> dataPacks;

    public BaseDataPackRegistry() {
        this.dataPacks = new ArrayList<>();
    }

    /**
     * 使用add来添加数据包
     */
    public abstract void addRegistry();

    public void add(PreparableReloadListener data) {
        dataPacks.add(data);
    }

    @SubscribeEvent
    public void onAddReloadListener(AddReloadListenerEvent event) {
        for (var data : dataPacks) {
            event.addListener(data);
        }
    }

    public void register() {
        addRegistry();
        CamelliaLib.modEventBus.register(this);
    }
}
