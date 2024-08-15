package org.hiedacamellia.whispergrove.core.network;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.hiedacamellia.whispergrove.core.codec.record.*;

public class WGPayload {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                Heart.TYPE,
                Heart.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        Heart::handleData,
                        Heart::handleData
                )
        );
        registrar.playBidirectional(
                Kidney.TYPE,
                Kidney.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        Kidney::handleData,
                        Kidney::handleData
                )
        );
        registrar.playBidirectional(
                Liver.TYPE,
                Liver.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        Liver::handleData,
                        Liver::handleData
                )
        );
        registrar.playBidirectional(
                Lung.TYPE,
                Lung.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        Lung::handleData,
                        Lung::handleData
                )
        );
        registrar.playBidirectional(
                Spleen.TYPE,
                Spleen.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        Spleen::handleData,
                        Spleen::handleData
                )
        );
        registrar.playBidirectional(
                NameMap.TYPE,
                NameMap.STREAM_CODEC,
                new DirectionalPayloadHandler<>(
                        NameMap::handleData,
                        NameMap::handleData
                )
        );
    }
}
