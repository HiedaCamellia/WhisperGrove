package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.Heart;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class HeartCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.literal("viscera")
                        .then(Commands.literal("heart")
                                .requires(s -> s.hasPermission(3))
                                .then(Commands.literal("yin")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Heart heart = player.getData(WGAttachment.HEART);
                                                                    player.setData(WGAttachment.HEART, new Heart(heart.yin() + change, heart.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Heart heart = player.getData(WGAttachment.HEART);
                                                                    player.setData(WGAttachment.HEART, new Heart(set, heart.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Heart heart = player.getData(WGAttachment.HEART);
                                                            player.sendSystemMessage(Component.literal(heart.yin().toString()));
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Heart heart = player.getData(WGAttachment.HEART);
                                                                    player.setData(WGAttachment.HEART, new Heart(heart.yin(), heart.yang() + change));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Heart heart = player.getData(WGAttachment.HEART);
                                                                    player.setData(WGAttachment.HEART, new Heart(heart.yin(), set));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Heart heart = player.getData(WGAttachment.HEART);
                                                            player.sendSystemMessage(Component.literal(heart.yang().toString()));
                                                            return 0;
                                                        })))
                                ))));

    }
}
