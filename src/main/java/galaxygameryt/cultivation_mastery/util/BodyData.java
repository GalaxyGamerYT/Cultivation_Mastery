package galaxygameryt.cultivation_mastery.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import galaxygameryt.cultivation_mastery.networking.ModMessages;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class BodyData {

    public static float getBody(IEntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        float body = nbt.getFloat("body");
        return body;
    }

    public static float addBody(IEntityDataSaver player, float amount) {
        NbtCompound nbt = player.getPersistentData();
        float body = nbt.getFloat("body");

        body += amount;

        if (body >= 10) {
            body = 10;
        }

        syncBody(body, (ServerPlayerEntity) player);
        return body;
    }

    public static void syncBody(float body, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeFloat(body);
        ServerPlayNetworking.send(player, ModMessages.BODY_LEVEL_SYNC_ID, buffer);
    }
}
