package galaxygameryt.cultivation_mastery.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerCopyHandler implements ServerPlayerEvents.CopyFrom{
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        ((IEntityDataSaver) newPlayer).getPersistentData().putFloat("body",
                ((IEntityDataSaver) oldPlayer).getPersistentData().getFloat("body"));
    }
}
