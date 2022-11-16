package com.sugoma.enlisted.world.gen;

import com.sugoma.enlisted.Enlisted;
import com.sugoma.enlisted.init.ModEntityTypes;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Enlisted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntitySpawns {
    @SubscribeEvent
    public static void spawnEntities(FMLLoadCompleteEvent event){
        for (Biome biome : ForgeRegistries.BIOMES){
            if (biome.getCategory()==Biome.Category.NETHER){

            }
            else if (biome.getCategory()==Biome.Category.THEEND){

            } else {
                if(biome.getCategory() != Biome.Category.OCEAN){
                    biome.getSpawns(EntityClassification.CREATURE)
                            .add(new Biome.SpawnListEntry(ModEntityTypes.HOG.get(),10, 5,10));
                }
            }
        }
    }
}
