package xyz.gamars.mod1.core.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.objects.items.BaseItem;
import xyz.gamars.mod1.objects.materials.ModArmorMaterial;
import xyz.gamars.mod1.objects.materials.ModToolMaterial;
import xyz.gamars.mod1.objects.tabs.Mod1ItemGroup;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mod1.MOD_ID);

    public static final ItemGroup MOD_1_ITEM_GROUP = Mod1ItemGroup.MOD_1_ITEM_GROUP;

    public static final RegistryObject<Item> ITEM_1 = ITEMS.register("item_1", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> ITEM_2 = ITEMS.register("item_2", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> ITEM_3 = ITEMS.register("item_3", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));

    public static final RegistryObject<Item> INSPECTOR_KNIFE = ITEMS.register("inspector_knife", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> WUKONGS_STAFF = ITEMS.register("wukongs_staff", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> TRUE_SAKURA_FLOWER = ITEMS.register("true_sakura_flower", () -> new BaseItem(new Item.Properties().tab(MOD_1_ITEM_GROUP)));

    // public static final RegistryObject<Item> BLOCK_1_ITEM = ITEMS.register("block_1", () -> new BlockItem(BlockInit.BLOCK_1.get(), new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    // weaponMaterial, attackDamage, attackSpeed (4 - whatever speed), properties
    public static final RegistryObject<Item> SWORD_1 = ITEMS.register("sword_1",
            () -> new SwordItem(ModToolMaterial.MOD_TOOL_MATERIAL,
                    10,
                    -1f,
                    new Item.Properties().tab(MOD_1_ITEM_GROUP)));
    public static final RegistryObject<Item> PICKAXE_1 = ITEMS.register("pickaxe_1",
            () -> new PickaxeItem(ModToolMaterial.MOD_TOOL_MATERIAL,
                    10,
                    -1f,
                    new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> AXE_1 = ITEMS.register("axe_1",
            () -> new AxeItem(ModToolMaterial.MOD_TOOL_MATERIAL,
                    10,
                    -1f,
                    new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> SHOVEL_1 = ITEMS.register("shovel_1",
            () -> new ShovelItem(ModToolMaterial.MOD_TOOL_MATERIAL,
                    10,
                    -1f,
                    new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> HOE_1 = ITEMS.register("hoe_1",
            () -> new HoeItem(ModToolMaterial.MOD_TOOL_MATERIAL,
                    10,
                    -1f,
                    new Item.Properties().tab(MOD_1_ITEM_GROUP)));

        // armorMaterial, equipmentSlot, properties
        public static final RegistryObject<Item> HELMET_1 = ITEMS.register("helmet_1",
                () -> new ArmorItem(ModArmorMaterial.MOD_ARMOR_MATERIAL,
                        EquipmentSlotType.HEAD,
                        new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> CHESTPLATE_1 = ITEMS.register("chestplate_1",
                () -> new ArmorItem(ModArmorMaterial.MOD_ARMOR_MATERIAL,
                        EquipmentSlotType.CHEST,
                        new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> LEGGINGS_1 = ITEMS.register("leggings_1",
                () -> new ArmorItem(ModArmorMaterial.MOD_ARMOR_MATERIAL,
                        EquipmentSlotType.LEGS,
                        new Item.Properties().tab(MOD_1_ITEM_GROUP)));
        public static final RegistryObject<Item> BOOTS_1 = ITEMS.register("boots_1",
                () -> new ArmorItem(ModArmorMaterial.MOD_ARMOR_MATERIAL,
                        EquipmentSlotType.FEET,
                        new Item.Properties().tab(MOD_1_ITEM_GROUP)));

}
