package galaxygameryt.cultivation_mastery.world.feature;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LOW_SPIRIT_STONE_ORE_KEY = registryKey("low_spirit_stone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEDIUM_SPIRIT_STONE_ORE_KEY = registryKey("medium_spirit_stone_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HIGH_SPIRIT_STONE_ORE_KEY = registryKey("high_spirit_stone_ore");


//    public static final RegistryKey<ConfiguredFeature<?, ?>> LOW_SPIRIT_STONE_GEODE_KEY = registryKey("low_spirit_stone_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> lowSpiritStoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.LOW_SPIRIT_STONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> mediumSpiritStoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.MEDIUM_SPIRIT_STONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> highSpiritStoneOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.HIGH_SPIRIT_STONE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE.getDefaultState()));

        register(context, LOW_SPIRIT_STONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(lowSpiritStoneOres, 12));
        register(context, MEDIUM_SPIRIT_STONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(mediumSpiritStoneOres, 10));
        register(context, HIGH_SPIRIT_STONE_ORE_KEY, Feature.ORE, new OreFeatureConfig(highSpiritStoneOres, 8));

//        register(context, LOW_SPIRIT_STONE_GEODE_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(
//                BlockStateProvider.of(Blocks.AIR),
//                BlockStateProvider.of(Blocks.DEEPSLATE),
//                BlockStateProvider.of(ModBlocks.LOW_SPIRIT_STONE_ORE),
//                BlockStateProvider.of(Blocks.DIRT),
//                BlockStateProvider.of(Blocks.DIAMOND_BLOCK),
//                List.of(Blocks.BLACKSTONE.getDefaultState()),
//                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
//                new GeodeLayerThicknessConfig(1.7D,1.2D,2.5D,3.5D),
//                new GeodeCrackConfig(0.25D, 1.5D,1),
//                0.35D,0.0,true,
//                UniformIntProvider.create(4, 5),UniformIntProvider.create(3, 4),UniformIntProvider.create(1, 2),
//                -16,16,0.05,1));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(CultivationMastery.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
