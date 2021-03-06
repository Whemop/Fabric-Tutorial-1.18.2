package net.whemop.tutorialmod.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.whemop.tutorialmod.TutorialMod;
import net.whemop.tutorialmod.item.ModItems;

public class ModRegistries {

    public static void registerModStuffs() {
        registerFuels();
    }

    private static void registerFuels() {
        TutorialMod.LOGGER.info("registering Fuels for " + TutorialMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.LILAC_FLOWER_BULB, 200);
    }

}
