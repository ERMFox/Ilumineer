package ch.reflo.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.block.Block;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    HARDLIGHTOOL_MATERIAL(MiningLevels.NETHERITE, 7.5f, 9, 30,
            () ->Ingredient.ofItems(ModItems.HARDLIGHT_IN_A_JAR));

    private final int durability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repaitIngredient;

    ModToolMaterial(int durability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repaitIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repaitIngredient = repaitIngredient;
    }

    /**
     * @return
     */
    @Override
    public int getDurability() {
        return this.durability;
    }

    /**
     * @return
     */
    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    /**
     * @return
     */
    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    /**
     * @return
     */
    @Override
    public TagKey<Block> getInverseTag() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    /**
     * @return
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.repaitIngredient.get();
    }

    /**
     * @param tag
     * @return
     */
    @Override
    public ToolComponent createComponent(TagKey<Block> tag) {
        return ToolMaterial.super.createComponent(tag);
    }
}
