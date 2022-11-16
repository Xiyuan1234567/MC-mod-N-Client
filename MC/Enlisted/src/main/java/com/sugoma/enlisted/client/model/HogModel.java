package com.sugoma.enlisted.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.sugoma.enlisted.entities.HogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class HogModel<T extends HogEntity> extends EntityModel<T> {
    private final ModelRenderer amogus;
    private final ModelRenderer rightLeg;
    private final ModelRenderer upperBody;
    private final ModelRenderer leftLeg;

    public HogModel() {
        textureWidth = 32;
        textureHeight = 32;

        amogus = new ModelRenderer(this);
        amogus.setRotationPoint(-0.5F, 15.0F, -2.5F);


        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(2.5F, 4.0F, 3.25F);
        amogus.addChild(rightLeg);
        rightLeg.setTextureOffset(8, 11).addBox(-1.0F, -1.0F, -0.75F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        rightLeg.setTextureOffset(10, 19).addBox(-1.0F, 3.0F, -3.75F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        upperBody = new ModelRenderer(this);
        upperBody.setRotationPoint(0.5F, -0.25F, 1.25F);
        amogus.addChild(upperBody);
        upperBody.setTextureOffset(0, 0).addBox(-3.0F, -2.75F, -0.75F, 6.0F, 7.0F, 4.0F, 0.0F, false);
        upperBody.setTextureOffset(20, 19).addBox(-1.5F, -1.75F, -1.75F, 3.0F, 2.0F, 1.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(-1.5F, 4.0F, 3.25F);
        amogus.addChild(leftLeg);
        leftLeg.setTextureOffset(0, 11).addBox(-1.0F, -1.0F, -0.75F, 2.0F, 6.0F, 2.0F, 0.0F, false);
        leftLeg.setTextureOffset(0, 19).addBox(-1.0F, 3.0F, -3.75F, 2.0F, 2.0F, 3.0F, 0.0F, false);
    }


    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.upperBody.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.upperBody.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        amogus.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
