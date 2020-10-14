package fr.zom.csmm;

import fr.zom.csmm.init.ModBlocks;
import fr.zom.csmm.init.ModItems;
import fr.zom.csmm.init.ModTileEntities;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CSMM.MODID)
public class CSMM
{

    public static final String MODID = "csmm";

    public CSMM()
    {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);

    }

    private void setup(FMLCommonSetupEvent e)
    {

    }

    private void clientSetup(FMLClientSetupEvent e)
    {

    }

}
