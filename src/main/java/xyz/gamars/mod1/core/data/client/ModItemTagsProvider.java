package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.data.ModTags;
import xyz.gamars.mod1.core.init.ItemInit;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, Mod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //ORES
        copy(ModTags.Blocks.ORES_ITEM_1, ModTags.Items.ORES_ITEM_1);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        //STORAGE_BLOCKS
        copy(ModTags.Blocks.STORAGE_BLOCKS_ITEM_BLOCK_1, ModTags.Items.STORAGE_BLOCKS_ITEM_BLOCK_1);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        //LOGS
        copy(ModTags.Blocks.SAKURA_LOG, ModTags.Items.SAKURA_LOG);
        copy(ModTags.Blocks.LOGS, ModTags.Items.LOGS);

        //WOOD
        copy(ModTags.Blocks.SAKURA_WOOD, ModTags.Items.SAKURA_WOOD);
        copy(ModTags.Blocks.WOOD, ModTags.Items.WOOD);

        //LEAVES
        copy(ModTags.Blocks.SAKURA_LEAVES, ModTags.Items.SAKURA_LEAVES);
        copy(ModTags.Blocks.LEAVES, ModTags.Items.LEAVES);


        //INGOTS
        tag(ModTags.Items.INGOTS_TEST_1).add(ItemInit.ITEM_1.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_TEST_1);

        //ITEMS
        tag(ModTags.Items.ITEMS_ITEM_1).add(ItemInit.ITEM_1.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_ITEM_1);
        //|
        tag(ModTags.Items.ITEMS_ITEM_2).add(ItemInit.ITEM_2.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_ITEM_2);
        //|
        tag(ModTags.Items.ITEMS_ITEM_3).add(ItemInit.ITEM_3.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_ITEM_3);

        tag(ModTags.Items.ITEMS_TRUE_SAKURA_FLOWER).add(ItemInit.TRUE_SAKURA_FLOWER.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_TRUE_SAKURA_FLOWER);

        tag(ModTags.Items.ITEMS_INSPECTOR_KNIFE).add(ItemInit.INSPECTOR_KNIFE.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_INSPECTOR_KNIFE);

        tag(ModTags.Items.ITEMS_WUKONGS_STAFF).add(ItemInit.WUKONGS_STAFF.get());
        tag(ModTags.Items.ITEMS).addTag(ModTags.Items.ITEMS_WUKONGS_STAFF);


        //TOOLS_1
        tag(ModTags.Items.TOOLS_SWORD_1).add(ItemInit.SWORD_1.get());
        tag(ModTags.Items.TOOLS).addTag(ModTags.Items.TOOLS_SWORD_1);
        //|
        tag(ModTags.Items.TOOLS_PICKAXE_1).add(ItemInit.PICKAXE_1.get());
        tag(ModTags.Items.TOOLS).addTag(ModTags.Items.TOOLS_PICKAXE_1);
        //|
        tag(ModTags.Items.TOOLS_AXE_1).add(ItemInit.AXE_1.get());
        tag(ModTags.Items.TOOLS).addTag(ModTags.Items.TOOLS_AXE_1);
        //|
        tag(ModTags.Items.TOOLS_SHOVEL_1).add(ItemInit.SHOVEL_1.get());
        tag(ModTags.Items.TOOLS).addTag(ModTags.Items.TOOLS_SHOVEL_1);
        //|
        tag(ModTags.Items.TOOLS_HOE_1).add(ItemInit.HOE_1.get());
        tag(ModTags.Items.TOOLS).addTag(ModTags.Items.TOOLS_HOE_1);


        //ARMOR_1
        tag(ModTags.Items.ARMOR_HELMET_1).add(ItemInit.HELMET_1.get());
        tag(ModTags.Items.ARMOR).addTag(ModTags.Items.ARMOR_HELMET_1);
        //|
        tag(ModTags.Items.ARMOR_CHESTPLATE_1).add(ItemInit.CHESTPLATE_1.get());
        tag(ModTags.Items.ARMOR).addTag(ModTags.Items.ARMOR_CHESTPLATE_1);
        //|
        tag(ModTags.Items.ARMOR_LEGGINGS_1).add(ItemInit.LEGGINGS_1.get());
        tag(ModTags.Items.ARMOR).addTag(ModTags.Items.ARMOR_LEGGINGS_1);
        //|
        tag(ModTags.Items.ARMOR_BOOTS_1).add(ItemInit.BOOTS_1.get());
        tag(ModTags.Items.ARMOR).addTag(ModTags.Items.ARMOR_BOOTS_1);

    }
}
