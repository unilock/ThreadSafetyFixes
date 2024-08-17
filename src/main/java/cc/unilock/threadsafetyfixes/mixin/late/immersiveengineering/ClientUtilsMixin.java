package cc.unilock.threadsafetyfixes.mixin.late.immersiveengineering;

import blusunrize.immersiveengineering.client.ClientUtils;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ClientUtils.class, remap = false)
public class ClientUtilsMixin {
    @Inject(method = "renderAttachedConnections", at = @At("HEAD"), cancellable = true)
    private static void renderAttachedConnections(CallbackInfo ci, @Local(argsOnly = true) TileEntity te) {
        if (te == null) {
            ci.cancel();
        }
    }
}
