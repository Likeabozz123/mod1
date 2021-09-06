package xyz.gamars.mod1;

import com.mojang.serialization.Codec;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.gamars.mod1.core.init.BiomeInit;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.init.FeatureInit;
import xyz.gamars.mod1.core.init.ItemInit;
import xyz.gamars.mod1.core.structures.ConfiguredStructures;
import xyz.gamars.mod1.core.structures.StructureInit;
import xyz.gamars.mod1.objects.tabs.Mod1ItemGroup;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mod1")
@Mod.EventBusSubscriber(modid = Mod1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Mod1
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mod1";

    public Mod1() {
        // Register ourselves for server and other game events we are interested in
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);
        BiomeInit.BIOMES.register(bus);
        BiomeInit.registerBiomes();
        //StructureInit.STRUCTURES.register(bus);
        bus.addListener(this::clientSetup);

        forgeBus.addListener(EventPriority.HIGH, FeatureInit::addOres);
        //forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        //forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
        forgeBus.register(this);

    }

    private void clientSetup(FMLClientSetupEvent event) {
        BlockInit.registerRenderType(event);

        event.enqueueWork(() -> {
            StructureInit.setupStructures();
            ConfiguredStructures.registerConfigredStructures();
        });

    }

    public void biomeModification(final BiomeLoadingEvent event) {
        event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_SAKURA_TREE);
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld) {
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch (Exception e) {
                Mod1.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using TerraForged's ChunkGenerator.");
            }

            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator && serverWorld.dimension().equals(World.OVERWORLD)) {
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig);
            tempMap.putIfAbsent(StructureInit.SAKURATREE1.get(), DimensionStructuresSettings.DEFAULTS.get(StructureInit.SAKURATREE1.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig =tempMap;

        }
    }

    // AUTO BLOCKITEM CONVERSION
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(Mod1ItemGroup.MOD_1_ITEM_GROUP)).setRegistryName(block.getRegistryName()));
        });
    }

}
