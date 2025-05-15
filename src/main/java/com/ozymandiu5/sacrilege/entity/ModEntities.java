package com.ozymandiu5.sacrilege.entity;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.entity.custom.SculkRockProjectileEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Sacrilege.MODID);
	public static final RegistryObject<EntityType<SculkRockProjectileEntity>> SCULK_ROCK_PROJECTILE =
			ENTITY_TYPES.register("sculk_rock_projectile", () -> EntityType.Builder.<SculkRockProjectileEntity>of(SculkRockProjectileEntity::new, MobCategory.MISC)
					.sized(0.5f, 0.5f).build("sculk_rock_projectile"));
}
