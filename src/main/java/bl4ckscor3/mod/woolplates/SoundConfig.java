package bl4ckscor3.mod.woolplates;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class SoundConfig {
	public static final ForgeConfigSpec CONFIG_SPEC;
	public static final SoundConfig CONFIG;
	public final BooleanValue enableSound;

	static {
		Pair<SoundConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(SoundConfig::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	SoundConfig(ForgeConfigSpec.Builder builder) {
		//@formatter:off
		enableSound = builder
				.comment("true if the wool pressure plates should play a sound when stepped on/off, false otherwhise")
				.define("enable_sound", false);
		//@formatter:on
	}
}