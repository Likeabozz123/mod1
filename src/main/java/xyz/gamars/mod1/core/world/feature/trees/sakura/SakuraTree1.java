package xyz.gamars.mod1.core.world.feature.trees.sakura;

import com.mojang.serialization.Codec;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import xyz.gamars.mod1.core.world.AbstractTreeFeature;
import xyz.gamars.mod1.core.world.feature.config.Mod1TreeConfig;

import java.util.Random;
import java.util.Set;

public class SakuraTree1 extends AbstractTreeFeature<Mod1TreeConfig> {
    public SakuraTree1(Codec<Mod1TreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, Mod1TreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getMaxBuildHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                mutable.set(pos).immutable();

                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(pos, config, rand, changedBlocks, worldIn, mutable, boundsIn);
                    mutable.move(Direction.UP);
                }
                mutable.set(pos);


            }
        }
        return true;
    }
}
