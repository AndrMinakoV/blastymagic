package net.mecheniy.blastymagic.items;

import net.mecheniy.blastymagic.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class FuelItem extends Item{
        private final int burnTicks;
        public FuelItem(Properties properties, int burnTimeInTicks) {
            super(properties);
            this.burnTicks = burnTimeInTicks;
        }


        @Override
        public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
            return this.burnTicks;
        }
}
