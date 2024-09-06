package galaxygameryt.cultivation_mastery.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import galaxygameryt.cultivation_mastery.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class ModLivingEntityAsPlayerMixin {
    Entity entity = (Entity) (Object) this;

    @Definition(id = "isInLava", field = "Lnet/minecraft/entity/Entity;isInLava()Z")
    @Expression("!this.isInLava()")
    @ModifyExpressionValue(method = "baseTick", at = @At(value = "MIXINEXTRAS:EXPRESSION"))
    public boolean checkBodyLevelHandler(boolean original) {
        return original && checkBodyLevel(original);
    }

    public boolean checkBodyLevel(boolean original) {
        boolean player_check = entity instanceof PlayerEntity;
        if (player_check) {
            IEntityDataSaver player = (IEntityDataSaver) entity;
            float body = player.getBodyLevel();
            boolean output = body > 3;
            return original && output;
        } else {
            return original;
        }
    }
}
