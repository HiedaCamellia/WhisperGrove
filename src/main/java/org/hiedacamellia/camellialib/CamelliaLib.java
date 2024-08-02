package org.hiedacamellia.camellialib;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.hiedacamellia.camellialib.config.CamelliaConfig;
import org.hiedacamellia.camellialib.core.CamelliaBase;
import org.hiedacamellia.camellialib.core.entry.ObjectRegistry;
import org.hiedacamellia.camellialib.core.static_utor.Debug;
import org.hiedacamellia.camellialib.core.static_utor.Translator;

@Mod(CamelliaLib.MODID)
public class CamelliaLib extends CamelliaBase {
    public static final String MODID = "camellialib";
    //public static final ObjectRegistry REGISTRY = ObjectRegistry.create(MODID);
    public static final Debug DEBUG = Debug.create("[§4山茶花§f] ", CamelliaConfig.deBug);
    public static final Translator TRANSLATOR = Translator.create(MODID);

    public CamelliaLib(IEventBus modEventBus, ModContainer modContainer) {
        super(modEventBus, modContainer);
        modContainer.registerConfig(ModConfig.Type.COMMON, CamelliaConfig.SPEC);
    }

    @Override
    public void objectsClientOnly() {

    }

    @Override
    public void objects() {

    }

    @Override
    public void eventObjectsClientOnly() {

    }

    @Override
    public void eventObjects() {

    }

    @Override
    public void xData() {

    }

    @Override
    public void compats() {

    }
}
