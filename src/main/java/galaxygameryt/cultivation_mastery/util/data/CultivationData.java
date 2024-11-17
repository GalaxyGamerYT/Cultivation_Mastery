package galaxygameryt.cultivation_mastery.util.data;

import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;

public class CultivationData {
    private static final String[] CULTIVATION_LEVELS = {
            "Mortal",
            "Body Forging",
            "Qi Gathering",
            "Core Condensation",
            "Golden Core",
            "Primordial Spirit",
            "Nascent Soul",
            "Divinity"
    };

    public static void increaseCultivation(IEntityDataSaver player) {
        float cultivation = player.getCultivationLevel();

        cultivation = cultivation + 0.1f;

        player.setCultivationLevel(cultivation);
    }

    public static String getCultivation(IEntityDataSaver player) {
        float cultivation = player.getBodyLevel();

        int index = (int) Math.floor((double) cultivation/10);

        return CULTIVATION_LEVELS[index];
    }

    public static void setCultivation(IEntityDataSaver player, float amount) {
        player.setCultivationLevel(amount);
    }
}
