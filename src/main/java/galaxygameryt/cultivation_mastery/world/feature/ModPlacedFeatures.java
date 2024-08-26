package galaxygameryt.cultivation_mastery.world.feature;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.world.ModOrePlacement;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LOW_SPIRIT_STONE_ORE_PLACED_KEY = registerKey("low_spirit_stone_placed");
    public static final RegistryKey<PlacedFeature> MEDIUM_SPIRIT_STONE_ORE_PLACED_KEY = registerKey("medium_spirit_stone_placed");
    public static final RegistryKey<PlacedFeature> HIGH_SPIRIT_STONE_ORE_PLACED_KEY = registerKey("high_spirit_stone_placed");


    public static final RegistryKey<PlacedFeature> LOW_SPIRIT_STONE_GEODE_PLACED_KEY = registerKey("low_spirit_stone_geode_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, LOW_SPIRIT_STONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LOW_SPIRIT_STONE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, MEDIUM_SPIRIT_STONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MEDIUM_SPIRIT_STONE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(10, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, HIGH_SPIRIT_STONE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HIGH_SPIRIT_STONE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(8, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

//        register(context, LOW_SPIRIT_STONE_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LOW_SPIRIT_STONE_GEODE_KEY),
//                List.of(RarityFilterPlacementModifier.of(42),
//                        SquarePlacementModifier.of(),
//                        HeightRangePlacementModifier.uniform(YOffset.aboveBottom(6), YOffset.aboveBottom(50)),
//                        BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(CultivationMastery.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
