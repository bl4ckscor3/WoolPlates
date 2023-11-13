package bl4ckscor3.mod.woolplates;

import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class SoundConfig {
	public static final ModConfigSpec CONFIG_SPEC;
	public static final SoundConfig CONFIG;
	public final BooleanValue enableSound;

	static {
		Pair<SoundConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(SoundConfig::new);

		CONFIG_SPEC = specPair.getRight();
		CONFIG = specPair.getLeft();
	}

	SoundConfig(ModConfigSpec.Builder builder) {
		//@formatter:off
		enableSound = builder
				.comment("true if the wool pressure plates should play a sound when stepped on/off, false otherwhise")
				.define("enable_sound", false);
		//@formatter:on
	}
}