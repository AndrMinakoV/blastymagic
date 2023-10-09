package net.mecheniy.blastymagic.blocks.custom;

import com.google.common.collect.ImmutableMap;
import net.mecheniy.blastymagic.blocks.BlocksInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.ScheduledExecutorService;


public class ActivatedBlock extends Block {

    public ActivatedBlock(Properties properties){
        super(properties);
    }
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide() && interactionHand == InteractionHand.MAIN_HAND && player.getItemInHand(interactionHand).getItem() == Items.DIAMOND ) {
            Block block =  ForgeRegistries.BLOCKS.getValue(new ResourceLocation("blastymagic:activated_unobtanium_block"));
            player.sendSystemMessage(Component.literal("Its diamond"));
            level.destroyBlock(blockPos, true);
            if (block != null){
                level.setBlock(blockPos, block.defaultBlockState(), 1);
            }
        }
            return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
