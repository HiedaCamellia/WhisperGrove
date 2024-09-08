package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class WGCmd {

    private static final String GET_SUCCESS = "cmd.whispergrove.get.success";
    private static final String SET_SUCCESS = "cmd.whispergrove.set.success";
    private static final String RESET_SUCCESS = "cmd.whispergrove.reset.success";
    private static final String GET_FAILED = "cmd.whispergrove.get.failed";
    private static final String SET_FAILED = "cmd.whispergrove.set.failed";
    private static final String RESET_FAILED = "cmd.whispergrove.reset.failed";

    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.argument("player", EntityArgument.player())
                        .then(Commands.literal("get")
                                .then(Commands.literal("heart")
                                        .then(Commands.literal("yin").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Heart viscera = player.getData(WGAttachment.HEART);
                                            sendSuccess(player, GET_SUCCESS,viscera.yin());
                                            return 0;
                                        }))
                                        .then(Commands.literal("yang").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Heart viscera = player.getData(WGAttachment.HEART);
                                            sendSuccess(player, GET_SUCCESS,viscera.yang());
                                            return 0;
                                        }))
                                )
                                .then(Commands.literal("liver")
                                        .then(Commands.literal("yin").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Liver viscera = player.getData(WGAttachment.LIVER);
                                            sendSuccess(player, GET_SUCCESS,viscera.yin());
                                            return 0;
                                        }))
                                        .then(Commands.literal("yang").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Liver viscera = player.getData(WGAttachment.LIVER);
                                            sendSuccess(player, GET_SUCCESS,viscera.yang());
                                            return 0;
                                        }))
                                )
                                .then(Commands.literal("spleen")
                                        .then(Commands.literal("yin").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Spleen viscera = player.getData(WGAttachment.SPLEEN);
                                            sendSuccess(player, GET_SUCCESS,viscera.yin());
                                            return 0;
                                        }))
                                        .then(Commands.literal("yang").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Spleen viscera = player.getData(WGAttachment.SPLEEN);
                                            sendSuccess(player, GET_SUCCESS,viscera.yang());
                                            return 0;
                                        }))
                                )
                                .then(Commands.literal("lung")
                                        .then(Commands.literal("yin").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Lung viscera = player.getData(WGAttachment.LUNG);
                                            sendSuccess(player, GET_SUCCESS,viscera.yin());
                                            return 0;
                                        }))
                                        .then(Commands.literal("yang").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Lung viscera = player.getData(WGAttachment.LUNG);
                                            sendSuccess(player, GET_SUCCESS,viscera.yang());
                                            return 0;
                                        }))
                                )
                                .then(Commands.literal("kidney")
                                        .then(Commands.literal("yin").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Kidney viscera = player.getData(WGAttachment.KIDNEY);
                                            sendSuccess(player, GET_SUCCESS,viscera.yin());
                                            return 0;
                                        }))
                                        .then(Commands.literal("yang").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            Kidney viscera = player.getData(WGAttachment.KIDNEY);
                                            sendSuccess(player, GET_SUCCESS,viscera.yang());
                                            return 0;
                                        }))
                                )
                        )
                        .then(Commands.literal("set")
                                .then(Commands.literal("heart")
                                        .then(Commands.literal("yin").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Heart viscera = player.getData(WGAttachment.HEART);
                                            player.setData(WGAttachment.HEART, new Heart(value, viscera.yang(), viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                        .then(Commands.literal("yang").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Heart viscera = player.getData(WGAttachment.HEART);
                                            player.setData(WGAttachment.HEART, new Heart(viscera.yin(), value, viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                )
                                .then(Commands.literal("liver")
                                        .then(Commands.literal("yin").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Liver viscera = player.getData(WGAttachment.LIVER);
                                            player.setData(WGAttachment.LIVER, new Liver(value, viscera.yang(), viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                        .then(Commands.literal("yang").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Liver viscera = player.getData(WGAttachment.LIVER);
                                            player.setData(WGAttachment.LIVER, new Liver(viscera.yin(), value, viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                )
                                .then(Commands.literal("spleen")
                                        .then(Commands.literal("yin").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Spleen viscera = player.getData(WGAttachment.SPLEEN);
                                            player.setData(WGAttachment.SPLEEN, new Spleen(value, viscera.yang(), viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                        .then(Commands.literal("yang").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Spleen viscera = player.getData(WGAttachment.SPLEEN);
                                            player.setData(WGAttachment.SPLEEN, new Spleen(viscera.yin(), value, viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                )
                                .then(Commands.literal("lung")
                                        .then(Commands.literal("yin").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Lung viscera = player.getData(WGAttachment.LUNG);
                                            player.setData(WGAttachment.LUNG, new Lung(value, viscera.yang(), viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                        .then(Commands.literal("yang").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Lung viscera = player.getData(WGAttachment.LUNG);
                                            player.setData(WGAttachment.LUNG, new Lung(viscera.yin(), value, viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                )
                                .then(Commands.literal("kidney")
                                        .then(Commands.literal("yin").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Kidney viscera = player.getData(WGAttachment.KIDNEY);
                                            player.setData(WGAttachment.KIDNEY, new Kidney(value, viscera.yang(), viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                        .then(Commands.literal("yang").then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            double value = DoubleArgumentType.getDouble(context, "value");
                                            Kidney viscera = player.getData(WGAttachment.KIDNEY);
                                            player.setData(WGAttachment.KIDNEY, new Kidney(viscera.yin(), value, viscera.ping()));
                                            sendSuccess(player, SET_SUCCESS, value);
                                            return 0;
                                        }))
                                        )
                                )
                        )
                        .then(Commands.literal("reset")
                                .then(Commands.literal("heart").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            player.setData(WGAttachment.HEART, new Heart(1000.0, 1000.0, 0.0));
                                            sendSuccess(player, RESET_SUCCESS);
                                            return 0;
                                        })
                                )
                                .then(Commands.literal("liver").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            player.setData(WGAttachment.LIVER, new Liver(1000.0, 1000.0, 0.0));
                                            sendSuccess(player, RESET_SUCCESS);
                                            return 0;
                                        })
                                )
                                .then(Commands.literal("spleen").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            player.setData(WGAttachment.SPLEEN, new Spleen(1000.0, 1000.0, 0.0));
                                            sendSuccess(player, RESET_SUCCESS);
                                            return 0;
                                        })
                                )
                                .then(Commands.literal("lung").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            player.setData(WGAttachment.LUNG, new Lung(1000.0, 1000.0, 0.0));
                                            sendSuccess(player, RESET_SUCCESS);
                                            return 0;
                                        })
                                )
                                .then(Commands.literal("kidney").executes(context -> {
                                            Player player = EntityArgument.getPlayer(context, "player");
                                            player.setData(WGAttachment.KIDNEY, new Kidney(1000.0, 1000.0, 0.0));
                                            sendSuccess(player, RESET_SUCCESS);
                                            return 0;
                                        })
                                )
                        )
                )
        );

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
