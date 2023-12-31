package space.autistic.fishhead.client.evenmoremixinshowmanydoyouthinkwecanhave;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeadFeatureRenderer.class)
public class FishheadHeadFeatureRendererMixin {
    @Inject(cancellable = true, at = @At("HEAD"), method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V")
    private void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity entity, float pos, float speed, float tickDelta, float animProgress, float yawDelta, float pitch, CallbackInfo ci) {
        ItemStack stack = entity.getEquippedStack(EquipmentSlot.HEAD);
        if (stack.isEmpty()) return;
        if (stack.getItem() == Items.PUFFERFISH) {
            ci.cancel();
        }
    }
}
