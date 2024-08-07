package org.hiedacamellia.whispergrove.core.command;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.whispergrove.core.codec.record.Spleen;
import org.hiedacamellia.whispergrove.registers.WGAttachment;

@EventBusSubscriber
public class SpleenCmd {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("whispergrove")
                .then(Commands.literal("viscera")
                        .then(Commands.literal("spleen")
                                .requires(s -> s.hasPermission(3))
                                .then(Commands.literal("yin")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                                    player.setData(WGAttachment.SPLEEN, new Spleen(spleen.yin() + change, spleen.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                                    player.setData(WGAttachment.SPLEEN, new Spleen(set, spleen.yang()));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                            player.sendSystemMessage(Component.literal(spleen.yin().toString()));
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                                    player.setData(WGAttachment.SPLEEN, new Spleen(spleen.yin(), spleen.yang() + change));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    Player player = arguments.getSource().getPlayer();
                                                                    double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                    Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                                    player.setData(WGAttachment.SPLEEN, new Spleen(spleen.yin(), set));
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            Player player = arguments.getSource().getPlayer();
                                                            Spleen spleen = player.getData(WGAttachment.SPLEEN);
                                                            player.sendSystemMessage(Component.literal(spleen.yang().toString()));
                                                            return 0;
                                                        })))
                                ))));

    }
}
