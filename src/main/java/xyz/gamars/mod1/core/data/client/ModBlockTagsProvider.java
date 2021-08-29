package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.init.ModTags;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Mod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_ORE_1)
                .add(BlockInit.BLOCK_2.get())
        ;
        tag(Tags.Blocks.ORES)
                .addTag(ModTags.Blocks.ORES_ORE_1)
        ;

        tag(ModTags.Blocks.STORAGE_BLOCKS_STORAGE_BLOCK_1)
                .add(BlockInit.BLOCK_1.get())
        ;
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ModTags.Blocks.STORAGE_BLOCKS_STORAGE_BLOCK_1);

    }
}
