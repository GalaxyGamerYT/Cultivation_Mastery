package galaxygameryt.cultivation_mastery.util;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WOOD_TRAINING_POST = createTag("wood_training_posts");
        public static final TagKey<Block> LOW_SPIRIT_STONE_ORES = createTag("low_spirit_stone_ores");
        public static final TagKey<Block> MEDIUM_SPIRIT_STONE_ORES = createTag("medium_spirit_stone_ores");
        public static final TagKey<Block> HIGH_SPIRIT_STONE_ORES = createTag("high_spirit_stone_ores");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(CultivationMastery.MOD_ID, name));

        }
    }

    public static class Items {
        public static final TagKey<Item> SPIRIT_STONES = createTag("spirit_stones");

        public static final TagKey<Item> WOOD_TRAINING_POST = createTag("wood_training_posts");
        public static final TagKey<Item> LOW_SPIRIT_STONE_ORES = createTag("low_spirit_stone_ores");
        public static final TagKey<Item> MEDIUM_SPIRIT_STONE_ORES = createTag("medium_spirit_stone_ores");
        public static final TagKey<Item> HIGH_SPIRIT_STONE_ORES = createTag("high_spirit_stone_ores");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(CultivationMastery.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> MEDIUM_SPIRIT_BIOMES = createTag("medium_spirit_biomes");
        public static final TagKey<Biome> HIGH_SPIRIT_BIOMES = createTag("high_spirit_biomes");

        public static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, new Identifier(CultivationMastery.MOD_ID, name));
        }
    }
}
