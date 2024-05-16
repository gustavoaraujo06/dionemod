package net.dione.mccourse.block;

import net.dione.mccourse.DioneMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = registerBlock("deepslate_pink_garnet_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));
    public static final Block NETHER_PINK_GARNET_ORE = registerBlock("nether_pink_garnet_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.NETHER_GOLD_ORE)));
    public static final Block END_STONE_PINK_GARNET_ORE = registerBlock("end_stone_pink_garnet_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.END_STONE)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DioneMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(DioneMod.MOD_ID,  name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks(){
        DioneMod.LOGGER.info("Registering mod blocks for " + DioneMod.MOD_ID);
    }
}
