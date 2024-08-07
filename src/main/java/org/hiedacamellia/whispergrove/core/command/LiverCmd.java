package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.Liver;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class LiverCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.literal("viscera")
                        .then(Commands.literal("liver")
                                .requires(s -> s.hasPermission(3))
                                .then(Commands.literal("yin")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Liver liver = player.getData(WGAttachment.LIVER);
                                                                    player.setData(WGAttachment.LIVER, new Liver(liver.yin() + change, liver.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Liver liver = player.getData(WGAttachment.LIVER);
                                                                    player.setData(WGAttachment.LIVER, new Liver(set, liver.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Liver liver = player.getData(WGAttachment.LIVER);
                                                            player.sendSystemMessage(Component.literal(liver.yin().toString()));
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Liver liver = player.getData(WGAttachment.LIVER);
                                                                    player.setData(WGAttachment.LIVER, new Liver(liver.yin(), liver.yang() + change));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Liver liver = player.getData(WGAttachment.LIVER);
                                                                    player.setData(WGAttachment.LIVER, new Liver(liver.yin(), set));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Liver liver = player.getData(WGAttachment.LIVER);
                                                            player.sendSystemMessage(Component.literal(liver.yang().toString()));
                                                            return 0;
                                                        })))
                                ))));

    }
}
