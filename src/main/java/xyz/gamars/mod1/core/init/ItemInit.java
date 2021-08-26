package xyz.gamars.mod1.core.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod1.MOD_ID);

    public static final RegistryObject<Item> ITEM_1 = ITEMS.register("item_1", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    // public static final RegistryObject<Item> BLOCK_1_ITEM = ITEMS.register("block_1", () -> new BlockItem(BlockInit.BLOCK_1.get(), new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

}
