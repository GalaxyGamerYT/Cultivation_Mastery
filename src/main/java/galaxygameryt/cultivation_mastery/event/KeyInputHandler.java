package galaxygameryt.cultivation_mastery.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import galaxygameryt.cultivation_mastery.networking.ModMessages;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_CULTIVATION_MASTERY = "key.category.cultivation_mastery.debug";
//    public static final String KEY_YIN_YANG_TOOLTIP_TOGGLE = "key.cultivation_mastery.yin_yang_tooltip_toggle";

//    public static KeyBinding yinYangTooltipToggleKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            if (yinYangTooltipToggleKey.wasPressed()) {
//                ClientPlayNetworking.send(ModMessages.YIN_YANG_TOOLTIP_TOGGLE_ID, PacketByteBufs.create());
//            }
        });
    }
    public static void register() {
//        yinYangTooltipToggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
//                KEY_YIN_YANG_TOOLTIP_TOGGLE,
//                InputUtil.Type.KEYSYM,
//                GLFW.GLFW_KEY_F12,
//                KEY_CATEGORY_CULTIVATION_MASTERY
//        ));

        registerKeyInputs();
    }
}
