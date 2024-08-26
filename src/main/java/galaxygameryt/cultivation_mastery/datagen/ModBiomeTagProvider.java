package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.vanilla.VanillaBiomeTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagProvider extends VanillaBiomeTagProvider {
    public ModBiomeTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Biomes.MEDIUM_SPIRIT_BIOMES)
                .add(BiomeKeys.BAMBOO_JUNGLE)
                .add(BiomeKeys.BIRCH_FOREST)
                .add(BiomeKeys.CHERRY_GROVE)
                .add(BiomeKeys.CRIMSON_FOREST)
                .add(BiomeKeys.DARK_FOREST)
                .add(BiomeKeys.FLOWER_FOREST)
                .add(BiomeKeys.FOREST)
                .add(BiomeKeys.JUNGLE)
                .add(BiomeKeys.GROVE)
                .add(BiomeKeys.LUSH_CAVES)
                .add(BiomeKeys.MANGROVE_SWAMP)
                .add(BiomeKeys.MEADOW)
                .add(BiomeKeys.MUSHROOM_FIELDS)
                .add(BiomeKeys.OLD_GROWTH_BIRCH_FOREST)
                .add(BiomeKeys.OLD_GROWTH_PINE_TAIGA)
                .add(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA)
                .add(BiomeKeys.SAVANNA)
                .add(BiomeKeys.SAVANNA_PLATEAU)
                .add(BiomeKeys.SNOWY_SLOPES)
                .add(BiomeKeys.SNOWY_TAIGA)
                .add(BiomeKeys.SOUL_SAND_VALLEY)
                .add(BiomeKeys.SPARSE_JUNGLE)
                .add(BiomeKeys.SUNFLOWER_PLAINS)
                .add(BiomeKeys.SWAMP)
                .add(BiomeKeys.TAIGA)
                .add(BiomeKeys.WARPED_FOREST)
                .add(BiomeKeys.WINDSWEPT_FOREST)
                .add(BiomeKeys.WINDSWEPT_SAVANNA);

        getOrCreateTagBuilder(ModTags.Biomes.HIGH_SPIRIT_BIOMES)
                .add(BiomeKeys.DEEP_COLD_OCEAN)
                .add(BiomeKeys.DEEP_DARK)
                .add(BiomeKeys.DEEP_OCEAN)
                .add(BiomeKeys.DEEP_FROZEN_OCEAN)
                .add(BiomeKeys.DEEP_LUKEWARM_OCEAN)
                .add(BiomeKeys.END_BARRENS)
                .add(BiomeKeys.END_HIGHLANDS)
                .add(BiomeKeys.END_MIDLANDS)
                .add(BiomeKeys.SMALL_END_ISLANDS)
                .add(BiomeKeys.THE_END)
                .add(BiomeKeys.FROZEN_OCEAN)
                .add(BiomeKeys.FROZEN_PEAKS)
                .add(BiomeKeys.FROZEN_RIVER)
                .add(BiomeKeys.ICE_SPIKES)
                .add(BiomeKeys.JAGGED_PEAKS)
                .add(BiomeKeys.STONY_PEAKS);
    }
}
