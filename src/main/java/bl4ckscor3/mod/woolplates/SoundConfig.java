package bl4ckscor3.mod.woolplates;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;

@Config(modid = WoolPlates.MODID)
public class SoundConfig
{
	@Name("enable_sound")
	@Comment("true if the wool pressure plates should play a sound when stepped on/off, false otherwhise")
	public static boolean enableSound = false;
}