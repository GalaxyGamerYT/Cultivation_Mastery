package galaxygameryt.cultivation_mastery.command;

import galaxygameryt.cultivation_mastery.command.custom.SetLevelsCommand;
import galaxygameryt.cultivation_mastery.command.custom.StatsCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class ModCommands {
    public static void registerCommands() {
        CommandRegistrationCallback.EVENT.register(StatsCommand::register);
        CommandRegistrationCallback.EVENT.register(SetLevelsCommand::register);
    }
}
