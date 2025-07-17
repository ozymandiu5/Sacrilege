package com.ozymandiu5.sacrilege;

import com.ozymandiu5.sacrilege.block.ModBlocks;
import com.ozymandiu5.sacrilege.effect.ModEffects;
import com.ozymandiu5.sacrilege.sound.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.ozymandiu5.sacrilege.entity.ModEntities;
import com.ozymandiu5.sacrilege.init.ItemInit;
import com.ozymandiu5.sacrilege.items.AltarItem;
import com.ozymandiu5.sacrilege.items.ScalpelItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Sacrilege.MODID)
public class Sacrilege {
	public static final String MODID = "sacrilege";
	private static final Logger LOGGER = LogUtils.getLogger();

	public Sacrilege() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		modEventBus.addListener(this::commonSetup);

		MinecraftForge.EVENT_BUS.register(this);
		ItemInit.ITEMS.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModEntities.ENTITY_TYPES.register(modEventBus);

		ModSounds.register(modEventBus);
		ModEffects.register(modEventBus);
	}

	private void commonSetup(final FMLCommonSetupEvent event) {
		LOGGER.info("Sacrilege setting up...");
		LOGGER.info("There is no going back.");
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {

	}

	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			EntityRenderers.register(ModEntities.SCULK_ROCK_PROJECTILE.get(), ThrownItemRenderer::new);
			LOGGER.info("have fun " + Minecraft.getInstance().getUser().getName() + "!! :3");
			
			ItemProperties.register(ItemInit.SCALPEL.get(), new ResourceLocation(MODID, "is_used"),
					(stack, world, player, seed) -> {
						return ScalpelItem.isUsed(stack) ? 1 : 0;
			});
			
			ItemProperties.register(ItemInit.ALTAR.get(), new ResourceLocation(MODID, "altar_type"),
					(stack, world, player, seed) -> AltarItem.getAltarType(stack));
		}
	}
}
