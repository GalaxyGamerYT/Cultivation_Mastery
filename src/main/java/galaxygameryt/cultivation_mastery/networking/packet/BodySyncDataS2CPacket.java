package galaxygameryt.cultivation_mastery.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class BodySyncDataS2CPacket {
    public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        float data = buf.readFloat();
        ((IEntityDataSaver) client.player).setBodyLevel(data);
    }
}
