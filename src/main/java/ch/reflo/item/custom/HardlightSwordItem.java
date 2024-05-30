package ch.reflo.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class HardlightSwordItem extends SwordItem {
    public HardlightSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }



    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(5);
        return super.postHit(stack, target, attacker);
    }
}
