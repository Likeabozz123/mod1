package xyz.gamars.mod1.core.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import xyz.gamars.mod1.Mod1;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Mod1.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        ModelFile itemHandheld = getExistingFile(mcLoc("item/handheld"));

        withExistingParent("item_1_block", modLoc("block/item_1_block"));
        withExistingParent("item_1_ore", modLoc("block/item_1_ore"));
        withExistingParent("sakura_log", modLoc("block/sakura_log"));
        withExistingParent("sakura_wood", modLoc("block/sakura_wood"));
        withExistingParent("sakura_leaves", modLoc("block/sakura_leaves"));
        withExistingParent("dead_sakura_leaves", modLoc("block/dead_sakura_leaves"));
        withExistingParent("true_sakura_leaves", modLoc("block/true_sakura_leaves"));
        blockBuilder("sakura_sapling", itemGenerated);



        builder("item_1", itemGenerated);
        builder("item_2", itemGenerated);
        builder("item_3", itemGenerated);

        builder("inspector_knife", itemHandheld);
        builder("wukongs_staff", itemHandheld);

        builder("true_sakura_flower", itemGenerated);

        builder("sword_1", itemHandheld);
        builder("pickaxe_1", itemHandheld);
        builder("axe_1", itemHandheld);
        builder("shovel_1", itemHandheld);
        builder("hoe_1", itemHandheld);

        builder("helmet_1", itemGenerated);
        builder("chestplate_1", itemGenerated);
        builder("leggings_1", itemGenerated);
        builder("boots_1", itemGenerated);

    }

    private ItemModelBuilder builder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }

    private ItemModelBuilder blockBuilder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "block/" + name);
    }
}
