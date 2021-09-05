package xyz.gamars.mod1.core.init;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.objects.blocks.BaseBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mod1.MOD_ID);

    private static LeavesBlock leavesBlock() {
        return new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(BlockInit::never).isViewBlocking(BlockInit::never));
    }

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
    public static final RegistryObject<Block> SAKURA_LOG = BLOCKS.register("sakura_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD)
    .strength(2f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SAKURA_WOOD = BLOCKS.register("sakura_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD)
    .strength(2f).sound(SoundType.WOOD)));

}
