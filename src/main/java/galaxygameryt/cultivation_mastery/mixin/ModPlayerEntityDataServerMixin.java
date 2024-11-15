package galaxygameryt.cultivation_mastery.mixin;

import com.llamalad7.mixinextras.expression.Expression;
import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import galaxygameryt.cultivation_mastery.util.data.BodyData;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;

@Mixin(PlayerEntity.class)
public abstract class ModPlayerEntityDataServerMixin implements IEntityDataSaver {
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

    @Inject(method = "damage", at = @At(value = "HEAD"))
    protected void injectDamageMethod(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {

        int body_index = BodyData.getBodyIndex(getBodyLevel());
        ArrayList<RegistryKey<DamageType>> damage_type_list = new ArrayList<>();

        if (body_index >= 1) {
            if (body_index >= 2) {
                if (body_index >= 3) {
                    if (body_index >= 4) {
                        if (body_index >= 5) {
                            if (body_index >= 6) {
//                                Immortal Body
                                damage_type_list.add(DamageTypes.MAGIC);
                                damage_type_list.add(DamageTypes.OUTSIDE_BORDER);
                                damage_type_list.add(DamageTypes.OUT_OF_WORLD);
                                damage_type_list.add(DamageTypes.BAD_RESPAWN_POINT);
                                damage_type_list.add(DamageTypes.GENERIC_KILL);
                            }
//                            Golden Body
                            damage_type_list.add(DamageTypes.DRAGON_BREATH);
                            damage_type_list.add(DamageTypes.CRAMMING);
                            damage_type_list.add(DamageTypes.IN_WALL);
                            damage_type_list.add(DamageTypes.INDIRECT_MAGIC);
                            damage_type_list.add(DamageTypes.SONIC_BOOM);
                            damage_type_list.add(DamageTypes.WITHER);
                            damage_type_list.add(DamageTypes.WITHER_SKULL);
                            damage_type_list.add(DamageTypes.PLAYER_EXPLOSION);
                            damage_type_list.add(DamageTypes.LIGHTNING_BOLT);
                            damage_type_list.add(DamageTypes.MOB_ATTACK);
                        }
//                        Cell Forging
                        damage_type_list.add(DamageTypes.LAVA);
                        damage_type_list.add(DamageTypes.FREEZE);
                        damage_type_list.add(DamageTypes.FALLING_ANVIL);
                        damage_type_list.add(DamageTypes.MOB_ATTACK_NO_AGGRO);
                    }
//                    Skin Forging
                    damage_type_list.add(DamageTypes.ON_FIRE);
                    damage_type_list.add(DamageTypes.IN_FIRE);
                    damage_type_list.add(DamageTypes.STALAGMITE);
                    damage_type_list.add(DamageTypes.FALLING_STALACTITE);
                    damage_type_list.add(DamageTypes.MOB_PROJECTILE);
                    damage_type_list.add(DamageTypes.ARROW);
                    damage_type_list.add(DamageTypes.CACTUS);
                    damage_type_list.add(DamageTypes.FIREWORKS);
                    damage_type_list.add(DamageTypes.HOT_FLOOR);
                    damage_type_list.add(DamageTypes.STING);
                    damage_type_list.add(DamageTypes.SWEET_BERRY_BUSH);
                    damage_type_list.add(DamageTypes.THORNS);
                    damage_type_list.add(DamageTypes.TRIDENT);
                }
//                Bone Forging
                damage_type_list.add(DamageTypes.FALL);
                damage_type_list.add(DamageTypes.FLY_INTO_WALL);
                damage_type_list.add(DamageTypes.IN_WALL);
                damage_type_list.add(DamageTypes.FALLING_BLOCK);
            }
//            Organ Forging
            damage_type_list.add(DamageTypes.STARVE);
            damage_type_list.add(DamageTypes.DROWN);
            damage_type_list.add(DamageTypes.THROWN);
        }

        if (damage_type_list.contains(source.getTypeRegistryEntry())) {
            amount = 0f;
        }
    }

}
