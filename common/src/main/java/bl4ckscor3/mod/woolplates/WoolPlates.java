package bl4ckscor3.mod.woolplates;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WoolPlates {
	public static final String MODID = "woolplates";
	public static final BlockSetType WOOL_PLATES_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType(MODID + ":wool", true, true, true, BlockSetType.PressurePlateSensitivity.EVERYTHING, SoundType.WOOL, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.EMPTY, SoundEvents.EMPTY));
	public static final Map<Color, RegistryObject<WoolPlateBlock>> BLOCKS = new EnumMap<>(Color.class);
	public static final Map<Color, RegistryObject<BlockItem>> ITEMS = new EnumMap<>(Color.class);
	private static Platform platform;

	public synchronized static void initialize(Platform platform) {
		if (WoolPlates.platform != null) {
			throw new IllegalArgumentException(MODID + " platform has already been initialized");
		}

		WoolPlates.platform = platform;

		for (Color color : Color.values()) {
			String name = color.getPlateName();
			RegistryObject<WoolPlateBlock> block = RegistryObject.block(name, p -> new WoolPlateBlock(p, WOOL_PLATES_BLOCK_SET_TYPE), () -> BlockBehaviour.Properties.of().noCollision().strength(0.5F));
			RegistryObject<BlockItem> blockItem = RegistryObject.blockItem(name, p -> new BlockItem(block.get(), p), Item.Properties::new);

			platform.register(Registries.BLOCK, block);
			platform.register(Registries.ITEM, blockItem);
			BLOCKS.put(color, block);
			ITEMS.put(color, blockItem);
		}
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}

	public static Platform platform() {
		return platform;
	}

	public enum Color {
		WHITE,
		LIGHT_GRAY,
		GRAY,
		BLACK,
		BROWN,
		RED,
		ORANGE,
		YELLOW,
		LIME,
		GREEN,
		CYAN,
		LIGHT_BLUE,
		BLUE,
		PURPLE,
		MAGENTA,
		PINK;

		public String getPlateName() {
			return "wool_plate_" + name().toLowerCase();
		}
	}
}
