package xyz.gamars.mod1.core.data.client.LootTables;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.gamars.mod1.Mod1;
import xyz.gamars.mod1.core.init.BlockInit;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootTables {

    @Override
    protected void addTables() {
        dropSelf(BlockInit.BLOCK_1.get());
        dropSelf(BlockInit.BLOCK_2.get());

        // If it drops an item, rather then the ore
        // Also gets affected by Fortune
        //createOreDrop(Blocks.DIAMOND_ORE, Items.DIAMOND);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }

}