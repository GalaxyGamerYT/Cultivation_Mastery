package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.WOOD_TRAINING_POST)
                .add(ModBlocks.OAK_TRAINING_POST)
                .add(ModBlocks.SPRUCE_TRAINING_POST)
                .add(ModBlocks.BIRCH_TRAINING_POST)
                .add(ModBlocks.JUNGLE_TRAINING_POST)
                .add(ModBlocks.ACACIA_TRAINING_POST)
                .add(ModBlocks.DARK_OAK_TRAINING_POST)
                .add(ModBlocks.MANGROVE_TRAINING_POST)
                .add(ModBlocks.CHERRY_TRAINING_POST);

        getOrCreateTagBuilder(ModTags.Blocks.LOW_SPIRIT_STONE_ORES)
                .add(ModBlocks.LOW_SPIRIT_STONE_ORE)
                .add(ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.MEDIUM_SPIRIT_STONE_ORES)
                .add(ModBlocks.MEDIUM_SPIRIT_STONE_ORE)
                .add(ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE);
        getOrCreateTagBuilder(ModTags.Blocks.HIGH_SPIRIT_STONE_ORES)
                .add(ModBlocks.HIGH_SPIRIT_STONE_ORE)
                .add(ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(ModTags.Blocks.LOW_SPIRIT_STONE_ORES)
                .forceAddTag(ModTags.Blocks.MEDIUM_SPIRIT_STONE_ORES)
                .forceAddTag(ModTags.Blocks.HIGH_SPIRIT_STONE_ORES);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModTags.Blocks.LOW_SPIRIT_STONE_ORES);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(ModTags.Blocks.MEDIUM_SPIRIT_STONE_ORES);
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .forceAddTag(ModTags.Blocks.HIGH_SPIRIT_STONE_ORES);

    }
}
