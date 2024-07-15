package cc.unilock.reikafixes.mixin.late.geostrata;

import Reika.GeoStrata.Rendering.OreVeinRenderer;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = OreVeinRenderer.class, remap = false)
public class OreVeinRendererMixin {
    @Inject(method = "renderSide", at = @At("HEAD"), cancellable = true)
    private void renderSide(CallbackInfo ci, @Local(argsOnly = true) IBlockAccess world, @Local(argsOnly = true, ordinal = 0) int x, @Local(argsOnly = true, ordinal = 1) int y, @Local(argsOnly = true, ordinal = 2) int z) {
        if (world.getTileEntity(x, y, z) == null) {
            ci.cancel();
        }
    }
}
