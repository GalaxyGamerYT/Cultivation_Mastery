package galaxygameryt.cultivation_mastery.item.custom;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EssenceItems extends Item {
    private final Formatting COLOUR;

    public EssenceItems(Settings settings, Formatting colour) {
        super(settings);
        this.COLOUR = colour;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        boolean toggle = CultivationMastery.CONFIG.debug.essenceTooltipToggle;
        if (!toggle) {
            tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.1")
                    .append(Text.translatable(String.format("tooltip.cultivation_mastery.$s",stack.getTranslationKey().split("[.]")[2]))
                                    .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)
                                    .formatted(Formatting.OBFUSCATED)));
//            if (stack.isOf(ModItems.YIN_YANG)) {
//                tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.1")
//                        .append(Text.translatable("tooltip.cultivation_mastery.yin_yang")
//                                .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)
//                                .formatted(Formatting.OBFUSCATED)
//                        )
//                );
//            } else if (stack.isOf(ModItems.MANDALA)) {
//                tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.1")
//                        .append(Text.translatable("tooltip.cultivation_mastery.mandala")
//                                .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)
//                                .formatted(Formatting.OBFUSCATED)
//                        )
//                );
//            }
        } else if (toggle) {
            tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.1")
                    .append(Text.translatable(String.format("tooltip.cultivation_mastery.%s",stack.getTranslationKey().split("[.]")[2]))
                            .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)));
//            if (stack.isOf(ModItems.YIN_YANG)) {
//                tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.2")
//                        .append(Text.translatable("tooltip.cultivation_mastery.yin_yang")
//                                .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)
//                        )
//                );
//            } else if (stack.isOf(ModItems.MANDALA)) {
//                tooltip.add(Text.translatable("tooltip.cultivation_mastery.essences.2")
//                        .append(Text.translatable("tooltip.cultivation_mastery.mandala")
//                                .formatted(COLOUR).formatted(Formatting.BOLD).formatted(Formatting.ITALIC)
//                        )
//                );
//            }
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
