package disable.shulker.breeding.mixin;

import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Shulker.class)
public class ShulkerMixin {

    //Redirect the call to hitByShulkerBullet() to effectively disable the duplication
    @Redirect(
            method = "hurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/monster/Shulker;hitByShulkerBullet()V"
            )
    )
    private void disableShulkerBreeding$disableShulkerDuplication(Shulker instance) {}

}
