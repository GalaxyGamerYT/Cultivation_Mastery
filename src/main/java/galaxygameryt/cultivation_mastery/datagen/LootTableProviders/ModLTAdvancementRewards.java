package galaxygameryt.cultivation_mastery.datagen.LootTableProviders;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantWithLevelsLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class ModLTAdvancementRewards extends SimpleFabricLootTableProvider {
    public static final Identifier TEST_ADVANCEMENT_REWARD = new Identifier(CultivationMastery.MOD_ID,"advancement_rewards/test_loot");

    public ModLTAdvancementRewards(FabricDataOutput output) {
        super(output, LootContextTypes.ADVANCEMENT_REWARD);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> exporter) {
        exporter.accept(TEST_ADVANCEMENT_REWARD, LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.DIAMOND)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                        .with(ItemEntry.builder(Items.DIAMOND_SWORD))
                                .apply(EnchantWithLevelsLootFunction.builder(UniformLootNumberProvider.create(20.0F, 39.0F))))
        );
    }
}
