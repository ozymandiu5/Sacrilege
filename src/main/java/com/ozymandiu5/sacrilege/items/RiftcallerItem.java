package com.ozymandiu5.sacrilege.items;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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

public class RiftcallerItem extends SwordItem {

	public RiftcallerItem(Tier tier, int damage, float speed, Properties properties) {
		super(tier, damage, speed, properties);
	}
	
	public static boolean getInbetween(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		try {
			return nbt.getBoolean("inbetween");
		} catch (IllegalArgumentException err) {
			return false;
		}
	}

	public static void setInbetween(ItemStack stack, boolean inbetween) {
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putBoolean("inbetween", inbetween);
	}
	
	public static int getAbility(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		try {
			return nbt.getInt("currentAbility");
		} catch (IllegalArgumentException err) {
			return 0;
		}
	}

	public static void setAbility(ItemStack stack, int ability) {
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putInt("currentAbility", ability);
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.ILLUSIONER_CAST_SPELL, SoundSource.PLAYERS, 1, (float) 0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.RESPAWN_ANCHOR_DEPLETE.get(), SoundSource.PLAYERS, 1, (float) 0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 1, (float) 0.5, true);
		world.playLocalSound(player.getBlockX(), player.getBlockY(), player.getBlockZ(), SoundEvents.TRIDENT_THUNDER, SoundSource.PLAYERS, 1, (float) 0.5, true);

		if(player.isCrouching()==false) {
			switch(getAbility(player.getItemInHand(hand))) {
			case 1:
				if (!world.isClientSide()) {
					((ServerLevel) world).sendParticles(ParticleTypes.SONIC_BOOM, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 20, 1, 1, 1, 1);
					((ServerLevel) world).sendParticles(ParticleTypes.ENCHANTED_HIT, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 1, 1, 1, 1);
					((ServerLevel) world).sendParticles(ParticleTypes.END_ROD, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 0, 0, 0, 1);
					((ServerLevel) world).sendParticles(ParticleTypes.PORTAL, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 0, 0, 0, 1);
					((ServerLevel) world).sendParticles(ParticleTypes.ENCHANT, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 0, 0, 0, 1);
					((ServerLevel) world).sendParticles(ParticleTypes.SCULK_SOUL, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 0.3, 0.5, 0.3, 0);
					((ServerLevel) world).sendParticles(ParticleTypes.SOUL, player.getBlockX() + 0.5, player.getBlockY() + 1, player.getBlockZ() + 0.5, 100, 0.3, 0.5, 0.3, 0.1);
					if (getInbetween(player.getItemInHand(hand)) == false) {						player.forceAddEffect(new MobEffectInstance(MobEffects.INVISIBILITY, -1, 0, false, false), player);
						player.forceAddEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 4, false, false), player);
						player.forceAddEffect(new MobEffectInstance(MobEffects.WEAKNESS, -1, 50, false, false), player);
						player.forceAddEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, -1, 2, false, false), player);
						player.forceAddEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 50, false, false), player);
						player.forceAddEffect(new MobEffectInstance(MobEffects.DARKNESS, -1, 0, false, false), player);
						setInbetween(player.getItemInHand(hand), true);
					} else {
						player.removeEffect(MobEffects.INVISIBILITY);
						player.removeEffect(MobEffects.MOVEMENT_SPEED);
						player.removeEffect(MobEffects.WEAKNESS);
						player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
						player.removeEffect(MobEffects.DARKNESS);
						player.removeEffect(MobEffects.DIG_SLOWDOWN);
						setInbetween(player.getItemInHand(hand), false);
					}
				}
			}
		}
		
		
		player.getCooldowns().addCooldown(this, 100);
		return super.use(world, player, hand);
	}
}
