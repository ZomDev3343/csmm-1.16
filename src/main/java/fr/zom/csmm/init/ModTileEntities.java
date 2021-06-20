package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import fr.zom.csmm.tileentity.TileEntityRedEmerald;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CSMM.MODID);

    public static final RegistryObject<TileEntityType<?>> RED_EMERALD_TILE_ENTITIY = TILE_ENTITIES.register("red_emerald_tile_entity", () -> TileEntityType.Builder.of(TileEntityRedEmerald::new, ModBlocks.RED_EMERALD_BLOCK.get()).build(null));
}
