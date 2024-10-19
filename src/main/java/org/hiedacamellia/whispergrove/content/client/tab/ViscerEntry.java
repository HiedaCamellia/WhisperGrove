package org.hiedacamellia.whispergrove.content.client.tab;

import com.mojang.datafixers.util.Pair;
import dev.xkmc.l2library.util.TextWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.api.viscera.VisceraHolder;
import org.hiedacamellia.whispergrove.content.viscera.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public record ViscerEntry(
        List<Component> hover,
        Component content,
        ResourceLocation icon
){

    public static List<ViscerEntry> aggregate(@Nullable Player le) {
        if (le == null) return List.of();
        List<ViscerEntry> raw = new ArrayList<>();

        raw.add(new ViscerEntry(HeartEvent.getHover(le), HeartEvent.getdesc(le),
                WhisperGrove.prefix("textures/viscera/heart.png")));
        raw.add(new ViscerEntry(KidneyEvent.getHover(le), KidneyEvent.getdesc(le),
                WhisperGrove.prefix("textures/viscera/kidney.png")));
        raw.add(new ViscerEntry(LiverEvent.getHover(le), LiverEvent.getdesc(le),
                WhisperGrove.prefix("textures/viscera/liver.png")));
        raw.add(new ViscerEntry(LungEvent.getHover(le), LungEvent.getdesc(le),
                WhisperGrove.prefix("textures/viscera/lung.png")));
        raw.add(new ViscerEntry(SpleenEvent.getHover(le), SpleenEvent.getdesc(le),
                WhisperGrove.prefix("textures/viscera/spleen.png")));

        return raw;
    }

}
