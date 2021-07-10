package fr.zom.csmm;

import fr.zom.csmm.init.*;
import net.minecraftforge.common.MinecraftForge;
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

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

    }

    private void setup(FMLCommonSetupEvent e)
    {
        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);
    }

    private void clientSetup(FMLClientSetupEvent e)
    {
        IEventBus bus = MinecraftForge.EVENT_BUS;

        ModKeybindings.register();
        bus.addListener(ModKeybindings::onKeyPress);

    }

}
