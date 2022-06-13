package bl4ckscor3.mod.woolplates;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistries.Keys;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

@Mod(WoolPlates.MODID)
@EventBusSubscriber(bus=Bus.MOD)
public class WoolPlates
{
	public static final String MODID = "woolplates";
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

	public static final RegistryObject<WoolPlateBlock> WHITE = register("wool_plate_white");
	public static final RegistryObject<WoolPlateBlock> ORANGE = register("wool_plate_orange");
	public static final RegistryObject<WoolPlateBlock> MAGENTA = register("wool_plate_magenta");
	public static final RegistryObject<WoolPlateBlock> LIGHT_BLUE = register("wool_plate_light_blue");
	public static final RegistryObject<WoolPlateBlock> YELLOW = register("wool_plate_yellow");
	public static final RegistryObject<WoolPlateBlock> LIME = register("wool_plate_lime");
	public static final RegistryObject<WoolPlateBlock> PINK = register("wool_plate_pink");
	public static final RegistryObject<WoolPlateBlock> GRAY = register("wool_plate_gray");
	public static final RegistryObject<WoolPlateBlock> LIGHT_GRAY = register("wool_plate_light_gray");
	public static final RegistryObject<WoolPlateBlock> CYAN = register("wool_plate_cyan");
	public static final RegistryObject<WoolPlateBlock> PURPLE = register("wool_plate_purple");
	public static final RegistryObject<WoolPlateBlock> BLUE = register("wool_plate_blue");
	public static final RegistryObject<WoolPlateBlock> BROWN = register("wool_plate_brown");
	public static final RegistryObject<WoolPlateBlock> GREEN = register("wool_plate_green");
	public static final RegistryObject<WoolPlateBlock> RED = register("wool_plate_red");
	public static final RegistryObject<WoolPlateBlock> BLACK = register("wool_plate_black");

	public WoolPlates()
	{
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SoundConfig.CONFIG_SPEC);
	}

	@SubscribeEvent
	public static void onRegister(RegisterEvent event)
	{
		event.register(Keys.ITEMS, helper -> {
			helper.register("wool_plate_white", new BlockItem(WHITE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_orange", new BlockItem(ORANGE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_magenta", new BlockItem(MAGENTA.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_light_blue", new BlockItem(LIGHT_BLUE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_yellow", new BlockItem(YELLOW.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_lime", new BlockItem(LIME.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_pink", new BlockItem(PINK.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_gray", new BlockItem(GRAY.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_light_gray", new BlockItem(LIGHT_GRAY.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_cyan", new BlockItem(CYAN.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_purple", new BlockItem(PURPLE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_blue", new BlockItem(BLUE.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_brown", new BlockItem(BROWN.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_green", new BlockItem(GREEN.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_red", new BlockItem(RED.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
			helper.register("wool_plate_black", new BlockItem(BLACK.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));
		});
	}

	private static RegistryObject<WoolPlateBlock> register(String name)
	{
		return BLOCKS.register(name, () -> new WoolPlateBlock(Block.Properties.of(Material.WOOL).noCollission().strength(0.5F).sound(SoundType.WOOL)));
	}
}
