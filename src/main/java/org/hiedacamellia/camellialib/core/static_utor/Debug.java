package org.hiedacamellia.camellialib.core.static_utor;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Debug {
    private final String prefix;
    private final Boolean debugConfig;
    private final Logger logger;

    public Debug(String prefix, Boolean debugConfig) {
        this.prefix = prefix;
        this.debugConfig = debugConfig;
        this.logger = LoggerFactory.getLogger(prefix);
    }

    /**
     * 客户端侧debug
     */
    public void send(String string) {
        if (FMLEnvironment.dist.isClient()) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.player != null && debugConfig) {
                mc.player.sendSystemMessage(Component.literal(prefix + string));
            }
        }
    }

    /**
     * 服务端侧debug
     */
    public void send(String string, Player player) {
        Level level = player.level();
        if(!level.isClientSide && debugConfig) {
            player.sendSystemMessage(Component.literal(prefix  + string));
        }
    }

    public Logger getLogger() {
        return logger;
    }

    public static Debug create(String prefix, Boolean debugConfig) {
        return new Debug(prefix, debugConfig);
    }

}
