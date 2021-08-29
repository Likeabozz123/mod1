package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.ItemInit;
import xyz.gamars.mod1.core.init.ModTags;

import javax.annotation.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, Mod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_ORE_1, ModTags.Items.ORES_ORE_1);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        copy(ModTags.Blocks.STORAGE_BLOCKS_STORAGE_BLOCK_1, ModTags.Items.STORAGE_BLOCKS_STORAGE_BLOCK_1);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_TEST_1).add(ItemInit.ITEM_1.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_TEST_1);
    }
}
