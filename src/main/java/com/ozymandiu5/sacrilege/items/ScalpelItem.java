package com.ozymandiu5.sacrilege.items;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.init.DamageSourceInit;
import com.ozymandiu5.sacrilege.init.ItemInit;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ScalpelItem extends Item {

	public ScalpelItem(Properties properties) {
		super(properties);
	}

	public static boolean isUsed(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		try{
			return nbt.getBoolean("is_used");
		} catch(IllegalArgumentException err) {
			err.printStackTrace();			
			return false;
		}
	}

	public static void setUsed(ItemStack stack, boolean isUsed) {
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putBoolean("is_used", isUsed);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		InteractionHand opposite = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND
				: InteractionHand.MAIN_HAND;
		if ((player.getItemInHand(opposite).getItem() == Items.GLASS_BOTTLE) && (!isUsed(player.getItemInHand(hand)))) {
			ItemStack stack = player.getItemInHand(hand);
			stack.setDamageValue(stack.getDamageValue() + 1);
			if (stack.getDamageValue() >= stack.getMaxDamage())
				stack.setCount(0);

			world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.AXE_WAX_OFF,
					SoundSource.PLAYERS, 1.0f, 1.0f);

			setUsed(stack, true);
			player.swing(hand);

			ItemStack bottle = player.getItemInHand(opposite);
			bottle.setCount(bottle.getCount() - 1);
			ItemStack blood = new ItemStack(ItemInit.BLOOD_BOTTLE.get());
			
			BloodBottleItem.setPlayerUUID(blood, player.getUUID());
			
			player.addItem(blood);
			
			DamageSource bloodLoss = new DamageSourceInit(player.level().registryAccess()).bloodLoss();
			player.hurt(bloodLoss, 4);
		}

		return super.use(world, player, hand);
	}

	@SubscribeEvent
	public void onInteractBlock(PlayerInteractEvent.RightClickBlock event) {
		final var level = event.getLevel();
		final var itemUsed = event.getItemStack().getItem();
		final var blockUsed = level.getBlockState(event.getPos()).getBlock();
		if (blockUsed == Blocks.WATER_CAULDRON && itemUsed == this && isUsed(event.getItemStack())) {
			this.clean(level, event.getEntity(), event.getHand(), event.getPos());
		}
	}

	protected void clean(Level world, Player player, InteractionHand hand, BlockPos pos) {
		ItemStack stack = player.getItemInHand(hand);
		setUsed(stack, false);
		player.swing(hand);
		LayeredCauldronBlock.lowerFillLevel(world.getBlockState(pos), world, pos);
		world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GENERIC_SPLASH,
				SoundSource.PLAYERS, 1.0f, 2.0f);
	}
}
