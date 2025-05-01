package net.jctb.justamodforhackcraftv2.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SUPERTATER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400,2),1f)
            .effect(new  MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400,5), 1f)
            .effect(new  MobEffectInstance(MobEffects.REGENERATION, 400,3), 1f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,400,10),1f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED,400,2), 1f)
            .effect(new MobEffectInstance(MobEffects.JUMP,400,3),1f)
            .alwaysEdible().build();

}
