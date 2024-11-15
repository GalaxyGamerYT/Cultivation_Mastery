package galaxygameryt.cultivation_mastery.datagen.LootTableProviders;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import galaxygameryt.cultivation_mastery.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.state.property.Properties;

public class ModLTBlock extends FabricBlockLootTableProvider {
    public ModLTBlock(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.OAK_TRAINING_POST, doorLikeDrops(ModBlocks.OAK_TRAINING_POST));
        addDrop(ModBlocks.SPRUCE_TRAINING_POST, doorLikeDrops(ModBlocks.SPRUCE_TRAINING_POST));
        addDrop(ModBlocks.BIRCH_TRAINING_POST, doorLikeDrops(ModBlocks.BIRCH_TRAINING_POST));
        addDrop(ModBlocks.JUNGLE_TRAINING_POST, doorLikeDrops(ModBlocks.JUNGLE_TRAINING_POST));
        addDrop(ModBlocks.ACACIA_TRAINING_POST, doorLikeDrops(ModBlocks.ACACIA_TRAINING_POST));
        addDrop(ModBlocks.DARK_OAK_TRAINING_POST, doorLikeDrops(ModBlocks.DARK_OAK_TRAINING_POST));
        addDrop(ModBlocks.MANGROVE_TRAINING_POST, doorLikeDrops(ModBlocks.MANGROVE_TRAINING_POST));
        addDrop(ModBlocks.CHERRY_TRAINING_POST, doorLikeDrops(ModBlocks.CHERRY_TRAINING_POST));

        addDrop(ModBlocks.LOW_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_SPIRIT_STONE_ORE, ModItems.LOW_SPIRIT_STONE));
        addDrop(ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE, ModItems.LOW_SPIRIT_STONE));
        addDrop(ModBlocks.LOW_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_SPIRIT_STONE_ORE, ModItems.MEDIUM_SPIRIT_STONE));
        addDrop(ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE, ModItems.MEDIUM_SPIRIT_STONE));
        addDrop(ModBlocks.LOW_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.LOW_SPIRIT_STONE_ORE, ModItems.HIGH_SPIRIT_STONE));
        addDrop(ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE, ModItems.HIGH_SPIRIT_STONE));

        addDrop(ModBlocks.GEM_CUTTER, doorLikeDrops(ModBlocks.GEM_CUTTER));

    }

    public LootTable.Builder doorLikeDrops(Block block) {
        return this.dropsWithProperty(block, Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER);
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(
                drop, (LootPoolEntry.Builder)this.applyExplosionDecay(
                        drop, ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }

}
