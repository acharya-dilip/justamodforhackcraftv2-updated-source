package net.jctb.justamodforhackcraftv2;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.jctb.justamodforhackcraftv2.block.ModBlocks;
import net.jctb.justamodforhackcraftv2.item.Moditems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(craftthisthing.MOD_ID)
public class craftthisthing
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "justamodforhackcraftv2";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public craftthisthing()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



        //Calling the files and codes of the items and blocks file and defining them as a mod event bus in this function and keyword below
        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }



    //Setting up the final FMLCommon SeupEvent function and defining it in the function written below as a private void function
    private void commonSetup(final FMLCommonSetupEvent event)
    {  }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {


        //Event Case for adding items to the game using this condition as fetch them in ingredients as other items.
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(Moditems.STEEL);
            event.accept(Moditems.CHARGED_STEEL_DRILL);
            event.accept(Moditems.STEEL_DRILL);
            event.accept(Moditems.SUPERTATER);
            event.accept(Moditems.ENERGIZER);
            event.accept(Moditems.DRILL_BIT);

        }



//Event Case for adding a block to the minecraft using this mod and this condition helps to get the work done to add the blocks to the game and use it as regular blocks
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.STEEL_BLOCK_REINFORCED);
            event.accept(ModBlocks.STEEL_CASING);
            event.accept(ModBlocks.STEEL_GIRDLE);
            event.accept(ModBlocks.STEEL_LAMP);
            event.accept(ModBlocks.STEEL_LAMP_GREEN);
            event.accept(ModBlocks.STEEL_LAMP_PURPLE);
            event.accept(ModBlocks.STEEL_LAMP_RED);
        }


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent


        //defining the client setup public static main function
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code

        }
    }
}