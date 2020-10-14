package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import fr.zom.csmm.tileentity.TileEntityTest;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.common.extensions.IForgeTileEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CSMM.MODID);

    public static final RegistryObject<TileEntityType<?>> TEST_TILE_ENTITY = TILE_ENTITIES.register(CSMM.MODID, () -> TileEntityType.Builder.create(TileEntityTest::new, ModBlocks.TEST_ENTITY_BLOCK.get()).build(null));

}
