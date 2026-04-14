package net.yuelqnn.templatemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yuelqnn.templatemod.TemplateMod;
import net.yuelqnn.templatemod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup APPLE_ITEMS_GROUP =
            Registry.register(Registries.ITEM_GROUP, Identifier.of(TemplateMod.MOD_ID, "apple_items_group"),
                    FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.APPLE_PIE))
                            .displayName(Text.translatable("itemgroup.templatemod.apple_items_group"))
                            .entries((displayContext, entries) -> {
                                entries.add(ModItems.APPLE_PIE);
                                entries.add(ModItems.APPLE_SLICE);
                                entries.add(ModBlocks.APPLE_CRATE_BLOCK);
                                entries.add(ModBlocks.APPLE_LEAVES);
                                entries.add(ModItems.APPLE_RUBY);
                                entries.add(ModBlocks.APPLE_RUBY_BLOCK);
                            })

                            .build());

    public static void registerItemGroups(){
        TemplateMod.LOGGER.info("Registering Item Groups for "+ TemplateMod.MOD_ID);
    }
}
