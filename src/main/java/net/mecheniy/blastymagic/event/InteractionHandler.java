package net.mecheniy.blastymagic.event;

import net.mecheniy.blastymagic.blocks.BlocksInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.level.Level;
//import java.util.logging.Level;

@Mod.EventBusSubscriber
public class InteractionHandler {
    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event){
        Level level = event.getLevel();
        BlockPos blockPos = event.getPos();
        Player player = event.getEntity();


        if (level.getBlockState(blockPos).getBlock() == BlocksInit.unobtanium_block.get() && player.getMainHandItem().getItem() == Items.DIAMOND){
            if (!level.isClientSide()){
                level.setBlock(blockPos, BlocksInit.activated_unobtanium_block.get().defaultBlockState(), 1);

            }
            player.getMainHandItem().shrink(1);
        }
    }
}
