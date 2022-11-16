package com.sugoma.enlisted.init;

import com.sugoma.enlisted.Enlisted;
import com.sugoma.enlisted.blocks.AluminumOre;
import com.sugoma.enlisted.blocks.HardConcreteBlock;
import com.sugoma.enlisted.blocks.Oven1;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enlisted.MOD_ID);

    //blocks
    public static final RegistryObject<Block> HARD_CONCRETE_BLOCK = BLOCKS.register("hard_concrete_block", HardConcreteBlock::new);
    public static final RegistryObject<Block> ALUMINUM_ORE = BLOCKS.register("aluminum_ore", AluminumOre::new);
    public static final RegistryObject<Block> OVEN1 = BLOCKS.register("oven1", Oven1::new);


}
