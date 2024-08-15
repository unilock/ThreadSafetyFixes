package cc.unilock.reikafixes.mixin.late.mariculture;

import com.llamalad7.mixinextras.sugar.Local;
import mariculture.core.render.RenderOyster;
import mariculture.core.tile.TileOyster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderOyster.class, remap = false)
public class RenderOysterMixin {
    @Inject(method = "init", at = @At(value = "INVOKE", target = "Lmariculture/core/tile/TileOyster;getStackInSlot(I)Lnet/minecraft/item/ItemStack;"), cancellable = true)
    private void init$getStackInSlot(CallbackInfo ci, @Local TileOyster tile) {
        if (tile == null) {
            ci.cancel();
        }
    }
}
