package org.hiedacamellia.camellialib.core.static_utor;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class Translator {

    private final String modId;

    public Translator(String modId) {
        this.modId = modId;
    }

    public Component set(String string1, String string2, Object... objects) {
        return Component.translatable(string1 + "." + modId + "." + string2, objects);
    }

    public Component set(String string1, String string2, ChatFormatting format, Object... objects) {
        return Component.translatable(string1 + "." + modId + "." + string2, objects)
                .withStyle(format);
    }

    public static Translator create(String modId) {
        return new Translator(modId);
    }
}
