package galaxygameryt.cultivation_mastery.mixin;

import galaxygameryt.cultivation_mastery.CultivationMastery;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataServerMixin implements IEntityDataSaver {

    private TrackedData<Float> BODY_LEVEL;

//    @Shadow @Final DataTracker dataTracker;
    DataTracker dataTracker = ((Entity)(Object)this).getDataTracker();

    @Shadow
    protected void initDataTracker() {
        dataTracker.startTracking(BODY_LEVEL, 0.0F);
    }

    @Override
    public float getBodyLevel() {
        return dataTracker.get(BODY_LEVEL);
    }

    @Override
    public void setBodyLevel(float data) {
        dataTracker.set(BODY_LEVEL, data);
        CultivationMastery.LOGGER.info(String.format("Setting data - Data: %.2f, BodyLevel: %.2f", data, getBodyLevel()));
    }

    @Inject(method = "writeNbt", at = @At(value = "HEAD"))
    protected void injectWriteNbtMethod(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (nbt != null) {
            nbt.putFloat("cultivation_mastery.body_level", getBodyLevel());
        }
    }

    @Inject(method = "readNbt", at = @At(value = "HEAD"))
    protected void injectReadNbtMethod(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("cultivation_mastery.cultivation_data", 10)) {
            setBodyLevel(nbt.getFloat("cultivation_mastery.body_level"));
        }
    }
}
