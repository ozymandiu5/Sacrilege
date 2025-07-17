package com.ozymandiu5.sacrilege.init;

import java.util.function.Supplier;

import com.ozymandiu5.sacrilege.Sacrilege;

import com.ozymandiu5.sacrilege.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {

	WHISPERING_STEEL("whispering_steel", 7250, new int[] { 6, 12, 8, 4 }, 30, ModSounds.EQUIP_WHISPERING_STEEL.get(), 2f, 0.2f, () -> Ingredient.of(ItemInit.WHISPERING_STEEL.get())),

	SCULK_COVERED_IRON("sculk_covered_iron", 96, new int[] { 2, 6, 3, 2 }, 25, SoundEvents.ARMOR_EQUIP_IRON, 1f, 0f, () -> Ingredient.of(Items.IRON_INGOT));

	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantmentValue;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;

	private static final int[] BASE_DURABILITY = { 1, 1, 1, 1 };

	ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantmentValue = enchantmentValue;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurabilityForType(Type pType) {
		return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForType(Type pType) {
		return this.protectionAmounts[pType.ordinal()];
	}

	@Override
	public int getEnchantmentValue() {
		return enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return Sacrilege.MODID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

}
