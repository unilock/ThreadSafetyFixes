package cc.unilock.threadsafetyfixes.mixin.late.chromaticraft;

import Reika.ChromatiCraft.ChromaticEventManager;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ChromaticEventManager.class, remap = false)
public class ChromaticEventManagerMixin {
    @Inject(method = "markHostile", at = @At("HEAD"), cancellable = true)
    private void markHostile(AttackEntityEvent evt, CallbackInfo ci) {
        if (evt.entity.worldObj.isRemote) {
            ci.cancel();
        }
    }
}
