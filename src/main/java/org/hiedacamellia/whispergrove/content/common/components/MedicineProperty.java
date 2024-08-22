package org.hiedacamellia.whispergrove.content.common.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;

import java.util.function.IntFunction;

public record MedicineProperty(Property property, int level) {

    public static final Codec<MedicineProperty> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Property.CODEC.fieldOf("property").forGetter(MedicineProperty::property),
            Codec.INT.fieldOf("level").forGetter(MedicineProperty::level)).apply(instance, MedicineProperty::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, MedicineProperty> STREAM_CODEC = StreamCodec.composite(
            Property.STREAM_CODEC, MedicineProperty::property, ByteBufCodecs.VAR_INT, MedicineProperty::level, MedicineProperty::new);

    public enum Property implements StringRepresentable {

        WARM(0, "warm"),
        COLD(1, "cold"),
        MILD(2, "mild"),
        LESS_HEAT(3, "less_heat");

        public static final Codec<Property> CODEC = StringRepresentable.fromValues(Property::values);
        public static final IntFunction<Property> BY_ID = ByIdMap.continuous(property -> property.id, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        public static final StreamCodec<ByteBuf, Property> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, property -> property.id);
        private final int id;
        private final String name;

        Property(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

    }

}