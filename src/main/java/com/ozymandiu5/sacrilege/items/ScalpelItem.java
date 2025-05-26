package com.ozymandiu5.sacrilege.items;

import com.ozymandiu5.sacrilege.init.DamageSourceInit;
import com.ozymandiu5.sacrilege.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class ScalpelItem extends Item {

	public ScalpelItem(Properties properties) {
		super(properties);
	}

	public static boolean isUsed(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		try {
			return nbt.getBoolean("is_used");
		} catch (IllegalArgumentException err) {
			return false;
		}
	}

	public static void setUsed(ItemStack stack, boolean isUsed) {
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putBoolean("is_used", isUsed);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {		
		InteractionHand opposite = hand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
		ItemStack stack = player.getItemInHand(hand);

		if (player.getItemInHand(opposite).getItem() == Items.GLASS_BOTTLE && !isUsed(player.getItemInHand(hand))) {

			if (player instanceof ServerPlayer serverPlayer)
				stack.hurt(1, world.random, serverPlayer);

			setUsed(stack, true);
			player.swing(hand);
			world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.AXE_WAX_OFF,
					SoundSource.PLAYERS, 1.0f, 1.0f);

			ItemStack bottle = player.getItemInHand(opposite);
			if (!player.isCreative())
				bottle.shrink(1);
			createBottle(player);

			DamageSource bloodLoss = new DamageSourceInit(player.level().registryAccess()).blood_loss;
			player.hurt(bloodLoss, 4);

			return InteractionResultHolder.success(stack);
		} else if (isUsed(player.getItemInHand(hand))) { // BottleItem
			BlockHitResult blockhitresult = getPlayerPOVHitResult(world, player, ClipContext.Fluid.SOURCE_ONLY);
			if (blockhitresult.getType() == HitResult.Type.MISS) {
				return InteractionResultHolder.pass(stack);
			} else {
				if (blockhitresult.getType() == HitResult.Type.BLOCK) {
					BlockPos blockpos = blockhitresult.getBlockPos();
					if (!world.mayInteract(player, blockpos)) {
						return InteractionResultHolder.pass(stack);
					}

					if (world.getFluidState(blockpos).is(FluidTags.WATER)) {
						clean(world, player, hand, blockpos);
						return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());
					} else if (world.getBlockState(blockpos).getBlock() == Blocks.WATER_CAULDRON) {
						clean(world, player, hand, blockpos);
						return InteractionResultHolder.sidedSuccess(stack, world.isClientSide());		
					}
				}

				return InteractionResultHolder.pass(stack);
			}
		}

		return super.use(world, player, hand);
	}

	public void createBottle(Player player) {
		ItemStack blood = new ItemStack(ItemInit.BLOOD_BOTTLE.get());
		BloodBottleItem.setPlayerUUID(blood, player.getUUID());
		player.addItem(blood);
	}

	protected void clean(Level world, Player player, InteractionHand hand, BlockPos pos) {
		ItemStack stack = player.getItemInHand(hand);
		setUsed(stack, false);
		player.swing(hand);
		if (world.getBlockState(pos).getBlock() instanceof LayeredCauldronBlock)
				LayeredCauldronBlock.lowerFillLevel(world.getBlockState(pos), world, pos);
		world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.GENERIC_SPLASH,
				SoundSource.PLAYERS, 1.0f, 2.0f);
	}
}
