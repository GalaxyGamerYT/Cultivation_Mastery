package galaxygameryt.cultivation_mastery.util;

public interface IEntityDataSaver {

    float getBodyLevel();

    void setBodyLevel(float data);

    float getCultivationLevel();

    void setCultivationLevel(float data);

    float getQiLevel();

    void setQiLevel(float data);

    boolean getImmortality();

    void setImmortality(boolean data);

    float getMaxQi();

    void setMaxQi(float data);

    float getQiIncrease();

    void setQiIncrease(float data);

    boolean isImmortalToDamage(String check_type, float value);
}
