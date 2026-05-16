package bl4ckscor3.mod.woolplates;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(WoolPlates.MODID)
@EventBusSubscriber
public class NeoEntrypoint implements Platform {
	private final Map<ResourceKey<? extends Registry<?>>, DeferredRegister<?>> registers = new HashMap<>();
	private final IEventBus modBus;

	public NeoEntrypoint(ModContainer modContainer, IEventBus modBus) {
		this.modBus = modBus;
		WoolPlates.initialize(this);
		modContainer.registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
			event.insertAfter(new ItemStack(Items.STONE_PRESSURE_PLATE), new ItemStack(WoolPlates.ITEMS.get(WoolPlates.Color.WHITE).get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
		else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS)
			event.acceptAll(WoolPlates.ITEMS.values().stream().map(RegistryObject::get).map(ItemStack::new).toList());
	}

	@Override
	public <R, T extends R> void register(ResourceKey<? extends Registry<R>> registry, Supplier<T> entry, String path) {
		@SuppressWarnings("unchecked")
		DeferredRegister<R> register = (DeferredRegister<R>) registers.computeIfAbsent(
			registry,
			_ -> {
				DeferredRegister<R> r = DeferredRegister.create(registry, WoolPlates.MODID);

				r.register(modBus);
				return r;
			}
		);
		register.register(path, entry);
	}
}
