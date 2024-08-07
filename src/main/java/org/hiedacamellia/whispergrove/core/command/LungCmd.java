package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.Lung;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class LungCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.literal("viscera")
                        .then(Commands.literal("lung")
                                .requires(s -> s.hasPermission(3))
                                .then(Commands.literal("yin")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Lung lung = player.getData(WGAttachment.LUNG);
                                                                    player.setData(WGAttachment.LUNG, new Lung(lung.yin() + change, lung.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Lung lung = player.getData(WGAttachment.LUNG);
                                                                    player.setData(WGAttachment.LUNG, new Lung(set, lung.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Lung lung = player.getData(WGAttachment.LUNG);
                                                            player.sendSystemMessage(Component.literal(lung.yin().toString()));
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Lung lung = player.getData(WGAttachment.LUNG);
                                                                    player.setData(WGAttachment.LUNG, new Lung(lung.yin(), lung.yang() + change));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Lung lung = player.getData(WGAttachment.LUNG);
                                                                    player.setData(WGAttachment.LUNG, new Lung(lung.yin(), set));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Lung lung = player.getData(WGAttachment.LUNG);
                                                            player.sendSystemMessage(Component.literal(lung.yang().toString()));
                                                            return 0;
                                                        })))
                                ))));

    }
}
