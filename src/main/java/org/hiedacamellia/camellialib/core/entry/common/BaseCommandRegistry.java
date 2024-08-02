package org.hiedacamellia.camellialib.core.entry.common;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.hiedacamellia.camellialib.CamelliaLib;
import org.hiedacamellia.camellialib.core.command.BaseCommand;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommandRegistry {

    protected final List<BaseCommand> commands = new ArrayList<>();

    public abstract void addRegistry();

    public void add(BaseCommand command) {
        commands.add(command);
    }

    public void onCommandsRegister(final RegisterCommandsEvent event) {
        addRegistry();
        for (var command : commands) {
            if (command.isEnabled()) {
                event.getDispatcher().register(command.getBuilder());
            }
        }
    }

    public void register() {
        CamelliaLib.modEventBus.addListener(this::onCommandsRegister);
    }
}
