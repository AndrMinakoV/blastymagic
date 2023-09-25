package net.mecheniy.blastymagic;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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

}

