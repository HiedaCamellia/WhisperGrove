package org.hiedacamellia.whispergrove.core.data.provider;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.WhisperGrove;
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

//        new GeneralPrescriptProcessRecipeBuilder(
//                new ItemStack(Items.DIAMOND),//产物
//                Blocks.DIRT.defaultBlockState(),//工作台方块
//                100,//运转时间
//                false,//是否有序
//                Arrays.asList(Ingredient.of(Items.IRON_INGOT),Ingredient.of(Items.APPLE))//输入物品
//        )
//                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
//                .save(output);

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
                .unlockedBy("has_bone", has(Items.BONE))
                .save(output, "bone_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(MONKSHOOD),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) ROASTED_MONKSHOOD),//产物，也可以是ItemStack
                        0.1f,//经验值
                        250//烹饪时间
                )
                .unlockedBy("has_monkshood", has(MONKSHOOD))
                .save(output, "monkshood_smelting");
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.TURTLE_SCUTE),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) TORTOISE_PLASTRON_GLUE,4),//产物，也可以是ItemStack
                        0.1f,//经验值
                        250//烹饪时间
                )
                .unlockedBy("has_scute", has(Items.TURTLE_SCUTE))
                .save(output, "scute_smelting");
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.SWEET_BERRIES),//输入
                        RecipeCategory.MISC,//配方类型
                        new ItemStack((Holder<Item>) SCHISANDRA_CHINENSIS),//产物，也可以是ItemStack
                        0.1f,//经验值
                        250//烹饪时间
                )
                .unlockedBy("has_berry", has(Items.SWEET_BERRIES))
                .save(output, "berry_smelting");

        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(GYPSUM_RUBRUM.get()),
                roller(),
                100,
                Ingredient.of(Items.CALCITE)
        )
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(output);

        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(FLUORITE.get()),
                roller(),
                100,
                Ingredient.of(Items.AMETHYST_SHARD)
        )
                .unlockedBy("has_amethyst_shard", has(Items.AMETHYST_SHARD))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(MALT.get()),
                cutter(),
                100,
                Ingredient.of(Items.WHEAT)
        )
                .unlockedBy("has_wheat", has(Items.WHEAT))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(ROSE.get()),
                cutter(),
                100,
                Ingredient.of(Items.ROSE_BUSH)
        )
                .unlockedBy("has_rose", has(Items.ROSE_BUSH))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(SLICED_MILKVETCH.get()),
                cutter(),
                100,
                Ingredient.of(MILKVETCH)
        )
                .unlockedBy("has_milkvetch", has(MILKVETCH))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(SLICED_CASSIA_TWIG.get()),
                cutter(),
                100,
                Ingredient.of(CASSIA_TWIG)
        )
                .unlockedBy("has_cassia_twig", has(CASSIA_TWIG))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(DRYING_REHMANNIA.get()),
                cutter(),
                100,
                Ingredient.of(REHMANNIA)
        )
                .unlockedBy("has_rehmannia", has(REHMANNIA))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(DRYING_LICORICE.get()),
                cutter(),
                100,
                Ingredient.of(LICORICE)
        )
                .unlockedBy("has_licorice", has(LICORICE))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(SLICED_GINSENG.get()),
                cutter(),
                100,
                Ingredient.of(GINSENG)
        )
                .unlockedBy("has_ginseng", has(GINSENG))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(SLICED_GENTIAN.get()),
                cutter(),
                100,
                Ingredient.of(GENTIAN)
        )
                .unlockedBy("has_gentain", has(GENTIAN))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(BAMBOO_LEAF.get()),
                cutter(),
                100,
                Ingredient.of(Items.BAMBOO)
        )
                .unlockedBy("has_gentain", has(Items.BAMBOO))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(PORIA_COCOS.get()),
                cutter(),
                100,
                Ingredient.of(Items.RED_MUSHROOM_BLOCK)
        )
                .unlockedBy("has_mushroom_red", has(Items.RED_MUSHROOM_BLOCK))
                .save(output, WhisperGrove.prefix("poria_cocos_red"));
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(PORIA_COCOS.get()),
                cutter(),
                100,
                Ingredient.of(Items.BROWN_MUSHROOM_BLOCK)
        )
                .unlockedBy("has_mushroom_brown", has(Items.BROWN_MUSHROOM_BLOCK))
                .save(output, WhisperGrove.prefix("poria_cocos_brown"));
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(MONKSHOOD.get()),
                cutter(),
                100,
                Ingredient.of(Items.NETHER_WART)
        )
                .unlockedBy("has_nether_wart", has(Items.NETHER_WART))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(CLOVE.get()),
                pot(),
                100,
                Ingredient.of(Items.LILAC)
        )
                .unlockedBy("has_lilac", has(Items.LILAC))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(PREPARED_LICORICE.get()),
                pot(),
                100,
                Ingredient.of(DRYING_LICORICE)
        )
                .unlockedBy("has_drying_licorice", has(DRYING_LICORICE))
                .save(output);
        new SimpleHerbProcessRicipeBuilder(
                new ItemStack(ROASTED_REHMANNIA.get()),
                pot(),
                100,
                Ingredient.of(DRYING_REHMANNIA)
        )
                .unlockedBy("has_drying_rehmannia", has(DRYING_REHMANNIA))
                .save(output);

    }

    private BlockState roller() {
        return WGBlock.ROLLER.get().defaultBlockState();
    }
    private BlockState cutter() {
        return WGBlock.CUTTER.get().defaultBlockState();
    }
    private BlockState pot() {
        return WGBlock.POT.get().defaultBlockState();
    }
}
