package com.ozymandiu5.sacrilege.block;

import com.ozymandiu5.sacrilege.Sacrilege;
import com.ozymandiu5.sacrilege.init.ItemInit;
import com.ozymandiu5.sacrilege.sound.ModSounds;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Sacrilege.MODID);

    public static final RegistryObject<Block> NULLSTONE = registerBlock("nullstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE)
                    .strength(30.0f, 800.0f)
            ));
    public static final RegistryObject<Block> COBBLED_NULLSTONE = registerBlock("cobbled_nullstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.COBBLED_DEEPSLATE)
                    .strength(20.0F, 600.0F)
            ));
    public static final RegistryObject<Block> OBSCURED_NULLSTONE = registerBlock("obscured_nullstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.DEEPSLATE)
                    .strength(50.0f, 2000.0f)
                    .sound(new SoundType(1.0F, 1.0F, ModSounds.OBSCURED_NULLSTONE_BREAK.get(), ModSounds.OBSCURED_NULLSTONE_STEP.get(), ModSounds.OBSCURED_NULLSTONE_PLACE.get(), ModSounds.OBSCURED_NULLSTONE_HIT.get(), ModSounds.OBSCURED_NULLSTONE_FALL.get()))
            ));
    public static final RegistryObject<Block> COBBLED_OBSCURED_NULLSTONE = registerBlock("cobbled_obscured_nullstone",
            () -> new Block(BlockBehaviour.Properties
                    .copy(Blocks.COBBLED_DEEPSLATE)
                    .strength(40.0F, 1600.0F)
                    .sound(new SoundType(1.0F, 1.0F, ModSounds.OBSCURED_NULLSTONE_BREAK.get(), ModSounds.OBSCURED_NULLSTONE_STEP.get(), ModSounds.OBSCURED_NULLSTONE_PLACE.get(), ModSounds.OBSCURED_NULLSTONE_HIT.get(), ModSounds.OBSCURED_NULLSTONE_FALL.get()))
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
