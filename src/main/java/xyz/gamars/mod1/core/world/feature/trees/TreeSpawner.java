package xyz.gamars.mod1.core.world.feature.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import xyz.gamars.mod1.core.world.feature.config.Mod1TreeConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TreeSpawner {

    @Nullable
    protected abstract ConfiguredFeature<Mod1TreeConfig, ?> getTreeFeature(Random random);

    public boolean spawn(ISeedReader worldIn, ChunkGenerator chunkGenerator, BlockPos pos, BlockState blockUnder, Random random) {
        ConfiguredFeature<Mod1TreeConfig, ?> configredTreeFeature = this.getTreeFeature(random);

        if(configredTreeFeature == null) {
            return false;
        } else {
            worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 4);
            configredTreeFeature.config.forcePlacement();
            if (configredTreeFeature.place(worldIn, chunkGenerator, random, pos)) {
                return true;
            } else {
                worldIn.setBlock(pos, blockUnder, 4);
                return false;
            }
        }
    }

}
