package galaxygameryt.cultivation_mastery.client;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import galaxygameryt.cultivation_mastery.util.data.BodyData;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;

public class BodyHudOverlay implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        int x = 70;
        int y = 70;

        IEntityDataSaver player = (IEntityDataSaver) client.player;

        float body = player.getBodyLevel();
//        String body_level = BodyData.getBodyLevel(player);

        Identifier hud_background_scoll_texture = new Identifier(CultivationMastery.MOD_ID, "hud/hud_background_scroll.png");

        int screen_margin = 20;
        int scroll_width = 64;
        int scroll_height = 64;
        int scroll_margin = 20;
        int font_height = 7;

        if (body != 0 || CultivationMastery.CONFIG.debug.showBodyHudOverlay) {
//            drawContext.drawTexture(
//                    hud_background_scoll_texture,
//                    screen_margin,
//                    height-scroll_width-screen_margin,
//                    0,
//                    0,
//                    scroll_width,
//                    scroll_height
//            );
//            drawContext.drawText(
//                    client.textRenderer,
//                    String.format("Body: %s", body_level),
//                    screen_margin+scroll_margin,
//                    screen_margin-(int) Math.floor((double) scroll_height/2)-(int) Math.floor((double) font_height/2),
//                    Colors.BLACK,
//                    false
//            );
        }
    }
}
