package ch.reflo.item.custom_tier;


import ch.reflo.Illumineer;
import ch.reflo.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class HardlightTier implements ToolMaterial {


    @Override
    public int getDurability() {
        return 1300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.5f;
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    @Override
    public int getEnchantability() {
        return 35;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // Define the repair material for this tier
        return Ingredient.ofItems(ModItems.HARDLIGHT_IN_A_JAR);  // Placeholder
    }
}
