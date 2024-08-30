package galaxygameryt.cultivation_mastery.mixin;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class ModPlayerEntityDataServerMixin extends LivingEntity implements IEntityDataSaver {
    protected ModPlayerEntityDataServerMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    private static final TrackedData<Float> BODY_LEVEL = DataTracker.registerData(ModPlayerEntityDataServerMixin.class, TrackedDataHandlerRegistry.FLOAT);

    @Inject(method = "initDataTracker", at = @At(value = "HEAD"))
    protected void injectInitDataTrackerMethod(CallbackInfo ci) {
        this.dataTracker.startTracking(BODY_LEVEL, 0.0F);
    }

    @Override
    public float getBodyLevel() {
        return this.dataTracker.get(BODY_LEVEL);
    }

    @Override
    public void setBodyLevel(float data) {
        this.dataTracker.set(BODY_LEVEL, data);
        CultivationMastery.LOGGER.info(String.format("Setting data - Data: %.2f, BodyLevel: %.2f", data, getBodyLevel()));
    }

    @Inject(method = "writeCustomDataToNbt", at = @At(value = "HEAD"))
    protected void injectWriteCustomDataToNbtMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt != null) {
            nbt.putFloat("cultivation_mastery.body_level", getBodyLevel());
        }
    }

    @Inject(method = "readCustomDataFromNbt", at = @At(value = "HEAD"))
    protected void injectReadCustomDataFromNbtMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("cultivation_mastery.cultivation_data", 10)) {
            setBodyLevel(nbt.getFloat("cultivation_mastery.body_level"));
        }
    }
}
