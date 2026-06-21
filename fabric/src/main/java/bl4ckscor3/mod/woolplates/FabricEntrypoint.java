package bl4ckscor3.mod.woolplates;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import bl4ckscor3.mod.woolplates.lib.Platform;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.fml.config.ModConfig;

public class FabricEntrypoint implements ModInitializer, Platform {
	@Override
	public void onInitialize() {
		WoolPlates.initialize(this);
		ConfigRegistry.INSTANCE.register(WoolPlates.MODID, ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS).register(output -> output.insertAfter(Items.STONE_PRESSURE_PLATE, List.of(new ItemStack(WoolPlates.ITEMS.white().get())), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> output.acceptAll(WoolPlates.gameplayColorOrderItems().map(ItemStack::new).toList()));
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public <R, T extends R> void register(ResourceKey<? extends Registry<R>> registryKey, Supplier<T> entry, String path) {
		Optional<Holder.Reference<R>> registry = BuiltInRegistries.REGISTRY.get((ResourceKey) registryKey);

		if (registry.isEmpty()) {
			throw new IllegalArgumentException("Couldn't find registry " + registryKey);
		}

		Registry.register((Registry<R>) registry.get().value(), WoolPlates.id(path), entry.get());
	}
}
