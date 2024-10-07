package org.hiedacamellia.whispergrove.core.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.core.network.PlayerMenuC2SPacket;
import org.hiedacamellia.whispergrove.core.network.PlayerMenuS2SPacket;
import org.hiedacamellia.whispergrove.core.network.PlayerVisceraS2CPacket;

@EventBusSubscriber(modid = WhisperGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class WGModBusEvent {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(PlayerVisceraS2CPacket.TYPE,
                PlayerVisceraS2CPacket.STREAM_CODEC,
                PlayerVisceraS2CPacket::handleData);
        registrar.playToServer(PlayerMenuC2SPacket.TYPE,
                PlayerMenuC2SPacket.STREAM_CODEC,
                PlayerMenuC2SPacket::handleData
        );
        registrar.playToClient(PlayerMenuS2SPacket.TYPE,
                PlayerMenuS2SPacket.STREAM_CODEC,
                PlayerMenuS2SPacket::handleData
        );
    }

}