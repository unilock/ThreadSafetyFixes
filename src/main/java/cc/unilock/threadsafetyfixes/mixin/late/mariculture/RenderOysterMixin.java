package cc.unilock.threadsafetyfixes.mixin.late.mariculture;

import mariculture.core.render.RenderBase;
import mariculture.core.render.RenderOyster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderOyster.class, remap = false)
public class RenderOysterMixin {
    @Inject(method = "init", at = @At("HEAD"), cancellable = true)
    private void init$getStackInSlot(CallbackInfo ci) {
        RenderBase that = (RenderBase) (Object) this;
        if (that.world.getTileEntity(that.x, that.y, that.z) == null) {
            ci.cancel();
        }
    }
}
