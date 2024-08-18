package org.hiedacamellia.whispergrove.registers;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.client.menu.SpringingMenu;
import org.hiedacamellia.whispergrove.content.client.menu.VisceraMenu;

import java.util.function.Supplier;

public class WGMenu {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, WhisperGrove.MODID);

    public static final Supplier<MenuType<VisceraMenu>> VISCERA = MENUS.register("viscera", () -> IMenuTypeExtension.create(VisceraMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<SpringingMenu>> SPRINGING = register(SpringingMenu::new, "springing");

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> register(IContainerFactory<T> factory, String name) {
        return MENUS.register(name + "_menu", () -> new MenuType<>(factory, FeatureFlags.DEFAULT_FLAGS));
    }

}