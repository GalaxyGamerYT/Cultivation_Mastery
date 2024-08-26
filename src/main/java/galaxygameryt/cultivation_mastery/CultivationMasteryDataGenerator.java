package galaxygameryt.cultivation_mastery;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import galaxygameryt.cultivation_mastery.datagen.*;
import galaxygameryt.cultivation_mastery.datagen.LootTableProviders.ModLTAdvancementRewards;
import galaxygameryt.cultivation_mastery.datagen.LootTableProviders.ModLTBlock;
import galaxygameryt.cultivation_mastery.world.feature.ModConfiguredFeatures;
import galaxygameryt.cultivation_mastery.world.feature.ModPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class CultivationMasteryDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBiomeTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModAdvancementProvider::new);

		lootTableProviders(pack);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}

	public void lootTableProviders(FabricDataGenerator.Pack pack) {
		pack.addProvider(ModLTBlock::new);
		pack.addProvider(ModLTAdvancementRewards::new);
	}
}
