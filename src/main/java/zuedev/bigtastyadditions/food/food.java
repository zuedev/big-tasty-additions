package zuedev.bigtastyadditions.food;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import zuedev.bigtastyadditions.BigTastyAdditions;
import zuedev.bigtastyadditions.food.items.apple_slices;
import zuedev.bigtastyadditions.food.items.knife;
import zuedev.bigtastyadditions.food.items.peeled_apple;
import zuedev.bigtastyadditions.food.items.peeler;

import static zuedev.bigtastyadditions.food.items.apple_slices.APPLE_SLICES;

public class food {
    public static final ItemGroup BIG_TASTY_ADDITIONS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(APPLE_SLICES))
            .displayName(Text.translatable("itemGroup.big-tasty-additions.food"))
            .build();

    public static final RegistryKey<ItemGroup> BIG_TASTY_ADDITIONS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(BigTastyAdditions.MOD_ID, "big-tasty-additions"));

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, BIG_TASTY_ADDITIONS_KEY, BIG_TASTY_ADDITIONS);

        apple_slices.initialize();
        knife.initialize();
        peeled_apple.initialize();
        peeler.initialize();
    }
}
