package net.whemop.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.whemop.tutorialmod.block.ModBlocks;
import net.whemop.tutorialmod.item.ModItems;
import net.whemop.tutorialmod.util.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registeredModItems();
		ModBlocks.registerModBlocks();

		ModRegistries.registerModStuffs();

	}
}
