package bl4ckscor3.mod.woolplates;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab.TabVisibility;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegisterEvent;

@Mod(WoolPlates.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class WoolPlates {
	public static final String MODID = "woolplates";
	private static final List<ItemStack> STACKS_FOR_CREATIVE_TABS = new ArrayList<>();
	public static final BlockSetType WOOL_PLATES_BLOCK_SET_TYPE = new BlockSetType(MODID + ":wool", SoundType.WOOL, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.EMPTY, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.EMPTY, SoundEvents.EMPTY);

	public WoolPlates() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(Keys.BLOCKS, helper -> {
			for (Color color : Color.values()) {
				helper.register(getName(color), new WoolPlateBlock(Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOL).noCollission().strength(0.5F), WOOL_PLATES_BLOCK_SET_TYPE));
			}
		});
		event.register(Keys.ITEMS, helper -> {
			for (Color color : Color.values()) {
				ResourceLocation name = getName(color);
				Block block = ForgeRegistries.BLOCKS.getValue(name);

				if (block != null) {
					BlockItem blockItem = new BlockItem(block, new Item.Properties());

					helper.register(name, blockItem);
					STACKS_FOR_CREATIVE_TABS.add(new ItemStack(blockItem));
				}
			}
		});
	}

	@SubscribeEvent
	public static void onCreativeModeTabBuildContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS)
			event.getEntries().putAfter(new ItemStack(Items.STONE_PRESSURE_PLATE), STACKS_FOR_CREATIVE_TABS.get(0), TabVisibility.PARENT_AND_SEARCH_TABS); //white only
		else if (event.getTab() == CreativeModeTabs.COLORED_BLOCKS)
			event.acceptAll(STACKS_FOR_CREATIVE_TABS);
	}

	public static ResourceLocation getName(Color color) {
		return new ResourceLocation(MODID, "wool_plate_" + color.name().toLowerCase());
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
	}
}
