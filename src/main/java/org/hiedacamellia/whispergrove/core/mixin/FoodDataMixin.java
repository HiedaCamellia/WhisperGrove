package org.hiedacamellia.whispergrove.core.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.level.GameRules;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.core.interfaces.FoodDataAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyArg;
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
        if(CommonConfig.MIXIN_CONTENT.get())
            return MAX_FOOD_LEVEL;
        return 20;
    }

    @ModifyConstant(method = {"tick"},constant = @Constant(intValue = 18))
    private int modifyFoodLevel(int FoodLevel) {
        if(CommonConfig.MIXIN_CONTENT.get())
            return (int) (MAX_FOOD_LEVEL*0.9);
        return 18;
    }

    @ModifyArg(method = "add" , at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(III)I"),index = 0)
    private int modifyArg(int foodLevel) {
        if(CommonConfig.MIXIN_CONTENT.get())
            return (int) (foodLevel*FOOD_EFFICIENCY);
        return foodLevel;
    }

    @ModifyArg(method = "add" , at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clamp(FFF)F"),index = 0)
    private float modifyArg(float foodLevel) {
        if(CommonConfig.MIXIN_CONTENT.get())
            return (int) (foodLevel*FOOD_EFFICIENCY);
        return foodLevel;
    }


}
