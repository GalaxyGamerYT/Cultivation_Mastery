package galaxygameryt.cultivation_mastery.command.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import galaxygameryt.cultivation_mastery.util.data.BodyData;
import galaxygameryt.cultivation_mastery.util.data.CultivationData;
import galaxygameryt.cultivation_mastery.util.data.QiData;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.function.Supplier;

public class SetLevelsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(
                CommandManager.literal("cultivation")
                        .then(
                                CommandManager.literal("set")
                                        .requires(source -> source.hasPermissionLevel(4))
                                        .then(
                                                CommandManager.argument("target", EntityArgumentType.player())
                                                        .then(
                                                                CommandManager.literal("body")
                                                                        .then(
                                                                                CommandManager.argument("amount", FloatArgumentType.floatArg(0, 70))
                                                                                        .executes(SetLevelsCommand::bodyRun)
                                                                        )
                                                        )
                                                        .then(
                                                                CommandManager.literal("qi")
                                                                        .then(
                                                                                CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                                                                                        .executes(SetLevelsCommand::qiRun)
                                                                        )
                                                        )
                                                        .then(
                                                                CommandManager.literal("cultivation")
                                                                        .then(
                                                                                CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                                                                                        .executes(SetLevelsCommand::cultivationRun)
                                                                        )
                                                        )
                                        )
                        )
        );
    }

    static Supplier<Text> content = () -> Text.literal("");

    private static int run(CommandContext<ServerCommandSource> context, String type) throws CommandSyntaxException {
        ServerPlayerEntity playerEntity = EntityArgumentType.getPlayer(context, "target");
        float amount = FloatArgumentType.getFloat(context, "amount");

        IEntityDataSaver playerData = (IEntityDataSaver)playerEntity;

        if (type == "body") {
            BodyData.setBody(playerData, amount);
        } else if (type == "qi") {
            QiData.setQi(playerData, amount);
        } else if (type == "cultivation") {
            CultivationData.setCultivation(playerData, amount);
        }

        content = () -> Text.literal("Body has been set to "+amount);

        context.getSource().sendFeedback(content, false);

        return 1;
    }

    private static int qiRun(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, "qi");
    }

    private static int cultivationRun(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, "cultivation");
    }

    private static int bodyRun(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        return run(context, "body");
    }
}
