package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.data.ModTags;
import xyz.gamars.mod1.core.init.BlockInit;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Mod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_ITEM_1)
                .add(BlockInit.ITEM_1_ORE.get())
        ;
        tag(Tags.Blocks.ORES)
                .addTag(ModTags.Blocks.ORES_ITEM_1)
        ;

        tag(ModTags.Blocks.STORAGE_BLOCKS_ITEM_BLOCK_1)
                .add(BlockInit.ITEM_1_BLOCK.get())
        ;
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_ITEM_BLOCK_1);

    }
}
