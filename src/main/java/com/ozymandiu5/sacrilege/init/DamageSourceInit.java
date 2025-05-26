package com.ozymandiu5.sacrilege.init;

import javax.annotation.Nullable;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class DamageSourceInit {
	private final Registry<DamageType> damageTypes;
	
	public final DamageSource blood_loss;
	
	public DamageSourceInit(RegistryAccess pRegistry) {
		this.damageTypes = pRegistry.registryOrThrow(Registries.DAMAGE_TYPE);
		this.blood_loss = this.source(DamageTypeInit.BLOOD_LOSS);
	}

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }

    @SuppressWarnings("unused")
	private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pEntity);
    }

    @SuppressWarnings("unused")
    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pCausingEntity, @Nullable Entity pDirectEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pCausingEntity, pDirectEntity);
    }
}
