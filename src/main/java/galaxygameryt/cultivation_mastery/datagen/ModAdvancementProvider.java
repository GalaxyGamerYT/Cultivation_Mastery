package galaxygameryt.cultivation_mastery.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.item.ModItems;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootChoice;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import vazkii.patchouli.common.item.PatchouliItems;

import java.util.List;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(
                        ModItems.YIN_YANG, //Icon
                        Text.literal("Immortal Journey"), // Title
                        Text.literal("The start of your cultivation journey."), // Description
                        new Identifier(CultivationMastery.MOD_ID, "textures/item/yin_yang.png"), // Background Image
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("tick", TickCriterion.Conditions.createTick())
                .rewards(AdvancementRewards.Builder.loot(new Identifier(CultivationMastery.MOD_ID,"grant_book_on_first_join")))
                .build(consumer, CultivationMastery.MOD_ID+"/root");

        AdvancementEntry gotSpiritStonesAdvancement = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(
                        ModItems.LOW_SPIRIT_STONE,
                        Text.literal("Spiritual Energy"),
                        Text.literal("Your first contact with spiritual energy"),
                        null, // children to parent advancements don't need a background set
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_spirit_stones", InventoryChangedCriterion.Conditions.items(
                        ModItems.LOW_SPIRIT_STONE,
                        ModItems.MEDIUM_SPIRIT_STONE,
                        ModItems.HIGH_SPIRIT_STONE
                ))
                .build(consumer, CultivationMastery.MOD_ID+"/got_spirit_stones");

        AdvancementEntry gotDiamonds = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(
                        Items.DIAMOND,
                        Text.literal("Diamonds"),
                        Text.literal("Diamonds again..."),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_diamonds", InventoryChangedCriterion.Conditions.items(Items.DIAMOND))
                .rewards(AdvancementRewards.Builder.loot(new Identifier(CultivationMastery.MOD_ID, "advancement_rewards/test_loot")))
                .build(consumer, CultivationMastery.MOD_ID+"/got_diamonds");
    }
}
