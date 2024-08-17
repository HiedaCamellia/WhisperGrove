package org.hiedacamellia.whispergrove.core.codec.button;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.hiedacamellia.whispergrove.WhisperGrove;

public record SpringingButton(int buttonID, BlockPos pos) implements CustomPacketPayload {
    public static final Type<SpringingButton> TYPE = new Type<>( ResourceLocation.fromNamespaceAndPath(WhisperGrove.MODID, "springing_button"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SpringingButton> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            SpringingButton::buttonID,
            BlockPos.STREAM_CODEC,
            SpringingButton::pos,
            SpringingButton::new
    );

    @Override
    public Type<SpringingButton> type() {
        return TYPE;
    }

    public static void handleData(final SpringingButton message, final IPayloadContext context) {
        if (context.flow() == PacketFlow.SERVERBOUND) {
            context.enqueueWork(() -> {
                Player entity = context.player();
                int buttonID = message.buttonID;
                handleButtonAction(entity, buttonID, message.pos);
            }).exceptionally(e -> {
                context.connection().disconnect(Component.literal(e.getMessage()));
                return null;
            });
        }
    }

    public static void handleButtonAction(Player entity, int buttonID, BlockPos pos) {
        
    }
}
