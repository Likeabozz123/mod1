package xyz.gamars.mod1.core.init;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.tags.ITag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.world.feature.trees.TreeSpawner;
import xyz.gamars.mod1.core.world.TreeInit;
import xyz.gamars.mod1.objects.blocks.*;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mod1.MOD_ID);

    private static boolean never(BlockState blockState, IBlockReader iBlockReader, BlockPos blockPos) {
        return false;
    }

    // properties, strength, harvestTool, harvestLevel, sound
    public static final RegistryObject<Block> ITEM_1_BLOCK = BLOCKS.register("item_1_block", () -> new BaseBlock
            (AbstractBlock.Properties.of(Material.METAL).requiresCorrectToolForDrops()
            .strength(5f, 6f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(4)
            .sound(SoundType.METAL)));

    public static final RegistryObject<Block> ITEM_1_ORE = BLOCKS.register("item_1_ore", () -> new BaseBlock
            (AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops()
            .strength(5f, 6f)
            .harvestTool(ToolType.PICKAXE)
            .harvestLevel(4)
            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> SAKURA_LEAVES = BLOCKS.register("sakura_leaves", () -> leavesBlock());
    public static final RegistryObject<Block> TRUE_SAKURA_LEAVES = BLOCKS.register("true_sakura_leaves", () -> new GlowingLeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2f).sound(SoundType.GRASS).noOcclusion().isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never)));
    public static final RegistryObject<Block> DEAD_SAKURA_LEAVES = BLOCKS.register("dead_sakura_leaves", () -> leavesBlock());
    public static final RegistryObject<Block> SAKURA_LOG = BLOCKS.register("sakura_log", () -> new BurnableLogBlock
            (AbstractBlock.Properties.of(Material.WOOD)
            .strength(2f)
            .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SAKURA_WOOD = BLOCKS.register("sakura_wood", () -> new BurnableLogBlock
            (AbstractBlock.Properties.of(Material.WOOD)
            .strength(2f)
            .sound(SoundType.WOOD)));
    //public static final RegistryObject<Block> SAKURA_SAPLING = BLOCKS.register("sakura_sapling", ()-> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SAKURA_SAPLING = BLOCKS.register("sakura_sapling", () -> createSapling(Tags.Blocks.DIRT, TreeInit.SAKURA));

    private static BurnableLeavesBlock leavesBlock() {
        return new BurnableLeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerRenderType(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(SAKURA_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(TRUE_SAKURA_LEAVES.get(), RenderType.cutout());
    }

    static Block createSapling(ITag<Block> groundTag, TreeSpawner tree) {
        return new CustomSapling(AbstractBlock.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks(), groundTag, tree);
    }

}
