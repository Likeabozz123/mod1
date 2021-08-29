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
        withExistingParent("block_1", modLoc("block/block_1"));
        withExistingParent("block_2", modLoc("block/block_2"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder("item_1", itemGenerated);
        builder("item_2", itemGenerated);
        builder("item_3", itemGenerated);

    }

    private ItemModelBuilder builder(String name, ModelFile parent) {
        return getBuilder(name).parent(parent).texture("layer0", "item/" + name);
    }
}
