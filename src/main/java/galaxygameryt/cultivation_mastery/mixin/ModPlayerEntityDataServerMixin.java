package galaxygameryt.cultivation_mastery.mixin;

import com.llamalad7.mixinextras.expression.Expression;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class ModPlayerEntityDataServerMixin implements IEntityDataSaver {
//tickControlled
    private static float body_level = 0f;
    private static float cultivation_level = 0f;
    private static float qi_level = 0f;

    private static float max_qi = 0f;
    private static float qi_increase = 0f;
    private static boolean immortality = false;

    @Override
    public float getBodyLevel() {
        return body_level;
    }

    @Override
    public void setBodyLevel(float data) {
        body_level = data;
    }

    @Override
    public float getCultivationLevel(){
        return cultivation_level;
    }

    @Override
    public void setCultivationLevel(float data) {
        cultivation_level = data;
    }

    @Override
    public float getQiLevel(){
        return qi_level;
    }

    @Override
    public void setQiLevel(float data) {
        qi_level = data;
    }

    @Override
    public boolean getImmortality(){
        return immortality;
    }

    @Override
    public void setImmortality(boolean data) {
        immortality = data;
    }

    @Override
    public float getMaxQi(){
        return max_qi;
    }

    @Override
    public void setMaxQi(float data) {
        max_qi = data;
    }

    @Override
    public float getQiIncrease(){
        return qi_increase;
    }

    @Override
    public void setQiIncrease(float data) {
        qi_increase = data;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At(value = "TAIL"))
    protected void injectWriteCustomDataToNbtMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt != null) {
            nbt.putFloat(CultivationMastery.MOD_ID+".body_level", body_level);
            nbt.putFloat(CultivationMastery.MOD_ID+".cultivation_level", cultivation_level);
            nbt.putFloat(CultivationMastery.MOD_ID+".qi_level", qi_level);
            nbt.putFloat(CultivationMastery.MOD_ID+".max_qi_level", max_qi);
            nbt.putFloat(CultivationMastery.MOD_ID+".qi_increase", qi_increase);
            nbt.putBoolean(CultivationMastery.MOD_ID+".immortality", immortality);
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At(value = "TAIL"))
    protected void injectReadCustomDataFromNbtMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains(CultivationMastery.MOD_ID+".body_level")) {
            body_level = nbt.getFloat(CultivationMastery.MOD_ID+".body_level");
        }
        if (nbt.contains(CultivationMastery.MOD_ID+".cultivation_level")) {
            cultivation_level = nbt.getFloat(CultivationMastery.MOD_ID+".cultivation_level");
        }
        if (nbt.contains(CultivationMastery.MOD_ID+".qi_level")) {
            qi_level = nbt.getFloat(CultivationMastery.MOD_ID+".qi_level");
        }
        if (nbt.contains(CultivationMastery.MOD_ID+".max_qi_level")) {
            max_qi = nbt.getFloat(CultivationMastery.MOD_ID+".max_qi_level");
        }
        if (nbt.contains(CultivationMastery.MOD_ID+".qi_increase")) {
            qi_increase = nbt.getFloat(CultivationMastery.MOD_ID+".qi_increase");
        }
        if (nbt.contains(CultivationMastery.MOD_ID+".immortality")) {
            immortality = nbt.getBoolean(CultivationMastery.MOD_ID+".immortality");
        }
    }

    @Expression("return amount == 0.0")
    @Inject(method = "damage", at = @At(value = "MIXINEXTRAS:EXPRESSION", shift = At.Shift.BEFORE))
    protected float injectDamageMethod(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {
        if (source.isIn(DamageTypeTags.IS_FIRE)) {

        }
    }

    @Override
    public boolean isImmortalToDamage(String check_type, float value) {
        if (check_type == "body") {
            return body_level > value;
        } else if (check_type == "cultivation") {
            return cultivation_level > value;
        }
    }
}
