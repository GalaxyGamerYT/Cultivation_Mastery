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
    private static final float maxBody = 70;

    public static void addBody(IEntityDataSaver player, float amount) {
        float currentBody = player.getBodyLevel();
        float body = 0;

        body = currentBody + amount;

        if (body > maxBody) {
            body = maxBody;
        }

        player.setBodyLevel(body);
    }

    public static void setBody(IEntityDataSaver player, float amount) {
        float body = 0;

        if (amount >= maxBody) {
            body = maxBody;
        } else if (amount <= 0) {
            body = 0;
        } else {
            body = amount;
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
