package bl4ckscor3.mod.woolplates;

import bl4ckscor3.mod.woolplates.block.BlockWoolPlate;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.ObjectHolder;

@Mod(WoolPlates.MODID)
@EventBusSubscriber(bus=Bus.MOD)
public class WoolPlates
{
	public static final String MODID = "woolplates";
	public static final String NAME = "Wool Pressure Plates";
	public static final String MC_VERSION = "1.12";
	public static final String PREFIX = MODID + ":";

	@ObjectHolder(PREFIX + "wool_plate_white")
	public static final Block WHITE = null;
	@ObjectHolder(PREFIX + "wool_plate_orange")
	public static final Block ORANGE = null;
	@ObjectHolder(PREFIX + "wool_plate_magenta")
	public static final Block MAGENTA = null;
	@ObjectHolder(PREFIX + "wool_plate_light_blue")
	public static final Block LIGHT_BLUE = null;
	@ObjectHolder(PREFIX + "wool_plate_yellow")
	public static final Block YELLOW = null;
	@ObjectHolder(PREFIX + "wool_plate_lime")
	public static final Block LIME = null;
	@ObjectHolder(PREFIX + "wool_plate_pink")
	public static final Block PINK = null;
	@ObjectHolder(PREFIX + "wool_plate_gray")
	public static final Block GRAY = null;
	@ObjectHolder(PREFIX + "wool_plate_light_gray")
	public static final Block SILVER = null;
	@ObjectHolder(PREFIX + "wool_plate_cyan")
	public static final Block CYAN = null;
	@ObjectHolder(PREFIX + "wool_plate_purple")
	public static final Block PURPLE = null;
	@ObjectHolder(PREFIX + "wool_plate_blue")
	public static final Block BLUE = null;
	@ObjectHolder(PREFIX + "wool_plate_brown")
	public static final Block BROWN = null;
	@ObjectHolder(PREFIX + "wool_plate_green")
	public static final Block GREEN = null;
	@ObjectHolder(PREFIX + "wool_plate_red")
	public static final Block RED = null;
	@ObjectHolder(PREFIX + "wool_plate_black")
	public static final Block BLACK = null;

	public WoolPlates()
	{
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SoundConfig.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(new BlockWoolPlate("wool_plate_white"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_orange"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_magenta"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_light_blue"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_yellow"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_lime"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_pink"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_gray"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_light_gray"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_cyan"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_purple"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_blue"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_brown"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_green"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_red"));
		event.getRegistry().register(new BlockWoolPlate("wool_plate_black"));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new BlockItem(WHITE, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(WHITE.getRegistryName()));
		event.getRegistry().register(new BlockItem(ORANGE, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(ORANGE.getRegistryName()));
		event.getRegistry().register(new BlockItem(MAGENTA, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(MAGENTA.getRegistryName()));
		event.getRegistry().register(new BlockItem(LIGHT_BLUE, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(LIGHT_BLUE.getRegistryName()));
		event.getRegistry().register(new BlockItem(YELLOW, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(YELLOW.getRegistryName()));
		event.getRegistry().register(new BlockItem(LIME, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(LIME.getRegistryName()));
		event.getRegistry().register(new BlockItem(PINK, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(PINK.getRegistryName()));
		event.getRegistry().register(new BlockItem(GRAY, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(GRAY.getRegistryName()));
		event.getRegistry().register(new BlockItem(SILVER, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(SILVER.getRegistryName()));
		event.getRegistry().register(new BlockItem(CYAN, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(CYAN.getRegistryName()));
		event.getRegistry().register(new BlockItem(PURPLE, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(PURPLE.getRegistryName()));
		event.getRegistry().register(new BlockItem(BLUE, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(BLUE.getRegistryName()));
		event.getRegistry().register(new BlockItem(BROWN, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(BROWN.getRegistryName()));
		event.getRegistry().register(new BlockItem(GREEN, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(GREEN.getRegistryName()));
		event.getRegistry().register(new BlockItem(RED, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(RED.getRegistryName()));
		event.getRegistry().register(new BlockItem(BLACK, new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(BLACK.getRegistryName()));
	}
}
