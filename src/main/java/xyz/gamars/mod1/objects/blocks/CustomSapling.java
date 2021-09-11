package xyz.gamars.mod1.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.world.feature.trees.TreeSpawner;

import java.util.Random;

public class CustomSapling extends SaplingBlock {
    private final ITag<Block> groundTag;
    private final TreeSpawner tree;

    public CustomSapling(Properties properties, ITag<Block> groundTag, TreeSpawner tree) {
        super(null, properties);
        this.groundTag = groundTag;
        this.tree = tree;
    }

    /*@Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return this == BlockInit.PALM_SAPLING ? state.is(BlockTags.SAND) && state.is(this.groundTag) : state.is(this.groundTag);
    }*/

    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.spawn(world, world.getChunkSource().getGenerator(), pos, state, rand);
        }
    }

}
