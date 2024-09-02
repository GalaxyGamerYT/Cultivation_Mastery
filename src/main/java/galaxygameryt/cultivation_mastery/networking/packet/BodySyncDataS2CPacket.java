package galaxygameryt.cultivation_mastery.networking.packet;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class BodySyncDataS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        float data = buf.readFloat();
        CultivationMastery.LOGGER.info(String.format("S2C Received - Body: %.2f", data));
        ((IEntityDataSaver) client.player).setBodyLevel(data);
    }
}
