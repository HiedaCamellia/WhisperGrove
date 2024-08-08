package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.menu.VisceraMenu;

import java.util.function.Supplier;

public class WGMenu {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, WhisperGrove.MODID);

    public static final Supplier<MenuType<VisceraMenu>> VISCERA = MENUS.register("viscera", () -> IMenuTypeExtension.create(VisceraMenu::new));
}
