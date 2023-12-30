package space.autistic.fishhead.mixinisbullshitcanyoujustfuckoffandstoptryingtostopusfromshootingourownfoot;

import net.minecraft.registry.Registry;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(SimpleRegistry.class)
public class FishheadSuppressRegistryErrorsMixin {
    @Shadow
    private Map<?, RegistryEntry.Reference<?>> intrusiveValueToEntry;

    @Inject(method = "freeze()Lnet/minecraft/registry/Registry;", at = @At("HEAD"))
    private void onFreeze(CallbackInfoReturnable<Registry<?>> ignored) {
        intrusiveValueToEntry = null;
    }
}
