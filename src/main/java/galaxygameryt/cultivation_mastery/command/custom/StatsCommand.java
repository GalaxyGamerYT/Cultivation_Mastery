package galaxygameryt.cultivation_mastery.command.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.command.suggestion.SuggestionProviders;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Supplier;

public class StatsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(
                CommandManager.literal("cultivation")
                        .then(
                                CommandManager.literal("stats")
                                    .executes(StatsCommand::runAsPlayer)
                                        .then(
                                                CommandManager.argument("target", EntityArgumentType.player())
                                                        .requires(source -> source.hasPermissionLevel(3))
                                                        .executes(StatsCommand::runWithArg)
                                        )
                        )
        );
    }

    static Supplier<Text> content = () -> Text.literal("");

    private static int run(CommandContext<ServerCommandSource> context, ServerPlayerEntity playerEntity) {
        IEntityDataSaver playerData = (IEntityDataSaver)playerEntity;

        content = () -> Text.literal("Stats for "+String.format("%s",playerEntity.getName().getString())+"\n" +
                "Body: "+String.format("%.2f",playerData.getBodyLevel())+"\n" +
                "Qi: "+String.format("%.2f",playerData.getQiLevel())+"\n" +
                "Cultivation: "+String.format("%.2f",playerData.getCultivationLevel()));

        context.getSource().sendFeedback(content, false);

        return 1;
    }

    private static int runAsPlayer(CommandContext<ServerCommandSource> context) {
        ServerPlayerEntity playerEntity = context.getSource().getPlayer();
        return run(context, playerEntity);
    }

    private static int runWithArg(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity playerEntity = EntityArgumentType.getPlayer(context, "target");
        return run(context, playerEntity);
    }

}
