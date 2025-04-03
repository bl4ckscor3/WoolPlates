package bl4ckscor3.mod.woolplates.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class BlockTagGenerator extends BlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, WoolPlates.MODID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		WoolPlates.BLOCKS.values().forEach(block -> tag(BlockTags.DAMPENS_VIBRATIONS).add(block));
	}
}
