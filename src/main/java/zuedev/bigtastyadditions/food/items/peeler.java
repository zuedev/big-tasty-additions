package zuedev.bigtastyadditions.food.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static zuedev.bigtastyadditions.BigTastyAdditions.registerItem;
import static zuedev.bigtastyadditions.food.food.BIG_TASTY_ADDITIONS_KEY;

public class peeler {
    public static final Item PEELER = registerItem(
            new Item(
                    new FabricItemSettings().maxCount(1)
            ),
            "peeler"
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(BIG_TASTY_ADDITIONS_KEY).register(itemGroup -> {
            itemGroup.add(new ItemStack(PEELER));
        });
    }
}
