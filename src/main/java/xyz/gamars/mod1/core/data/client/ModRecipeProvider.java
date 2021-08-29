package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.init.ItemInit;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ItemInit.ITEM_1.get(), 9)
                .requires(BlockInit.BLOCK_1.get())
                .unlockedBy("has_item", has(ItemInit.ITEM_1.get()))
                .save(consumer);
        ;

        ShapedRecipeBuilder.shaped(BlockInit.BLOCK_1.get())
                .define('#', ItemInit.ITEM_1.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ItemInit.ITEM_1.get()))
                .save(consumer);
        ;

        CookingRecipeBuilder.smelting(Ingredient.of(BlockInit.BLOCK_2.get()), ItemInit.ITEM_1.get(), 1.0F, 200)
                .unlockedBy("has_item", has(BlockInit.BLOCK_2.get()))
                .save(consumer, modID("item_1_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(BlockInit.BLOCK_2.get()), ItemInit.ITEM_1.get(), 1.0F, 100)
                .unlockedBy("has_item", has(BlockInit.BLOCK_2.get()))
                .save(consumer, modID("item_1_blasting"));
    }

    private static ResourceLocation modID(String path) {
        return new ResourceLocation(Mod1.MOD_ID, path);
    }

}
