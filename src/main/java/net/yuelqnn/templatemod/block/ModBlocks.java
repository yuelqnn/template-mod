package net.yuelqnn.templatemod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yuelqnn.templatemod.TemplateMod;

public class ModBlocks {

    public static final Block APPLE_CRATE_BLOCK = registerBlock("apple_crate_block",
            new Block(AbstractBlock.Settings.create().strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD).burnable()));

    //code taken from azalea leaves code
    public static final Block APPLE_LEAVES = registerBlock("apple_leaves",
            new LeavesBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never)));

    public static final Block APPLE_RUBY_BLOCK = registerBlock("apple_ruby_block",
            new Block(AbstractBlock.Settings.create().strength(3.0f, 2.0f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TemplateMod.MOD_ID, name), block);
    }

    //registers item associated with the block
    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TemplateMod.LOGGER.info("registering mod blocks for " + TemplateMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(APPLE_CRATE_BLOCK);
            entries.add(APPLE_RUBY_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(APPLE_LEAVES);
        });
    }
}
