package zuedev.bigtastyadditions;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Items {
    public static final Item PEELER = registerItem(
            new Item(
                    new FabricItemSettings().maxCount(1)
            ),
            "peeler"
    );

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

    public static final ItemGroup BIG_TASTY_ADDITIONS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PEELED_APPLE))
            .displayName(Text.translatable("itemGroup.big-tasty-additions"))
            .build();

    public static final Item KNIFE = registerItem(
            new Item(
                    new FabricItemSettings().maxCount(1)
            ),
            "knife"
    );

    public static final Item APPLE_SLICES = registerItem(
            new Item(
                    new FabricItemSettings().food(
                            new FoodComponent.Builder()
                                    .hunger(FoodComponents.APPLE.getHunger())
                                    .build()
                    ).recipeRemainder(KNIFE)
            ),
            "apple_slices"
    );

    public static final RegistryKey<ItemGroup> BIG_TASTY_ADDITIONS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(BigTastyAdditions.MOD_ID, "big-tasty-additions"));

    public static Item registerItem(Item item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(BigTastyAdditions.MOD_ID, id), item);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, BIG_TASTY_ADDITIONS_KEY, BIG_TASTY_ADDITIONS);

        ItemGroupEvents.modifyEntriesEvent(BIG_TASTY_ADDITIONS_KEY).register(itemGroup -> {
            itemGroup.add(new ItemStack(PEELED_APPLE));
            itemGroup.add(new ItemStack(APPLE_SLICES));
            itemGroup.add(new ItemStack(PEELER));
            itemGroup.add(new ItemStack(KNIFE));
        });
    }
}
