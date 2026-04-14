package net.yuelqnn.templatemod;

import net.fabricmc.api.ModInitializer;

import net.yuelqnn.templatemod.block.ModBlocks;
import net.yuelqnn.templatemod.item.ModItemGroups;
import net.yuelqnn.templatemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateMod implements ModInitializer {
	public static final String MOD_ID = "templatemod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}