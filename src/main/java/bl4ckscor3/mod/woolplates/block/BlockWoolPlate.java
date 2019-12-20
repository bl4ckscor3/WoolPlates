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

public class BlockWoolPlate extends PressurePlateBlock
{
	public BlockWoolPlate(String name)
	{
		super(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOL).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.CLOTH));

		setRegistryName(name);
	}

	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance)
	{
		super.onFallenUpon(world, pos, entity, fallDistance * 0.8F);
	}

	@Override
	protected void playClickOnSound(IWorld world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
	}

	@Override
	protected void playClickOffSound(IWorld world, BlockPos pos)
	{
		if(SoundConfig.CONFIG.enableSound.get())
			world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
	}
}
