package org.hiedacamellia.whispergrove.core.entry.builder;

import net.minecraft.world.item.Item;
import org.hiedacamellia.whispergrove.core.codec.record.*;
import org.hiedacamellia.whispergrove.core.entry.BaseItem;
import org.hiedacamellia.whispergrove.registers.WGDataComponent;

public class BaseItemBuilder {
    private Heart heart;
    private Kidney kidney;
    private Liver liver;
    private Lung lung;
    private Spleen spleen;

    private String regname;
    private Item.Properties properties;

    public BaseItem build(){
        properties.component(WGDataComponent.HEART,heart);
        properties.component(WGDataComponent.KIDNEY,kidney);
        properties.component(WGDataComponent.LIVER,liver);
        properties.component(WGDataComponent.LUNG,lung);
        properties.component(WGDataComponent.SPLEEN,spleen);
        return new BaseItem(properties,regname);
    }

    public BaseItemBuilder heart(double yin ,double yang){
        this.heart = new Heart(yin,yang);
        return this;
    }

    public BaseItemBuilder kidney(double yin ,double yang){
        this.kidney = new Kidney(yin,yang);
        return this;
    }

    public BaseItemBuilder liver(double yin ,double yang){
        this.liver = new Liver(yin,yang);
        return this;
    }

    public BaseItemBuilder lung(double yin ,double yang){
        this.lung = new Lung(yin,yang);
        return this;
    }

    public BaseItemBuilder spleen(double yin ,double yang){
        this.spleen = new Spleen(yin,yang);
        return this;
    }

    public BaseItemBuilder regname(String regname){
        this.regname = regname;
        return this;
    }

    public BaseItemBuilder properties(Item.Properties properties){
        this.properties = properties;
        return this;
    }
}
