package bl4ckscor3.mod.woolplates;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.gameevent.GameEvent;

public class WoolPlateBlock extends PressurePlateBlock {
	private BlockSetType blockSetType;

	public WoolPlateBlock(Sensitivity sensitivity, Properties properties, BlockSetType blockSetType) {
		super(sensitivity, properties, blockSetType);
		this.blockSetType = blockSetType;
	}

	@Override
	public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
		super.fallOn(level, state, pos, entity, fallDistance * 0.8F);
	}

	@Override
	public void checkPressed(Entity entity, Level level, BlockPos pos, BlockState state, int currentSignal) {
		int signalStrength = getSignalStrength(level, pos);
		boolean hasSignal = currentSignal > 0;
		boolean shouldHaveSignal = signalStrength > 0;

		if (currentSignal != signalStrength) {
			BlockState newState = setSignalForState(state, signalStrength);

			level.setBlock(pos, newState, 2);
			updateNeighbours(level, pos);
			level.setBlocksDirty(pos, state, newState);
		}

		if (!shouldHaveSignal && hasSignal) {
			if (SoundConfig.CONFIG.enableSound.get())
				level.playSound(null, pos, blockSetType.pressurePlateClickOff(), SoundSource.BLOCKS);

			level.gameEvent(entity, GameEvent.BLOCK_DEACTIVATE, pos);
		}
		else if (shouldHaveSignal && !hasSignal) {
			if (SoundConfig.CONFIG.enableSound.get())
				level.playSound(null, pos, blockSetType.pressurePlateClickOn(), SoundSource.BLOCKS);

			level.gameEvent(entity, GameEvent.BLOCK_ACTIVATE, pos);
		}

		if (shouldHaveSignal)
			level.scheduleTick(new BlockPos(pos), this, getPressedTime());
	}
}
