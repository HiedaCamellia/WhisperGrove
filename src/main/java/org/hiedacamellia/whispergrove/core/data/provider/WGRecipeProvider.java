package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.hiedacamellia.whispergrove.core.recipe.generalherbprocess.GeneralHerbProcessRecipeBuilder;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static org.hiedacamellia.whispergrove.registers.WGItem.*;

public class WGRecipeProvider extends RecipeProvider {
    public WGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        // Add your recipes here.
//        new RightClickRicipeBuilder(
//                // Our constructor parameters. This example adds the ever-popular dirt -> diamond conversion.
//                new ItemStack(Items.DIAMOND),
//                Blocks.DIRT.defaultBlockState(),
//                Ingredient.of(Items.IRON_INGOT)
//        )
//                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
//                .save(output);

        new GeneralHerbProcessRecipeBuilder(
                new ItemStack(Items.DIAMOND),//产物
                Blocks.DIRT.defaultBlockState(),//工作台方块
                100,//运转时间
                false,//是否有序
                Arrays.asList(Ingredient.of(Items.IRON_INGOT),Ingredient.of(Items.APPLE))//输入物品
        )
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);

//        SimpleCookingRecipeBuilder.smelting(
//                        Ingredient.of(Items.KELP),//输入
//                        RecipeCategory.FOOD,//配方类型
//                        Items.DIAMOND,//产物，也可以是ItemStack
//                        0.1f,//经验值
//                        200//烹饪时间
//                )
//                .unlockedBy("has_kelp", has(Blocks.KELP))
//                .save(output, "dried_kelp_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(CUTTLEBONE),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) ROASTED_CUTTLEFLSH_BONE),//产物，也可以是ItemStack
                        0.1f,//经验值
                        200//烹饪时间
                )
                .unlockedBy("has_kelp", has(Blocks.KELP))
                .save(output, "mo_yu_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.LILAC),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) CLOVE),//产物，也可以是ItemStack
                        0.1f,//经验值
                        100//烹饪时间
                )
                .unlockedBy("has_lilac", has(Blocks.LILAC))
                .save(output, "dried_lilac_smelting");
    }
}
