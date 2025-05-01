package net.jctb.justamodforhackcraftv2;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = craftthisthing.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    // Initializes the Forge configuration builder used to define config options.
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    //Configuration Option to enable or disable logging of the dirt block during the common setup phase
    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);


    //Configuration option for setting a magic number (default: 42), must be between 0 and Integer.MAX_VALUE.
    private static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);



    // Configuration option to set the introduction message displayed before showing tthe magis number.
    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);


    //Builds and stores the finalized configuration specification using the defined settings.
    static final ForgeConfigSpec SPEC = BUILDER.build();


    //Indicates whether logging of the dirt block is enabled.
    public static boolean logDirtBlock;

    //Holds the configured magic number value
    public static int magicNumber;

    // Stores the custom introduction message for the magic number
    public static String magicNumberIntroduction;


    // A set containing item instances, typically used for configuration or feature control
    public static Set<Item> items;


    //Validate whether the given object is a valid item name string and exists in the item registry
    private static boolean validateItemName(final Object obj)
    {

        //Check if the object is a string and if it corresponds to a valid item in the registry.
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(itemName));
    }


    // Subscribes to the mod configuration loading event.
    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

        // Load the boolean config value for logging the dirt block.
        logDirtBlock = LOG_DIRT_BLOCK.get();

        // Load the integer config value for the magic number.
        magicNumber = MAGIC_NUMBER.get();

        // Load the string config value for the magic number introduction message.
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // Convert the list of item name strings into a Set of actual Item objects from the registry.
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName)))
                .collect(Collectors.toSet());
    }
}