package com.sugoma.enlisted.events;

import com.sugoma.enlisted.Enlisted;
import com.sugoma.enlisted.init.ModBlocks;
import com.sugoma.enlisted.init.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Enlisted.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent //LivingEntity#func_233580_cy_ this is not positioned
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event){
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == Items.BEACON){
            Enlisted.LOGGER.info("player tries to jump with a beacon!");
            World world = player.getEntityWorld();
            //location below player
            world.setBlockState(player.getPosition().add(0,-1,0), ModBlocks.ALUMINUM_ORE.get().getDefaultState());
        }
    }

    //use subscribe it knows there an event being fired
    //getTarget returns an entity

    //all events are ran twice so sent twice
    @SubscribeEvent
    public static void onDamageMobs(AttackEntityEvent event){
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.MEDKIT.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity) event.getTarget();
                //add if(target instanceof xxxEntity){} here if we target only said entity
                target.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH,600,2));
                target.addPotionEffect(new EffectInstance(Effects.REGENERATION,600,2));
                target.setGlowing(true);
                //make sure only sending client side
                if(!event.getPlayer().getEntityWorld().isRemote){
                    String msg = TextFormatting.GOLD + "Revived!";
                    PlayerEntity player = event.getPlayer();
                    player.sendMessage(new StringTextComponent(msg),player.getUniqueID());
                }
            }
        }

    }

    //cancelling event preventing this from happening so thing will neven happen
//    @SubscribeEvent
//    public static void onCraftingTableOpen(GuiOpenEvent event){
//        if(event.isCancelable()){
//            if(event.getGui() instanceof CraftingScreen){
//                event.setCanceled(true);
//                Enlisted.LOGGER.info("trying to open a crafting table");
//            }
//        }
//    }

}
