package galaxygameryt.cultivation_mastery.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Category;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.TransitiveObject;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import galaxygameryt.cultivation_mastery.CultivationMastery;

@Config(name = CultivationMastery.MOD_ID)
public class ModConfig extends PartitioningSerializer.GlobalData {
    @Category("general")
    @TransitiveObject
    public General general = new General();

    @Category("debug")
    @TransitiveObject
    public Debug debug = new Debug();

    public ModConfig() {
    }

    @Config(name = "debug")
    public static final class Debug implements ConfigData {
//        @PrefixText
        @Tooltip
        public boolean essenceTooltipToggle = false;

        public Debug() {
        }
    }

    @Config(name = "general")
   public static final class General implements ConfigData {
        public General() {
        }
    }
}

