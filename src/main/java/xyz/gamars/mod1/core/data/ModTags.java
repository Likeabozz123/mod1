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
        public static final ITag.INamedTag<Block> ORES_ORE_1 = forge("ores/ore_1");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STORAGE_BLOCK_1 = forge("storage_blocks/storage_block_1");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(Mod1.MOD_ID, path).toString());
        }
    }

    public static  final class Items {
        public static final ITag.INamedTag<Item> ORES_ORE_1 = forge("ores/ore_1");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STORAGE_BLOCK_1 = forge("storage_blocks/storage_block_1");

        public static final ITag.INamedTag<Item> INGOTS_TEST_1 = forge("ingots/test_1");

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
