/*
 * This file is part of the New Creative Inventory project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  Plastoid501 and contributors
 *
 * New Creative Inventory is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * New Creative Inventory is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with New Creative Inventory.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.plastoid501.nci.item;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
//#if MC <= 11402
//$$ import net.minecraft.network.chat.TranslatableComponent;
//#elseif MC <= 11802
//$$ import net.minecraft.text.TranslatableText;
//#else
import net.minecraft.text.Text;
//#endif
//#if MC >= 11402
//#if MC <= 11502
//$$ import net.minecraft.entity.raid.Raid;
//#else
import net.minecraft.village.raid.Raid;
//#endif
//#endif


public class NewItemGroups
{
    public static final NewItemGroup[] GROUPS = new NewItemGroup[14];
    public static final NewItemGroup BUILDING_BLOCKS = new NewItemGroup(
            "building_blocks",
            0,
            "plastoid501.newItemGroup.buildingBlocks",
            new ItemStack(Blocks.BRICKS)
    );

    public static final NewItemGroup COLORED_BLOCKS = new NewItemGroup(
            "colored_blocks",
            1,
            "plastoid501.newItemGroup.coloredBlocks",
            new ItemStack(Blocks.CYAN_WOOL)
    );

    public static final NewItemGroup NATURAL = new NewItemGroup(
            "natural_blocks",
            2,
            "plastoid501.newItemGroup.natural",
            new ItemStack(Blocks.GRASS_BLOCK)
    );

    public static final NewItemGroup FUNCTIONAL = new NewItemGroup(
            "functional_blocks",
            3,
            "plastoid501.newItemGroup.functional",
            new ItemStack(Items.OAK_SIGN)
    );

    public static final NewItemGroup REDSTONE = new NewItemGroup(
            "redstone_blocks",
            4,
            "plastoid501.newItemGroup.redstone",
            new ItemStack(Items.REDSTONE)
    );

    public static final NewItemGroup HOTBAR = new NewItemGroup(
            "hotbar",
            5,
            "plastoid501.newItemGroup.hotbar",
            new ItemStack(Blocks.BOOKSHELF)
    );

    public static final NewItemGroup SEARCH = new NewItemGroup(
            "search",
            6,
            "plastoid501.newItemGroup.search",
            new ItemStack(Items.COMPASS)
    );

    public static final NewItemGroup TOOLS = new NewItemGroup(
            "tools_and_utilities",
            7,
            "plastoid501.newItemGroup.tools",
            new ItemStack(Items.DIAMOND_PICKAXE)
    );

    public static final NewItemGroup COMBAT = new NewItemGroup(
            "combat",
            8,
            "plastoid501.newItemGroup.combat",
            new ItemStack(
                    //#if MC <= 11502
                    //$$ Items.DIAMOND_SWORD
                    //#else
                    Items.NETHERITE_SWORD
                    //#endif
            )
    );

    public static final NewItemGroup FOOD_AND_DRINK = new NewItemGroup(
            "food_and_drinks",
            9,
            "plastoid501.newItemGroup.foodAndDrink",
            new ItemStack(Items.GOLDEN_APPLE)
    );

    public static final NewItemGroup INGREDIENTS = new NewItemGroup(
            "ingredients",
            10,
            "plastoid501.newItemGroup.ingredients",
            new ItemStack(Items.IRON_INGOT)
    );

    public static final NewItemGroup SPAWN_EGGS = new NewItemGroup(
            "spawn_eggs",
            11,
            "plastoid501.newItemGroup.spawnEggs",
            new ItemStack(Items.PIG_SPAWN_EGG)
    );

    public static final NewItemGroup OPERATOR = new NewItemGroup(
            "op_blocks",
            12,
            "plastoid501.newItemGroup.op",
            new ItemStack(Items.COMMAND_BLOCK)
    );

    public static final NewItemGroup INVENTORY = new NewItemGroup(
            "inventory",
            13,
            "plastoid501.newItemGroup.inventory",
            new ItemStack(Blocks.CHEST)
    );

    static {
        BUILDING_BLOCKS.setItems(entry -> {
            entry.add(Items.OAK_LOG);
            entry.add(Items.OAK_WOOD);
            entry.add(Items.STRIPPED_OAK_LOG);
            entry.add(Items.STRIPPED_OAK_WOOD);
            entry.add(Items.OAK_PLANKS);
            entry.add(Items.OAK_STAIRS);
            entry.add(Items.OAK_SLAB);
            entry.add(Items.OAK_FENCE);
            entry.add(Items.OAK_FENCE_GATE);
            entry.add(Items.OAK_DOOR);
            entry.add(Items.OAK_TRAPDOOR);
            entry.add(Items.OAK_PRESSURE_PLATE);
            entry.add(Items.OAK_BUTTON);
            entry.add(Items.SPRUCE_LOG);
            entry.add(Items.SPRUCE_WOOD);
            entry.add(Items.STRIPPED_SPRUCE_LOG);
            entry.add(Items.STRIPPED_SPRUCE_WOOD);
            entry.add(Items.SPRUCE_PLANKS);
            entry.add(Items.SPRUCE_STAIRS);
            entry.add(Items.SPRUCE_SLAB);
            entry.add(Items.SPRUCE_FENCE);
            entry.add(Items.SPRUCE_FENCE_GATE);
            entry.add(Items.SPRUCE_DOOR);
            entry.add(Items.SPRUCE_TRAPDOOR);
            entry.add(Items.SPRUCE_PRESSURE_PLATE);
            entry.add(Items.SPRUCE_BUTTON);
            entry.add(Items.BIRCH_LOG);
            entry.add(Items.BIRCH_WOOD);
            entry.add(Items.STRIPPED_BIRCH_LOG);
            entry.add(Items.STRIPPED_BIRCH_WOOD);
            entry.add(Items.BIRCH_PLANKS);
            entry.add(Items.BIRCH_STAIRS);
            entry.add(Items.BIRCH_SLAB);
            entry.add(Items.BIRCH_FENCE);
            entry.add(Items.BIRCH_FENCE_GATE);
            entry.add(Items.BIRCH_DOOR);
            entry.add(Items.BIRCH_TRAPDOOR);
            entry.add(Items.BIRCH_PRESSURE_PLATE);
            entry.add(Items.BIRCH_BUTTON);
            entry.add(Items.JUNGLE_LOG);
            entry.add(Items.JUNGLE_WOOD);
            entry.add(Items.STRIPPED_JUNGLE_LOG);
            entry.add(Items.STRIPPED_JUNGLE_WOOD);
            entry.add(Items.JUNGLE_PLANKS);
            entry.add(Items.JUNGLE_STAIRS);
            entry.add(Items.JUNGLE_SLAB);
            entry.add(Items.JUNGLE_FENCE);
            entry.add(Items.JUNGLE_FENCE_GATE);
            entry.add(Items.JUNGLE_DOOR);
            entry.add(Items.JUNGLE_TRAPDOOR);
            entry.add(Items.JUNGLE_PRESSURE_PLATE);
            entry.add(Items.JUNGLE_BUTTON);
            entry.add(Items.ACACIA_LOG);
            entry.add(Items.ACACIA_WOOD);
            entry.add(Items.STRIPPED_ACACIA_LOG);
            entry.add(Items.STRIPPED_ACACIA_WOOD);
            entry.add(Items.ACACIA_PLANKS);
            entry.add(Items.ACACIA_STAIRS);
            entry.add(Items.ACACIA_SLAB);
            entry.add(Items.ACACIA_FENCE);
            entry.add(Items.ACACIA_FENCE_GATE);
            entry.add(Items.ACACIA_DOOR);
            entry.add(Items.ACACIA_TRAPDOOR);
            entry.add(Items.ACACIA_PRESSURE_PLATE);
            entry.add(Items.ACACIA_BUTTON);
            entry.add(Items.DARK_OAK_LOG);
            entry.add(Items.DARK_OAK_WOOD);
            entry.add(Items.STRIPPED_DARK_OAK_LOG);
            entry.add(Items.STRIPPED_DARK_OAK_WOOD);
            entry.add(Items.DARK_OAK_PLANKS);
            entry.add(Items.DARK_OAK_STAIRS);
            entry.add(Items.DARK_OAK_SLAB);
            entry.add(Items.DARK_OAK_FENCE);
            entry.add(Items.DARK_OAK_FENCE_GATE);
            entry.add(Items.DARK_OAK_DOOR);
            entry.add(Items.DARK_OAK_TRAPDOOR);
            entry.add(Items.DARK_OAK_PRESSURE_PLATE);
            entry.add(Items.DARK_OAK_BUTTON);
            //#if MC >= 11900
            entry.add(Items.MANGROVE_LOG);
            entry.add(Items.MANGROVE_WOOD);
            entry.add(Items.STRIPPED_MANGROVE_LOG);
            entry.add(Items.STRIPPED_MANGROVE_WOOD);
            entry.add(Items.MANGROVE_PLANKS);
            entry.add(Items.MANGROVE_STAIRS);
            entry.add(Items.MANGROVE_SLAB);
            entry.add(Items.MANGROVE_FENCE);
            entry.add(Items.MANGROVE_FENCE_GATE);
            entry.add(Items.MANGROVE_DOOR);
            entry.add(Items.MANGROVE_TRAPDOOR);
            entry.add(Items.MANGROVE_PRESSURE_PLATE);
            entry.add(Items.MANGROVE_BUTTON);
            //#endif
            //#if MC >= 11600
            entry.add(Items.CRIMSON_STEM);
            entry.add(Items.CRIMSON_HYPHAE);
            entry.add(Items.STRIPPED_CRIMSON_STEM);
            entry.add(Items.STRIPPED_CRIMSON_HYPHAE);
            entry.add(Items.CRIMSON_PLANKS);
            entry.add(Items.CRIMSON_STAIRS);
            entry.add(Items.CRIMSON_SLAB);
            entry.add(Items.CRIMSON_FENCE);
            entry.add(Items.CRIMSON_FENCE_GATE);
            entry.add(Items.CRIMSON_DOOR);
            entry.add(Items.CRIMSON_TRAPDOOR);
            entry.add(Items.CRIMSON_PRESSURE_PLATE);
            entry.add(Items.CRIMSON_BUTTON);
            entry.add(Items.WARPED_STEM);
            entry.add(Items.WARPED_HYPHAE);
            entry.add(Items.STRIPPED_WARPED_STEM);
            entry.add(Items.STRIPPED_WARPED_HYPHAE);
            entry.add(Items.WARPED_PLANKS);
            entry.add(Items.WARPED_STAIRS);
            entry.add(Items.WARPED_SLAB);
            entry.add(Items.WARPED_FENCE);
            entry.add(Items.WARPED_FENCE_GATE);
            entry.add(Items.WARPED_DOOR);
            entry.add(Items.WARPED_TRAPDOOR);
            entry.add(Items.WARPED_PRESSURE_PLATE);
            entry.add(Items.WARPED_BUTTON);
            //#endif
            entry.add(Items.STONE);
            entry.add(Items.STONE_STAIRS);
            entry.add(Items.STONE_SLAB);
            entry.add(Items.STONE_PRESSURE_PLATE);
            entry.add(Items.STONE_BUTTON);
            entry.add(Items.COBBLESTONE);
            entry.add(Items.COBBLESTONE_STAIRS);
            entry.add(Items.COBBLESTONE_SLAB);
            entry.add(Items.COBBLESTONE_WALL);
            entry.add(Items.MOSSY_COBBLESTONE);
            entry.add(Items.MOSSY_COBBLESTONE_STAIRS);
            entry.add(Items.MOSSY_COBBLESTONE_SLAB);
            entry.add(Items.MOSSY_COBBLESTONE_WALL);
            entry.add(Items.SMOOTH_STONE);
            entry.add(Items.SMOOTH_STONE_SLAB);
            entry.add(Items.STONE_BRICKS);
            entry.add(Items.CRACKED_STONE_BRICKS);
            entry.add(Items.STONE_BRICK_STAIRS);
            entry.add(Items.STONE_BRICK_SLAB);
            entry.add(Items.STONE_BRICK_WALL);
            entry.add(Items.CHISELED_STONE_BRICKS);
            entry.add(Items.MOSSY_STONE_BRICKS);
            entry.add(Items.MOSSY_STONE_BRICK_STAIRS);
            entry.add(Items.MOSSY_STONE_BRICK_SLAB);
            entry.add(Items.MOSSY_STONE_BRICK_WALL);
            entry.add(Items.GRANITE);
            entry.add(Items.GRANITE_STAIRS);
            entry.add(Items.GRANITE_SLAB);
            entry.add(Items.GRANITE_WALL);
            entry.add(Items.POLISHED_GRANITE);
            entry.add(Items.POLISHED_GRANITE_STAIRS);
            entry.add(Items.POLISHED_GRANITE_SLAB);
            entry.add(Items.DIORITE);
            entry.add(Items.DIORITE_STAIRS);
            entry.add(Items.DIORITE_SLAB);
            entry.add(Items.DIORITE_WALL);
            entry.add(Items.POLISHED_DIORITE);
            entry.add(Items.POLISHED_DIORITE_STAIRS);
            entry.add(Items.POLISHED_DIORITE_SLAB);
            entry.add(Items.ANDESITE);
            entry.add(Items.ANDESITE_STAIRS);
            entry.add(Items.ANDESITE_SLAB);
            entry.add(Items.ANDESITE_WALL);
            entry.add(Items.POLISHED_ANDESITE);
            entry.add(Items.POLISHED_ANDESITE_STAIRS);
            entry.add(Items.POLISHED_ANDESITE_SLAB);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE);
            entry.add(Items.COBBLED_DEEPSLATE);
            entry.add(Items.COBBLED_DEEPSLATE_STAIRS);
            entry.add(Items.COBBLED_DEEPSLATE_SLAB);
            //#if MC <= 11701
            //$$ entry.add(Items.DEEPSLATE_WALL);
            //#elseif MC >= 11800
            entry.add(Items.COBBLED_DEEPSLATE_WALL);
            //#endif
            entry.add(Items.CHISELED_DEEPSLATE);
            entry.add(Items.POLISHED_DEEPSLATE);
            entry.add(Items.POLISHED_DEEPSLATE_STAIRS);
            entry.add(Items.POLISHED_DEEPSLATE_SLAB);
            entry.add(Items.POLISHED_DEEPSLATE_WALL);
            entry.add(Items.DEEPSLATE_BRICKS);
            entry.add(Items.CRACKED_DEEPSLATE_BRICKS);
            entry.add(Items.DEEPSLATE_BRICK_STAIRS);
            entry.add(Items.DEEPSLATE_BRICK_SLAB);
            entry.add(Items.DEEPSLATE_BRICK_WALL);
            entry.add(Items.DEEPSLATE_TILES);
            entry.add(Items.CRACKED_DEEPSLATE_TILES);
            entry.add(Items.DEEPSLATE_TILE_STAIRS);
            entry.add(Items.DEEPSLATE_TILE_SLAB);
            entry.add(Items.DEEPSLATE_TILE_WALL);
            //#endif
            //#if MC >= 11900
            entry.add(Items.REINFORCED_DEEPSLATE);
            //#endif
            entry.add(Items.BRICKS);
            entry.add(Items.BRICK_STAIRS);
            entry.add(Items.BRICK_SLAB);
            entry.add(Items.BRICK_WALL);
            //#if MC >= 11900
            entry.add(Items.PACKED_MUD);
            entry.add(Items.MUD_BRICKS);
            entry.add(Items.MUD_BRICK_STAIRS);
            entry.add(Items.MUD_BRICK_SLAB);
            entry.add(Items.MUD_BRICK_WALL);
            //#endif
            entry.add(Items.SANDSTONE);
            entry.add(Items.SANDSTONE_STAIRS);
            entry.add(Items.SANDSTONE_SLAB);
            entry.add(Items.SANDSTONE_WALL);
            entry.add(Items.CHISELED_SANDSTONE);
            entry.add(Items.SMOOTH_SANDSTONE);
            entry.add(Items.SMOOTH_SANDSTONE_STAIRS);
            entry.add(Items.SMOOTH_SANDSTONE_SLAB);
            entry.add(Items.CUT_SANDSTONE);
            entry.add(Items.CUT_SANDSTONE_SLAB);
            entry.add(Items.RED_SANDSTONE);
            entry.add(Items.RED_SANDSTONE_STAIRS);
            entry.add(Items.RED_SANDSTONE_SLAB);
            entry.add(Items.RED_SANDSTONE_WALL);
            entry.add(Items.CHISELED_RED_SANDSTONE);
            entry.add(Items.SMOOTH_RED_SANDSTONE);
            entry.add(Items.SMOOTH_RED_SANDSTONE_STAIRS);
            entry.add(Items.SMOOTH_RED_SANDSTONE_SLAB);
            entry.add(Items.CUT_RED_SANDSTONE);
            entry.add(Items.CUT_RED_SANDSTONE_SLAB);
            entry.add(Items.SEA_LANTERN);
            entry.add(Items.PRISMARINE);
            entry.add(Items.PRISMARINE_STAIRS);
            entry.add(Items.PRISMARINE_SLAB);
            entry.add(Items.PRISMARINE_WALL);
            entry.add(Items.PRISMARINE_BRICKS);
            entry.add(Items.PRISMARINE_BRICK_STAIRS);
            entry.add(Items.PRISMARINE_BRICK_SLAB);
            entry.add(Items.DARK_PRISMARINE);
            entry.add(Items.DARK_PRISMARINE_STAIRS);
            entry.add(Items.DARK_PRISMARINE_SLAB);
            entry.add(Items.NETHERRACK);
            entry.add(Items.NETHER_BRICKS);
            //#if MC >= 11600
            entry.add(Items.CRACKED_NETHER_BRICKS);
            //#endif
            entry.add(Items.NETHER_BRICK_STAIRS);
            entry.add(Items.NETHER_BRICK_SLAB);
            entry.add(Items.NETHER_BRICK_WALL);
            entry.add(Items.NETHER_BRICK_FENCE);
            //#if MC >= 11600
            entry.add(Items.CHISELED_NETHER_BRICKS);
            //#endif
            entry.add(Items.RED_NETHER_BRICKS);
            entry.add(Items.RED_NETHER_BRICK_STAIRS);
            entry.add(Items.RED_NETHER_BRICK_SLAB);
            entry.add(Items.RED_NETHER_BRICK_WALL);
            //#if MC >= 11600
            entry.add(Items.BASALT);
            //#endif
            //#if MC >= 11700
            entry.add(Items.SMOOTH_BASALT);
            //#endif
            //#if MC >= 11600
            entry.add(Items.POLISHED_BASALT);
            entry.add(Items.BLACKSTONE);
            entry.add(Items.GILDED_BLACKSTONE);
            entry.add(Items.BLACKSTONE_STAIRS);
            entry.add(Items.BLACKSTONE_SLAB);
            entry.add(Items.BLACKSTONE_WALL);
            entry.add(Items.CHISELED_POLISHED_BLACKSTONE);
            entry.add(Items.POLISHED_BLACKSTONE);
            entry.add(Items.POLISHED_BLACKSTONE_STAIRS);
            entry.add(Items.POLISHED_BLACKSTONE_SLAB);
            entry.add(Items.POLISHED_BLACKSTONE_WALL);
            entry.add(Items.POLISHED_BLACKSTONE_PRESSURE_PLATE);
            entry.add(Items.POLISHED_BLACKSTONE_BUTTON);
            entry.add(Items.POLISHED_BLACKSTONE_BRICKS);
            entry.add(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS);
            entry.add(Items.POLISHED_BLACKSTONE_BRICK_STAIRS);
            entry.add(Items.POLISHED_BLACKSTONE_BRICK_SLAB);
            entry.add(Items.POLISHED_BLACKSTONE_BRICK_WALL);
            //#endif
            entry.add(Items.END_STONE);
            entry.add(Items.END_STONE_BRICKS);
            entry.add(Items.END_STONE_BRICK_STAIRS);
            entry.add(Items.END_STONE_BRICK_SLAB);
            entry.add(Items.END_STONE_BRICK_WALL);
            entry.add(Items.PURPUR_BLOCK);
            entry.add(Items.PURPUR_PILLAR);
            entry.add(Items.PURPUR_STAIRS);
            entry.add(Items.PURPUR_SLAB);
            entry.add(Items.COAL_BLOCK);
            entry.add(Items.IRON_BLOCK);
            entry.add(Items.IRON_BARS);
            entry.add(Items.IRON_DOOR);
            entry.add(Items.IRON_TRAPDOOR);
            entry.add(Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
            //#if MC >= 11600
            entry.add(Items.CHAIN);
            //#endif
            entry.add(Items.GOLD_BLOCK);
            entry.add(Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
            entry.add(Items.REDSTONE_BLOCK);
            entry.add(Items.EMERALD_BLOCK);
            entry.add(Items.LAPIS_BLOCK);
            entry.add(Items.DIAMOND_BLOCK);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_BLOCK);
            //#endif
            entry.add(Items.QUARTZ_BLOCK);
            entry.add(Items.QUARTZ_STAIRS);
            entry.add(Items.QUARTZ_SLAB);
            entry.add(Items.CHISELED_QUARTZ_BLOCK);
            //#if MC >= 11600
            entry.add(Items.QUARTZ_BRICKS);
            //#endif
            entry.add(Items.QUARTZ_PILLAR);
            entry.add(Items.SMOOTH_QUARTZ);
            entry.add(Items.SMOOTH_QUARTZ_STAIRS);
            entry.add(Items.SMOOTH_QUARTZ_SLAB);
            //#if MC >= 11700
            entry.add(Items.AMETHYST_BLOCK);
            entry.add(Items.COPPER_BLOCK);
            entry.add(Items.CUT_COPPER);
            entry.add(Items.CUT_COPPER_STAIRS);
            entry.add(Items.CUT_COPPER_SLAB);
            entry.add(Items.EXPOSED_COPPER);
            entry.add(Items.EXPOSED_CUT_COPPER);
            entry.add(Items.EXPOSED_CUT_COPPER_STAIRS);
            entry.add(Items.EXPOSED_CUT_COPPER_SLAB);
            entry.add(Items.WEATHERED_COPPER);
            entry.add(Items.WEATHERED_CUT_COPPER);
            entry.add(Items.WEATHERED_CUT_COPPER_STAIRS);
            entry.add(Items.WEATHERED_CUT_COPPER_SLAB);
            entry.add(Items.OXIDIZED_COPPER);
            entry.add(Items.OXIDIZED_CUT_COPPER);
            entry.add(Items.OXIDIZED_CUT_COPPER_STAIRS);
            entry.add(Items.OXIDIZED_CUT_COPPER_SLAB);
            //#if MC <= 11701
            //$$ entry.add(Items.WAXED_COPPER);
            //#else
            entry.add(Items.WAXED_COPPER_BLOCK);//if >= 11800
            //#endif
            entry.add(Items.WAXED_CUT_COPPER);
            entry.add(Items.WAXED_CUT_COPPER_STAIRS);
            entry.add(Items.WAXED_CUT_COPPER_SLAB);
            entry.add(Items.WAXED_EXPOSED_COPPER);
            entry.add(Items.WAXED_EXPOSED_CUT_COPPER);
            entry.add(Items.WAXED_EXPOSED_CUT_COPPER_STAIRS);
            entry.add(Items.WAXED_EXPOSED_CUT_COPPER_SLAB);
            entry.add(Items.WAXED_WEATHERED_COPPER);
            entry.add(Items.WAXED_WEATHERED_CUT_COPPER);
            entry.add(Items.WAXED_WEATHERED_CUT_COPPER_STAIRS);
            entry.add(Items.WAXED_WEATHERED_CUT_COPPER_SLAB);
            entry.add(Items.WAXED_OXIDIZED_COPPER);
            entry.add(Items.WAXED_OXIDIZED_CUT_COPPER);
            entry.add(Items.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
            entry.add(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB);
            //#endif
        });

        COLORED_BLOCKS.setItems(entry -> {
            entry.add(Items.WHITE_WOOL);
            entry.add(Items.LIGHT_GRAY_WOOL);
            entry.add(Items.GRAY_WOOL);
            entry.add(Items.BLACK_WOOL);
            entry.add(Items.BROWN_WOOL);
            entry.add(Items.RED_WOOL);
            entry.add(Items.ORANGE_WOOL);
            entry.add(Items.YELLOW_WOOL);
            entry.add(Items.LIME_WOOL);
            entry.add(Items.GREEN_WOOL);
            entry.add(Items.CYAN_WOOL);
            entry.add(Items.LIGHT_BLUE_WOOL);
            entry.add(Items.BLUE_WOOL);
            entry.add(Items.PURPLE_WOOL);
            entry.add(Items.MAGENTA_WOOL);
            entry.add(Items.PINK_WOOL);
            entry.add(Items.WHITE_CARPET);
            entry.add(Items.LIGHT_GRAY_CARPET);
            entry.add(Items.GRAY_CARPET);
            entry.add(Items.BLACK_CARPET);
            entry.add(Items.BROWN_CARPET);
            entry.add(Items.RED_CARPET);
            entry.add(Items.ORANGE_CARPET);
            entry.add(Items.YELLOW_CARPET);
            entry.add(Items.LIME_CARPET);
            entry.add(Items.GREEN_CARPET);
            entry.add(Items.CYAN_CARPET);
            entry.add(Items.LIGHT_BLUE_CARPET);
            entry.add(Items.BLUE_CARPET);
            entry.add(Items.PURPLE_CARPET);
            entry.add(Items.MAGENTA_CARPET);
            entry.add(Items.PINK_CARPET);
            entry.add(Items.TERRACOTTA);
            entry.add(Items.WHITE_TERRACOTTA);
            entry.add(Items.LIGHT_GRAY_TERRACOTTA);
            entry.add(Items.GRAY_TERRACOTTA);
            entry.add(Items.BLACK_TERRACOTTA);
            entry.add(Items.BROWN_TERRACOTTA);
            entry.add(Items.RED_TERRACOTTA);
            entry.add(Items.ORANGE_TERRACOTTA);
            entry.add(Items.YELLOW_TERRACOTTA);
            entry.add(Items.LIME_TERRACOTTA);
            entry.add(Items.GREEN_TERRACOTTA);
            entry.add(Items.CYAN_TERRACOTTA);
            entry.add(Items.LIGHT_BLUE_TERRACOTTA);
            entry.add(Items.BLUE_TERRACOTTA);
            entry.add(Items.PURPLE_TERRACOTTA);
            entry.add(Items.MAGENTA_TERRACOTTA);
            entry.add(Items.PINK_TERRACOTTA);
            entry.add(Items.WHITE_CONCRETE);
            entry.add(Items.LIGHT_GRAY_CONCRETE);
            entry.add(Items.GRAY_CONCRETE);
            entry.add(Items.BLACK_CONCRETE);
            entry.add(Items.BROWN_CONCRETE);
            entry.add(Items.RED_CONCRETE);
            entry.add(Items.ORANGE_CONCRETE);
            entry.add(Items.YELLOW_CONCRETE);
            entry.add(Items.LIME_CONCRETE);
            entry.add(Items.GREEN_CONCRETE);
            entry.add(Items.CYAN_CONCRETE);
            entry.add(Items.LIGHT_BLUE_CONCRETE);
            entry.add(Items.BLUE_CONCRETE);
            entry.add(Items.PURPLE_CONCRETE);
            entry.add(Items.MAGENTA_CONCRETE);
            entry.add(Items.PINK_CONCRETE);
            entry.add(Items.WHITE_CONCRETE_POWDER);
            entry.add(Items.LIGHT_GRAY_CONCRETE_POWDER);
            entry.add(Items.GRAY_CONCRETE_POWDER);
            entry.add(Items.BLACK_CONCRETE_POWDER);
            entry.add(Items.BROWN_CONCRETE_POWDER);
            entry.add(Items.RED_CONCRETE_POWDER);
            entry.add(Items.ORANGE_CONCRETE_POWDER);
            entry.add(Items.YELLOW_CONCRETE_POWDER);
            entry.add(Items.LIME_CONCRETE_POWDER);
            entry.add(Items.GREEN_CONCRETE_POWDER);
            entry.add(Items.CYAN_CONCRETE_POWDER);
            entry.add(Items.LIGHT_BLUE_CONCRETE_POWDER);
            entry.add(Items.BLUE_CONCRETE_POWDER);
            entry.add(Items.PURPLE_CONCRETE_POWDER);
            entry.add(Items.MAGENTA_CONCRETE_POWDER);
            entry.add(Items.PINK_CONCRETE_POWDER);
            entry.add(Items.WHITE_GLAZED_TERRACOTTA);
            entry.add(Items.LIGHT_GRAY_GLAZED_TERRACOTTA);
            entry.add(Items.GRAY_GLAZED_TERRACOTTA);
            entry.add(Items.BLACK_GLAZED_TERRACOTTA);
            entry.add(Items.BROWN_GLAZED_TERRACOTTA);
            entry.add(Items.RED_GLAZED_TERRACOTTA);
            entry.add(Items.ORANGE_GLAZED_TERRACOTTA);
            entry.add(Items.YELLOW_GLAZED_TERRACOTTA);
            entry.add(Items.LIME_GLAZED_TERRACOTTA);
            entry.add(Items.GREEN_GLAZED_TERRACOTTA);
            entry.add(Items.CYAN_GLAZED_TERRACOTTA);
            entry.add(Items.LIGHT_BLUE_GLAZED_TERRACOTTA);
            entry.add(Items.BLUE_GLAZED_TERRACOTTA);
            entry.add(Items.PURPLE_GLAZED_TERRACOTTA);
            entry.add(Items.MAGENTA_GLAZED_TERRACOTTA);
            entry.add(Items.PINK_GLAZED_TERRACOTTA);
            entry.add(Items.GLASS);
            //#if MC >= 11700
            entry.add(Items.TINTED_GLASS);
            //#endif
            entry.add(Items.WHITE_STAINED_GLASS);
            entry.add(Items.LIGHT_GRAY_STAINED_GLASS);
            entry.add(Items.GRAY_STAINED_GLASS);
            entry.add(Items.BLACK_STAINED_GLASS);
            entry.add(Items.BROWN_STAINED_GLASS);
            entry.add(Items.RED_STAINED_GLASS);
            entry.add(Items.ORANGE_STAINED_GLASS);
            entry.add(Items.YELLOW_STAINED_GLASS);
            entry.add(Items.LIME_STAINED_GLASS);
            entry.add(Items.GREEN_STAINED_GLASS);
            entry.add(Items.CYAN_STAINED_GLASS);
            entry.add(Items.LIGHT_BLUE_STAINED_GLASS);
            entry.add(Items.BLUE_STAINED_GLASS);
            entry.add(Items.PURPLE_STAINED_GLASS);
            entry.add(Items.MAGENTA_STAINED_GLASS);
            entry.add(Items.PINK_STAINED_GLASS);
            entry.add(Items.GLASS_PANE);
            entry.add(Items.WHITE_STAINED_GLASS_PANE);
            entry.add(Items.LIGHT_GRAY_STAINED_GLASS_PANE);
            entry.add(Items.GRAY_STAINED_GLASS_PANE);
            entry.add(Items.BLACK_STAINED_GLASS_PANE);
            entry.add(Items.BROWN_STAINED_GLASS_PANE);
            entry.add(Items.RED_STAINED_GLASS_PANE);
            entry.add(Items.ORANGE_STAINED_GLASS_PANE);
            entry.add(Items.YELLOW_STAINED_GLASS_PANE);
            entry.add(Items.LIME_STAINED_GLASS_PANE);
            entry.add(Items.GREEN_STAINED_GLASS_PANE);
            entry.add(Items.CYAN_STAINED_GLASS_PANE);
            entry.add(Items.LIGHT_BLUE_STAINED_GLASS_PANE);
            entry.add(Items.BLUE_STAINED_GLASS_PANE);
            entry.add(Items.PURPLE_STAINED_GLASS_PANE);
            entry.add(Items.MAGENTA_STAINED_GLASS_PANE);
            entry.add(Items.PINK_STAINED_GLASS_PANE);
            entry.add(Items.SHULKER_BOX);
            entry.add(Items.WHITE_SHULKER_BOX);
            entry.add(Items.LIGHT_GRAY_SHULKER_BOX);
            entry.add(Items.GRAY_SHULKER_BOX);
            entry.add(Items.BLACK_SHULKER_BOX);
            entry.add(Items.BROWN_SHULKER_BOX);
            entry.add(Items.RED_SHULKER_BOX);
            entry.add(Items.ORANGE_SHULKER_BOX);
            entry.add(Items.YELLOW_SHULKER_BOX);
            entry.add(Items.LIME_SHULKER_BOX);
            entry.add(Items.GREEN_SHULKER_BOX);
            entry.add(Items.CYAN_SHULKER_BOX);
            entry.add(Items.LIGHT_BLUE_SHULKER_BOX);
            entry.add(Items.BLUE_SHULKER_BOX);
            entry.add(Items.PURPLE_SHULKER_BOX);
            entry.add(Items.MAGENTA_SHULKER_BOX);
            entry.add(Items.PINK_SHULKER_BOX);
            entry.add(Items.WHITE_BED);
            entry.add(Items.LIGHT_GRAY_BED);
            entry.add(Items.GRAY_BED);
            entry.add(Items.BLACK_BED);
            entry.add(Items.BROWN_BED);
            entry.add(Items.RED_BED);
            entry.add(Items.ORANGE_BED);
            entry.add(Items.YELLOW_BED);
            entry.add(Items.LIME_BED);
            entry.add(Items.GREEN_BED);
            entry.add(Items.CYAN_BED);
            entry.add(Items.LIGHT_BLUE_BED);
            entry.add(Items.BLUE_BED);
            entry.add(Items.PURPLE_BED);
            entry.add(Items.MAGENTA_BED);
            entry.add(Items.PINK_BED);
            //#if MC >= 11700
            entry.add(Items.CANDLE);
            entry.add(Items.WHITE_CANDLE);
            entry.add(Items.LIGHT_GRAY_CANDLE);
            entry.add(Items.GRAY_CANDLE);
            entry.add(Items.BLACK_CANDLE);
            entry.add(Items.BROWN_CANDLE);
            entry.add(Items.RED_CANDLE);
            entry.add(Items.ORANGE_CANDLE);
            entry.add(Items.YELLOW_CANDLE);
            entry.add(Items.LIME_CANDLE);
            entry.add(Items.GREEN_CANDLE);
            entry.add(Items.CYAN_CANDLE);
            entry.add(Items.LIGHT_BLUE_CANDLE);
            entry.add(Items.BLUE_CANDLE);
            entry.add(Items.PURPLE_CANDLE);
            entry.add(Items.MAGENTA_CANDLE);
            entry.add(Items.PINK_CANDLE);
            //#endif
            entry.add(Items.WHITE_BANNER);
            entry.add(Items.LIGHT_GRAY_BANNER);
            entry.add(Items.GRAY_BANNER);
            entry.add(Items.BLACK_BANNER);
            entry.add(Items.BROWN_BANNER);
            entry.add(Items.RED_BANNER);
            entry.add(Items.ORANGE_BANNER);
            entry.add(Items.YELLOW_BANNER);
            entry.add(Items.LIME_BANNER);
            entry.add(Items.GREEN_BANNER);
            entry.add(Items.CYAN_BANNER);
            entry.add(Items.LIGHT_BLUE_BANNER);
            entry.add(Items.BLUE_BANNER);
            entry.add(Items.PURPLE_BANNER);
            entry.add(Items.MAGENTA_BANNER);
            entry.add(Items.PINK_BANNER);
        });

        NATURAL.setItems(entry -> {
            entry.add(Items.GRASS_BLOCK);
            entry.add(Items.PODZOL);
            entry.add(Items.MYCELIUM);
            //#if MC >= 11700
            entry.add(Items.DIRT_PATH);
            //#endif
            entry.add(Items.DIRT);
            entry.add(Items.COARSE_DIRT);
            //#if MC >= 11700
            entry.add(Items.ROOTED_DIRT);
            //#endif
            entry.add(Items.FARMLAND);
            //#if MC >= 11900
            entry.add(Items.MUD);
            //#endif
            entry.add(Items.CLAY);
            entry.add(Items.GRAVEL);
            entry.add(Items.SAND);
            entry.add(Items.SANDSTONE);
            entry.add(Items.RED_SAND);
            entry.add(Items.RED_SANDSTONE);
            entry.add(Items.ICE);
            entry.add(Items.PACKED_ICE);
            entry.add(Items.BLUE_ICE);
            entry.add(Items.SNOW_BLOCK);
            entry.add(Items.SNOW);
            //#if MC >= 11700
            entry.add(Items.MOSS_BLOCK);
            entry.add(Items.MOSS_CARPET);
            //#endif
            entry.add(Items.STONE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE);
            //#endif
            entry.add(Items.GRANITE);
            entry.add(Items.DIORITE);
            entry.add(Items.ANDESITE);
            //#if MC >= 11700
            entry.add(Items.CALCITE);
            entry.add(Items.TUFF);
            entry.add(Items.DRIPSTONE_BLOCK);
            entry.add(Items.POINTED_DRIPSTONE);
            //#endif
            entry.add(Items.PRISMARINE);
            entry.add(Items.MAGMA_BLOCK);
            entry.add(Items.OBSIDIAN);
            //#if MC >= 11600
            entry.add(Items.CRYING_OBSIDIAN);
            //#endif
            entry.add(Items.NETHERRACK);
            //#if MC >= 11600
            entry.add(Items.CRIMSON_NYLIUM);
            entry.add(Items.WARPED_NYLIUM);
            //#endif
            entry.add(Items.SOUL_SAND);
            //#if MC >= 11600
            entry.add(Items.SOUL_SOIL);
            //#endif
            entry.add(Items.BONE_BLOCK);
            //#if MC >= 11600
            entry.add(Items.BLACKSTONE);
            entry.add(Items.BASALT);
            //#endif
            //#if MC >= 11700
            entry.add(Items.SMOOTH_BASALT);
            //#endif
            entry.add(Items.END_STONE);
            entry.add(Items.COAL_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_COAL_ORE);
            //#endif
            entry.add(Items.IRON_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_IRON_ORE);
            entry.add(Items.COPPER_ORE);
            entry.add(Items.DEEPSLATE_COPPER_ORE);
            //#endif
            entry.add(Items.GOLD_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_GOLD_ORE);
            //#endif
            entry.add(Items.REDSTONE_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_REDSTONE_ORE);
            //#endif
            entry.add(Items.EMERALD_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_EMERALD_ORE);
            //#endif
            entry.add(Items.LAPIS_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_LAPIS_ORE);
            //#endif
            entry.add(Items.DIAMOND_ORE);
            //#if MC >= 11700
            entry.add(Items.DEEPSLATE_DIAMOND_ORE);
            //#endif
            //#if MC >= 11600
            entry.add(Items.NETHER_GOLD_ORE);
            //#endif
            entry.add(Items.NETHER_QUARTZ_ORE);
            //#if MC >= 11600
            entry.add(Items.ANCIENT_DEBRIS);
            //#endif
            //#if MC >= 11700
            entry.add(Items.RAW_IRON_BLOCK);
            entry.add(Items.RAW_COPPER_BLOCK);
            entry.add(Items.RAW_GOLD_BLOCK);
            //#endif
            entry.add(Items.GLOWSTONE);
            //#if MC >= 11700
            entry.add(Items.AMETHYST_BLOCK);
            entry.add(Items.BUDDING_AMETHYST);
            entry.add(Items.SMALL_AMETHYST_BUD);
            entry.add(Items.MEDIUM_AMETHYST_BUD);
            entry.add(Items.LARGE_AMETHYST_BUD);
            entry.add(Items.AMETHYST_CLUSTER);
            //#endif
            entry.add(Items.OAK_LOG);
            entry.add(Items.SPRUCE_LOG);
            entry.add(Items.BIRCH_LOG);
            entry.add(Items.JUNGLE_LOG);
            entry.add(Items.ACACIA_LOG);
            entry.add(Items.DARK_OAK_LOG);
            //#if MC >= 11900
            entry.add(Items.MANGROVE_LOG);
            entry.add(Items.MANGROVE_ROOTS);
            entry.add(Items.MUDDY_MANGROVE_ROOTS);
            //#endif
            entry.add(Items.MUSHROOM_STEM);
            //#if MC >= 11600
            entry.add(Items.CRIMSON_STEM);
            entry.add(Items.WARPED_STEM);
            //#endif
            entry.add(Items.OAK_LEAVES);
            entry.add(Items.SPRUCE_LEAVES);
            entry.add(Items.BIRCH_LEAVES);
            entry.add(Items.JUNGLE_LEAVES);
            entry.add(Items.ACACIA_LEAVES);
            entry.add(Items.DARK_OAK_LEAVES);
            //#if MC >= 11900
            entry.add(Items.MANGROVE_LEAVES);
            //#endif
            //#if MC >= 11700
            entry.add(Items.AZALEA_LEAVES);
            //#if MC <= 11701
            //$$ entry.add(Items.AZALEA_LEAVES_FLOWERS);
            //#elseif MC >= 11800
            entry.add(Items.FLOWERING_AZALEA_LEAVES);
            //#endif
            //#endif
            entry.add(Items.BROWN_MUSHROOM_BLOCK);
            entry.add(Items.RED_MUSHROOM_BLOCK);
            entry.add(Items.NETHER_WART_BLOCK);
            //#if MC >= 11600
            entry.add(Items.WARPED_WART_BLOCK);
            entry.add(Items.SHROOMLIGHT);
            //#endif
            entry.add(Items.OAK_SAPLING);
            entry.add(Items.SPRUCE_SAPLING);
            entry.add(Items.BIRCH_SAPLING);
            entry.add(Items.JUNGLE_SAPLING);
            entry.add(Items.ACACIA_SAPLING);
            entry.add(Items.DARK_OAK_SAPLING);
            //#if MC >= 11900
            entry.add(Items.MANGROVE_PROPAGULE);
            //#endif
            //#if MC >= 11700
            entry.add(Items.AZALEA);
            entry.add(Items.FLOWERING_AZALEA);
            //#endif
            entry.add(Items.BROWN_MUSHROOM);
            entry.add(Items.RED_MUSHROOM);
            //#if MC >= 11600
            entry.add(Items.CRIMSON_FUNGUS);
            entry.add(Items.WARPED_FUNGUS);
            //#endif
            entry.add(Items.GRASS);
            entry.add(Items.FERN);
            entry.add(Items.DEAD_BUSH);
            entry.add(Items.DANDELION);
            entry.add(Items.POPPY);
            entry.add(Items.BLUE_ORCHID);
            entry.add(Items.ALLIUM);
            entry.add(Items.AZURE_BLUET);
            entry.add(Items.RED_TULIP);
            entry.add(Items.ORANGE_TULIP);
            entry.add(Items.WHITE_TULIP);
            entry.add(Items.PINK_TULIP);
            entry.add(Items.OXEYE_DAISY);
            entry.add(Items.CORNFLOWER);
            entry.add(Items.LILY_OF_THE_VALLEY);
            entry.add(Items.WITHER_ROSE);
            //#if MC >= 11700
            entry.add(Items.SPORE_BLOSSOM);
            //#endif
            entry.add(Items.BAMBOO);
            entry.add(Items.SUGAR_CANE);
            entry.add(Items.CACTUS);
            //#if MC >= 11600
            entry.add(Items.CRIMSON_ROOTS);
            entry.add(Items.WARPED_ROOTS);
            entry.add(Items.NETHER_SPROUTS);
            entry.add(Items.WEEPING_VINES);
            entry.add(Items.TWISTING_VINES);
            //#endif
            entry.add(Items.VINE);
            entry.add(Items.TALL_GRASS);
            entry.add(Items.LARGE_FERN);
            entry.add(Items.SUNFLOWER);
            entry.add(Items.LILAC);
            entry.add(Items.ROSE_BUSH);
            entry.add(Items.PEONY);
            //#if MC >= 11700
            entry.add(Items.BIG_DRIPLEAF);
            entry.add(Items.SMALL_DRIPLEAF);
            //#endif
            entry.add(Items.CHORUS_PLANT);
            entry.add(Items.CHORUS_FLOWER);
            //#if MC >= 11700
            entry.add(Items.GLOW_LICHEN);
            entry.add(Items.HANGING_ROOTS);
            //#endif
            //#if MC >= 11900
            entry.add(Items.FROGSPAWN);
            //#endif
            entry.add(Items.TURTLE_EGG);
            entry.add(Items.WHEAT_SEEDS);
            entry.add(Items.COCOA_BEANS);
            entry.add(Items.PUMPKIN_SEEDS);
            entry.add(Items.MELON_SEEDS);
            entry.add(Items.BEETROOT_SEEDS);
            //#if MC >= 11700
            entry.add(Items.GLOW_BERRIES);
            //#endif
            entry.add(Items.SWEET_BERRIES);
            entry.add(Items.NETHER_WART);
            entry.add(Items.LILY_PAD);
            entry.add(Items.SEAGRASS);
            entry.add(Items.SEA_PICKLE);
            entry.add(Items.KELP);
            entry.add(Items.DRIED_KELP_BLOCK);
            entry.add(Items.TUBE_CORAL_BLOCK);
            entry.add(Items.BRAIN_CORAL_BLOCK);
            entry.add(Items.BUBBLE_CORAL_BLOCK);
            entry.add(Items.FIRE_CORAL_BLOCK);
            entry.add(Items.HORN_CORAL_BLOCK);
            entry.add(Items.DEAD_TUBE_CORAL_BLOCK);
            entry.add(Items.DEAD_BRAIN_CORAL_BLOCK);
            entry.add(Items.DEAD_BUBBLE_CORAL_BLOCK);
            entry.add(Items.DEAD_FIRE_CORAL_BLOCK);
            entry.add(Items.DEAD_HORN_CORAL_BLOCK);
            entry.add(Items.TUBE_CORAL);
            entry.add(Items.BRAIN_CORAL);
            entry.add(Items.BUBBLE_CORAL);
            entry.add(Items.FIRE_CORAL);
            entry.add(Items.HORN_CORAL);
            entry.add(Items.DEAD_TUBE_CORAL);
            entry.add(Items.DEAD_BRAIN_CORAL);
            entry.add(Items.DEAD_BUBBLE_CORAL);
            entry.add(Items.DEAD_FIRE_CORAL);
            entry.add(Items.DEAD_HORN_CORAL);
            entry.add(Items.TUBE_CORAL_FAN);
            entry.add(Items.BRAIN_CORAL_FAN);
            entry.add(Items.BUBBLE_CORAL_FAN);
            entry.add(Items.FIRE_CORAL_FAN);
            entry.add(Items.HORN_CORAL_FAN);
            entry.add(Items.DEAD_TUBE_CORAL_FAN);
            entry.add(Items.DEAD_BRAIN_CORAL_FAN);
            entry.add(Items.DEAD_BUBBLE_CORAL_FAN);
            entry.add(Items.DEAD_FIRE_CORAL_FAN);
            entry.add(Items.DEAD_HORN_CORAL_FAN);
            entry.add(Items.SPONGE);
            entry.add(Items.WET_SPONGE);
            entry.add(Items.MELON);
            entry.add(Items.PUMPKIN);
            entry.add(Items.CARVED_PUMPKIN);
            entry.add(Items.JACK_O_LANTERN);
            entry.add(Items.HAY_BLOCK);
            //#if MC >= 11500
            entry.add(Items.BEE_NEST);
            entry.add(Items.HONEYCOMB_BLOCK);
            //#endif
            entry.add(Items.SLIME_BLOCK);
            //#if MC >= 11500
            entry.add(Items.HONEY_BLOCK);
            //#endif
            //#if MC >= 11900
            entry.add(Items.OCHRE_FROGLIGHT);
            entry.add(Items.VERDANT_FROGLIGHT);
            entry.add(Items.PEARLESCENT_FROGLIGHT);
            entry.add(Items.SCULK);
            entry.add(Items.SCULK_VEIN);
            entry.add(Items.SCULK_CATALYST);
            entry.add(Items.SCULK_SHRIEKER);
            entry.add(Items.SCULK_SENSOR);
            //#endif
            entry.add(Items.COBWEB);
            entry.add(Items.BEDROCK);
        });

        FUNCTIONAL.setItems(entry -> {
            entry.add(Items.TORCH);
            //#if MC >= 11600
            entry.add(Items.SOUL_TORCH);
            //#endif
            entry.add(Items.REDSTONE_TORCH);
            entry.add(Items.LANTERN);
            //#if MC >= 11600
            entry.add(Items.SOUL_LANTERN);
            entry.add(Items.CHAIN);
            //#endif
            entry.add(Items.END_ROD);
            entry.add(Items.SEA_LANTERN);
            entry.add(Items.REDSTONE_LAMP);
            entry.add(Items.GLOWSTONE);
            //#if MC >= 11600
            entry.add(Items.SHROOMLIGHT);
            //#endif
            //#if MC >= 11900
            entry.add(Items.OCHRE_FROGLIGHT);
            entry.add(Items.VERDANT_FROGLIGHT);
            entry.add(Items.PEARLESCENT_FROGLIGHT);
            //#endif
            //#if MC >= 11600
            entry.add(Items.CRYING_OBSIDIAN);
            //#endif
            //#if MC >= 11700
            entry.add(Items.GLOW_LICHEN);
            //#endif
            entry.add(Items.MAGMA_BLOCK);
            entry.add(Items.CRAFTING_TABLE);
            entry.add(Items.STONECUTTER);
            entry.add(Items.CARTOGRAPHY_TABLE);
            entry.add(Items.FLETCHING_TABLE);
            entry.add(Items.SMITHING_TABLE);
            entry.add(Items.GRINDSTONE);
            entry.add(Items.LOOM);
            entry.add(Items.FURNACE);
            entry.add(Items.SMOKER);
            entry.add(Items.BLAST_FURNACE);
            entry.add(Items.CAMPFIRE);
            //#if MC >= 11600
            entry.add(Items.SOUL_CAMPFIRE);
            //#endif
            entry.add(Items.ANVIL);
            entry.add(Items.CHIPPED_ANVIL);
            entry.add(Items.DAMAGED_ANVIL);
            entry.add(Items.COMPOSTER);
            entry.add(Items.NOTE_BLOCK);
            entry.add(Items.JUKEBOX);
            entry.add(Items.ENCHANTING_TABLE);
            entry.add(Items.END_CRYSTAL);
            entry.add(Items.BREWING_STAND);
            entry.add(Items.CAULDRON);
            entry.add(Items.BELL);
            entry.add(Items.BEACON);
            entry.add(Items.CONDUIT);
            //#if MC >= 11600
            entry.add(Items.LODESTONE);
            //#endif
            entry.add(Items.LADDER);
            entry.add(Items.SCAFFOLDING);
            //#if MC >= 11500
            entry.add(Items.BEE_NEST);
            entry.add(Items.BEEHIVE);
            //#endif
            //#if MC >= 11700
            entry.add(Items.LIGHTNING_ROD);
            //#endif
            entry.add(Items.FLOWER_POT);
            entry.add(Items.ARMOR_STAND);
            entry.add(Items.ITEM_FRAME);
            //#if MC >= 11700
            entry.add(Items.GLOW_ITEM_FRAME);
            //#endif
            entry.add(Items.PAINTING);
            entry.addPaintings();
            entry.add(Items.BOOKSHELF);
            entry.add(Items.LECTERN);
            //#if MC >= 11700
            entry.add(Items.TINTED_GLASS);
            //#endif
            entry.add(Items.OAK_SIGN);
            entry.add(Items.SPRUCE_SIGN);
            entry.add(Items.BIRCH_SIGN);
            entry.add(Items.JUNGLE_SIGN);
            entry.add(Items.ACACIA_SIGN);
            entry.add(Items.DARK_OAK_SIGN);
            //#if MC >= 11900
            entry.add(Items.MANGROVE_SIGN);
            //#endif
            //#if MC >= 11600
            entry.add(Items.CRIMSON_SIGN);
            entry.add(Items.WARPED_SIGN);
            //#endif
            entry.add(Items.CHEST);
            entry.add(Items.BARREL);
            entry.add(Items.ENDER_CHEST);
            entry.add(Items.SHULKER_BOX);
            entry.add(Items.WHITE_SHULKER_BOX);
            entry.add(Items.LIGHT_GRAY_SHULKER_BOX);
            entry.add(Items.GRAY_SHULKER_BOX);
            entry.add(Items.BLACK_SHULKER_BOX);
            entry.add(Items.BROWN_SHULKER_BOX);
            entry.add(Items.RED_SHULKER_BOX);
            entry.add(Items.ORANGE_SHULKER_BOX);
            entry.add(Items.YELLOW_SHULKER_BOX);
            entry.add(Items.LIME_SHULKER_BOX);
            entry.add(Items.GREEN_SHULKER_BOX);
            entry.add(Items.CYAN_SHULKER_BOX);
            entry.add(Items.LIGHT_BLUE_SHULKER_BOX);
            entry.add(Items.BLUE_SHULKER_BOX);
            entry.add(Items.PURPLE_SHULKER_BOX);
            entry.add(Items.MAGENTA_SHULKER_BOX);
            entry.add(Items.PINK_SHULKER_BOX);
            //#if MC >= 11600
            entry.add(Items.RESPAWN_ANCHOR);
            //#endif
            entry.add(Items.WHITE_BED);
            entry.add(Items.LIGHT_GRAY_BED);
            entry.add(Items.GRAY_BED);
            entry.add(Items.BLACK_BED);
            entry.add(Items.BROWN_BED);
            entry.add(Items.RED_BED);
            entry.add(Items.ORANGE_BED);
            entry.add(Items.YELLOW_BED);
            entry.add(Items.LIME_BED);
            entry.add(Items.GREEN_BED);
            entry.add(Items.CYAN_BED);
            entry.add(Items.LIGHT_BLUE_BED);
            entry.add(Items.BLUE_BED);
            entry.add(Items.PURPLE_BED);
            entry.add(Items.MAGENTA_BED);
            entry.add(Items.PINK_BED);
            //#if MC >= 11700
            entry.add(Items.CANDLE);
            entry.add(Items.WHITE_CANDLE);
            entry.add(Items.LIGHT_GRAY_CANDLE);
            entry.add(Items.GRAY_CANDLE);
            entry.add(Items.BLACK_CANDLE);
            entry.add(Items.BROWN_CANDLE);
            entry.add(Items.RED_CANDLE);
            entry.add(Items.ORANGE_CANDLE);
            entry.add(Items.YELLOW_CANDLE);
            entry.add(Items.LIME_CANDLE);
            entry.add(Items.GREEN_CANDLE);
            entry.add(Items.CYAN_CANDLE);
            entry.add(Items.LIGHT_BLUE_CANDLE);
            entry.add(Items.BLUE_CANDLE);
            entry.add(Items.PURPLE_CANDLE);
            entry.add(Items.MAGENTA_CANDLE);
            entry.add(Items.PINK_CANDLE);
            //#endif
            entry.add(Items.WHITE_BANNER);
            entry.add(Items.LIGHT_GRAY_BANNER);
            entry.add(Items.GRAY_BANNER);
            entry.add(Items.BLACK_BANNER);
            entry.add(Items.BROWN_BANNER);
            entry.add(Items.RED_BANNER);
            entry.add(Items.ORANGE_BANNER);
            entry.add(Items.YELLOW_BANNER);
            entry.add(Items.LIME_BANNER);
            entry.add(Items.GREEN_BANNER);
            entry.add(Items.CYAN_BANNER);
            entry.add(Items.LIGHT_BLUE_BANNER);
            entry.add(Items.BLUE_BANNER);
            entry.add(Items.PURPLE_BANNER);
            entry.add(Items.MAGENTA_BANNER);
            entry.add(Items.PINK_BANNER);
            //#if MC <= 11402
            //$$ entry.add(Raid.OMINOUS_BANNER);
            //#else
            entry.add(Raid.getOminousBanner());
            //#endif
            entry.add(Items.SKELETON_SKULL);
            entry.add(Items.WITHER_SKELETON_SKULL);
            entry.add(Items.PLAYER_HEAD);
            entry.add(Items.ZOMBIE_HEAD);
            entry.add(Items.CREEPER_HEAD);
            entry.add(Items.DRAGON_HEAD);
            entry.add(Items.DRAGON_EGG);
            entry.add(Items.END_PORTAL_FRAME);
            entry.add(Items.ENDER_EYE);
            entry.add(Items.INFESTED_STONE);
            entry.add(Items.INFESTED_COBBLESTONE);
            entry.add(Items.INFESTED_STONE_BRICKS);
            entry.add(Items.INFESTED_MOSSY_STONE_BRICKS);
            entry.add(Items.INFESTED_CRACKED_STONE_BRICKS);
            entry.add(Items.INFESTED_CHISELED_STONE_BRICKS);
            //#if MC >= 11700
            entry.add(Items.INFESTED_DEEPSLATE);
            //#endif
        });


        REDSTONE.setItems(entry -> {
            entry.add(Items.REDSTONE);
            entry.add(Items.REDSTONE_TORCH);
            entry.add(Items.REDSTONE_BLOCK);
            entry.add(Items.REPEATER);
            entry.add(Items.COMPARATOR);
            //#if MC >= 11600
            entry.add(Items.TARGET);
            //#endif
            entry.add(Items.LEVER);
            entry.add(Items.OAK_BUTTON);
            entry.add(Items.STONE_BUTTON);
            entry.add(Items.OAK_PRESSURE_PLATE);
            entry.add(Items.STONE_PRESSURE_PLATE);
            entry.add(Items.LIGHT_WEIGHTED_PRESSURE_PLATE);
            entry.add(Items.HEAVY_WEIGHTED_PRESSURE_PLATE);
            //#if MC >= 11900
            entry.add(Items.SCULK_SENSOR);
            entry.add(Items.SCULK_SHRIEKER);
            //#endif
            //#if MC >= 11700
            entry.add(Items.AMETHYST_BLOCK);
            //#endif
            entry.add(Items.WHITE_WOOL);
            entry.add(Items.TRIPWIRE_HOOK);
            entry.add(Items.STRING);
            entry.add(Items.LECTERN);
            entry.add(Items.DAYLIGHT_DETECTOR);
            //#if MC >= 11700
            entry.add(Items.LIGHTNING_ROD);
            //#endif
            entry.add(Items.PISTON);
            entry.add(Items.STICKY_PISTON);
            entry.add(Items.SLIME_BLOCK);
            //#if MC >= 11500
            entry.add(Items.HONEY_BLOCK);
            //#endif
            entry.add(Items.DISPENSER);
            entry.add(Items.DROPPER);
            entry.add(Items.HOPPER);
            entry.add(Items.CHEST);
            entry.add(Items.BARREL);
            entry.add(Items.FURNACE);
            entry.add(Items.TRAPPED_CHEST);
            entry.add(Items.JUKEBOX);
            entry.add(Items.OBSERVER);
            entry.add(Items.NOTE_BLOCK);
            entry.add(Items.COMPOSTER);
            entry.add(Items.CAULDRON);
            entry.add(Items.RAIL);
            entry.add(Items.POWERED_RAIL);
            entry.add(Items.DETECTOR_RAIL);
            entry.add(Items.ACTIVATOR_RAIL);
            entry.add(Items.MINECART);
            entry.add(Items.HOPPER_MINECART);
            entry.add(Items.CHEST_MINECART);
            entry.add(Items.FURNACE_MINECART);
            entry.add(Items.TNT_MINECART);
            //#if MC >= 11900
            entry.add(Items.OAK_CHEST_BOAT);
            //#endif
            entry.add(Items.OAK_DOOR);
            entry.add(Items.IRON_DOOR);
            entry.add(Items.OAK_FENCE_GATE);
            entry.add(Items.OAK_TRAPDOOR);
            entry.add(Items.IRON_TRAPDOOR);
            entry.add(Items.TNT);
            entry.add(Items.REDSTONE_LAMP);
            entry.add(Items.BELL);
            //#if MC >= 11700
            entry.add(Items.BIG_DRIPLEAF);
            //#endif
            entry.add(Items.ARMOR_STAND);
            entry.add(Items.REDSTONE_ORE);
        });

        TOOLS.setItems(entry -> {
            entry.add(Items.WOODEN_SHOVEL);
            entry.add(Items.WOODEN_PICKAXE);
            entry.add(Items.WOODEN_AXE);
            entry.add(Items.WOODEN_HOE);
            entry.add(Items.STONE_SHOVEL);
            entry.add(Items.STONE_PICKAXE);
            entry.add(Items.STONE_AXE);
            entry.add(Items.STONE_HOE);
            entry.add(Items.IRON_SHOVEL);
            entry.add(Items.IRON_PICKAXE);
            entry.add(Items.IRON_AXE);
            entry.add(Items.IRON_HOE);
            entry.add(Items.GOLDEN_SHOVEL);
            entry.add(Items.GOLDEN_PICKAXE);
            entry.add(Items.GOLDEN_AXE);
            entry.add(Items.GOLDEN_HOE);
            entry.add(Items.DIAMOND_SHOVEL);
            entry.add(Items.DIAMOND_PICKAXE);
            entry.add(Items.DIAMOND_AXE);
            entry.add(Items.DIAMOND_HOE);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_SHOVEL);
            entry.add(Items.NETHERITE_PICKAXE);
            entry.add(Items.NETHERITE_AXE);
            entry.add(Items.NETHERITE_HOE);
            //#endif
            entry.add(Items.BUCKET);
            entry.add(Items.WATER_BUCKET);
            entry.add(Items.COD_BUCKET);
            entry.add(Items.SALMON_BUCKET);
            entry.add(Items.TROPICAL_FISH_BUCKET);
            entry.add(Items.PUFFERFISH_BUCKET);
            //#if MC >= 11700
            entry.add(Items.AXOLOTL_BUCKET);
            //#endif
            //#if MC >= 11900
            entry.add(Items.TADPOLE_BUCKET);
            //#endif
            entry.add(Items.LAVA_BUCKET);
            //#if MC >= 11700
            entry.add(Items.POWDER_SNOW_BUCKET);
            //#endif
            entry.add(Items.MILK_BUCKET);
            entry.add(Items.FISHING_ROD);
            entry.add(Items.FLINT_AND_STEEL);
            entry.add(Items.FIRE_CHARGE);
            entry.add(Items.BONE_MEAL);
            entry.add(Items.SHEARS);
            entry.add(Items.NAME_TAG);
            entry.add(Items.LEAD);
            //entry.add(Items.BUNDLE);//x.x.x
            entry.add(Items.COMPASS);
            //#if MC >= 11900
            entry.add(Items.RECOVERY_COMPASS);
            //#endif
            entry.add(Items.CLOCK);
            //#if MC >= 11700
            entry.add(Items.SPYGLASS);
            //#endif
            entry.add(Items.MAP);
            entry.add(Items.WRITABLE_BOOK);
            entry.add(Items.ENDER_PEARL);
            entry.add(Items.ENDER_EYE);
            entry.add(Items.ELYTRA);
            entry.addFireworkRockets();
            entry.add(Items.SADDLE);
            entry.add(Items.CARROT_ON_A_STICK);
            //#if MC >= 11600
            entry.add(Items.WARPED_FUNGUS_ON_A_STICK);
            //#endif
            entry.add(Items.OAK_BOAT);
            //#if MC >= 11900
            entry.add(Items.OAK_CHEST_BOAT);
            //#endif
            entry.add(Items.SPRUCE_BOAT);
            //#if MC >= 11900
            entry.add(Items.SPRUCE_CHEST_BOAT);
            //#endif
            entry.add(Items.BIRCH_BOAT);
            //#if MC >= 11900
            entry.add(Items.BIRCH_CHEST_BOAT);
            //#endif
            entry.add(Items.JUNGLE_BOAT);
            //#if MC >= 11900
            entry.add(Items.JUNGLE_CHEST_BOAT);
            //#endif
            entry.add(Items.ACACIA_BOAT);
            //#if MC >= 11900
            entry.add(Items.ACACIA_CHEST_BOAT);
            //#endif
            entry.add(Items.DARK_OAK_BOAT);
            //#if MC >= 11900
            entry.add(Items.DARK_OAK_CHEST_BOAT);
            entry.add(Items.MANGROVE_BOAT);
            entry.add(Items.MANGROVE_CHEST_BOAT);
            //#endif
            entry.add(Items.RAIL);
            entry.add(Items.POWERED_RAIL);
            entry.add(Items.DETECTOR_RAIL);
            entry.add(Items.ACTIVATOR_RAIL);
            entry.add(Items.MINECART);
            entry.add(Items.HOPPER_MINECART);
            entry.add(Items.CHEST_MINECART);
            entry.add(Items.FURNACE_MINECART);
            entry.add(Items.TNT_MINECART);
            //#if MC >= 11900
            entry.addInstruments();
            //#endif
            entry.add(Items.MUSIC_DISC_13);
            entry.add(Items.MUSIC_DISC_CAT);
            entry.add(Items.MUSIC_DISC_BLOCKS);
            entry.add(Items.MUSIC_DISC_CHIRP);
            entry.add(Items.MUSIC_DISC_FAR);
            entry.add(Items.MUSIC_DISC_MALL);
            entry.add(Items.MUSIC_DISC_MELLOHI);
            entry.add(Items.MUSIC_DISC_STAL);
            entry.add(Items.MUSIC_DISC_STRAD);
            entry.add(Items.MUSIC_DISC_WARD);
            entry.add(Items.MUSIC_DISC_11);
            entry.add(Items.MUSIC_DISC_WAIT);
            //#if MC >= 11800
            entry.add(Items.MUSIC_DISC_OTHERSIDE);
            //#endif
            //#if MC >= 11900
            entry.add(Items.MUSIC_DISC_5);
            //#endif
            //#if MC >= 11600
            entry.add(Items.MUSIC_DISC_PIGSTEP);
            //#endif
        });

        COMBAT.setItems(entry -> {
            entry.add(Items.WOODEN_SWORD);
            entry.add(Items.STONE_SWORD);
            entry.add(Items.IRON_SWORD);
            entry.add(Items.GOLDEN_SWORD);
            entry.add(Items.DIAMOND_SWORD);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_SWORD);
            //#endif
            entry.add(Items.WOODEN_AXE);
            entry.add(Items.STONE_AXE);
            entry.add(Items.IRON_AXE);
            entry.add(Items.GOLDEN_AXE);
            entry.add(Items.DIAMOND_AXE);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_AXE);
            //#endif
            entry.add(Items.TRIDENT);
            entry.add(Items.SHIELD);
            entry.add(Items.LEATHER_HELMET);
            entry.add(Items.LEATHER_CHESTPLATE);
            entry.add(Items.LEATHER_LEGGINGS);
            entry.add(Items.LEATHER_BOOTS);
            entry.add(Items.CHAINMAIL_HELMET);
            entry.add(Items.CHAINMAIL_CHESTPLATE);
            entry.add(Items.CHAINMAIL_LEGGINGS);
            entry.add(Items.CHAINMAIL_BOOTS);
            entry.add(Items.IRON_HELMET);
            entry.add(Items.IRON_CHESTPLATE);
            entry.add(Items.IRON_LEGGINGS);
            entry.add(Items.IRON_BOOTS);
            entry.add(Items.GOLDEN_HELMET);
            entry.add(Items.GOLDEN_CHESTPLATE);
            entry.add(Items.GOLDEN_LEGGINGS);
            entry.add(Items.GOLDEN_BOOTS);
            entry.add(Items.DIAMOND_HELMET);
            entry.add(Items.DIAMOND_CHESTPLATE);
            entry.add(Items.DIAMOND_LEGGINGS);
            entry.add(Items.DIAMOND_BOOTS);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_HELMET);
            entry.add(Items.NETHERITE_CHESTPLATE);
            entry.add(Items.NETHERITE_LEGGINGS);
            entry.add(Items.NETHERITE_BOOTS);
            //#endif
            entry.add(Items.TURTLE_HELMET);
            entry.add(Items.LEATHER_HORSE_ARMOR);
            entry.add(Items.IRON_HORSE_ARMOR);
            entry.add(Items.GOLDEN_HORSE_ARMOR);
            entry.add(Items.DIAMOND_HORSE_ARMOR);
            entry.add(Items.TOTEM_OF_UNDYING);
            entry.add(Items.TNT);
            entry.add(Items.END_CRYSTAL);
            entry.add(Items.SNOWBALL);
            entry.add(Items.EGG);
            entry.add(Items.BOW);
            entry.add(Items.CROSSBOW);
            entry.addFireworkRockets();
            entry.add(Items.ARROW);
            entry.add(Items.SPECTRAL_ARROW);
            entry.addTippedArrow();
        });

        FOOD_AND_DRINK.setItems(entry -> {
            entry.add(Items.APPLE);
            entry.add(Items.GOLDEN_APPLE);
            entry.add(Items.ENCHANTED_GOLDEN_APPLE);
            entry.add(Items.MELON_SLICE);
            entry.add(Items.SWEET_BERRIES);
            //#if MC >= 11700
            entry.add(Items.GLOW_BERRIES);
            //#endif
            entry.add(Items.CHORUS_FRUIT);
            entry.add(Items.CARROT);
            entry.add(Items.GOLDEN_CARROT);
            entry.add(Items.POTATO);
            entry.add(Items.BAKED_POTATO);
            entry.add(Items.POISONOUS_POTATO);
            entry.add(Items.BEETROOT);
            entry.add(Items.DRIED_KELP);
            entry.add(Items.BEEF);
            entry.add(Items.COOKED_BEEF);
            entry.add(Items.PORKCHOP);
            entry.add(Items.COOKED_PORKCHOP);
            entry.add(Items.MUTTON);
            entry.add(Items.COOKED_MUTTON);
            entry.add(Items.CHICKEN);
            entry.add(Items.COOKED_CHICKEN);
            entry.add(Items.RABBIT);
            entry.add(Items.COOKED_RABBIT);
            entry.add(Items.COD);
            entry.add(Items.COOKED_COD);
            entry.add(Items.SALMON);
            entry.add(Items.COOKED_SALMON);
            entry.add(Items.TROPICAL_FISH);
            entry.add(Items.PUFFERFISH);
            entry.add(Items.BREAD);
            entry.add(Items.COOKIE);
            entry.add(Items.CAKE);
            entry.add(Items.PUMPKIN_PIE);
            entry.add(Items.ROTTEN_FLESH);
            entry.add(Items.SPIDER_EYE);
            entry.add(Items.MUSHROOM_STEW);
            entry.add(Items.BEETROOT_SOUP);
            entry.add(Items.RABBIT_STEW);
            entry.addSuspiciousStews();
            entry.add(Items.MILK_BUCKET);
            //#if MC >= 11500
            entry.add(Items.HONEY_BOTTLE);
            //#endif
            entry.addPotions(Items.POTION);
            entry.addPotions(Items.SPLASH_POTION);
            entry.addPotions(Items.LINGERING_POTION);
        });

        INGREDIENTS.setItems(entry -> {
            entry.add(Items.COAL);
            entry.add(Items.CHARCOAL);
            //#if MC >= 11700
            entry.add(Items.RAW_IRON);
            entry.add(Items.RAW_COPPER);
            entry.add(Items.RAW_GOLD);
            //#endif
            entry.add(Items.EMERALD);
            entry.add(Items.LAPIS_LAZULI);
            entry.add(Items.DIAMOND);
            //#if MC >= 11600
            entry.add(Items.ANCIENT_DEBRIS);
            //#endif
            entry.add(Items.QUARTZ);
            //#if MC >= 11700
            entry.add(Items.AMETHYST_SHARD);
            //#endif
            entry.add(Items.IRON_NUGGET);
            entry.add(Items.GOLD_NUGGET);
            entry.add(Items.IRON_INGOT);
            //#if MC >= 11700
            entry.add(Items.COPPER_INGOT);
            //#endif
            entry.add(Items.GOLD_INGOT);
            //#if MC >= 11600
            entry.add(Items.NETHERITE_SCRAP);
            entry.add(Items.NETHERITE_INGOT);
            //#endif
            entry.add(Items.STICK);
            entry.add(Items.FLINT);
            entry.add(Items.WHEAT);
            entry.add(Items.BONE);
            entry.add(Items.BONE_MEAL);
            entry.add(Items.STRING);
            entry.add(Items.FEATHER);
            entry.add(Items.SNOWBALL);
            entry.add(Items.EGG);
            entry.add(Items.LEATHER);
            entry.add(Items.RABBIT_HIDE);
            //#if MC >= 11500
            entry.add(Items.HONEYCOMB);
            //#endif
            entry.add(Items.INK_SAC);
            //#if MC >= 11700
            entry.add(Items.GLOW_INK_SAC);
            //#endif
            entry.add(Items.SCUTE);
            entry.add(Items.SLIME_BALL);
            entry.add(Items.CLAY_BALL);
            entry.add(Items.PRISMARINE_SHARD);
            entry.add(Items.PRISMARINE_CRYSTALS);
            entry.add(Items.NAUTILUS_SHELL);
            entry.add(Items.HEART_OF_THE_SEA);
            entry.add(Items.FIRE_CHARGE);
            entry.add(Items.BLAZE_ROD);
            entry.add(Items.NETHER_STAR);
            entry.add(Items.ENDER_PEARL);
            entry.add(Items.ENDER_EYE);
            entry.add(Items.SHULKER_SHELL);
            entry.add(Items.POPPED_CHORUS_FRUIT);
            //#if MC >= 11900
            entry.add(Items.ECHO_SHARD);
            entry.add(Items.DISC_FRAGMENT_5);
            //#endif
            entry.add(Items.WHITE_DYE);
            entry.add(Items.LIGHT_GRAY_DYE);
            entry.add(Items.GRAY_DYE);
            entry.add(Items.BLACK_DYE);
            entry.add(Items.BROWN_DYE);
            entry.add(Items.RED_DYE);
            entry.add(Items.ORANGE_DYE);
            entry.add(Items.YELLOW_DYE);
            entry.add(Items.LIME_DYE);
            entry.add(Items.GREEN_DYE);
            entry.add(Items.CYAN_DYE);
            entry.add(Items.LIGHT_BLUE_DYE);
            entry.add(Items.BLUE_DYE);
            entry.add(Items.PURPLE_DYE);
            entry.add(Items.MAGENTA_DYE);
            entry.add(Items.PINK_DYE);
            entry.add(Items.BOWL);
            entry.add(Items.BRICK);
            entry.add(Items.NETHER_BRICK);
            entry.add(Items.PAPER);
            entry.add(Items.BOOK);
            entry.add(Items.FIREWORK_STAR);
            entry.add(Items.GLASS_BOTTLE);
            entry.add(Items.NETHER_WART);
            entry.add(Items.REDSTONE);
            entry.add(Items.GLOWSTONE_DUST);
            entry.add(Items.GUNPOWDER);
            entry.add(Items.DRAGON_BREATH);
            entry.add(Items.FERMENTED_SPIDER_EYE);
            entry.add(Items.BLAZE_POWDER);
            entry.add(Items.SUGAR);
            entry.add(Items.RABBIT_FOOT);
            entry.add(Items.GLISTERING_MELON_SLICE);
            entry.add(Items.SPIDER_EYE);
            entry.add(Items.PUFFERFISH);
            entry.add(Items.MAGMA_CREAM);
            entry.add(Items.GOLDEN_CARROT);
            entry.add(Items.GHAST_TEAR);
            entry.add(Items.TURTLE_HELMET);
            entry.add(Items.PHANTOM_MEMBRANE);
            entry.add(Items.FLOWER_BANNER_PATTERN);
            entry.add(Items.CREEPER_BANNER_PATTERN);
            entry.add(Items.SKULL_BANNER_PATTERN);
            entry.add(Items.MOJANG_BANNER_PATTERN);
            entry.add(Items.GLOBE_BANNER_PATTERN);
            //#if MC >= 11600
            entry.add(Items.PIGLIN_BANNER_PATTERN);
            //#endif
            entry.add(Items.EXPERIENCE_BOTTLE);
            entry.addMaxLevelEnchantedBooks();
        });

        SPAWN_EGGS.setItems(entry -> {
            entry.add(Items.SPAWNER);
            //#if MC >= 11900
            entry.add(Items.ALLAY_SPAWN_EGG);
            //#endif
            //#if MC >= 11700
            entry.add(Items.AXOLOTL_SPAWN_EGG);
            //#endif
            entry.add(Items.BAT_SPAWN_EGG);
            //#if MC >= 11500
            entry.add(Items.BEE_SPAWN_EGG);
            //#endif
            entry.add(Items.BLAZE_SPAWN_EGG);
            entry.add(Items.CAT_SPAWN_EGG);
            entry.add(Items.CAVE_SPIDER_SPAWN_EGG);
            entry.add(Items.CHICKEN_SPAWN_EGG);
            entry.add(Items.COD_SPAWN_EGG);
            entry.add(Items.COW_SPAWN_EGG);
            entry.add(Items.CREEPER_SPAWN_EGG);
            entry.add(Items.DOLPHIN_SPAWN_EGG);
            entry.add(Items.DONKEY_SPAWN_EGG);
            entry.add(Items.DROWNED_SPAWN_EGG);
            entry.add(Items.ELDER_GUARDIAN_SPAWN_EGG);
            entry.add(Items.ENDERMAN_SPAWN_EGG);
            entry.add(Items.ENDERMITE_SPAWN_EGG);
            entry.add(Items.EVOKER_SPAWN_EGG);
            entry.add(Items.FOX_SPAWN_EGG);
            //#if MC >= 11900
            entry.add(Items.FROG_SPAWN_EGG);
            //#endif
            entry.add(Items.GHAST_SPAWN_EGG);
            //#if MC >= 11700
            entry.add(Items.GLOW_SQUID_SPAWN_EGG);
            entry.add(Items.GOAT_SPAWN_EGG);
            //#endif
            entry.add(Items.GUARDIAN_SPAWN_EGG);
            //#if MC >= 11600
            entry.add(Items.HOGLIN_SPAWN_EGG);
            //#endif
            entry.add(Items.HORSE_SPAWN_EGG);
            entry.add(Items.HUSK_SPAWN_EGG);
            entry.add(Items.LLAMA_SPAWN_EGG);
            entry.add(Items.MAGMA_CUBE_SPAWN_EGG);
            entry.add(Items.MOOSHROOM_SPAWN_EGG);
            entry.add(Items.MULE_SPAWN_EGG);
            entry.add(Items.OCELOT_SPAWN_EGG);
            entry.add(Items.PANDA_SPAWN_EGG);
            entry.add(Items.PARROT_SPAWN_EGG);
            entry.add(Items.PHANTOM_SPAWN_EGG);
            entry.add(Items.PIG_SPAWN_EGG);
            //#if MC >= 11600
            entry.add(Items.PIGLIN_SPAWN_EGG);
            //#endif
            //#if MC >= 11602
            entry.add(Items.PIGLIN_BRUTE_SPAWN_EGG);
            //#endif
            entry.add(Items.PILLAGER_SPAWN_EGG);
            entry.add(Items.POLAR_BEAR_SPAWN_EGG);
            entry.add(Items.PUFFERFISH_SPAWN_EGG);
            entry.add(Items.RABBIT_SPAWN_EGG);
            entry.add(Items.RAVAGER_SPAWN_EGG);
            entry.add(Items.SALMON_SPAWN_EGG);
            entry.add(Items.SHEEP_SPAWN_EGG);
            entry.add(Items.SHULKER_SPAWN_EGG);
            entry.add(Items.SILVERFISH_SPAWN_EGG);
            entry.add(Items.SKELETON_SPAWN_EGG);
            entry.add(Items.SKELETON_HORSE_SPAWN_EGG);
            entry.add(Items.SLIME_SPAWN_EGG);
            entry.add(Items.SPIDER_SPAWN_EGG);
            entry.add(Items.SQUID_SPAWN_EGG);
            entry.add(Items.STRAY_SPAWN_EGG);
            //#if MC >= 11600
            entry.add(Items.STRIDER_SPAWN_EGG);
            //#endif
            //#if MC >= 11900
            entry.add(Items.TADPOLE_SPAWN_EGG);
            //#endif
            entry.add(Items.TRADER_LLAMA_SPAWN_EGG);
            entry.add(Items.TROPICAL_FISH_SPAWN_EGG);
            entry.add(Items.TURTLE_SPAWN_EGG);
            entry.add(Items.VEX_SPAWN_EGG);
            entry.add(Items.VILLAGER_SPAWN_EGG);
            entry.add(Items.VINDICATOR_SPAWN_EGG);
            entry.add(Items.WANDERING_TRADER_SPAWN_EGG);
            //#if MC >= 11900
            entry.add(Items.WARDEN_SPAWN_EGG);
            //#endif
            entry.add(Items.WITCH_SPAWN_EGG);
            entry.add(Items.WITHER_SKELETON_SPAWN_EGG);
            entry.add(Items.WOLF_SPAWN_EGG);
            //#if MC >= 11600
            entry.add(Items.ZOGLIN_SPAWN_EGG);
            //#endif
            entry.add(Items.ZOMBIE_SPAWN_EGG);
            entry.add(Items.ZOMBIE_HORSE_SPAWN_EGG);
            entry.add(Items.ZOMBIE_VILLAGER_SPAWN_EGG);
            //#if MC >= 11600
            entry.add(Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
            //#endif
        });

        OPERATOR.setItems(entry -> {
            entry.add(Items.COMMAND_BLOCK);
            entry.add(Items.CHAIN_COMMAND_BLOCK);
            entry.add(Items.REPEATING_COMMAND_BLOCK);
            entry.add(Items.COMMAND_BLOCK_MINECART);
            entry.add(Items.JIGSAW);
            entry.add(Items.STRUCTURE_BLOCK);
            entry.add(Items.STRUCTURE_VOID);
            entry.add(Items.BARRIER);
            entry.add(Items.DEBUG_STICK);
            //#if MC >= 11700
            entry.addLightBlocks();
            //#endif
            //#if MC >= 11900
            entry.addPaintings();
            //#endif
        });

        GROUPS[0] = BUILDING_BLOCKS;
        GROUPS[1] = COLORED_BLOCKS;
        GROUPS[2] = NATURAL;
        GROUPS[3] = FUNCTIONAL;
        GROUPS[4] = REDSTONE;
        GROUPS[5] = HOTBAR;
        GROUPS[6] = SEARCH;
        GROUPS[7] = TOOLS;
        GROUPS[8] = COMBAT;
        GROUPS[9] = FOOD_AND_DRINK;
        GROUPS[10] = INGREDIENTS;
        GROUPS[11] = SPAWN_EGGS;
        GROUPS[12] = OPERATOR;
        GROUPS[13] = INVENTORY;

    }
}
