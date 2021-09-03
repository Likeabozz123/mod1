package xyz.gamars.mod1.core.data.client.LootTables;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraftforge.fml.RegistryObject;
import xyz.gamars.mod1.core.init.BlockInit;

import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootTables {

    @Override
    protected void addTables() {
        dropSelf(BlockInit.ITEM_1_BLOCK.get());
        dropSelf(BlockInit.ITEM_1_ORE.get());

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