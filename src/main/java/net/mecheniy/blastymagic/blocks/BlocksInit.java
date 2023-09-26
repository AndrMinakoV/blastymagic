package net.mecheniy.blastymagic.blocks;
import net.mecheniy.blastymagic.BlastyMagic;
import net.mecheniy.blastymagic.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;


import javax.swing.*;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksInit {
    @SubscribeEvent
    public static void onRegisterItems(final RegisterEvent event) {
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
            BLOCKS.getEntries().forEach((blockRegistryObject) -> {
                Item.Properties properties = new Item.Properties().tab(ItemInit.ModeCreativeTab.instance);
                Supplier<Item> blockItemFactory = () -> new BlockItem(blockRegistryObject.get(), properties);
                event.register(ForgeRegistries.Keys.ITEMS, blockRegistryObject.getId(), blockItemFactory);
            });
        }
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BlastyMagic.MODID);

    public static final RegistryObject<Block> unobtanium_ore = BLOCKS.register("unobtanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f, 1200f).requiresCorrectToolForDrops().lightLevel((state) -> 15)));
}

