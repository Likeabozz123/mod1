package xyz.gamars.mod1.core.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import xyz.gamars.mod1.Mod1;

public class ModTags {

    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES = forge("ores");
        public static final ITag.INamedTag<Block> ORES_ITEM_1 = forge("ores/item_1");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS = forge("storage_blocks");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_ITEM_BLOCK_1 = forge("storage_blocks/item_block_1");

        public static final ITag.INamedTag<Block> LOGS = forge("logs");
        public static final ITag.INamedTag<Block> SAKURA_LOG = forge("logs/sakura_log");

        public static final ITag.INamedTag<Block> WOOD = forge("wood");
        public static final ITag.INamedTag<Block> SAKURA_WOOD = forge("wood/sakura_wood");

        public static final ITag.INamedTag<Block> LEAVES = forge("leaves");
        public static final ITag.INamedTag<Block> SAKURA_LEAVES = forge("leaves/sakura_leaves");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Mod1.MOD_ID, path).toString());
        }
    }

    public static  final class Items {

        //BLOCKS
        public static final ITag.INamedTag<Item> ORES = forge("ores");
        public static final ITag.INamedTag<Item> ORES_ITEM_1 = forge("ores/item_1");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS = forge("storage_blocks");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ITEM_BLOCK_1 = forge("storage_blocks/item_block_1");

        public static final ITag.INamedTag<Item> LOGS = forge("logs");
        public static final ITag.INamedTag<Item> SAKURA_LOG = forge("logs/sakura_log");

        public static final ITag.INamedTag<Item> WOOD = forge("wood");
        public static final ITag.INamedTag<Item> SAKURA_WOOD = forge("wood/sakura_wood");

        public static final ITag.INamedTag<Item> LEAVES = forge("leaves");
        public static final ITag.INamedTag<Item> SAKURA_LEAVES  = forge("leaves/sakura_leaves");

        //ITEMS
        public static final ITag.INamedTag<Item> INGOTS = forge("ingots");
        public static final ITag.INamedTag<Item> INGOTS_TEST_1 = forge("ingots/test_1");

        public static final ITag.INamedTag<Item> ITEMS = forge("items");
        public static final ITag.INamedTag<Item> ITEMS_ITEM_1 = forge("items/item_1");
        public static final ITag.INamedTag<Item> ITEMS_ITEM_2 = forge("items/item_2");
        public static final ITag.INamedTag<Item> ITEMS_ITEM_3 = forge("items/item_3");

        public static final ITag.INamedTag<Item> ITEMS_INSPECTOR_KNIFE = forge("items/inspector_knife");
        public static final ITag.INamedTag<Item> ITEMS_WUKONGS_STAFF = forge("items/wukongs_staff");
        public static final ITag.INamedTag<Item> ITEMS_TRUE_SAKURA_FLOWER = forge("items/true_sakura_flower");

        public static final ITag.INamedTag<Item> TOOLS = forge("tools");
        public static final ITag.INamedTag<Item> TOOLS_SWORD_1 = forge("tools/sword_1");
        public static final ITag.INamedTag<Item> TOOLS_PICKAXE_1 = forge("tools/pickaxe_1");
        public static final ITag.INamedTag<Item> TOOLS_AXE_1 = forge("tools/axe_1");
        public static final ITag.INamedTag<Item> TOOLS_SHOVEL_1 = forge("tools/shovel_1");
        public static final ITag.INamedTag<Item> TOOLS_HOE_1 = forge("tools/hoe_1");

        public static final ITag.INamedTag<Item> ARMOR = forge("armor");
        public static final ITag.INamedTag<Item> ARMOR_HELMET_1 = forge("armor/helmet_1");
        public static final ITag.INamedTag<Item> ARMOR_CHESTPLATE_1 = forge("armor/chestplate_1");
        public static final ITag.INamedTag<Item> ARMOR_LEGGINGS_1 = forge("armor/leggings_1");
        public static final ITag.INamedTag<Item> ARMOR_BOOTS_1 = forge("armor/boots_1");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Mod1.MOD_ID, path).toString());
        }

    }

}
