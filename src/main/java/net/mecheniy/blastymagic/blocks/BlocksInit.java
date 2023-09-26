package net.mecheniy.blastymagic.blocks;
import net.mecheniy.blastymagic.BlastyMagic;
import net.mecheniy.blastymagic.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockAgeProcessor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
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
            () -> new Block(Block.Properties.of(Material.METAL).strength(4f, 1200f).requiresCorrectToolForDrops().lightLevel((state) -> 15)));

public static class ExplosiveBlock extends Block {
    public ExplosiveBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand);

        if (!world.isClientSide() && held.getItem() == Items.GUNPOWDER) {
            world.explode(player, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true, Explosion.BlockInteraction.DESTROY);
            held.shrink(1);
            return InteractionResult.CONSUME;
        }
        return super.use(state, world,pos, player,hand,hit);
    }
    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true,
                Explosion.BlockInteraction.DESTROY);
        super.wasExploded(world, pos, explosion);
    }
}
    public static final RegistryObject<Block> explosive_block = BLOCKS.register("explosive_block",
            ()-> new ExplosiveBlock(BlockBehaviour.Properties.copy(Blocks.DIRT)));

}