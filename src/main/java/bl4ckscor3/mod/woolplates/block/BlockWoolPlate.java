package bl4ckscor3.mod.woolplates.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWoolPlate extends BlockPressurePlate
{
	public BlockWoolPlate(String name)
	{
		super(Sensitivity.EVERYTHING, Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.CLOTH));

		setRegistryName(name);
	}

	@Override
	public void onFallenUpon(World world, BlockPos pos, Entity entity, float fallDistance)
	{
		super.onFallenUpon(world, pos, entity, fallDistance * 0.8F);
	}
}
