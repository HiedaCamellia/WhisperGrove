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
import org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess.GeneralPrescriptProcessRecipeBuilder;
import org.hiedacamellia.whispergrove.core.recipe.simpleherbprocess.SimpleHerbProcessRicipeBuilder;
import org.hiedacamellia.whispergrove.registers.WGBlock;
import org.hiedacamellia.whispergrove.registers.WGItem;

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

        new GeneralPrescriptProcessRecipeBuilder(
                new ItemStack(Items.DIAMOND),//产物
                Blocks.DIRT.defaultBlockState(),//工作台方块
                100,//运转时间
                false,//是否有序
                Arrays.asList(Ingredient.of(Items.IRON_INGOT),Ingredient.of(Items.APPLE))//输入物品
        )
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(output);

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(CUTTLEBONE),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) ROASTED_CUTTLEFLSH_BONE),//产物，也可以是ItemStack
                        0.1f,//经验值
                        200//烹饪时间
                )
                .unlockedBy("has_cuttlebone", has(CUTTLEBONE))
                .save(output, "cuttlebone_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.BONE),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) CALCINED_DRAGON_BONE),//产物，也可以是ItemStack
                        0.1f,//经验值
                        250//烹饪时间
                )
                .unlockedBy("has_lilac", has(Items.BONE))
                .save(output, "bone_smelting");

        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(WGItem.GYPSUM_RUBRUM.get()),//产物
                WGBlock.ROLLER.get().defaultBlockState(),//工作台方块
                100,//运转时间
                Ingredient.of(Items.CALCITE)//输入物品
        )
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(output);

        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(WGItem.ACTINOLITE.get()),//产物
                WGBlock.ROLLER.get().defaultBlockState(),//工作台方块
                100,//运转时间
                Ingredient.of(Items.DIORITE)//输入物品
        )
                .unlockedBy("has_diorite", has(Items.DIORITE))
                .save(output);

    }
}
