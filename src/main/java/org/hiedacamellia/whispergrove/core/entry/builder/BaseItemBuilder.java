package org.hiedacamellia.whispergrove.core.entry.builder;

import net.minecraft.world.item.Item;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public class BaseItemBuilder {

    private Heart heart = new Heart(0.0, 0.0,0.0);
    private Kidney kidney = new Kidney(0.0, 0.0,0.0);
    private Liver liver = new Liver(0.0, 0.0,0.0);
    private Lung lung = new Lung(0.0, 0.0,0.0);
    private Spleen spleen = new Spleen(0.0, 0.0,0.0);
    private Item.Properties properties = new Item.Properties();

    public BaseItem build() {
        this.properties.component(WGDataComponent.HEART, this.heart);
        this.properties.component(WGDataComponent.KIDNEY, this.kidney);
        this.properties.component(WGDataComponent.LIVER, this.liver);
        this.properties.component(WGDataComponent.LUNG, this.lung);
        this.properties.component(WGDataComponent.SPLEEN, this.spleen);
        return new BaseItem(this.properties);
    }

    public BaseItemBuilder heart(double yin, double yang,double ping) {
        this.heart = new Heart(yin, yang,ping);
        return this;
    }

    public BaseItemBuilder kidney(double yin, double yang,double ping) {
        this.kidney = new Kidney(yin, yang,ping);
        return this;
    }

    public BaseItemBuilder liver(double yin, double yang,double ping) {
        this.liver = new Liver(yin, yang,ping);
        return this;
    }

    public BaseItemBuilder lung(double yin, double yang,double ping) {
        this.lung = new Lung(yin, yang,ping);
        return this;
    }

    public BaseItemBuilder spleen(double yin, double yang,double ping) {
        this.spleen = new Spleen(yin, yang,ping);
        return this;
    }

    public BaseItemBuilder properties(Item.Properties properties) {
        this.properties = properties;
        return this;
    }

}