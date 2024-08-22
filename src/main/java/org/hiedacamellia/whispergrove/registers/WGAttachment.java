package org.hiedacamellia.whispergrove.registers;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.hiedacamellia.whispergrove.WhisperGrove;
import org.hiedacamellia.whispergrove.content.common.components.Viscera;
import org.hiedacamellia.whispergrove.core.codec.WGCodec;
import org.hiedacamellia.whispergrove.core.codec.record.*;

import java.util.function.Supplier;

public class WGAttachment {
    // Create the DeferredRegister for attachment types
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, WhisperGrove.MODID);

    //Heart
    public static final Supplier<AttachmentType<Heart>> HEART = ATTACHMENTS.register(
            "heart", () -> AttachmentType.builder(() -> new Heart(100.0, 100.0)).serialize(WGCodec.HEART_CODEC).build()
    );

    //Kidney
    public static final Supplier<AttachmentType<Kidney>> KIDNEY = ATTACHMENTS.register(
            "kidney", () -> AttachmentType.builder(() -> new Kidney(100.0, 100.0)).serialize(WGCodec.KIDNEY_CODEC).build()
    );

    //Liver
    public static final Supplier<AttachmentType<Liver>> LIVER = ATTACHMENTS.register(
            "liver", () -> AttachmentType.builder(() -> new Liver(100.0, 100.0)).serialize(WGCodec.LIVER_CODEC).build()
    );

    //Lung
    public static final Supplier<AttachmentType<Lung>> LUNG = ATTACHMENTS.register(
            "lung", () -> AttachmentType.builder(() -> new Lung(100.0, 100.0)).serialize(WGCodec.LUNG_CODEC).build()
    );

    //Spleen
    public static final Supplier<AttachmentType<Spleen>> SPLEEN = ATTACHMENTS.register(
            "spleen", () -> AttachmentType.builder(() -> new Spleen(100.0, 100.0)).serialize(WGCodec.SPLEEN_CODEC).build()
    );

    public static final Supplier<AttachmentType<Refresh>> REFRESH = ATTACHMENTS.register(
            "refresh", () -> AttachmentType.builder(() -> new Refresh(0)).serialize(WGCodec.REFRESH_CODEC).build()
    );

    public static final Supplier<AttachmentType<NameMap>> NAMEMAP = ATTACHMENTS.register(
            "namemap", () -> AttachmentType.builder(() -> new NameMap(null)).serialize(WGCodec.NAMEMAP_CODEC).build()
    );

    private static DeferredHolder<AttachmentType<?>, AttachmentType<Viscera>> registerViscera(String name) {
        Viscera viscera = new Viscera(WhisperGrove.prefix(name), 100.0D, 100.0D);
        return ATTACHMENTS.register(name, () -> AttachmentType.builder(() -> viscera).serialize(Viscera.CODEC).build());
    }

}