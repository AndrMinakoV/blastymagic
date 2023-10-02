package net.mecheniy.blastymagic;

import net.mecheniy.blastymagic.items.FuelItem;
import net.mecheniy.blastymagic.items.TeleportStaff;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mecheniy.blastymagic.util.ModItemTier;

import javax.annotation.Nullable;
import java.util.logging.Level;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BlastyMagic.MODID);

    public static final RegistryObject<Item> unobtanium_ingot = ITEMS.register("unobtanium_ingot",
            () -> new Item(new Item.Properties().tab(ModeCreativeTab.instance)));
    public static class ModeCreativeTab extends CreativeModeTab {
        public static final ModeCreativeTab instance = new ModeCreativeTab(CreativeModeTab.TABS.length, "Blasty Magic");

        public ModeCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon(){
            return new ItemStack(unobtanium_ingot.get());
        }
    }
    public static RegistryObject<Item> unobtanium_goal = ITEMS.register("unobtanium_goal", //must be static
            () -> new FuelItem(new Item.Properties().tab(ItemInit.ModeCreativeTab.instance), 3200));
    public static final RegistryObject<Item> poisoned_apple = ITEMS.register("poisoned_apple",
            ()-> new Item(new Item.Properties().tab(ModeCreativeTab.instance)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.POISON), 0.5F).alwaysEat().build())));

    public static final RegistryObject<Item> basic_teleportator = ITEMS.register("basic_teleportator",
            ()->new TeleportStaff(new Item.Properties().tab(ModeCreativeTab.instance).durability(200)));

    public static final RegistryObject<Item> PENIS_SWORD = ITEMS.register("penis_sword",
            () -> new SwordItem(ModItemTier.PINK, 3, -2.4F, new Item.Properties().tab(ModeCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_PICKAXE = ITEMS.register("pink_pickaxe",
            () -> new PickaxeItem(ModItemTier.PINK,1, -1.0F, new Item.Properties().tab(ModeCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_AXE = ITEMS.register("pink_axe",
            () -> new AxeItem(ModItemTier.PINK, 6, -3.4F, new Item.Properties().tab(ModeCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_SHOVEL = ITEMS.register("pink_shovel",
            () -> new ShovelItem(ModItemTier.PINK, 1, -1.0F, new Item.Properties().tab(ModeCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_HOE = ITEMS.register("pink_hoe",
            () -> new HoeItem(ModItemTier.PINK, 0, -1.0F, new Item.Properties().tab(ModeCreativeTab.instance)));

}


