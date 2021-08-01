package bl4ckscor3.mod.woolplates.block;

import bl4ckscor3.mod.woolplates.SoundConfig;
import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import net.minecraft.block.PressurePlateBlock.Sensitivity;

public class BlockWoolPlate extends PressurePlateBlock
{
	public BlockWoolPlate(String name)
	{
		super(Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOL).noCollission().strength(0.5F).sound(SoundType.WOOL));

		setRegistryName(name);
	}

	@Override
	public void fallOn(World world, BlockPos pos, Entity entity, float fallDistance)
	{
		super.fallOn(world, pos, entity, fallDistance * 0.8F);
	}

	@Override
	protected void playOnSound(IWorld world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
	}

	@Override
	protected void playOffSound(IWorld world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
	}
}
