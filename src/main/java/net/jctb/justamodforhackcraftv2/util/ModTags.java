package net.jctb.justamodforhackcraftv2.util;
import net.jctb.justamodforhackcraftv2.craftthisthing;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");
        public static final TagKey<Block> NEEDS_CHARGED_STEEL_TOOL = createTag("needs_charged_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHARGED_STEEL_TOOL = createTag("incorrect_for_charged_steel_tool");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(craftthisthing.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(craftthisthing.MOD_ID, name));
        }
    }
}