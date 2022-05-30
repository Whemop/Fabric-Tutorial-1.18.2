package net.whemop.tutorialmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.whemop.tutorialmod.TutorialMod;
import net.whemop.tutorialmod.block.custom.*;
import net.whemop.tutorialmod.item.ModItemGroup;

public class ModBlocks {

    // Mythril Block
    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
        new Block(FabricBlockSettings.of(Material.METAL).strength(5f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Ore
    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Deepslate Mythril Ore
    public static final Block DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool()), ModItemGroup.MYTHRIL);
    // Netherrack Mythril Ore
    public static final Block NETHERRACK_MYTHRIL_ORE = registerBlock("netherrack_mythril_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Raw Mythril Block
    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Speedy Block
    public static final Block SPEEDY_BLOCK = registerBlock("speedy_block",
            new SpeedyBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Button Block
    public static final Block MYTHRIL_BUTTON = registerBlock("mythril_button",
            new ModStoneButtonBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool().noCollision()), ModItemGroup.MYTHRIL);
    // Mythril Pressure Plate
    public static final Block MYTHRIL_PRESSURE_PLATE = registerBlock("mythril_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Fence
    public static final Block MYTHRIL_FENCE = registerBlock("mythril_fence",
            new FenceBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Fence Gate
    public static final Block MYTHRIL_FENCE_GATE = registerBlock("mythril_fence_gate",
            new FenceGateBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Wall
    public static final Block MYTHRIL_WALL = registerBlock("mythril_wall",
            new WallBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Slab
    public static final Block MYTHRIL_SLAB = registerBlock("mythril_slab",
            new SlabBlock(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Mythril Stairs
    public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs",
            new ModStairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.MYTHRIL);
    // Kaupen Door
    public static final Block KAUPEN_DOOR = registerBlock("kaupen_door",
            new ModDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);
    // Kaupen Trapdoor
    public static final Block KAUPEN_TRAPDOOR = registerBlock("kaupen_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3f).requiresTool().nonOpaque()), ModItemGroup.MYTHRIL);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering ModBlocks for " + TutorialMod.MOD_ID);
    }

}
