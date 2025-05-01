package net.jctb.justamodforhackcraftv2.block;//Importing different packages to the program and defining the required packages to use different keywords and values
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.jctb.justamodforhackcraftv2.craftthisthing;
import net.jctb.justamodforhackcraftv2.item.Moditems;

import java.util.function.Supplier;

//Defining the public main class to the Mod Blocks File as ModBlocks
public class ModBlocks {


    //Defining the BLOCKS value to input the blocks defination
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, craftthisthing.MOD_ID);



    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final RegistryObject<Block> STEEL_BLOCK_REINFORCED= registerBlock("steel_block_reinforced",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> STEEL_CASING= registerBlock("steel_casing",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.LODESTONE)));
    public static final RegistryObject<Block> STEEL_GIRDLE= registerBlock("steel_girdle",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.LODESTONE)));
    public static final RegistryObject<Block> STEEL_LAMP= registerBlock("steel_lamp",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.COPPER).lightLevel((state) -> 15)));
    public static final RegistryObject<Block> STEEL_LAMP_GREEN= registerBlock("steel_lamp_green",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.COPPER).lightLevel((state) -> 15)));
    public static final RegistryObject<Block> STEEL_LAMP_RED= registerBlock("steel_lamp_red",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.COPPER).lightLevel((state) -> 15)));
    public static final RegistryObject<Block> STEEL_LAMP_PURPLE= registerBlock("steel_lamp_purple",
            () -> new Block(BlockBehaviour.Properties.of().strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.COPPER).lightLevel((state) -> 15)));




    //Defining the most required components for defining a block in a minecraft mod program
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {

        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }


    //Defining the required components fo defining a block in a minecraft program
    private static<T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {

        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }


    //Defining the required components for defining a block in a minecraft mod program
    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }

}