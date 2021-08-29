package xyz.gamars.mod1.core.init;

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

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(Mod1.MOD_ID, path).toString());
        }

    }

}
