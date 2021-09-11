package xyz.gamars.mod1.core.world;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import xyz.gamars.mod1.core.world.feature.config.Mod1TreeConfig;
import xyz.gamars.mod1.core.world.feature.trees.TreeSpawner;

import javax.annotation.Nullable;
import java.util.Random;

public class TreeInit {

    // To add a tree you need to add it into TreeInit, Mod1Features, ConfiguredFeatures

    public static final TreeSpawner SAKURA = new TreeSpawner() {
        @Nullable
        public ConfiguredFeature<Mod1TreeConfig, ?> getTreeFeature(Random random) {
            return ConfiguredFeatures.SAKURA_TREE1;
        }
    };

}
