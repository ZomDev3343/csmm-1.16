package fr.zom.csmm.init;

import fr.zom.csmm.CSMM;
import fr.zom.csmm.utils.CustomArmorMaterials;
import fr.zom.csmm.utils.CustomItemTiers;
import fr.zom.csmm.utils.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CSMM.MODID);

    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(ModItemGroups.CSMM_TAB)));
    public static final RegistryObject<Item> COPPER_STICK = ITEMS.register("copper_stick", () -> new Item(new Item.Properties().group(ModItemGroups.CSMM_TAB).maxStackSize(1).group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(CustomItemTiers.COPPER, 2, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));
    public static final RegistryObject<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(CustomItemTiers.COPPER, 0, -2.4f, new Item.Properties().maxStackSize(1).group(ItemGroup.TOOLS)));

    public static final RegistryObject<Item> AMETHYST_GEM = ITEMS.register("amethyst_gem", () -> new Item(new Item.Properties().group(ModItemGroups.CSMM_TAB)));

    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet", () -> new ArmorItem(CustomArmorMaterials.AMETHYST_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate", () -> new ArmorItem(CustomArmorMaterials.AMETHYST_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings", () -> new ArmorItem(CustomArmorMaterials.AMETHYST_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots", () -> new ArmorItem(CustomArmorMaterials.AMETHYST_ARMOR, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BLUE_APPLE = ITEMS.register("blue_apple", () -> new Item(new Item.Properties()
            .group(ModItemGroups.CSMM_TAB)
            .food(new Food.Builder().hunger(7).saturation(0.8F).effect(() -> new EffectInstance(Effects.SPEED, 20 * 30, 0), 1.0f).build())));

    public static final RegistryObject<Item> MYRTLE_JUICE = ITEMS.register("myrtle_juice", () -> new Item(new Item.Properties()
            .group(ModItemGroups.CSMM_TAB)
            .food(new Food.Builder().hunger(3).saturation(0.2F).effect(() -> new EffectInstance(Effects.STRENGTH, 20 * 15, 1), 0.5f).build()))
    {
        @Override
        public UseAction getUseAction(ItemStack stack) {
            return UseAction.DRINK;
        }
    });

}
