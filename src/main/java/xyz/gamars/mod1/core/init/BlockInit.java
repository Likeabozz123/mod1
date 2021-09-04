package xyz.gamars.mod1.core.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.objects.blocks.BaseBlock;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mod1.MOD_ID);

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

}
