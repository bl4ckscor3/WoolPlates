package bl4ckscor3.mod.woolplates;

import java.util.List;
import java.util.stream.Stream;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ColorCollection;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WoolPlates {
	public static final String MODID = "woolplates";
	public static final BlockSetType WOOL_PLATES_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType(MODID + ":wool", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.WOOL, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.EMPTY, SoundEvents.EMPTY));
	public static final ColorCollection<BlockItemId> IDS = ColorCollection.NAMES.map(color -> {
		Identifier base = Identifier.fromNamespaceAndPath(MODID, "wool_plate_" + color);
		return BlockItemId.create(base, base);
	});
	public static final ColorCollection<RegistryObject<WoolPlateBlock>> BLOCKS = IDS.map(
		id -> RegistryObject.block(
			id.block().identifier().getPath(),
			p -> new WoolPlateBlock(p, WOOL_PLATES_BLOCK_SET_TYPE),
			() -> BlockBehaviour.Properties.of().noCollision().strength(0.5F)
		)
	);
	public static final ColorCollection<RegistryObject<BlockItem>> ITEMS = ColorCollection.zipMap(IDS, BLOCKS,
		(id, block) -> RegistryObject.blockItem(
			id.item().identifier().getPath(),
			p -> new BlockItem(block.get(), p),
			Item.Properties::new
		)
	);
	private static Platform platform;

	public synchronized static void initialize(Platform platform) {
		if (WoolPlates.platform != null) {
			throw new IllegalArgumentException(MODID + " platform has already been initialized");
		}

		WoolPlates.platform = platform;

		BLOCKS.forEach(block -> platform.register(Registries.BLOCK, block));
		ITEMS.forEach(item -> platform.register(Registries.ITEM, item));
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}

	public static Platform platform() {
		return platform;
	}

	public static Stream<Item> gameplayColorOrderItems() {
		List<DyeColor> gameplayColorOrder = List.of(
			DyeColor.WHITE,
			DyeColor.LIGHT_GRAY,
			DyeColor.GRAY,
			DyeColor.BLACK,
			DyeColor.BROWN,
			DyeColor.RED,
			DyeColor.ORANGE,
			DyeColor.YELLOW,
			DyeColor.LIME,
			DyeColor.GREEN,
			DyeColor.CYAN,
			DyeColor.LIGHT_BLUE,
			DyeColor.BLUE,
			DyeColor.PURPLE,
			DyeColor.MAGENTA,
			DyeColor.PINK
		);

		return gameplayColorOrder.stream().map(ITEMS::pick).map(RegistryObject::get);
	}
}
