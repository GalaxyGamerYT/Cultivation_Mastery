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
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            int x = width/2;
            int y = height/2;
            float body = ((IEntityDataSaver) client.player).getBodyLevel();
            CultivationMastery.LOGGER.info(String.format("Body: %.2f", body));

//            if (body != 0) {
//            if (CultivationMastery.CONFIG.debug.showBodyHudOverlay) {
//            drawContext.drawText(client.textRenderer, String.format(String.valueOf(Text.translatable("hud.cultivation_mastery.text.body")), body), x, y, Colors.BLACK, false);
//            }
            drawContext.drawText(client.textRenderer, String.format("Body: %.2f", body), x, y, Colors.BLACK, false);
        }
    }
}
