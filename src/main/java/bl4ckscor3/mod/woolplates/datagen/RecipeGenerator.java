package bl4ckscor3.mod.woolplates.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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

public class RecipeGenerator extends RecipeProvider {
	private final HolderGetter<Item> items;

	public RecipeGenerator(HolderLookup.Provider lookupProvider, RecipeOutput output) {
		super(lookupProvider, output);
		items = lookupProvider.lookupOrThrow(Registries.ITEM);
	}

	@Override
	protected final void buildRecipes() {
		//@formatter:off
        List<Item> woolColors = List.of(
                Items.WHITE_WOOL,
                Items.LIGHT_GRAY_WOOL,
                Items.GRAY_WOOL,
                Items.BLACK_WOOL,
                Items.BROWN_WOOL,
                Items.RED_WOOL,
                Items.ORANGE_WOOL,
                Items.YELLOW_WOOL,
                Items.LIME_WOOL,
                Items.GREEN_WOOL,
                Items.CYAN_WOOL,
                Items.LIGHT_BLUE_WOOL,
                Items.BLUE_WOOL,
                Items.PURPLE_WOOL,
                Items.MAGENTA_WOOL,
                Items.PINK_WOOL);
        List<Item> dyes = List.of(
                Items.WHITE_DYE,
                Items.LIGHT_GRAY_DYE,
                Items.GRAY_DYE,
                Items.BLACK_DYE,
                Items.BROWN_DYE,
                Items.RED_DYE,
                Items.ORANGE_DYE,
                Items.YELLOW_DYE,
                Items.LIME_DYE,
                Items.GREEN_DYE,
                Items.CYAN_DYE,
                Items.LIGHT_BLUE_DYE,
                Items.BLUE_DYE,
                Items.PURPLE_DYE,
                Items.MAGENTA_DYE,
                Items.PINK_DYE);
		//@formatter:on
		List<Item> buttons = List.copyOf(WoolPlates.ITEMS.values());

		for (int i = 0; i < buttons.size(); i++) {
			Item dye = dyes.get(i);
			Item button = buttons.get(i);

			//@formatter:off
        	ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, button)
        	.group("wool_plates")
			.requires(ItemTags.WOODEN_PRESSURE_PLATES)
			.requires(woolColors.get(i))
			.unlockedBy("has_wool", has(ItemTags.WOOL))
			.save(output);
            ShapelessRecipeBuilder.shapeless(items, RecipeCategory.BUILDING_BLOCKS, button)
        	.group("wool_plates")
            .requires(dye)
            .requires(Ingredient.of(buttons.stream().filter(check -> !check.equals(button))))
            .unlockedBy("has_needed_dye", has(dye))
            .save(output, WoolPlates.MODID + ":dye_" + getItemName(button));
			//@formatter:on
		}
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
