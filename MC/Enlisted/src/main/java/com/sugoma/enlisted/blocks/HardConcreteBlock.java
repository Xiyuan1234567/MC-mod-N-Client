package com.sugoma.enlisted.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class HardConcreteBlock extends Block {
    public HardConcreteBlock() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(15.0f,1000.0f).sound(SoundType.STONE).harvestLevel(3).setRequiresTool().harvestTool(ToolType.PICKAXE));
    }
}
