package fr.zom.csmm.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class TestPacket {

    public int quantity;

    public TestPacket(int quantity) {
        this.quantity = quantity;
    }


    public static void encode(TestPacket testPacket, PacketBuffer packetBuffer) {
        packetBuffer.writeInt(testPacket.quantity);
    }

    public static TestPacket decode(PacketBuffer packetBuffer) {
        return new TestPacket(packetBuffer.readInt());
    }

    public static void handle(TestPacket packet, Supplier<NetworkEvent.Context> ctx) {

        ServerPlayerEntity player = ctx.get().getSender();

        //if(packet.quantity > 1) return;

        player.addItem(new ItemStack(Items.DIAMOND, packet.quantity));

    }
}
