package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import fr.zom.csmm.network.TestPacket;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import org.lwjgl.glfw.GLFW;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class ModKeybindings {

    public static final KeyBinding TEST_KEY = new KeyBinding("key." + CSMM.MODID + ".test_key", GLFW.GLFW_KEY_G, "key.categories." + CSMM.MODID);

    public static void register()
    {
        ClientRegistry.registerKeyBinding(TEST_KEY);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent e)
    {
        if(TEST_KEY.isDown())
        {
            CSMM.NETWORK.sendToServer(new TestPacket(64));
        }
    }

}
