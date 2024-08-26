package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import galaxygameryt.cultivation_mastery.item.ModItems;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> LOW_SPIRIT_STONE_SMELTABLES = List.of(ModBlocks.LOW_SPIRIT_STONE_ORE, ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE);
    private static final List<ItemConvertible> MEDIUM_SPIRIT_STONE_SMELTABLES = List.of(ModBlocks.MEDIUM_SPIRIT_STONE_ORE, ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE);
    private static final List<ItemConvertible> HIGH_SPIRIT_STONE_SMELTABLES = List.of(ModBlocks.HIGH_SPIRIT_STONE_ORE, ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateTrainingPostRecipe(exporter, ModBlocks.OAK_TRAINING_POST, Blocks.OAK_PLANKS, Blocks.OAK_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.SPRUCE_TRAINING_POST, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.BIRCH_TRAINING_POST, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.JUNGLE_TRAINING_POST, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.ACACIA_TRAINING_POST, Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.DARK_OAK_TRAINING_POST, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.MANGROVE_TRAINING_POST, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG);
        generateTrainingPostRecipe(exporter, ModBlocks.CHERRY_TRAINING_POST, Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.YIN_YANG,1)
                .pattern("BBW")
                .pattern("B W")
                .pattern("BWW")
                .input('B', Items.BLACK_CONCRETE)
                .input('W', Items.WHITE_CONCRETE)
                .criterion(hasItem(Items.BLACK_CONCRETE), conditionsFromItem(Items.BLACK_CONCRETE))
                .criterion(hasItem(Items.WHITE_CONCRETE), conditionsFromItem(Items.WHITE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.YIN_YANG)));

        offerSmelting(exporter, LOW_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.LOW_SPIRIT_STONE,
                0.7f, 200, "low_spirit_stone_smelting");
        offerBlasting(exporter, LOW_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.LOW_SPIRIT_STONE,
                0.7f, 200, "low_spirit_stone_blasting");

        offerSmelting(exporter, MEDIUM_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.MEDIUM_SPIRIT_STONE,
                0.7f, 200, "medium_spirit_stone_smelting");
        offerBlasting(exporter, MEDIUM_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.MEDIUM_SPIRIT_STONE,
                0.7f, 200, "medium_spirit_stone_blasting");

        offerSmelting(exporter, HIGH_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.HIGH_SPIRIT_STONE,
                0.7f, 200, "high_spirit_stone_smelting");
        offerBlasting(exporter, HIGH_SPIRIT_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.HIGH_SPIRIT_STONE,
                0.7f, 200, "high_spirit_stone_blasting");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LOW_SPIRIT_STONE, 9)
                .input(ModItems.MEDIUM_SPIRIT_STONE)
                .criterion(hasItem(ModItems.MEDIUM_SPIRIT_STONE), conditionsFromItem(ModItems.MEDIUM_SPIRIT_STONE))
                .offerTo(exporter, new Identifier("low_spirit_stones_from_medium_spirit_stone"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MEDIUM_SPIRIT_STONE)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.LOW_SPIRIT_STONE)
                .group("medium_spirit_stone")
                .criterion(hasItem(ModItems.LOW_SPIRIT_STONE), conditionsFromItem(ModItems.LOW_SPIRIT_STONE))
                .offerTo(exporter, new Identifier("medium_spirit_stone_from_low_spirit_stones"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MEDIUM_SPIRIT_STONE, 9)
                .input(ModItems.HIGH_SPIRIT_STONE)
                .group("medium_spirit_stone")
                .criterion(hasItem(ModItems.HIGH_SPIRIT_STONE), conditionsFromItem(ModItems.HIGH_SPIRIT_STONE))
                .offerTo(exporter, new Identifier("medium_spirit_stones_from_high_spirit_stone"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HIGH_SPIRIT_STONE)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.MEDIUM_SPIRIT_STONE)
                .criterion(hasItem(ModItems.MEDIUM_SPIRIT_STONE), conditionsFromItem(ModItems.MEDIUM_SPIRIT_STONE))
                .offerTo(exporter, new Identifier("high_spirit_stone_from_medium_spirit_stones"));
    }

    public void generateTrainingPostRecipe(RecipeExporter exporter, Block output, Block base, Block pillar) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, output, 1)
                .pattern(" P ")
                .pattern(" P ")
                .pattern("BBB")
                .input('P', pillar)
                .input('B', base)
                .criterion(hasItem(pillar), conditionsFromItem(pillar))
                .criterion(hasItem(base), conditionsFromItem(base))
                .offerTo(exporter, new Identifier(getRecipeName(output)));
    }
}
