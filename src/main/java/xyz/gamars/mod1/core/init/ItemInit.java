package xyz.gamars.mod1.core.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.items.BaseItem;
import xyz.gamars.mod1.core.tabs.Mod1ItemGroup;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod1.MOD_ID);

    public static final RegistryObject<Item> ITEM_1 = ITEMS.register("item_1", () -> new BaseItem(new Item.Properties().tab(Mod1ItemGroup.MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> ITEM_2 = ITEMS.register("item_2", () -> new BaseItem(new Item.Properties().tab(Mod1ItemGroup.MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> ITEM_3 = ITEMS.register("item_3", () -> new BaseItem(new Item.Properties().tab(Mod1ItemGroup.MOD_1_ITEM_GROUP)));

    // public static final RegistryObject<Item> BLOCK_1_ITEM = ITEMS.register("block_1", () -> new BlockItem(BlockInit.BLOCK_1.get(), new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

}
