package com.ozymandiu5.sacrilege.entity.custom;

import com.ozymandiu5.sacrilege.entity.ModEntities;
import com.ozymandiu5.sacrilege.init.ItemInit;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class SculkRockProjectileEntity extends ThrowableItemProjectile {

	public SculkRockProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public SculkRockProjectileEntity(Level pLevel) {
		super(ModEntities.SCULK_ROCK_PROJECTILE.get(), pLevel);
	}

	public SculkRockProjectileEntity(Level pLevel, LivingEntity livingEntity) {
		super(ModEntities.SCULK_ROCK_PROJECTILE.get(), livingEntity, pLevel);
	}

	protected Item getDefaultItem() {
		return ItemInit.SCULK_ROCK.get();
	}

	private ParticleOptions getParticle() {
		ItemStack itemstack = this.getItemRaw();
		return (ParticleOptions) (itemstack.isEmpty() ? ParticleTypes.ITEM : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
	}

	public void handleEntityEvent(byte p_37402_) {
		if (p_37402_ == 3) {
			ParticleOptions particleoptions = this.getParticle();

			for (int i = 0; i < 8; ++i) {
				this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	protected void onHitEntity(EntityHitResult p_37404_) {
		super.onHitEntity(p_37404_);
		Entity entity = p_37404_.getEntity();
		entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float) 4);
	}

	@SuppressWarnings("resource")
	protected void onHit(HitResult p_37406_) {
		super.onHit(p_37406_);
		if (!this.level().isClientSide) {
			this.level().broadcastEntityEvent(this, (byte) 3);
			this.discard();
		}
	}
}
