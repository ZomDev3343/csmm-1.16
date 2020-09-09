package fr.zom.csmm;

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

    }

    private void setup(FMLCommonSetupEvent e)
    {

    }

    private void clientSetup(FMLClientSetupEvent e)
    {

    }

}
