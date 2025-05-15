package com.ozymandiu5.sacrilege.items;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.init.ItemInit;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BloodBottleItem extends Item {

	public static final String TAG_USED = "Used";
	
	public BloodBottleItem(Properties properties) {
		super(properties);
		// ItemProperties.register(this, new ResourceLocation(Sacrilege.MODID, "PlayerUUID"),
		//		 (stack, world, player, seed) -> playerUUID(stack));
	}
}
