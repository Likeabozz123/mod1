package xyz.gamars.mod1.core.init;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;

import java.util.function.Supplier;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Mod1.MOD_ID);

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Mod1.MOD_ID, biomeName));
    }

    public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
        return BIOMES.register(biomeName, biome);
    }

    static {
        //createBiome("biome_1", BiomeMaker::theVoidBiome);
    }

    public static void registerBiomes() {
        //BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(BIOME_1, 10));
    }

    //public static RegistryKey<Biome> BIOME_1 = registerBiome("biome_1");

}
