package net.whemop.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.whemop.tutorialmod.TutorialMod;
import net.minecraft.util.registry.Registry;
import net.whemop.tutorialmod.item.custom.DowsingRodItem;
import net.whemop.tutorialmod.item.custom.ModAxeItem;
import net.whemop.tutorialmod.item.custom.ModHoeItem;
import net.whemop.tutorialmod.item.custom.ModPickaxeItem;
import org.lwjgl.system.CallbackI;

public class ModItems {
    // Mythril Ingot
    public static final Item MYTHRIL_INGOT = registerItem("mythril_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Mythril Nugget
    public static final Item MYTHRIL_NUGGET = registerItem("mythril_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Raw Mythril
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Dowsing Rod
    public static final Item DOWNSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.MYTHRIL).maxDamage(16)));
    // Lilac Flower Bulb
    public static final Item LILAC_FLOWER_BULB = registerItem("lilac_flower_bulb",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Grape
    public static final Item GRAPE = registerItem("grape",
            new Item(new FabricItemSettings().group(ModItemGroup.MYTHRIL).food(ModFoodComponents.GRAPE)));
    // Mythril Sword
    public static final Item MYTHRIL_SWORD = registerItem("mythril_sword",
            new SwordItem(ModToolMaterials.MYTHRIL, 1, 2f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Mythril Pickaxe
    public static final Item MYTHRIL_PICKAXE = registerItem("mythril_pickaxe",
            new ModPickaxeItem(ModToolMaterials.MYTHRIL, 2, 2f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Mythril Axe
    public static final Item MYTHRIL_AXE = registerItem("mythril_axe",
            new ModAxeItem(ModToolMaterials.MYTHRIL, 3, 1f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Mythril Shovel
    public static final Item MYTHRIL_SHOVEL = registerItem("mythril_shovel",
            new ShovelItem(ModToolMaterials.MYTHRIL, 1, 2f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));
    // Mythril Hoe
    public static final Item MYTHRIL_HOE = registerItem("mythril_hoe",
            new ModHoeItem(ModToolMaterials.MYTHRIL, 0, 0f, new FabricItemSettings().group(ModItemGroup.MYTHRIL)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registeredModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }

}
