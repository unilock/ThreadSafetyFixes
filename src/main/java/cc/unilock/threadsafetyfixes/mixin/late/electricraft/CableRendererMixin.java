package cc.unilock.threadsafetyfixes.mixin.late.electricraft;

import Reika.ElectriCraft.CableRenderer;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CableRenderer.class, remap = false)
public class CableRendererMixin {
    @Inject(method = "renderFace", at = @At("HEAD"), cancellable = true)
    private void renderFace(CallbackInfo ci, @Local(argsOnly = true) TileEntity te) {
        if (te == null) {
            ci.cancel();
        }
    }
}
