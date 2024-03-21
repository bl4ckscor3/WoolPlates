package bl4ckscor3.mod.woolplates;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class Configuration {
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final Configuration CONFIG;
	public final BooleanValue enableSound;
	public final BooleanValue triggerSculkSensors;

	static {
		Pair<Configuration, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Configuration::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	Configuration(ForgeConfigSpec.Builder builder) {
		//@formatter:off
		enableSound = builder
				.comment("true if the wool pressure plates should play a sound when stepped on/off, false otherwhise")
				.define("enable_sound", false);
		triggerSculkSensors = builder
				.comment("True if the wool pressure plates should trigger sculk sensors, false otherwise. This only applies to pressing the plates.",
						"If you want placing and breaking them to trigger sculk sensors, you need to remove the plates from the minecraft:dampens_vibrations block tag.")
				.define("trigger_sculk_sensors", false);
		//@formatter:on
	}
}