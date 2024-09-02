package galaxygameryt.cultivation_mastery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.item.custom.EssenceItems;
import galaxygameryt.cultivation_mastery.item.custom.SpiritStoneItems;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item YIN_YANG = registerItem("yin_yang",
            new EssenceItems(new FabricItemSettings(),Formatting.DARK_BLUE));
    public static final Item MANDALA = registerItem("mandala",
            new EssenceItems(new FabricItemSettings(),Formatting.GOLD));

    public static final Item LOW_SPIRIT_STONE = registerItem("low_spirit_stone",
            new SpiritStoneItems(new FabricItemSettings()));
    public static final Item MEDIUM_SPIRIT_STONE = registerItem("medium_spirit_stone",
            new SpiritStoneItems(new FabricItemSettings()));
    public static final Item HIGH_SPIRIT_STONE = registerItem("high_spirit_stone",
            new SpiritStoneItems(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CultivationMastery.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CultivationMastery.LOGGER.info("Registering Mod Items for " + CultivationMastery.MOD_ID);
    }

}
