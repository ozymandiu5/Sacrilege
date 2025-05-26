package com.ozymandiu5.sacrilege;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.ozymandiu5.sacrilege.entity.ModEntities;
import com.ozymandiu5.sacrilege.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
		ModEntities.ENTITY_TYPES.register(modEventBus);
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
		}
	}
}
