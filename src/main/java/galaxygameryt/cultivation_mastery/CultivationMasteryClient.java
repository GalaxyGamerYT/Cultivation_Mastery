package galaxygameryt.cultivation_mastery;

import galaxygameryt.cultivation_mastery.client.BodyHudOverlay;
import net.fabricmc.api.ClientModInitializer;
import galaxygameryt.cultivation_mastery.event.KeyInputHandler;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class CultivationMasteryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        KeyInputHandler.register();

        HudRenderCallback.EVENT.register(new BodyHudOverlay());
    }
}
