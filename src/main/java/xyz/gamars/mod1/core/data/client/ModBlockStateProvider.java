package xyz.gamars.mod1.core.data.client;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.BlockInit;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Mod1.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockInit.ITEM_1_BLOCK.get());
        simpleBlock(BlockInit.ITEM_1_ORE.get());

        simpleBlock(BlockInit.SAKURA_LEAVES.get());
        // axisBlock((RotatedPillarBlock) BlockInit.SAKURA_LOG.get(), modLoc("block/sakura_log"), modLoc("block/sakura_log_top"));
        logBlock((RotatedPillarBlock) BlockInit.SAKURA_LOG.get());
        simpleBlock(BlockInit.SAKURA_WOOD.get());
        simpleBlock(BlockInit.SAKURA_SAPLING.get(), models().cross("sakura_sapling", modLoc("block/sakura_sapling")));

    }

}
