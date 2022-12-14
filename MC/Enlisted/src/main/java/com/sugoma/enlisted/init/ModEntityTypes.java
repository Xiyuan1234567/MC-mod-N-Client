package com.sugoma.enlisted.init;

import com.sugoma.enlisted.Enlisted;
import com.sugoma.enlisted.entities.HogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Enlisted.MOD_ID);
    //Entity Types
    public static final RegistryObject<EntityType<HogEntity>> HOG = ENTITY_TYPES.register("hog",
            ()->EntityType.Builder.create(HogEntity::new, EntityClassification.CREATURE).size(1.0f, 1.0f).build(new ResourceLocation(Enlisted.MOD_ID,"hog").toString()));
}
