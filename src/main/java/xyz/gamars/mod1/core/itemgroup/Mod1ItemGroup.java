package xyz.gamars.mod1.core.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.ItemInit;

public class Mod1ItemGroup extends ItemGroup {

    public static final Mod1ItemGroup MOD_1_ITEM_GROUP = new Mod1ItemGroup(ItemGroup.getGroupCountSafe(), "mod_1_item_group");

    public Mod1ItemGroup(int index, String label) {
        super(index, label);
        this.setBackgroundImage(new ResourceLocation("textures/gui/container/creative_inventory/mod1itemgroup.png"));
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.ITEM_1.get());
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}
