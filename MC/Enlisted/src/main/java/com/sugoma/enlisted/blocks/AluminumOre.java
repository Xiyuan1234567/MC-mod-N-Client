package com.sugoma.enlisted.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;


public class AluminumOre extends OreBlock{
    public AluminumOre() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f, 4.0f).sound(SoundType.STONE).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE));
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader,BlockPos pos, int fortune, int silktouch) {
        return 1;
    }
}
