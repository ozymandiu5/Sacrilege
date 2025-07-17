package com.ozymandiu5.sacrilege.sound;

import com.ozymandiu5.sacrilege.Sacrilege;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Sacrilege.MODID);

    public static final RegistryObject<SoundEvent> EQUIP_WHISPERING_STEEL = registerSoundEvents("item.armor.equip_whispering_steel");

    public static final RegistryObject<SoundEvent> OBSCURED_NULLSTONE_BREAK = registerSoundEvents("block.obscured_nullstone.break");
    public static final RegistryObject<SoundEvent> OBSCURED_NULLSTONE_STEP = registerSoundEvents("block.obscured_nullstone.step");
    public static final RegistryObject<SoundEvent> OBSCURED_NULLSTONE_FALL = registerSoundEvents("block.obscured_nullstone.fall");
    public static final RegistryObject<SoundEvent> OBSCURED_NULLSTONE_HIT = registerSoundEvents("block.obscured_nullstone.hit");
    public static final RegistryObject<SoundEvent> OBSCURED_NULLSTONE_PLACE = registerSoundEvents("block.obscured_nullstone.place");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Sacrilege.MODID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
