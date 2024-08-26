package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import galaxygameryt.cultivation_mastery.item.ModItems;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.SPIRIT_STONES)
                .add(ModItems.LOW_SPIRIT_STONE)
                .add(ModItems.MEDIUM_SPIRIT_STONE)
                .add(ModItems.HIGH_SPIRIT_STONE);

        getOrCreateTagBuilder(ModTags.Items.WOOD_TRAINING_POST)
                .add(new Identifier(CultivationMastery.MOD_ID, "oak_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "spruce_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "birch_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "jungle_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "acacia_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "dark_oak_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "mangrove_training_post"))
                .add(new Identifier(CultivationMastery.MOD_ID, "cherry_training_post"));

        getOrCreateTagBuilder(ModTags.Items.LOW_SPIRIT_STONE_ORES)
                .add(new Identifier(CultivationMastery.MOD_ID, "low_spirit_stone_ore"))
                .add(new Identifier(CultivationMastery.MOD_ID, "deepslate_low_spirit_stone_ore"));

        getOrCreateTagBuilder(ModTags.Items.MEDIUM_SPIRIT_STONE_ORES)
                .add(new Identifier(CultivationMastery.MOD_ID, "medium_spirit_stone_ore"))
                .add(new Identifier(CultivationMastery.MOD_ID, "deepslate_medium_spirit_stone_ore"));

        getOrCreateTagBuilder(ModTags.Items.HIGH_SPIRIT_STONE_ORES)
                .add(new Identifier(CultivationMastery.MOD_ID, "high_spirit_stone_ore"))
                .add(new Identifier(CultivationMastery.MOD_ID, "deepslate_high_spirit_stone_ore"));
    }
}
