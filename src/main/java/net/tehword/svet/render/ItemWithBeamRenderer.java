package net.tehword.svet.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.tehword.svet.item.BeamItemRegistry;
import org.joml.Matrix4f;
import org.joml.Random;

public class ItemWithBeamRenderer extends ItemEntityRenderer {

    public ItemWithBeamRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(ItemEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        Item item = entity.getItem().getItem();
        if (BeamItemRegistry.ITEM_PROPERTIES.containsKey(item)) {
            super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
            renderBeams(entity, poseStack, buffer, partialTicks);
        } else {
            super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }

    private void renderBeams(ItemEntity entity, PoseStack poseStack, MultiBufferSource buffer, float partialTicks) {
        poseStack.pushPose();
        float time = (entity.level().getGameTime() + partialTicks);
        BeamProperties properties = BeamItemRegistry.ITEM_PROPERTIES.get(entity.getItem().getItem());
        int beamCount = properties.getBeamCount();
        float beamLength = properties.getBeamLength();
        Random random = new Random(entity.getId());
        int[] colors = properties.getColors();

        for (int i = 0; i < beamCount; i++) {
            poseStack.pushPose();
            float randomAngle = random.nextFloat() * 360F;
            poseStack.mulPose(Axis.YP.rotationDegrees(randomAngle));
            poseStack.translate(0, 0.35F, 0);
            float rotationSpeed = 5F + random.nextFloat() * 5F;
            poseStack.mulPose(Axis.XP.rotationDegrees(time * rotationSpeed));
            renderSingleBeam(poseStack, buffer, random, time, colors, i, beamLength);
            poseStack.popPose();
        }

        poseStack.popPose();
    }

    private void renderSingleBeam(PoseStack poseStack, MultiBufferSource buffer, Random random, float time, int[] colors, int i, float beamLength) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.lightning());
        Matrix4f matrix = poseStack.last().pose();
        int color = colors[i % colors.length];
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        int alphaTop = 0;
        int alphaBottom = 70;
        float topRadius = 0.5F;

        vertexConsumer.vertex(matrix, 0, 0, 0).color(red, green, blue, alphaBottom).endVertex();
        vertexConsumer.vertex(matrix, 0, beamLength, 0).color(red, green, blue, alphaTop).endVertex();
        vertexConsumer.vertex(matrix, -topRadius, beamLength, 0).color(red, green, blue, alphaTop).endVertex();
        vertexConsumer.vertex(matrix, topRadius, beamLength, 0).color(red, green, blue, alphaTop).endVertex();
    }

    public static class BeamProperties {
        private final int[] colors;
        private final float beamLength;
        private final int beamCount;

        public BeamProperties(int[] colors, float beamLength, int beamCount) {
            this.colors = colors;
            this.beamLength = beamLength;
            this.beamCount = beamCount;
        }

        public int[] getColors() {
            return colors;
        }

        public float getBeamLength() {
            return beamLength;
        }

        public int getBeamCount() {
            return beamCount;
        }
    }
}