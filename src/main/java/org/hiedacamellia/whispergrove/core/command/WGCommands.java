package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.viscera.Viscera;

@SuppressWarnings("unchecked")
public class WGCommands {

    private static final String GET_SUCCESS = "cmd.whispergrove.get.success";
    private static final String SET_SUCCESS = "cmd.whispergrove.set.success";
    private static final String RESET_SUCCESS = "cmd.whispergrove.reset.success";
    private static final String GET_FAILED = "cmd.whispergrove.get.failed";
    private static final String SET_FAILED = "cmd.whispergrove.set.failed";
    private static final String RESET_FAILED = "cmd.whispergrove.reset.failed";

    public WGCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext buildContext) {
        dispatcher.register(LiteralArgumentBuilder.<CommandSourceStack>literal(WhisperGrove.MODID)
                .then(Commands.argument("player", EntityArgument.player())
                        .then(Commands.argument("viscera", StringArgumentType.word())
                                .then(Commands.literal("get").executes(context -> {
                                    Player player = EntityArgument.getPlayer(context, "player");
                                    String viscera = StringArgumentType.getString(context, "viscera");
                                    ResourceLocation key = WhisperGrove.prefix(viscera);
                                    AttachmentType<?> type = NeoForgeRegistries.ATTACHMENT_TYPES.get(key);
                                    AttachmentType<Viscera> visceraType = (AttachmentType<Viscera>) type;
                                    if (visceraType != null) {
                                        Viscera data = player.getData(visceraType);
                                        sendSuccess(player, GET_SUCCESS, data);
                                    } else {
                                        sendFail(player, GET_FAILED, viscera);
                                    }
                                    
                                    return 0;
                                }))
                                .then(Commands.literal("set").then(Commands.argument("yin_yang", StringArgumentType.word())
                                        .then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            String yinYang = StringArgumentType.getString(context, "yin_yang");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            String viscera = StringArgumentType.getString(context, "viscera");
                                            ResourceLocation key = WhisperGrove.prefix(viscera);
                                            AttachmentType<?> type = NeoForgeRegistries.ATTACHMENT_TYPES.get(key);
                                            AttachmentType<Viscera> visceraType = (AttachmentType<Viscera>) type;
                                            if (visceraType != null) {
                                                Viscera data = player.getData(visceraType);
                                                if (yinYang.equals("yin")) {
                                                    player.setData(visceraType, new Viscera(key, value, data.yang(), data.ping()));
                                                    sendSuccess(player, SET_SUCCESS, data);
                                                } else if (yinYang.equals("yang")) {
                                                    player.setData(visceraType, new Viscera(key, data.yin(), value, data.ping()));
                                                    sendSuccess(player, SET_SUCCESS, data);
                                                } else {
                                                    sendFail(player, SET_FAILED, yinYang);
                                                }
                                            } else {
                                                sendFail(player, SET_FAILED, viscera);
                                            }

                                            return 0;
                                        }))))
                                .then(Commands.literal("reset").executes(context -> {
                                    Player player = EntityArgument.getPlayer(context, "player");
                                    String viscera = StringArgumentType.getString(context, "viscera");
                                    ResourceLocation key = WhisperGrove.prefix(viscera);
                                    AttachmentType<?> type = NeoForgeRegistries.ATTACHMENT_TYPES.get(key);
                                    AttachmentType<Viscera> visceraType = (AttachmentType<Viscera>) type;
                                    if (visceraType != null) {
                                        player.setData(visceraType, new Viscera(key, 1000.0D, 1000.0D, 0.0D));
                                        sendSuccess(player, RESET_SUCCESS);
                                    } else {
                                        sendFail(player, RESET_FAILED);
                                    }

                                    return 0;
                                })))).executes(ctx -> 0));
    }

    private static void sendSuccess(Player player, String key, Object... args) {
        MutableComponent component = Component.translatable(key, args);
        player.sendSystemMessage(component.withStyle(ChatFormatting.GREEN));
    }

    private static void sendFail(Player player, String key, Object... args) {
        MutableComponent component = Component.translatable(key, args);
        player.sendSystemMessage(component.withStyle(ChatFormatting.RED));
    }

}