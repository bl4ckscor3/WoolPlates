package bl4ckscor3.mod.woolplates;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class WoolPlateBlock extends PressurePlateBlock
{
	public WoolPlateBlock(String name)
	{
		super(Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOL).noCollission().strength(0.5F).sound(SoundType.WOOL));

		setRegistryName(name);
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
