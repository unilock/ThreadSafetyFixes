package cc.unilock.reikafixes.mixin.late.betterstorage;

import net.mcft.copy.betterstorage.tile.TileLocker;
import net.mcft.copy.betterstorage.tile.TileReinforcedChest;
import net.mcft.copy.betterstorage.tile.TileReinforcedLocker;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {TileLocker.class, TileReinforcedChest.class, TileReinforcedLocker.class}, remap = false)
public class TileCBSMixins {
    @Inject(method = "setBlockBoundsBasedOnState", at = @At("HEAD"), cancellable = true)
    private void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z, CallbackInfo ci) {
        if (world.getTileEntity(x, y, z) == null) {
            ci.cancel();
        }
    }
}
