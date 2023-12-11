package bl4ckscor3.mod.woolplates;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockSetType.PressurePlateSensitivity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.Mod.EventBusSubscriber;
import net.neoforged.fml.common.Mod.EventBusSubscriber.Bus;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(WoolPlates.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class WoolPlates {
	public static final String MODID = "woolplates";
	private static final List<ItemStack> STACKS_FOR_CREATIVE_TABS = new ArrayList<>();
	public static final BlockSetType WOOL_PLATES_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType(MODID + ":wool", true, true, true, PressurePlateSensitivity.EVERYTHING, SoundType.WOOL, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.EMPTY, SoundEvents.EMPTY));

	public WoolPlates() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SoundConfig.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(Registries.BLOCK, helper -> {
			for (Color color : Color.values()) {
				helper.register(getName(color), new WoolPlateBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F), WOOL_PLATES_BLOCK_SET_TYPE));
			}
		});
		event.register(Registries.ITEM, helper -> {
			for (Color color : Color.values()) {
				ResourceLocation name = getName(color);
				Block block = BuiltInRegistries.BLOCK.get(name);

				if (block != null) {
					BlockItem blockItem = new BlockItem(block, new Item.Properties());

					helper.register(name, blockItem);
					STACKS_FOR_CREATIVE_TABS.add(new ItemStack(blockItem));
				}
			}
		});
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
			event.getEntries().putAfter(new ItemStack(Items.STONE_PRESSURE_PLATE), STACKS_FOR_CREATIVE_TABS.get(0), TabVisibility.PARENT_AND_SEARCH_TABS); //white only
		else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS)
			event.acceptAll(STACKS_FOR_CREATIVE_TABS);
	}

	public static ResourceLocation getName(Color color) {
		return new ResourceLocation(MODID, "wool_plate_" + color.name().toLowerCase());
	}

	private enum Color {
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
	}
}
