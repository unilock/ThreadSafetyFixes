package cc.unilock.threadsafetyfixes.mixin.late.chromaticraft;

import Reika.ChromatiCraft.Block.Worldgen.BlockTieredPlant;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockTieredPlant.class, remap = false)
public class BlockTieredPlantMixin {
    @Inject(method = "setBlockBoundsBasedOnState", at = @At("HEAD"), cancellable = true)
    private void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z, CallbackInfo ci) {
        if (world.getBlockMetadata(x, y, z) != 5) {
            ((Block) (Object) this).setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            ci.cancel();
        }
    }
}
