package org.hiedacamellia.whispergrove.core.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.GameRules;
import org.hiedacamellia.whispergrove.core.interfaces.FoodDataAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FoodData.class)
public class FoodDataMixin implements FoodDataAccessor {

    @Unique
    private int MAX_FOOD_LEVEL = 20;
    @Unique
    private float FOOD_EFFICIENCY = 1;
    @Shadow
    private int foodLevel;
    @Shadow
    private float saturationLevel;
    @Shadow
    private int lastFoodLevel;
    @Shadow
    private float exhaustionLevel;
    @Shadow
    private int tickTimer;

    @Unique
    public void whisperGrove$setMaxFoodLevel(int MAX_FOOD_LEVEL) {
        this.MAX_FOOD_LEVEL = MAX_FOOD_LEVEL;
    }
    @Unique
    public int whisperGrove$getMaxFoodLevel() {
        return this.MAX_FOOD_LEVEL;
    }
    @Unique
    public void whisperGrove$setFoodEfficiency(float FOOD_EFFICIENCY) {
        this.FOOD_EFFICIENCY = FOOD_EFFICIENCY;
    }
    @Unique
    public float whisperGrove$getFoodEfficiency() {
        return this.FOOD_EFFICIENCY;
    }

    @ModifyConstant(method = {"add","needsFood","tick"},constant = @Constant(intValue = 20))
    private int modifyMaxFoodLevel(int maxFoodLevel) {
        return MAX_FOOD_LEVEL;
    }

    @ModifyConstant(method = {"tick"},constant = @Constant(intValue = 18))
    private double modifyFoodLevel(int FoodLevel) {
        return MAX_FOOD_LEVEL*0.9;
    }


}
