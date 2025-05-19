package com.ozymandiu5.sacrilege.util;

import com.ozymandiu5.sacrilege.Sacrilege;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
	public static class Blocks{
		public static final TagKey<Block> NEEDS_WHISPERING_STEEL_TOOL = tag("needs_whispering_steel_tool");
		public static final TagKey<Block> NEEDS_SCULK_COVERED_IRON_TOOL = tag("needs_sculk_covered_iron_tool");
		
		private static TagKey<Block> tag(String name){
			return BlockTags.create(new ResourceLocation(Sacrilege.MODID, name));
		}
	}
	
	public static class Items{
		private static TagKey<Item> tag(String name){
			return ItemTags.create(new ResourceLocation(Sacrilege.MODID, name));
		}
	}
}
