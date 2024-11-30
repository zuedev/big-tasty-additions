package zuedev.bigtastyadditions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigTastyAdditions implements ModInitializer {
    public static final String MOD_ID = "big-tasty-additions";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item PEELED_APPLE = registerItem(
            new Item(
                    new FabricItemSettings().food(
                            new FoodComponent.Builder()
                                    .hunger(FoodComponents.APPLE.getHunger())
                                    .build()
                    )
            ),
            "peeled_apple"
    );
    public static final ItemGroup BIG_TASTY_ADDITIONS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(PEELED_APPLE))
            .displayName(Text.translatable("itemGroup.big_tasty_additions"))
            .build();

    public static final RegistryKey<ItemGroup> BIG_TASTY_ADDITIONS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(MOD_ID, "big_tasty_additions"));

    public static final Item APPLE_SLICES = registerItem(
            new Item(
                    new FabricItemSettings().food(
                            new FoodComponent.Builder()
                                    .hunger(FoodComponents.APPLE.getHunger())
                                    .build()
                    )
            ),
            "apple_slices"
    );

    public static Item registerItem(Item item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, id), item);
    }

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");

        Registry.register(Registries.ITEM_GROUP, BIG_TASTY_ADDITIONS_KEY, BIG_TASTY_ADDITIONS);

        ItemGroupEvents.modifyEntriesEvent(BIG_TASTY_ADDITIONS_KEY).register(itemGroup -> {
            itemGroup.add(new ItemStack(PEELED_APPLE));
            itemGroup.add(new ItemStack(APPLE_SLICES));
        });
    }
}