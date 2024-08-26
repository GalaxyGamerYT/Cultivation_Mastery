package galaxygameryt.cultivation_mastery.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.block.custom.TrainingPostBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // Wood Training Posts
    public static final Block OAK_TRAINING_POST = registerTrainingPost("oak_training_post",1.0f);
    public static final Block SPRUCE_TRAINING_POST = registerTrainingPost("spruce_training_post",1.0f);
    public static final Block BIRCH_TRAINING_POST = registerTrainingPost("birch_training_post",1.0f);
    public static final Block JUNGLE_TRAINING_POST = registerTrainingPost("jungle_training_post",1.0f);
    public static final Block ACACIA_TRAINING_POST = registerTrainingPost("acacia_training_post",1.0f);
    public static final Block DARK_OAK_TRAINING_POST = registerTrainingPost("dark_oak_training_post",1.0f);
    public static final Block MANGROVE_TRAINING_POST = registerTrainingPost("mangrove_training_post",1.0f);
    public static final Block CHERRY_TRAINING_POST = registerTrainingPost("cherry_training_post",1.0f);

    public static final Block LOW_SPIRIT_STONE_ORE = registerBlock("low_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_LOW_SPIRIT_STONE_ORE = registerBlock("deepslate_low_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f)));

    public static final Block MEDIUM_SPIRIT_STONE_ORE = registerBlock("medium_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,7), FabricBlockSettings.copyOf(Blocks.STONE).strength(2.5f)));
    public static final Block DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE = registerBlock("deepslate_medium_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,7), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4.5f)));

    public static final Block HIGH_SPIRIT_STONE_ORE = registerBlock("high_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(6,9), FabricBlockSettings.copyOf(Blocks.STONE).strength(3f)));
    public static final Block DEEPSLATE_HIGH_SPIRIT_STONE_ORE = registerBlock("deepslate_high_spirit_stone_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(5f)));

    public static Block registerTrainingPost(String name, float trainingMultiplier) {
        return registerBlock(name, new TrainingPostBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
                .nonOpaque()
                .sounds(BlockSoundGroup.WOOD)
                .strength(-2.0f, 2.0f),trainingMultiplier));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CultivationMastery.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CultivationMastery.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CultivationMastery.LOGGER.info("Registering Mod Blocks for "+CultivationMastery.MOD_ID);
    }
}
