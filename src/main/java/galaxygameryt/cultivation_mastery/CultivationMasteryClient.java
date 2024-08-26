package galaxygameryt.cultivation_mastery;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import galaxygameryt.cultivation_mastery.event.ClientPlayConnectionJoin;
import galaxygameryt.cultivation_mastery.event.KeyInputHandler;
import galaxygameryt.cultivation_mastery.networking.ModMessages;

public class CultivationMasteryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        ClientPlayConnectionEvents.JOIN.register(new ClientPlayConnectionJoin());
    }
}
