package galaxygameryt.cultivation_mastery.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import galaxygameryt.cultivation_mastery.util.ModTags;
import galaxygameryt.cultivation_mastery.world.feature.ModPlacedFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.LOW_SPIRIT_STONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.MEDIUM_SPIRIT_BIOMES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.MEDIUM_SPIRIT_STONE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.tag(ModTags.Biomes.MEDIUM_SPIRIT_BIOMES),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.HIGH_SPIRIT_STONE_ORE_PLACED_KEY);

//        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
//                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.LOW_SPIRIT_STONE_GEODE_PLACED_KEY);


    }
}
