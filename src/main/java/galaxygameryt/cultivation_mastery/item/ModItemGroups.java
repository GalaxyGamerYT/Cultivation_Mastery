package galaxygameryt.cultivation_mastery.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CULTIVATION_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CultivationMastery.MOD_ID, "cultivation"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cultivation"))
                    .icon(() -> new ItemStack(ModItems.YIN_YANG)).entries((displayContext, entries) -> {
                        entries.add(ModItems.YIN_YANG);
                        entries.add(ModItems.MANDALA);

                        entries.add(ModBlocks.OAK_TRAINING_POST);
                        entries.add(ModBlocks.SPRUCE_TRAINING_POST);
                        entries.add(ModBlocks.BIRCH_TRAINING_POST);
                        entries.add(ModBlocks.JUNGLE_TRAINING_POST);
                        entries.add(ModBlocks.ACACIA_TRAINING_POST);
                        entries.add(ModBlocks.DARK_OAK_TRAINING_POST);
                        entries.add(ModBlocks.MANGROVE_TRAINING_POST);
                        entries.add(ModBlocks.CHERRY_TRAINING_POST);

                        entries.add(ModBlocks.LOW_SPIRIT_STONE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LOW_SPIRIT_STONE_ORE);
                        entries.add(ModBlocks.MEDIUM_SPIRIT_STONE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_MEDIUM_SPIRIT_STONE_ORE);
                        entries.add(ModBlocks.HIGH_SPIRIT_STONE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_HIGH_SPIRIT_STONE_ORE);

                        entries.add(ModBlocks.GEM_CUTTER);

                        entries.add(ModItems.LOW_SPIRIT_STONE);
                        entries.add(ModItems.MEDIUM_SPIRIT_STONE);
                        entries.add(ModItems.HIGH_SPIRIT_STONE);
                    }).build());

    public static void regiserItemGroups() {
        CultivationMastery.LOGGER.info("Registering Item Groups for "+CultivationMastery.MOD_ID);
    }

}
