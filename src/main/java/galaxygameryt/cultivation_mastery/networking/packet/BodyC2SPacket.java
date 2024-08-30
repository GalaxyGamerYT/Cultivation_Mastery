package galaxygameryt.cultivation_mastery.networking.packet;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import galaxygameryt.cultivation_mastery.util.BodyData;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class BodyC2SPacket {
    private static final String MESSAGE_BODY_INCREASE = "message.cultivation_mastery.body_increase";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        ServerWorld world = (ServerWorld) player.getWorld();
        float data = buf.readFloat();
        CultivationMastery.LOGGER.info("C2S Received");
        float bodyLevel = BodyData.addBody((IEntityDataSaver) player, data);
        world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.PLAYERS,
                0.5F, world.random.nextFloat() * 0.1F + 0.9F);
        player.sendMessage(Text.literal(String.format("Body: %.2f", ((IEntityDataSaver) player).getBodyLevel()))
                .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), false);
    }
}
