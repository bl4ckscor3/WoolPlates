package bl4ckscor3.mod.woolplates.block;

import bl4ckscor3.mod.woolplates.WoolPlates;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoolPlate extends BlockPressurePlate
{
	public BlockWoolPlate(String name)
	{
		super(Material.WOOD, Sensitivity.EVERYTHING);

		setRegistryName(name);
		setTranslationKey(WoolPlates.PREFIX + name);
		setHardness(0.5F);
		setSoundType(SoundType.CLOTH);
	}
}
