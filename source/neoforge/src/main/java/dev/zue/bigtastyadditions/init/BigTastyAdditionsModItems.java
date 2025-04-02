
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package dev.zue.bigtastyadditions.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

import dev.zue.bigtastyadditions.item.PeelerItem;
import dev.zue.bigtastyadditions.item.PeeledAppleItem;
import dev.zue.bigtastyadditions.item.ChefsKnifeItem;
import dev.zue.bigtastyadditions.item.AppleSlicesItem;
import dev.zue.bigtastyadditions.BigTastyAdditionsMod;

public class BigTastyAdditionsModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BigTastyAdditionsMod.MODID);
	public static final DeferredItem<Item> PEELED_APPLE = register("peeled_apple", PeeledAppleItem::new);
	public static final DeferredItem<Item> APPLE_SLICES = register("apple_slices", AppleSlicesItem::new);
	public static final DeferredItem<Item> CHEFS_KNIFE = register("chefs_knife", ChefsKnifeItem::new);
	public static final DeferredItem<Item> PEELER = register("peeler", PeelerItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}
