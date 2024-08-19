package cc.unilock.threadsafetyfixes.mixin.late.chromaticraft;

import Reika.ChromatiCraft.Block.Worldgen.BlockTieredPlant;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BlockTieredPlant.class, remap = false)
public class BlockTieredPlantMixin {
    @Inject(method = "setBlockBoundsBasedOnState", at = @At("HEAD"), cancellable = true)
    private void setBlockBoundsBasedOnState(CallbackInfo ci, @Local(argsOnly = true) IBlockAccess world, @Local(argsOnly = true, ordinal = 0) int x, @Local(argsOnly = true, ordinal = 1) int y, @Local(argsOnly = true, ordinal = 2) int z) {
        if (world.getBlockMetadata(x, y, z) != 5) {
            ((Block) (Object) this).setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            ci.cancel();
        }
    }
}
