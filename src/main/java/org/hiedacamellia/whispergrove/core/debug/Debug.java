package org.hiedacamellia.whispergrove.core.debug;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debug {

    private final String prefix;
    private static Boolean debugConfig;
    private static Logger logger;
    

    public Debug(String modid,String prefix,Boolean debug){
        this.prefix = prefix;
        debugConfig = debug;
        logger = LoggerFactory.getLogger(modid);
    }

    public static void info(String message){
        logger.info(message);
    }

    public static void info(String message, Throwable t){
        logger.info(message,t);
    }

    public static void info(String format, Object arg) {
        logger.info(format, arg);
    }

    public static void debug(String message){
        if(debugConfig)
            logger.debug(message);
    }

    public static void debug(String message, Throwable t){
        if(debugConfig)
            logger.debug(message,t);
    }

    public static void debug(String format, Object arg) {
        if(debugConfig)
            logger.debug(format, arg);
    }

    public static void error(String message){
        logger.error(message);
    }

    public static void error(String message, Throwable t){
        logger.error(message,t);
    }

    public static void error(String format, Object arg) {
        logger.error(format, arg);
    }

    public static void warn(String message){
        logger.warn(message);
    }

    public static void warn(String message, Throwable t){
        logger.warn(message,t);
    }

    public static void warn(String format, Object arg) {
        logger.warn(format, arg);
    }

    public static void trace(String message){
        logger.trace(message);
    }

    public static void trace(String message, Throwable t){
        logger.trace(message,t);
    }

    public static void trace(String format, Object arg) {
        logger.trace(format, arg);
    }

    public static Logger getLogger(){
        return logger;
    }

    public static String translateable(String s){
        return Component.translatable(s).getString();
    }

    //客户端调试信息
    public void send(String string) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix + string));
            }
        }
    }

    //服务端调试信息
    public void send(String string, Player player) {
        Level level = player.level();
      //  if(!level.isClientSide && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix  + string));
       // }
    }
}