package zuedev.bigtastyadditions.food.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static zuedev.bigtastyadditions.BigTastyAdditions.registerItem;
import static zuedev.bigtastyadditions.food.food.BIG_TASTY_ADDITIONS_KEY;
import static zuedev.bigtastyadditions.food.items.peeler.PEELER;

public class peeled_apple {
    public static final Item PEELED_APPLE = registerItem(
            new Item(
                    new FabricItemSettings().food(
                            new FoodComponent.Builder()
                                    .hunger(FoodComponents.APPLE.getHunger())
                                    .build()
                    ).recipeRemainder(PEELER)
            ),
            "peeled_apple"
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(BIG_TASTY_ADDITIONS_KEY).register(itemGroup -> {
            itemGroup.add(new ItemStack(PEELED_APPLE));
        });
    }
}
