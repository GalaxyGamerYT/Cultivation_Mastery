package galaxygameryt.cultivation_mastery.util.data;

import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;

public class QiData {
    public static void addQi(IEntityDataSaver player, float multiplier) {
        float qi = player.getQiLevel();
        float qi_increase = player.getQiIncrease();
        float max_qi = player.getMaxQi();

        qi = qi + (qi_increase*multiplier);

        if (qi > max_qi) {
            qi = max_qi;
        }

        player.setQiLevel(qi);
    }

    public static float removeQi(IEntityDataSaver player, float amount) {
        float qi = player.getQiLevel();
        qi = qi - amount;
        return qi;
    }

}
