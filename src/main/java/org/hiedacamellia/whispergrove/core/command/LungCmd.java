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
import org.hiedacamellia.whispergrove.core.codec.record.Lung;
import org.hiedacamellia.whispergrove.core.debug.Debug;
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
                                                                    try {
                                                                        Player player = EntityArgument.getPlayer(arguments, "player");
                                                                        double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                        Lung lung = player.getData(WGAttachment.LUNG);
                                                                        player.setData(WGAttachment.LUNG, new Lung(lung.yin() + change, lung.yang()));
                                                                        player.sendSystemMessage(Component.translatable("cmd.whispergrove.modify.success",lung.yin() + change));
                                                                        Debug.debug(Component.translatable("cmd.whispergrove.modify.success",lung.yin() + change).getString());
                                                                    } catch (Exception e) {
                                                                        Debug.getLogger().error(Component.translatable("cmd.whispergrove.modify.failed", e.getMessage()).getString());
                                                                    }
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    try{
                                                                        Player player = EntityArgument.getPlayer(arguments, "player");
                                                                        double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                        Lung lung = player.getData(WGAttachment.LUNG);
                                                                        player.setData(WGAttachment.LUNG, new Lung(set, lung.yang()));
                                                                        player.sendSystemMessage(Component.translatable("cmd.whispergrove.set.success",set));
                                                                        Debug.debug(Component.translatable("cmd.whispergrove.set.success",set).getString());
                                                                    }catch (Exception e){
                                                                        Debug.getLogger().error(Component.translatable("cmd.whispergrove.set.failed", e.getMessage()).getString());
                                                                    }
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            try{
                                                                Player player = EntityArgument.getPlayer(arguments, "player");
                                                                Lung lung = player.getData(WGAttachment.LUNG);
                                                                player.sendSystemMessage(Component.translatable("cmd.whispergrove.get.success",lung.yin()));
                                                                Debug.debug(Component.translatable("cmd.whispergrove.get.success",lung.yin()).getString());
                                                            }catch (Exception e){
                                                                Debug.getLogger().error(Component.translatable("cmd.whispergrove.get.failed", e.getMessage()).getString());
                                                            }
                                                            return 0;
                                                        }))))
                                .then(Commands.literal("yang")
                                        .then(Commands.literal("modify")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    try {
                                                                        Player player = EntityArgument.getPlayer(arguments, "player");
                                                                        double change = DoubleArgumentType.getDouble(arguments, "number");
                                                                        Lung lung = player.getData(WGAttachment.LUNG);
                                                                        player.setData(WGAttachment.LUNG, new Lung(lung.yin(), lung.yang() + change));
                                                                        player.sendSystemMessage(Component.translatable("cmd.whispergrove.modify.success",lung.yang() + change));
                                                                        Debug.debug(Component.translatable("cmd.whispergrove.modify.success",lung.yang() + change).getString());
                                                                    }catch (Exception e){
                                                                        Debug.getLogger().error(Component.translatable("cmd.whispergrove.modify.failed", e.getMessage()).getString());
                                                                    }
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("set")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .then(Commands.argument("number", DoubleArgumentType.doubleArg())
                                                                .executes(arguments -> {
                                                                    try {
                                                                        Player player = EntityArgument.getPlayer(arguments, "player");
                                                                        double set = DoubleArgumentType.getDouble(arguments, "number");
                                                                        Lung lung = player.getData(WGAttachment.LUNG);
                                                                        player.setData(WGAttachment.LUNG, new Lung(lung.yin(), set));
                                                                        player.sendSystemMessage(Component.translatable("cmd.whispergrove.set.success", set));
                                                                        Debug.debug(Component.translatable("cmd.whispergrove.set.success", set).getString());
                                                                    }catch (Exception e){
                                                                        Debug.getLogger().error(Component.translatable("cmd.whispergrove.set.failed", e.getMessage()).getString());
                                                                    }
                                                                    return 0;
                                                                }))))
                                        .then(Commands.literal("get")
                                                .then(Commands.argument("player", EntityArgument.player())
                                                        .executes(arguments -> {
                                                            try {
                                                                Player player = EntityArgument.getPlayer(arguments, "player");
                                                                Lung lung = player.getData(WGAttachment.LUNG);
                                                                player.sendSystemMessage(Component.translatable("cmd.whispergrove.get.success", lung.yang()));
                                                                Debug.debug(Component.translatable("cmd.whispergrove.get.success").getString());
                                                            }catch (Exception e){
                                                                Debug.getLogger().error(Component.translatable("cmd.whispergrove.get.failed", e.getMessage()).getString());
                                                            }
                                                            return 0;
                                                        })))
                                ).then(Commands.literal("reset"))
                                .then(Commands.argument("player", EntityArgument.player()).executes(arguments -> {
                                            try {
                                                Player player = EntityArgument.getPlayer(arguments, "player");
                                                player.setData(WGAttachment.LUNG, new Lung(100.0, 100.0));
                                                player.sendSystemMessage(Component.translatable("cmd.whispergrove.set.success"));
                                                Debug.debug(Component.translatable("cmd.whispergrove.set.success").getString());
                                            } catch (Exception e) {
                                                Debug.getLogger().error(Component.translatable("cmd.whispergrove.set.failed", e.getMessage()).getString());
                                            }
                                            return 0;
                                        }
                                )))));

    }
}
