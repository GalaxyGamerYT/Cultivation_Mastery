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

        player.setBodyLevel(body);
    }

    public static String getBodyLevel(IEntityDataSaver player) {
        float body = player.getBodyLevel();

        int index = getBodyIndex(body);

        String body_level = BODY_LEVELS[index]+" "+getBodyIncrement(body, index);
        return BODY_LEVELS[index];
    }

    public static String getBodyIncrement(float body, int body_level) {
        int index = getBodyIncrementIndex(body, body_level);

        String increment = BODY_INCREMENTS[index];

        return increment;
    }

    public static int getBodyIndex(float body) {
        int index = (int) Math.floor((double) body/10);
        return index;
    }

    public static int getBodyIncrementIndex(float body, int body_level) {
        int index = (int) Math.floor((double) body-(body_level*10));
        return index;
    }
}
