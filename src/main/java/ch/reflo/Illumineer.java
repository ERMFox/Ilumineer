package ch.reflo;

import ch.reflo.block.ModBlocks;
import ch.reflo.item.ModItemGroups;
import ch.reflo.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Illumineer implements ModInitializer {
	public static final String MOD_ID = "illumineer";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		LOGGER.info("Hello Fabric world!");

	}
}