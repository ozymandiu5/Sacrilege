package com.ozymandiu5.sacrilege.init;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.items.BloodBottleItem;
import com.ozymandiu5.sacrilege.items.ScalpelItem;
import com.ozymandiu5.sacrilege.items.SculkRockItem;
import com.ozymandiu5.sacrilege.items.AltarItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.HoeItem;
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
					.rarity(Rarity.UNCOMMON)
					.stacksTo(1)));
	
	public static final RegistryObject<Item> WHISPERING_STEEL = ITEMS.register("whispering_steel", () 
			-> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> WHISPERING_STEEL_SWORD = ITEMS.register("whispering_steel_sword", () 
			-> new SwordItem(ModToolTiers.WHISPERING_STEEL, 4, 1, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_PICKAXE = ITEMS.register("whispering_steel_pickaxe", () 
			-> new PickaxeItem(ModToolTiers.WHISPERING_STEEL, 2, 1, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_AXE = ITEMS.register("whispering_steel_axe", () 
			-> new AxeItem(ModToolTiers.WHISPERING_STEEL, 7, 1, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_SHOVEL = ITEMS.register("whispering_steel_shovel", () 
			-> new ShovelItem(ModToolTiers.WHISPERING_STEEL, 0, 0, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_HOE = ITEMS.register("whispering_steel_hoe", () 
			-> new HoeItem(ModToolTiers.WHISPERING_STEEL, 0, 0, new Item.Properties()));
	
	public static final RegistryObject<Item> WHISPERING_STEEL_HELMET = ITEMS.register("whispering_steel_helmet", () 
			-> new ArmorItem(ModArmorMaterials.WHISPERING_STEEL, ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_CHESTPLATE = ITEMS.register("whispering_steel_chestplate", () 
			-> new ArmorItem(ModArmorMaterials.WHISPERING_STEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_LEGGINGS = ITEMS.register("whispering_steel_leggings", () 
			-> new ArmorItem(ModArmorMaterials.WHISPERING_STEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<Item> WHISPERING_STEEL_BOOTS = ITEMS.register("whispering_steel_boots", () 
			-> new ArmorItem(ModArmorMaterials.WHISPERING_STEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
}
