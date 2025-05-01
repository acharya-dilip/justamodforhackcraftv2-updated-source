package net.jctb.justamodforhackcraftv2.item;
import net.jctb.justamodforhackcraftv2.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier STEEL = new ForgeTier(2560, 4, 2f, 20,
            ModTags.Blocks.NEEDS_STEEL_TOOL, () -> Ingredient.of(Moditems.STEEL.get()),
            ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL);
public static final Tier CHARGED_STEEL = new ForgeTier(5600,80, 5f, 20,
        ModTags.Blocks.NEEDS_CHARGED_STEEL_TOOL, () -> Ingredient.of(Moditems.ENERGIZER.get()),
        ModTags.Blocks.INCORRECT_FOR_CHARGED_STEEL_TOOL);
}
