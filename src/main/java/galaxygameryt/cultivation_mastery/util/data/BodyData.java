package galaxygameryt.cultivation_mastery.util.data;

import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.entity.player.PlayerEntity;

public class BodyData {
    private static final String[] BODY_LEVELS = {
            "Mortal",
            "Organ Forging",
            "Bone Forging",
            "Skin Forging",
            "Cell Forging",
            "Golden Body",
            "Immortal Body"
    };
    private static final String[] BODY_INCREMENTS = {"I","II","III","IV","V","VI","VII","VIII","IX"};

    public static void addBody(IEntityDataSaver player, float amount) {
        float body = player.getBodyLevel();

        body = body + amount;

        if (body > 70) {
            body = 70;
        }
        if (body >= 30) {
            ((PlayerEntity) player)
        }

        player.setBodyLevel(body);
    }

    public static String getBodyLevel(IEntityDataSaver player) {
        float body = player.getBodyLevel();

        int index = (int) Math.floor((double) body/10);

        String body_level = BODY_LEVELS[index]+" "+getBodyIncrement(player, body, index);
        return BODY_LEVELS[index];
    }

    public static String getBodyIncrement(IEntityDataSaver player, float body, int body_level) {
        int index = (int) Math.floor((double) body-(body_level*10));

        String increment = BODY_INCREMENTS[index];

        return increment;
    }
}
