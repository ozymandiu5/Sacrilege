package com.ozymandiu5.sacrilege.items;

import java.util.UUID;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BloodBottleItem extends Item {

	public BloodBottleItem(Properties properties) {
		super(properties);
	}

	public static UUID getPlayerUUID(ItemStack stack) {
		CompoundTag nbt = stack.getOrCreateTag();
		try {
			return nbt.getUUID("BloodUUID");
		} catch (IllegalArgumentException err) {
			return null;
		}
	}

	public static void setPlayerUUID(ItemStack stack, UUID playerUUID) {
		CompoundTag nbt = stack.getOrCreateTag();
		nbt.putUUID("BloodUUID", playerUUID);
	}
}
