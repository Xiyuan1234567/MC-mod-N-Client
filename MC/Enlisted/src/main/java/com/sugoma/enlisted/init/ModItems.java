package com.sugoma.enlisted.init;

import com.sugoma.enlisted.Enlisted;
import com.sugoma.enlisted.blocks.BlockItemBase;
import com.sugoma.enlisted.items.ItemBase;
import com.sugoma.enlisted.items.Medkit;
import com.sugoma.enlisted.items.ModSpawnEggItem;
import com.sugoma.enlisted.util.enums.ModArmorMaterial;
import com.sugoma.enlisted.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enlisted.MOD_ID);

    // Tools
    public static final RegistryObject<SwordItem> COMBAT_KNIFE = ITEMS.register("combat_knife",()->
            new SwordItem(ModItemTier.STEEL, 7, -1.9f, new Item.Properties().group(Enlisted.TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> M1_HELMET = ITEMS.register("m1_helmet",()->new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(Enlisted.TAB)));
    public static final RegistryObject<ArmorItem> VEST = ITEMS.register("vest",()->new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(Enlisted.TAB)));
    public static final RegistryObject<ArmorItem> LEGGING = ITEMS.register("legging",()->new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(Enlisted.TAB)));
    public static final RegistryObject<ArmorItem> BOOTS = ITEMS.register("boots",()->new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(Enlisted.TAB)));

    //items
    //green name shows item name in code
    public static final RegistryObject<Item> HARDCONCRETE = ITEMS.register("hardconcrete", ItemBase::new);
    public static final RegistryObject<Item> BOLTERROUND = ITEMS.register("bolterround", ItemBase::new);
    public static final RegistryObject<ModSpawnEggItem> HOG_SPAWN_EGG = ITEMS.register("hog_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.HOG, 0xE1A68B, 0x99593B, new Item.Properties().group(Enlisted.TAB)));
    public static final RegistryObject<Medkit> MEDKIT = ITEMS.register("medkit", Medkit::new);

    // Block Items
    public static final RegistryObject<Item> HARD_CONCRETE_BLOCK_ITEM = ITEMS.register("hard_concrete_block",
            () -> new BlockItemBase(ModBlocks.HARD_CONCRETE_BLOCK.get()));

    public static final RegistryObject<Item> ALUMINUM_ORE_ITEM = ITEMS.register("aluminum_ore",
            () -> new BlockItemBase(ModBlocks.ALUMINUM_ORE.get()));

    public static final RegistryObject<Item> OVEN1_ITEM = ITEMS.register("oven1",
            () -> new BlockItemBase(ModBlocks.OVEN1.get()));

}
