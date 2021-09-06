package xyz.gamars.mod1.core.structures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import xyz.gamars.mod1.Mod1;

public class ConfiguredStructures {

    public static StructureFeature<?, ?> CONFIGURED_SAKURA_TREE = StructureInit.SAKURATREE1.get().configured(IFeatureConfig.NONE);

    public static void registerConfigredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Mod1.MOD_ID, "configured_sakura_tree"), CONFIGURED_SAKURA_TREE);

        FlatGenerationSettings.STRUCTURE_FEATURES.put(StructureInit.SAKURATREE1.get(), CONFIGURED_SAKURA_TREE);
    }


}
