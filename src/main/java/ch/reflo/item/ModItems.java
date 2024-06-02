package ch.reflo.item;
// Imports
import ch.reflo.Illumineer;
import ch.reflo.item.custom.HardlightAxeItem;
import ch.reflo.item.custom.HardlightSwordItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * this class adds new mod items
 */
public class ModItems {

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(Item.ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", 8, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).add(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier( "Weapon modifier", -2.4f, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build();
    }
    // copy the item here and reasign params to what you need them to be

    public static final Item HARDLIGHT_IN_A_JAR = registerItem("hardlight_in_a_jar", new Item(new Item.Settings()));
    public static final Item HARDLIGHT_SWORD = registerItem("hardlight_sword", (Item)new HardlightSwordItem(ModToolMaterial.HARDLIGHTOOL_MATERIAL, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.HARDLIGHTOOL_MATERIAL, 8, -1.4f))));
    //public static final ToolItem W = registerToolItem("w", new AxeItem(ModToolMaterial.HARDLIGHTOOL_MATERIAL, new Item.Settings()));
    public static final Item HARDLIGHT_AXE = registerItem("hardlight_axe", (Item)new AxeItem(ModToolMaterial.HARDLIGHTOOL_MATERIAL, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.HARDLIGHTOOL_MATERIAL, 8.0f, -3.2f))));
    public static final Item HARDLIGHT_PICKAXE = registerItem("hardlight_pickaxe", (Item)new PickaxeItem(ModToolMaterial.HARDLIGHTOOL_MATERIAL, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.HARDLIGHTOOL_MATERIAL, 8.0f, -2.8f))));

    /*
    public static final Item WOODEN_SWORD = Items.register("wooden_sword", (Item)new SwordItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.WOOD, 3, -2.4f))));
    public static final Item WOODEN_SHOVEL = Items.register("wooden_shovel", (Item)new ShovelItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.WOOD, 1.5f, -3.0f))));
    public static final Item WOODEN_PICKAXE = Items.register("wooden_pickaxe", (Item)new PickaxeItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, 1.0f, -2.8f))));
    public static final Item WOODEN_AXE = Items.register("wooden_axe", (Item)new AxeItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.WOOD, 6.0f, -3.2f))));
    public static final Item WOODEN_HOE = Items.register("wooden_hoe", (Item)new HoeItem(ToolMaterials.WOOD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.WOOD, 0.0f, -3.0f))));

     */

    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(HARDLIGHT_IN_A_JAR);
        // new items added here
    }
    private static void addItemstoCombatItemGroup(FabricItemGroupEntries entries){
        entries.add(HARDLIGHT_SWORD);
    }
    private static void addItemstoToolItemGroup(FabricItemGroupEntries entries){
        entries.add(HARDLIGHT_AXE);
        entries.add(HARDLIGHT_PICKAXE);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Illumineer.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Illumineer.LOGGER.info("registering mod items for: " + Illumineer.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemstoCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemstoToolItemGroup);
    }
}
