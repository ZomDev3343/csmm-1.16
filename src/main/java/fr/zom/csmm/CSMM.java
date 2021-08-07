package fr.zom.csmm;

import fr.zom.csmm.init.ModBlocks;
import fr.zom.csmm.init.ModFeatures;
import fr.zom.csmm.init.ModItems;
import fr.zom.csmm.init.ModTileEntities;
import fr.zom.csmm.network.TestPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

@Mod(CSMM.MODID)
public class CSMM {

    public static final String MODID = "csmm";

    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel NETWORK = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, "channel"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);

    public CSMM() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModTileEntities.TILE_ENTITIES.register(bus);

    }

    private void setup(FMLCommonSetupEvent e) {
        ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);

        int index = 0;
        NETWORK.registerMessage(index, TestPacket.class, TestPacket::encode, TestPacket::decode, TestPacket::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));

    }

    private void clientSetup(FMLClientSetupEvent e) {

    }

}
