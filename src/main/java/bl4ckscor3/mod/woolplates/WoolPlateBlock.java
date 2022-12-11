package bl4ckscor3.mod.woolplates;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WoolPlateBlock extends PressurePlateBlock {
	public WoolPlateBlock(Sensitivity sensitivity, Properties properties, SoundEvent soundOff, SoundEvent soundOn) {
		super(sensitivity, properties, soundOff, soundOn);
	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.fallOn(level, state, pos, entity, fallDistance * 0.8F);
	}

	@Override
	protected void playOnSound(LevelAccessor level, BlockPos pos) {
		if (SoundConfig.CONFIG.enableSound.get())
			super.playOnSound(level, pos);
	}

	@Override
	protected void playOffSound(LevelAccessor level, BlockPos pos) {
		if (SoundConfig.CONFIG.enableSound.get())
			super.playOffSound(level, pos);
	}
}
