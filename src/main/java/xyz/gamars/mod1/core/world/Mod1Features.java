package xyz.gamars.mod1.core.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.world.feature.config.Mod1TreeConfig;
import xyz.gamars.mod1.core.world.feature.trees.sakura.SakuraTree1;
import xyz.gamars.mod1.core.world.feature.trees.sakura.SakuraTree2;

import java.util.ArrayList;
import java.util.List;

public class Mod1Features {

    public static List<Feature<?>> features = new ArrayList<>();

    public static final AbstractTreeFeature<Mod1TreeConfig> SAKURA_TREE1 = createFeature("sakura_tree1", new SakuraTree1(Mod1TreeConfig.CODEC.stable()));
    public static final AbstractTreeFeature<Mod1TreeConfig> SAKURA_TREE2 = createFeature("sakura_tree2", new SakuraTree2(Mod1TreeConfig.CODEC.stable()));

    public static <C extends IFeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        ResourceLocation modID = new ResourceLocation(Mod1.MOD_ID, id);
        if (Registry.FEATURE.keySet().contains(modID))
            throw new IllegalStateException("Feature ID: \"" + modID.toString() + "\" already exists in the Features registry!");

//        Registry.register(Registry.FEATURE, bygID, feature);
        feature.setRegistryName(modID); //Forge
        features.add(feature);
        return feature;
    }

}
