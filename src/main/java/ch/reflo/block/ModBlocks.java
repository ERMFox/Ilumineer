package ch.reflo.block;

import ch.reflo.Illumineer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block HARDIGHT_BLOCK = registerBlock("hardlight_block", new Block(AbstractBlock.Settings.copy(Blocks.GLOWSTONE).luminance(value -> 20).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Illumineer.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Illumineer.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        Illumineer.LOGGER.info("Registering ModBlocks for: " + Illumineer.MOD_ID);
    }
}