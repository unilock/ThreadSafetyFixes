package cc.unilock.threadsafetyfixes.mixin.late.mekanism;

import mekanism.common.block.BlockMachine;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(BlockMachine.class)
public class BlockMachineMixin {
    @Inject(method = "randomDisplayTick", at = @At("HEAD"), cancellable = true)
    private void randomDisplayTick(World world, int x, int y, int z, Random random, CallbackInfo ci) {
        if (world.getTileEntity(x, y, z) == null) {
            ci.cancel();
        }
    }

    @Inject(method = "getIcon(Lnet/minecraft/world/IBlockAccess;IIII)Lnet/minecraft/util/IIcon;", at = @At("HEAD"), cancellable = true)
    private void getIcon(IBlockAccess world, int x, int y, int z, int side, CallbackInfoReturnable<IIcon> cir) {
        if (world.getTileEntity(x, y, z) == null) {
            cir.setReturnValue(null);
        }
    }
}
