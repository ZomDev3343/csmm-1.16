package fr.zom.csmm.data.recipe;

import fr.zom.csmm.CSMM;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.KilledTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator p_i48262_1_) {
        super(p_i48262_1_);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Blocks.GRASS_BLOCK)
                .pattern(" H ")
                .pattern("HTH")
                .pattern(" H ")
                .define('H', Blocks.GRASS)
                .define('T', Blocks.DIRT)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.GRASS, Blocks.DIRT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(Blocks.DIAMOND_BLOCK)
                .pattern("TTT")
                .define('T', Blocks.DIRT)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.DIRT))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(Items.ENCHANTED_GOLDEN_APPLE)
                .requires(Items.APPLE)
                .requires(Blocks.GOLD_BLOCK)
                .unlockedBy("unlock", KilledTrigger.Instance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.CREEPER)))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(Items.DIAMOND), Items.ENCHANTED_GOLDEN_APPLE, 0.15f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Items.DIAMOND))
                .save(consumer, new ResourceLocation(CSMM.MODID, "notch_apple"));

        CookingRecipeBuilder.cooking(Ingredient.of(Items.EMERALD), Items.REDSTONE, 0.2f, 200, IRecipeSerializer.SMOKING_RECIPE)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Items.EMERALD))
                .save(consumer);

        CookingRecipeBuilder.blasting(Ingredient.of(Blocks.STONE), Blocks.IRON_DOOR, 0.5f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.IRON_BLOCK), Blocks.QUARTZ_BLOCK)
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(Blocks.IRON_BLOCK))
                .save(consumer, new ResourceLocation(CSMM.MODID, "iron_to_quartz"));

        SmithingRecipeBuilder.smithing(Ingredient.of(Items.STONE_PICKAXE), Ingredient.of(Items.EMERALD), Items.DIAMOND_PICKAXE)
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(Items.STONE_PICKAXE))
                .save(consumer, new ResourceLocation(CSMM.MODID, "stone_pickaxe_upgrade"));

    }
}
