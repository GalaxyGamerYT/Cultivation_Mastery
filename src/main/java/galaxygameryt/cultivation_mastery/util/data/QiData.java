package galaxygameryt.cultivation_mastery.util.data;

import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;

public class QiData {
    public static void addQi(IEntityDataSaver player, float multiplier) {
        float currentQi = player.getQiLevel();
        float qi_increase = player.getQiIncrease();
        float max_qi = player.getMaxQi();
        float qi = 0;

        qi = currentQi + (qi_increase*multiplier);

        if (qi > max_qi) {
            qi = max_qi;
        }

        player.setQiLevel(qi);
    }

    public static float removeQi(IEntityDataSaver player, float amount) {
        float currentQi = player.getQiLevel();
        float qi = 0;

        qi = currentQi - amount;

        return qi;
    }

    public static void setQi(IEntityDataSaver player, float amount) {
        float max_qi = player.getMaxQi();
        float qi = 0;

        if (amount >= max_qi) {
            qi = max_qi;
        } else if (amount <= 0) {
            qi = 0;
        } else {
            qi = amount;
        }

        player.setQiLevel(qi);
    }

}
