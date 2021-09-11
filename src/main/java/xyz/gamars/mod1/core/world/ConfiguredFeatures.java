package xyz.gamars.mod1.core.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.world.feature.config.Mod1TreeConfig;

public class ConfiguredFeatures {

    public static final ConfiguredFeature<Mod1TreeConfig, ?> SAKURA_TREE1 = createConfiguredFeature("sakura_tree1", Mod1Features.SAKURA_TREE1.configured(
            new Mod1TreeConfig.Builder()
                    .setTrunkBlock(BlockInit.SAKURA_LOG.get())
                    .setLeavesBlock(BlockInit.SAKURA_LEAVES.get())
                    .setMaxHeight(7)
                    .setMinHeight(4)
                    .build()));
    public static final ConfiguredFeature<Mod1TreeConfig, ?> SAKURA_TREE2 = createConfiguredFeature("sakura_tree2", Mod1Features.SAKURA_TREE2.configured(
            new Mod1TreeConfig.Builder()
                    .setTrunkBlock(BlockInit.SAKURA_LOG.get())
                    .setLeavesBlock(BlockInit.SAKURA_LEAVES.get())
                    .setMaxHeight(25)
                    .setMinHeight(15)
                    .build()));

    public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        ResourceLocation modId = new ResourceLocation(Mod1.MOD_ID, id);
        if (WorldGenRegistries.CONFIGURED_FEATURE.keySet().contains(modId))
            throw new IllegalStateException("Configured Feature ID: \"" + modId.toString() + "\" already exists in the Configured Features registry!");

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, modId, configuredFeature);
        return configuredFeature;
    }

}
