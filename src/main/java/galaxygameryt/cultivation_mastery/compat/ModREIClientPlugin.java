package galaxygameryt.cultivation_mastery.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.ModTags;
import net.minecraft.util.Identifier;

public class ModREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        REIClientPlugin.super.registerCategories(registry);
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        REIClientPlugin.super.registerDisplays(registry);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        REIClientPlugin.super.registerScreens(registry);
    }

    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        REIClientPlugin.super.registerCollapsibleEntries(registry);
//        registry.group(new Identifier(CultivationMastery.MOD_ID, "wood_training_post_entry"),
//                EntryIngredients.ofTag(ModTags.Blocks.WOOD_TRAINING_POST,));
    }
}
