package zuedev.bigtastyadditions;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zuedev.bigtastyadditions.food.food;

public class BigTastyAdditions implements ModInitializer {
    public static final String MOD_ID = "big-tasty-additions";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");

        food.initialize();
    }

    public static Item registerItem(Item item, String id) {
        return Registry.register(Registries.ITEM, new Identifier(BigTastyAdditions.MOD_ID, id), item);
    }
}