package bl4ckscor3.mod.woolplates.lib;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public record RegisteredItem<T extends Item>(ResourceKey<Item> key, Supplier<T> object) implements RegistryObject<Item, T>, ItemLike {
	public static <I extends Item> RegisteredItem<I> item(Identifier id, ItemConstructor<I> itemConstructor, Supplier<Item.Properties> properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
		return new RegisteredItem<>(
			key,
			Suppliers.memoize(() -> itemConstructor.construct(properties.get().setId(key)))
		);
	}

	public static <I extends Item> RegisteredItem<I> item(String id, ItemConstructor<I> itemConstructor, Supplier<Item.Properties> properties) {
		return item(WoolPlates.id(id), itemConstructor, properties);
	}

	public static RegisteredItem<BlockItem> blockItem(RegisteredBlock<?> block, Supplier<Item.Properties> properties) {
		return item(block.key().identifier(), p -> new BlockItem(block.get(), p), () -> properties.get().useBlockDescriptionPrefix());
	}

	public static <I extends BlockItem> RegisteredItem<I> blockItem(String id, ItemConstructor<I> itemConstructor, Supplier<Item.Properties> properties) {
		return item(id, itemConstructor, () -> properties.get().useBlockDescriptionPrefix());
	}

	@Override
	public Item asItem() {
		return get();
	}

	@FunctionalInterface
	public interface ItemConstructor<I extends Item> {
		I construct(Item.Properties properties);
	}
}
