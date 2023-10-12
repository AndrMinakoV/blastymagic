package net.mecheniy.blastymagic.blocks;

import net.mecheniy.blastymagic.BlastyMagic;
import net.mecheniy.blastymagic.blocks.blockentities.CrusherBlockEntity;
import net.mecheniy.blastymagic.blocks.custom.CrusherBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
    public  static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BlastyMagic.MODID);
    public static final RegistryObject<BlockEntityType<CrusherBlockEntity>> CRUSHER = BLOCK_ENTITIES.register("crusher", () ->
            BlockEntityType.Builder.of(CrusherBlockEntity::new, BlocksInit.CRUSHER.get()).build(null));
}
