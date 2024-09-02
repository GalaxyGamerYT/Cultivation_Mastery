package galaxygameryt.cultivation_mastery;

import galaxygameryt.cultivation_mastery.client.BodyHudOverlay;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import galaxygameryt.cultivation_mastery.event.ClientPlayConnectionJoin;
import galaxygameryt.cultivation_mastery.event.KeyInputHandler;
import galaxygameryt.cultivation_mastery.networking.ModMessages;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class CultivationMasteryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();
//        ModMessages.registerS2CPackets();

//        ClientPlayConnectionEvents.JOIN.register(new ClientPlayConnectionJoin());

        HudRenderCallback.EVENT.register(new BodyHudOverlay());
    }
}
