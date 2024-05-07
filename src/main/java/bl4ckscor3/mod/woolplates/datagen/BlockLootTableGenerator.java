package bl4ckscor3.mod.woolplates.datagen;

import java.util.Set;

import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

public class BlockLootTableGenerator extends BlockLootSubProvider {
	protected BlockLootTableGenerator() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate() {
		getKnownBlocks().forEach(this::dropSelf);
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return WoolPlates.BLOCKS.values();
	}
}
