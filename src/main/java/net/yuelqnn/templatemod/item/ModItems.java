package net.yuelqnn.templatemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yuelqnn.templatemod.TemplateMod;

public class ModItems {

    public final static Item APPLE_SLICE = registerItem("apple_slice", new Item(new Item.Settings()));
    public final static Item APPLE_PIE = registerItem("apple_pie", new Item(new Item.Settings()));
    public final static Item APPLE_RUBY = registerItem("apple_ruby", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TemplateMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TemplateMod.LOGGER.info("Registering Mod Items for " + TemplateMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(APPLE_SLICE);
            entries.add(APPLE_PIE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(APPLE_RUBY);
        });
    }
}
