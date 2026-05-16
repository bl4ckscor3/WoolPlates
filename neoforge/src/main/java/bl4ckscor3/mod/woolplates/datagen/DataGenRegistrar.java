package bl4ckscor3.mod.woolplates.datagen;

import java.util.List;
import java.util.Set;

import bl4ckscor3.mod.woolplates.RegistryObject;
import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = WoolPlates.MODID)
public class DataGenRegistrar {
	private DataGenRegistrar() {}

	@SubscribeEvent
	public static void onGatherData(GatherDataEvent.Client event) {
		event.createProvider(BlockTagGenerator::new);
		event.createProvider((output, lookupProvider) -> new LootTableProvider(output, Set.of(), List.of(new SubProviderEntry(lookupProvider1 -> new BlockLootTableGenerator(lookupProvider1) {
			@Override
			protected Iterable<Block> getKnownBlocks() {
				return WoolPlates.BLOCKS.values().stream().map(RegistryObject::get).map(Block.class::cast).toList();
			}
		}, LootContextParamSets.BLOCK)), lookupProvider));
		event.createProvider(RecipeGenerator.Runner::new);
	}
}
