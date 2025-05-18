package com.ozymandiu5.sacrilege.init;

import com.ozymandiu5.sacrilege.util.ModTags;
import com.ozymandiu5.sacrilege.Sacrilege;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import java.util.List;

public class ModToolTiers {
	public static final Tier WHISPERING_STEEL = TierSortingRegistry.registerTier(
			new ForgeTier(5, 7250, 9.5f, 4.0f, 25,
					ModTags.Blocks.NEEDS_WHISPERING_STEEL_TOOL, () -> Ingredient.of(ItemInit.WHISPERING_STEEL.get())),
			new ResourceLocation(Sacrilege.MODID, "whispering_steel"), List.of(Tiers.NETHERITE), List.of());
}
