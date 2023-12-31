package space.autistic.fishhead.client.evenmoremixinshowmanydoyouthinkwecanhave;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.LargePufferfishEntityModel;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import space.autistic.fishhead.client.FishheadRenderer;

@Mixin(HeadFeatureRenderer.class)
public class FishheadHeadFeatureRendererMixin {
    @Unique
    private FishheadRenderer<?> fishheadRenderer;

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/render/entity/feature/FeatureRendererContext;Lnet/minecraft/client/render/entity/model/EntityModelLoader;FFFLnet/minecraft/client/render/item/HeldItemRenderer;)V")
    private void init(FeatureRendererContext<?, ?> context, EntityModelLoader modelLoader, float sX, float sY, float sZ, HeldItemRenderer heldItemRenderer, CallbackInfo ci) {
        fishheadRenderer = new FishheadRenderer<>(new LargePufferfishEntityModel<>(modelLoader.getModelPart(EntityModelLayers.PUFFERFISH_BIG)));
    }

    @Inject(cancellable = true, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelPart;rotate(Lnet/minecraft/client/util/math/MatrixStack;)V", ordinal = 0, shift = At.Shift.AFTER), method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/entity/LivingEntity;FFFFFF)V")
    private void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity entity, float pos, float speed, float tickDelta, float animProgress, float yawDelta, float pitch, CallbackInfo ci) {
        ItemStack stack = entity.getEquippedStack(EquipmentSlot.HEAD);
        if (stack.getItem() != Items.PUFFERFISH) {
            return;
        }
        ci.cancel();
        fishheadRenderer.render(matrixStack, vertexConsumerProvider, light, entity, pos, speed, tickDelta, animProgress, yawDelta, pitch);
    }
}
