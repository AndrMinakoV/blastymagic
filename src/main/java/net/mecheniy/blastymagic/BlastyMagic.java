package net.mecheniy.blastymagic;

import com.mojang.logging.LogUtils;
import net.mecheniy.blastymagic.blocks.BlockEntityInit;
import net.mecheniy.blastymagic.blocks.BlocksInit;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BlastyMagic.MODID)
public class BlastyMagic
{

    public static final String MODID = "blastymagic";
    private static final Logger LOGGER = LogUtils.getLogger();
    public BlastyMagic()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BlocksInit.BLOCKS.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ItemInit.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);

        BlockEntityInit.BLOCK_ENTITIES.register(modEventBus);


    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
