package com.ozymandiu5.sacrilege.init;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.items.BloodBottleItem;
import com.ozymandiu5.sacrilege.items.ScalpelItem;
import com.ozymandiu5.sacrilege.items.SculkRockItem;
import com.ozymandiu5.sacrilege.items.AltarItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Sacrilege.MODID);
	
	public static final RegistryObject<Item> SCALPEL = ITEMS.register("scalpel", () 
			-> new ScalpelItem(new Item.Properties()
					.durability(64)
			));

	public static final RegistryObject<Item> BLOOD_BOTTLE = ITEMS.register("blood_bottle", () 
			-> new BloodBottleItem(new Item.Properties()));
	
	public static final RegistryObject<Item> ECHO_CORE = ITEMS.register("echo_core", () 
			-> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> SCULK_ROCK = ITEMS.register("sculk_rock", () 
			-> new SculkRockItem(new Item.Properties()));
	
	public static final RegistryObject<Item> ALTAR = ITEMS.register("altar", () 
			-> new AltarItem(new Item.Properties()
					.rarity(Rarity.UNCOMMON)));
	
	public static final RegistryObject<Item> WHISPERING_STEEL = ITEMS.register("whispering_steel", () 
			-> new Item(new Item.Properties()));
}
