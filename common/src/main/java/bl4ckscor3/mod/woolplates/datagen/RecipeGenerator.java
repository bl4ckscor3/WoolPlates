package bl4ckscor3.mod.woolplates.datagen;

import java.util.concurrent.CompletableFuture;

import bl4ckscor3.mod.woolplates.RegistryObject;
import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ColorCollection;

public class RecipeGenerator extends RecipeProvider {
	private final HolderGetter<Item> items;

	public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output) {
		super(lookupProvider, output);
		items = lookupProvider.lookupOrThrow(Registries.ITEM);
	}

	@Override
	public final void buildRecipes() {
		ColorCollection.VALUES.forEach(color -> {
			Item dye = Items.DYE.pick(color);
			Item plate = WoolPlates.ITEMS.pick(color).get();

			ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, plate)
				.group("wool_plates")
				.requires(ItemTags.WOODEN_PRESSURE_PLATES)
				.requires(Items.WOOL.pick(color))
				.unlockedBy("has_wool", has(ItemTags.WOOL))
				.save(output);
			ShapelessRecipeBuilder.shapeless(items, RecipeCategory.BUILDING_BLOCKS, plate)
				.group("wool_plates")
				.requires(dye)
				.requires(Ingredient.of(WoolPlates.ITEMS.asList().stream().map(RegistryObject::get).filter(check -> !check.equals(plate))))
				.unlockedBy("has_needed_dye", has(dye))
				.save(output, WoolPlates.MODID + ":dye_" + getItemName(plate));
		});
	}

	public static final class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
			super(output, lookupProvider);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
			return new RecipeGenerator(lookupProvider, output);
		}

		@Override
		public String getName() {
			return "Wool Pressure Plates recipes";
		}
	}
}
