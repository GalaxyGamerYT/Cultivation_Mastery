package galaxygameryt.cultivation_mastery.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import galaxygameryt.cultivation_mastery.networking.ModMessages;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class ClientPlayConnectionJoin implements ClientPlayConnectionEvents.Join{
    @Override
    public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        ClientPlayNetworking.send(ModMessages.BODY_LEVEL_ID, PacketByteBufs.create());
    }
}
