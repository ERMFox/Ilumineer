package ch.reflo.item;
// Imports

import ch.reflo.Illumineer;
import ch.reflo.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * This class adds items into a new group, one could also to my understanding add multiple
 */
public class ModItemGroups {
    // copy this and make another one to add more groups
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Illumineer.MOD_ID, "hardlight_in_a_jar"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup_illumineer"))
                    .icon(() -> new ItemStack(ModItems.HARDLIGHT_IN_A_JAR)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HARDLIGHT_IN_A_JAR);
                        entries.add(ModBlocks.HARDLIGHT_BLOCK);
                        entries.add(ModBlocks.BRIDGECONTROLLER_BLOCK);
                        entries.add(ModItems.HARDLIGHT_SWORD);
                        entries.add(ModItems.HARDLIGHT_PICKAXE);
                        entries.add(ModItems.HARDLIGHT_AXE);

                        //more entries added here
                    }).build());
    public static void registerItemGroups(){
        Illumineer.LOGGER.info("Registering item groups for: "+ Illumineer.MOD_ID);
    }
}
