package com.ozymandiu5.sacrilege.effect;

import com.ozymandiu5.sacrilege.Sacrilege;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Sacrilege.MODID);

    public static final RegistryObject<MobEffect> ECHOING = MOB_EFFECTS.register("echoing",
            () -> new EchoingEffect(MobEffectCategory.BENEFICIAL, 876888));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
