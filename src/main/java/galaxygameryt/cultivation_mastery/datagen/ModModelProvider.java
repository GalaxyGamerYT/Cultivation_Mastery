package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import galaxygameryt.cultivation_mastery.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.OAK_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.SPRUCE_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.BIRCH_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.JUNGLE_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.ACACIA_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.DARK_OAK_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.MANGROVE_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.CHERRY_TRAINING_POST,
                BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LOW_SPIRIT_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MEDIUM_SPIRIT_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HIGH_SPIRIT_STONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.YIN_YANG, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANDALA, Models.GENERATED);

        itemModelGenerator.register(ModItems.LOW_SPIRIT_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEDIUM_SPIRIT_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HIGH_SPIRIT_STONE, Models.GENERATED);
    }
}
