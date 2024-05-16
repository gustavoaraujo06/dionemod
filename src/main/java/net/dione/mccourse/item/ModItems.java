package net.dione.mccourse.item;

import net.dione.mccourse.DioneMod;
import net.dione.mccourse.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(
            new Item.Settings().maxDamage(25).maxCount(5)));
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings()));
    public static final Item CANNABIS = registerItem("cannabis", new Item(new Item.Settings().maxCount(42)));
    public static final Item CONSOLO = registerItem("consolo", new Item(new Item.Settings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DioneMod.MOD_ID, name), item);
    }
    private static void itemGroupIngredients(FabricItemGroupEntries entries){
        entries.add(PINK_GARNET);
        entries.add(CANNABIS);

        entries.add(ModBlocks.PINK_GARNET_BLOCK);
    }
    private static void itemGroupFunctional(FabricItemGroupEntries entries){
        entries.add(CONSOLO);
    }
    public static void registerModItems(){
        DioneMod.LOGGER.info("Registering Items for " + DioneMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::itemGroupIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::itemGroupFunctional);
    }
}
