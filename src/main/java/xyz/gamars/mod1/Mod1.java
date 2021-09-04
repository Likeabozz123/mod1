package xyz.gamars.mod1;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.init.FeatureInit;
import xyz.gamars.mod1.core.init.ItemInit;
import xyz.gamars.mod1.objects.tabs.Mod1ItemGroup;

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

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
        System.out.println("ORE GENERATION ADDED");
        MinecraftForge.EVENT_BUS.register(this);

    }

    // AUTO BLOCKITEM CONVERSION
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(Mod1ItemGroup.MOD_1_ITEM_GROUP)).setRegistryName(block.getRegistryName()));
        });
    }

}
