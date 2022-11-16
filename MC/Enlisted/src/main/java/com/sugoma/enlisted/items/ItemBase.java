package com.sugoma.enlisted.items;
import com.sugoma.enlisted.Enlisted;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Enlisted.TAB));
    }
}
