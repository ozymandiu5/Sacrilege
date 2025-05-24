package com.ozymandiu5.sacrilege.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RiftcallerItem extends SwordItem{
	private boolean currentlyInbetween = false;
	
	public RiftcallerItem(Tier tier, int damage, float speed, Properties properties) {
		super(tier, damage, speed, properties);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.PLAYERS, 1, (float)0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.RESPAWN_ANCHOR_DEPLETE.get(), SoundSource.PLAYERS, 1, (float)0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 1, (float)0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.TRIDENT_THUNDER, SoundSource.PLAYERS, 1, (float)0.5, true);
		
		if(!world.isClientSide()) {
			((ServerLevel) world).sendParticles(ParticleTypes.SONIC_BOOM, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 20, 1, 1, 1, 1);
			((ServerLevel) world).sendParticles(ParticleTypes.ENCHANTED_HIT, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 1, 1, 1, 1);
			((ServerLevel) world).sendParticles(ParticleTypes.END_ROD, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 0, 0, 0, 1);
			((ServerLevel) world).sendParticles(ParticleTypes.PORTAL, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 0, 0, 0, 1);
			((ServerLevel) world).sendParticles(ParticleTypes.ENCHANT, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 0, 0, 0, 1);
			((ServerLevel) world).sendParticles(ParticleTypes.SCULK_SOUL, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 0.3, 0.5, 0.3, 0);
			((ServerLevel) world).sendParticles(ParticleTypes.SOUL, player.getBlockX()+0.5, player.getBlockY()+1, player.getBlockZ()+0.5, 100, 0.3, 0.5, 0.3, 0.1);
			
			if(currentlyInbetween==false) {
				player.forceAddEffect(new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0, false, false), player);
				player.forceAddEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 4, false, false), player);
				player.forceAddEffect(new MobEffectInstance(MobEffects.WEAKNESS, -1, 50, false, false), player);
				player.forceAddEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, -1, 50, false, false), player);
				player.forceAddEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 50, false, false), player);
				player.forceAddEffect(new MobEffectInstance(MobEffects.DARKNESS, -1, 0, false, false), player);
				currentlyInbetween = true;
			} else {
				player.removeEffect(MobEffects.INVISIBILITY);
				player.removeEffect(MobEffects.MOVEMENT_SPEED);
				player.removeEffect(MobEffects.WEAKNESS);
				player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
				player.removeEffect(MobEffects.DARKNESS);
				player.removeEffect(MobEffects.DIG_SLOWDOWN);
				currentlyInbetween = false;
			}
		}
		player.getCooldowns().addCooldown(this, 100);
		return super.use(world, player, hand);
	}
}
