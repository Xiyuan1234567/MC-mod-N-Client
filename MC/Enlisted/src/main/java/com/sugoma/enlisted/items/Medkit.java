package com.sugoma.enlisted.items;

import com.sugoma.enlisted.Enlisted;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Medkit extends Item {
    //where custom stuff is added
    public Medkit() {
        super(new Item.Properties()
                .group(Enlisted.TAB)
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1.2F)
                        .effect(new EffectInstance(Effects.REGENERATION, 1000, 2), 2)
                        .effect(new EffectInstance(Effects.SATURATION, 500, 2), 1)
                        .meat()
                        .setAlwaysEdible()
                        .build())
        );
    }
}
