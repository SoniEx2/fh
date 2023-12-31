package space.autistic.fishhead.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.LargePufferfishEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;

public class FishheadRenderer<T extends Entity> {
    private final LargePufferfishEntityModel<T> largePufferfishEntityModel;
    private static final Identifier TEXTURE = new Identifier("textures/entity/fish/pufferfish.png");

    public FishheadRenderer(LargePufferfishEntityModel<T> largePufferfishEntityModel) {
        this.largePufferfishEntityModel = largePufferfishEntityModel;
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity entity, float pos, float speed, float tickDelta, float animProgress, float yawDelta, float pitch) {
        boolean bl = entity instanceof VillagerEntity || entity instanceof ZombieVillagerEntity;
        matrixStack.scale(1.1875f, 1.1875f, 1.1875f);
        if (bl) {
            matrixStack.translate(0.0f, 0.0625f, 0.0f);
        }
        matrixStack.translate(0.0f, -1.4f+0.03125f, 0.0f);
        largePufferfishEntityModel.setAngles(null, 0f, 0f, animProgress, 0f, 0f);
        VertexConsumer vertices = vertexConsumerProvider.getBuffer(RenderLayer.getArmorCutoutNoCull(TEXTURE));
        largePufferfishEntityModel.render(matrixStack, vertices, light, OverlayTexture.DEFAULT_UV, 1f, 1f, 1f, 1f);
        matrixStack.pop();
    }
}
