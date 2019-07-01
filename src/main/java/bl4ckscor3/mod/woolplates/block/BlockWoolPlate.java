package bl4ckscor3.mod.woolplates.block;

import bl4ckscor3.mod.woolplates.SoundConfig;
import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWoolPlate extends BlockPressurePlate
{
	public BlockWoolPlate(String name)
	{
		super(Material.CLOTH, Sensitivity.EVERYTHING);

		setRegistryName(name);
		setTranslationKey(WoolPlates.PREFIX + name);
		setHardness(0.5F);
		setSoundType(SoundType.CLOTH);
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
	{
		super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.8F);
	}

	@Override
	protected void playClickOnSound(World world, BlockPos pos)
	{
		if(SoundConfig.enableSound)
			world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
	}

	@Override
	protected void playClickOffSound(World world, BlockPos pos)
	{
		if(SoundConfig.enableSound)
			world.playSound(null, pos, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
	}
}
