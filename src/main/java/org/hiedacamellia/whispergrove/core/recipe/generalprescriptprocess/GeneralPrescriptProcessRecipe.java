package org.hiedacamellia.whispergrove.core.recipe.generalprescriptprocess;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.hiedacamellia.whispergrove.core.config.CommonConfig;
import org.hiedacamellia.whispergrove.api.viscera.VisceraHolder;
import org.hiedacamellia.whispergrove.registers.WGRicipe;
import org.hiedacamellia.whispergrove.registers.WGRicipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class GeneralPrescriptProcessRecipe implements Recipe<GeneralPrescriptProcessInput> {
    // An in-code representation of our recipe data. This can be basically anything you want.
    // Common things to have here is a processing time integer of some kind, or an experience reward.
    // Note that we now use an ingredient instead of an item stack for the input.
    private final BlockState inputState;
    private final List<Ingredient> inputItems;
    private final int processtime;
    private final boolean ordered;
    private final ItemStack result;

    // Add a constructor that sets all properties.
    public GeneralPrescriptProcessRecipe(BlockState inputState, List<Ingredient> inputItems, int processtime, boolean ordered, ItemStack result) {
        this.inputState = inputState;
        this.inputItems = inputItems;
        this.processtime = processtime;
        this.ordered = ordered;
        this.result = result;
    }

    // A list of our ingredients. Does not need to be overridden if you have no ingredients
    // (the default implementation returns an empty list here). It makes sense to cache larger lists in a field.
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(this.inputItems);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return WGRicipeSerializer.GENERAL_PRESCRIPT_PROCESS.get();
    }

    @Override
    public RecipeType<?> getType() {
        return WGRicipe.GENERAL_PRESCRIPT_PROCESS.get();
    }

    // Grid-based recipes should return whether their recipe can fit in the given dimensions.
    // We don't have a grid, so we just return if any item can be placed in there.
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 1;
    }

    // Check whether the given input matches this recipe. The first parameter matches the generic.
    // We check our blockstate and our item stack, and only return true if both match.
    @Override
    public boolean matches(GeneralPrescriptProcessInput input, Level level) {
        if(ordered) {
            
            if (this.inputItems.size() != input.stack().size()) {
                return false;
            }
            for (int i = 0; i < this.inputItems.size(); i++) {
                if (this.inputItems.get(i).test(input.stack().get(i))) {
                    return false;
                }
            }

            return true;

        }else {
            if (this.inputItems.size() != input.stack().size()) {
                return false;
            }

            // 创建两个可修改的副本
            List<Ingredient> ingredientsCopy = new ArrayList<>(this.inputItems);
            List<ItemStack> itemStacksCopy = new ArrayList<>(input.stack());

            // 外循环遍历 Ingredient 列表
            for (Ingredient ingredient : this.inputItems) {
                boolean foundMatch = false;

                // 内循环遍历 ItemStack 列表
                for (ItemStack itemStack : itemStacksCopy) {
                    if (ingredient.test(itemStack)) {
                        itemStacksCopy.remove(itemStack); // 找到匹配项后移除
                        ingredientsCopy.remove(ingredient); // 找到匹配项后移除
                        foundMatch = true;
                        break; // 停止内循环，继续下一个 Ingredient
                    }
                }
                if (!foundMatch) {
                    return false; // 如果没有找到匹配项，则返回 false
                }
            }
            // 检查两个列表是否为空，如果是，则表示所有元素匹配
            return itemStacksCopy.isEmpty() && ingredientsCopy.isEmpty();
        }

    }

    // Return an UNMODIFIABLE version of your result here. The result of this method is mainly intended
    // for the recipe book, and commonly used by JEI and other recipe viewers as well.
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    // Return the result of the recipe here, based on the given input. The first parameter matches the generic.
    // IMPORTANT: Always call .copy() if you use an existing result! If you don't, things can and will break,
    // as the result exists once per recipe, but the assembled stack is created each time the recipe is crafted.
    @Override
    public ItemStack assemble(GeneralPrescriptProcessInput input, HolderLookup.Provider registries) {

        List<ItemStack> itemStacks = input.stack();
        ItemStack result = this.result.copy();

        VisceraHolder heart = new VisceraHolder();
        VisceraHolder kidney = new VisceraHolder();
        VisceraHolder liver = new VisceraHolder();
        VisceraHolder lung = new VisceraHolder();
        VisceraHolder spleen = new VisceraHolder();

        for(ItemStack itemStack:itemStacks){
            heart = heart.updateHeart(itemStack);
            kidney = kidney.updateKidney(itemStack);
            liver = liver.updateLiver(itemStack);
            lung = lung.updateLung(itemStack);
            spleen = spleen.updateSpleen(itemStack);
        }
        double heartmass = heart.yang()+heart.yin()+heart.ping();
        double kidneymass = kidney.yang()+kidney.yin()+kidney.ping();
        double livermass = liver.yang()+liver.yin()+liver.ping();
        double lungmass = lung.yang()+lung.yin()+lung.ping();
        double spleenmass = spleen.yang()+spleen.yin()+spleen.ping();
        heartmass *= heartmass;
        kidneymass *= kidneymass;
        livermass *= livermass;
        lungmass *= lungmass;
        spleenmass *= spleenmass;

        double visceramass = heartmass+kidneymass+livermass+lungmass+spleenmass;

        if(heart.isYang()){
            result = heart.getYang(heartmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setHeart(result);
        }else {
            result =heart.getYin(heartmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setHeart(result);
        }
        if(kidney.isYang()){
            result =kidney.getYang(kidneymass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setKidney(result);
        }else {
            result =kidney.getYin(kidneymass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setKidney(result);
        }
        if(liver.isYang()){
            result =liver.getYang(livermass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setLiver(result);
        }else {
            result =liver.getYin(livermass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setLiver(result);
        }
        if(lung.isYang()){
            result =lung.getYang(lungmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setLung(result);
        }else {
            result =lung.getYin(lungmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setLung(result);
        }
        if(spleen.isYang()){
            result =spleen.getYang(spleenmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setSpleen(result);
        }else {
            result =spleen.getYin(spleenmass/visceramass * CommonConfig.VISCERA_CONSTANT.get()).setSpleen(result);
        }

        return result;
    }


    // This example outlines the most important methods. There is a number of other methods to override.
    // Check the class definition of Recipe to view them all.


    public List<Ingredient> getInputItems() {
        return inputItems;
    }

    public BlockState getInputState() {
        return inputState;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getProcesstime() {
        return processtime;
    }

    public boolean isOrdered() {
        return ordered;
    }


}