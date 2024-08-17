package cc.unilock.threadsafetyfixes.mixin.late.rotarycraft;

import Reika.RotaryCraft.PipeBodyRenderer;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = {PipeBodyRenderer.class}, remap = false)
public class ISBRHMixins {
    @Inject(method = "renderWorldBlock", at = @At("HEAD"), cancellable = true)
    private void renderWorldBlock(CallbackInfoReturnable<Boolean> cir, @Local(argsOnly = true) IBlockAccess world, @Local(argsOnly = true, ordinal = 0) int x, @Local(argsOnly = true, ordinal = 1) int y, @Local(argsOnly = true, ordinal = 2) int z) {
        if (world.getTileEntity(x, y, z) == null) {
            cir.setReturnValue(false);
        }
    }
}
