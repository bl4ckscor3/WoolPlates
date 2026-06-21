package bl4ckscor3.mod.woolplates.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.references.BlockItemId;
import net.minecraft.tags.BlockTags;

public class BlockTagGenerator extends VanillaBlockTagsProvider {
	public BlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(BlockTags.DAMPENS_VIBRATIONS).addAll(WoolPlates.IDS.map(BlockItemId::block));
	}
}
