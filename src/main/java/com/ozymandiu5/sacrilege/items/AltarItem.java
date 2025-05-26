package com.ozymandiu5.sacrilege.items;

import java.util.function.Consumer;

import com.ozymandiu5.sacrilege.Sacrilege;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

public class AltarItem extends Item {
	
	   public AltarItem(Item.Properties properties) {
		   	super(properties);
	   }
	   
		public static int getAltarType(ItemStack stack) {
			CompoundTag nbt = stack.getOrCreateTag();
			try{
				return (int)nbt.getFloat("altar_type");
			} catch(IllegalArgumentException err) {
				return 0;
			}
		}

		public static void setAltarType(ItemStack stack, int altarType) {
			CompoundTag nbt = stack.getOrCreateTag();
			nbt.putFloat("altar_type", altarType);
		}
		
	   public InteractionResult useOn(UseOnContext p_40510_) {
		      Direction direction = p_40510_.getClickedFace();
		      if (direction == Direction.DOWN) {
		         return InteractionResult.FAIL;
		      } else {
		         Level level = p_40510_.getLevel();
		         BlockPlaceContext blockplacecontext = new BlockPlaceContext(p_40510_);
		         BlockPos blockpos = blockplacecontext.getClickedPos();
		         ItemStack itemstack = p_40510_.getItemInHand();
		         Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
		         AABB aabb = EntityType.ARMOR_STAND.getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());
		         if (level.noCollision((Entity)null, aabb) && level.getEntities((Entity)null, aabb).isEmpty()) {
		            if (level instanceof ServerLevel) {
		               ServerLevel serverlevel = (ServerLevel)level;
		               Consumer<ArmorStand> consumer = EntityType.createDefaultStackConfig(serverlevel, itemstack, p_40510_.getPlayer());
		               ArmorStand armorstand = EntityType.ARMOR_STAND.create(serverlevel, itemstack.getTag(), consumer, blockpos, MobSpawnType.SPAWN_EGG, true, true);
		               if (armorstand == null) {
		                  return InteractionResult.FAIL;
		               }
		               CompoundTag compound = new CompoundTag();
		               compound.putBoolean("Small", true);
		               compound.putBoolean("NoGravity", true);
		               compound.putBoolean("Invisible", true);
		               compound.putInt("DisabledSlots", 1052688);
		               armorstand.readAdditionalSaveData(compound);
		               armorstand.setItemSlot(EquipmentSlot.HEAD, itemstack);
		               float f = (float)Mth.floor((Mth.wrapDegrees(p_40510_.getRotation() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
		               armorstand.moveTo(armorstand.getX(), armorstand.getY(), armorstand.getZ(), f, 0.0F);
		               serverlevel.addFreshEntityWithPassengers(armorstand);
		               level.playSound((Player)null, armorstand.getX(), armorstand.getY(), armorstand.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
		               armorstand.gameEvent(GameEvent.ENTITY_PLACE, p_40510_.getPlayer());
		            }

		            itemstack.shrink(1);
		            return InteractionResult.sidedSuccess(level.isClientSide);
		         } else {
		            return InteractionResult.FAIL;
		         }
		      }
		   }
}
