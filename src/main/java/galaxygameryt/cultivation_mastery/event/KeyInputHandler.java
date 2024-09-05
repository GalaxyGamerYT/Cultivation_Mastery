package galaxygameryt.cultivation_mastery.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;


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
