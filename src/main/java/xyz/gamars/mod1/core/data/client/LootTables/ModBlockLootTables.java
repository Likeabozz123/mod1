package xyz.gamars.mod1.core.data.client.LootTables;

import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.RegistryObject;
import xyz.gamars.mod1.core.init.BlockInit;
import xyz.gamars.mod1.core.init.ItemInit;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootTables {

    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
    private static final ILootCondition.IBuilder SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS));
    private static final ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS = SHEARS.or(SILK_TOUCH);
    private static final ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS = SILK_TOUCH_OR_SHEARS.invert();
    private static final float[] DEFAULT_SAPLING_DROP_RATES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] PURE_SAKURA_BLOSSOM_DROP_RATES = new float[]{0.001F, 0.00625F, 0.0083333336F, 0.01F};

    @Override
    protected void addTables() {
        dropSelf(BlockInit.ITEM_1_BLOCK.get());
        dropSelf(BlockInit.ITEM_1_ORE.get());

        add(BlockInit.SAKURA_LEAVES.get(), leaves(BlockInit.SAKURA_SAPLING.get(), Items.STICK, DEFAULT_SAPLING_DROP_RATES));
        add(BlockInit.DEAD_SAKURA_LEAVES.get(), leaves(BlockInit.SAKURA_SAPLING.get(), Items.STICK, DEFAULT_SAPLING_DROP_RATES));
        add(BlockInit.TRUE_SAKURA_LEAVES.get(), pureLeaves(ItemInit.TRUE_SAKURA_FLOWER.get(), PURE_SAKURA_BLOSSOM_DROP_RATES));
        dropSelf(BlockInit.SAKURA_LOG.get());
        dropSelf(BlockInit.SAKURA_WOOD.get());
        dropSelf(BlockInit.SAKURA_SAPLING.get());

        // If it drops an item, rather then the ore
        // Also gets affected by Fortune
        //createOreDrop(Blocks.DIAMOND_ORE, Items.DIAMOND);
    }

    @Nonnull
    private static Function<Block, LootTable.Builder> leaves(IItemProvider sapling, IItemProvider stick, float... chances) {
        return (block) -> createSelfDropDispatchTable(block, SILK_TOUCH_OR_SHEARS, applyExplosionCondition(block, ItemLootEntry.lootTableItem(sapling))
                .when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, chances)))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantRange.exactly(1))
                        .when(NOT_SILK_TOUCH_OR_SHEARS)
                        .add(applyExplosionDecay(block, ItemLootEntry.lootTableItem(stick)
                                .apply(SetCount.setCount(RandomValueRange.between(1.0F, 2.0F))))
                                .when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))));
    }

    @Nonnull
    private static Function<Block, LootTable.Builder> pureLeaves(IItemProvider item, float... chances) {
        return (block) -> createSelfDropDispatchTable(block, SILK_TOUCH_OR_SHEARS, applyExplosionCondition(block, ItemLootEntry.lootTableItem(item))
                .when(TableBonus.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, chances)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }

}