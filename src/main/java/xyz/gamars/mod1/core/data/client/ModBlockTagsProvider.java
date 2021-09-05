package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
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
        tag(ModTags.Blocks.ORES_ITEM_1).add(BlockInit.ITEM_1_ORE.get());
        tag(ModTags.Blocks.ORES).addTag(ModTags.Blocks.ORES_ITEM_1);
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES);

        tag(ModTags.Blocks.STORAGE_BLOCKS_ITEM_BLOCK_1).add(BlockInit.ITEM_1_BLOCK.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_ITEM_BLOCK_1);
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS);

        tag(ModTags.Blocks.SAKURA_LOG).add(BlockInit.SAKURA_LOG.get());
        tag(ModTags.Blocks.LOGS).addTag(ModTags.Blocks.SAKURA_LOG);
        tag(BlockTags.LOGS).addTag(ModTags.Blocks.LOGS);

        tag(ModTags.Blocks.SAKURA_WOOD).add(BlockInit.SAKURA_WOOD.get());
        tag(ModTags.Blocks.WOOD).addTag(ModTags.Blocks.SAKURA_WOOD);
        tag(BlockTags.LOGS).addTag(ModTags.Blocks.WOOD);

        tag(ModTags.Blocks.SAKURA_LEAVES).add(BlockInit.SAKURA_LEAVES.get());
        tag(ModTags.Blocks.LEAVES).addTag(ModTags.Blocks.SAKURA_LEAVES);
        tag(BlockTags.LEAVES).addTag(ModTags.Blocks.LEAVES);

    }
}
