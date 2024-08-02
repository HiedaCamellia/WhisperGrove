package org.hiedacamellia.whispergrove;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.hiedacamellia.camellialib.core.CamelliaBase;
import org.hiedacamellia.camellialib.core.static_utor.Translator;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGItem;
import org.hiedacamellia.whispergrove.registers.WGTab;


@Mod(WhisperGrove.MODID)
public class WhisperGrove extends CamelliaBase {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "whispergrove";
    //public static final ObjectRegistry REGISTRY = ObjectRegistry.create(MODID);
    //public static final Debug DEBUG = Debug.create("[§4山茶花§f] ", CamelliaConfig.deBug);
    public static final Translator TRANSLATOR = Translator.create(MODID);

    public WhisperGrove(IEventBus Bus, ModContainer Container) {
        super(Bus, Container);
        WGBlock.BLOCKS.register(Bus);
        WGItem.ITEMS.register(Bus);
        WGTab.TABS.register(Bus);
        //NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
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
