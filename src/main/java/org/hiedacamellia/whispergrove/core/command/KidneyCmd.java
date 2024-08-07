package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.Kidney;
import org.hiedacamellia.whispergrove.core.codec.record.Kidney;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class KidneyCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.literal("viscera")
                        .then(Commands.literal("kidney")
                                .requires(s -> s.hasPermission(3))
                                .then(Commands.literal("yin")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                                    player.setData(WGAttachment.KIDNEY, new Kidney(kidney.yin() + change, kidney.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                                    player.setData(WGAttachment.KIDNEY, new Kidney(set, kidney.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                            player.sendSystemMessage(Component.literal(kidney.yin().toString()));
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                                    player.setData(WGAttachment.KIDNEY, new Kidney(kidney.yin(), kidney.yang() + change));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                                    player.setData(WGAttachment.KIDNEY, new Kidney(kidney.yin(), set));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Kidney kidney = player.getData(WGAttachment.KIDNEY);
                                                            player.sendSystemMessage(Component.literal(kidney.yang().toString()));
                                                            return 0;
                                                        })))
                                ))));

    }
}
