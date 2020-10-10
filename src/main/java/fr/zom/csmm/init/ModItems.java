package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import fr.zom.csmm.utils.CustomItemTiers;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems
{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CSMM.MODID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_STICK = ITEMS.register("copper_stick", () -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CustomItemTiers.COPPER, 2, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));

}
