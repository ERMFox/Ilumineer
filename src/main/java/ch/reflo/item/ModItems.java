package ch.reflo.item;
// Imports
import ch.reflo.Illumineer;
import ch.reflo.item.custom_tier.HardlightTier;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * this class adds new mod items
 */
public class ModItems {
    // copy the item here and reasign params to what you need them to be
    public static final HardlightTier HARDLIGHT_TIER = new HardlightTier();

    public static final Item HARDLIGHT_IN_A_JAR = registerItem("hardlight_in_a_jar", new Item(new Item.Settings()));
    public static final ToolItem HARDLIGHT_SWORD = registerToolItem("hardlight_sword", new SwordItem(HARDLIGHT_TIER, new SwordItem.Settings()));

    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(HARDLIGHT_SWORD);
        entries.add(HARDLIGHT_IN_A_JAR);
        // new items added here
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Illumineer.MOD_ID, name), item);
    }
    private static ToolItem registerToolItem(String name, ToolItem item){
        return Registry.register(Registries.ITEM, new Identifier(Illumineer.MOD_ID, name), item);
    }
    public static void registerModItems(){
        Illumineer.LOGGER.info("registering mod items for: " + Illumineer.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
