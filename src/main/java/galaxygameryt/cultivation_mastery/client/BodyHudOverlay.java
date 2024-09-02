package galaxygameryt.cultivation_mastery.client;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class BodyHudOverlay implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        int x = width/6;
        int y = (height/4)*3;
        float body = ((IEntityDataSaver) client.player).getBodyLevel();
//      CultivationMastery.LOGGER.info(String.format("Body: %.2f", body));

        if (body != 0 || CultivationMastery.CONFIG.debug.showBodyHudOverlay) {
//            drawContext.fill(
//                    width/6,
//                    (height/4)*3,
//                    width/4,
//                    (height/6)*3,
//                    Colors.WHITE
//            );
//            drawContext.drawText(
//                    client.textRenderer,
//                    String.format("Body: %.2f", body),
//                    width/6,
//                    (height/4)*3,
//                    Colors.BLACK,
//                    false
//            );
            drawContext.drawText(
                    client.textRenderer,
                    String.format("Body: %.2f", body),
                    x,
                    y,
                    Colors.BLACK,
                    false
            );
        }
    }
}
