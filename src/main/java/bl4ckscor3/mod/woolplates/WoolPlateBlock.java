package bl4ckscor3.mod.woolplates;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WoolPlateBlock extends PressurePlateBlock
{
	public WoolPlateBlock(Properties properties)
	{
		super(Sensitivity.EVERYTHING, properties);
	}

	@Override
	public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float fallDistance)
	{
		super.fallOn(world, state, pos, entity, fallDistance * 0.8F);
	}

	@Override
	protected void playOnSound(LevelAccessor world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundSource.BLOCKS, 0.3F, 0.8F);
	}

	@Override
	protected void playOffSound(LevelAccessor world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundSource.BLOCKS, 0.3F, 0.7F);
	}
}
