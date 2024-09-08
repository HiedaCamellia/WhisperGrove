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


    /**
     * @author HiedaCamellia
     * @reason 添加最大饱食度限制
     */
    @Overwrite
    private void add(int foodLevel, float saturationLevel){
        this.foodLevel = (int) Mth.clamp(this.FOOD_EFFICIENCY*foodLevel + this.foodLevel, 0, MAX_FOOD_LEVEL);
        this.saturationLevel = Mth.clamp(this.FOOD_EFFICIENCY*saturationLevel + this.saturationLevel, 0.0F, (float)this.foodLevel);
    }

    /**
     * @author HiedaCamellia
     * @reason 添加最大饱食度限制
     */
    @Overwrite
    public boolean needsFood() {
        return this.foodLevel < MAX_FOOD_LEVEL;
    }

    /**
     * @author HiedaCamellia
     * @reason 添加最大饱食度限制
     */
    @Overwrite
    public void tick(Player player) {
        Difficulty difficulty = player.level().getDifficulty();
        this.lastFoodLevel = this.foodLevel;
        if (this.exhaustionLevel > 4.0F) {
            this.exhaustionLevel -= 4.0F;
            if (this.saturationLevel > 0.0F) {
                this.saturationLevel = Math.max(this.saturationLevel - 1.0F, 0.0F);
            } else if (difficulty != Difficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }

        boolean flag = player.level().getGameRules().getBoolean(GameRules.RULE_NATURAL_REGENERATION);
        if (flag && this.saturationLevel > 0.0F && player.isHurt() && this.foodLevel >= MAX_FOOD_LEVEL) {
            ++this.tickTimer;
            if (this.tickTimer >= 10) {
                float f = Math.min(this.saturationLevel, 6.0F);
                player.heal(f / 6.0F);
                ((FoodData)(Object)this).addExhaustion(f);
                this.tickTimer = 0;
            }
        } else if (flag && this.foodLevel >= 18 && player.isHurt()) {
            ++this.tickTimer;
            if (this.tickTimer >= 80) {
                player.heal(1.0F);
                ((FoodData)(Object)this).addExhaustion(6.0F);
                this.tickTimer = 0;
            }
        } else if (this.foodLevel <= 0) {
            ++this.tickTimer;
            if (this.tickTimer >= 80) {
                if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
                    player.hurt(player.damageSources().starve(), 1.0F);
                }

                this.tickTimer = 0;
            }
        } else {
            this.tickTimer = 0;
        }

    }


}
