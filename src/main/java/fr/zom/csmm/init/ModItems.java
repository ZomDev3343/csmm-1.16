package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CSMM.MODID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_STICK = ITEMS.register("copper_stick", () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MATERIALS)));


}
