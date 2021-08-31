package xyz.gamars.mod1.objects.items;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;

public class BaseItem extends Item {

    public BaseItem(Properties properties) {
        super(properties);
    }

    /*@Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> itemStacks) {
        super.fillItemCategory(group, itemStacks);
    }*/
}
