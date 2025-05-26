package com.ozymandiu5.sacrilege.init;

import com.ozymandiu5.sacrilege.Sacrilege;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public interface DamageTypeInit {
	ResourceKey<DamageType> BLOOD_LOSS = ResourceKey.create(Registries.DAMAGE_TYPE,
			new ResourceLocation(Sacrilege.MODID, "blood_loss"));

	public static void bootstrap(BootstapContext<DamageType> context) {
		context.register(BLOOD_LOSS, new DamageType("blood_loss", 0.1F));
	}
}
