package galaxygameryt.cultivation_mastery.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public class ModLivingEntityAsPlayerMixin {

    @Definition(id = "fireTicks", field = "Lnet/minecraft/entity/Entity;fireTicks")
    @Definition(id = "isInLava", field = "Lnet/minecraft/entity/Entity;isInLava()Z")
    @Expression("this.fireTicks ? 20 == 0 ?!this.isInLava()")
    @ModifyExpressionValue(method = "baseTick", at = @At("MIXINEXTRAS:EXPRESSION"))
    public boolean checkIfCultivatorHandler(boolean original) {
        return original && this.checkIfCultivator(original);
    }

    public boolean checkIfCultivator(boolean original) {
        boolean bl = this instanceof PlayerEntity;
        return false;
    }
}
