package net.mecheniy.blastymagic.blocks.blockentities;

import net.mecheniy.blastymagic.blocks.BlockEntityInit;
import net.mecheniy.blastymagic.blocks.custom.CrusherBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CrusherBlockEntity extends BlockEntity {


    private static final int MAX_PROGRESS = 100;
    private int progress;
    public CrusherBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityInit.CRUSHER.get(), blockPos, blockState);
    }

    //Каждые progress тиков будет спавнить свинью
    public void tick(){
        if(this.level == null){
            return;
        }
        progress++;
        if (progress > MAX_PROGRESS){
            progress = 0;
            var pig = new Pig(EntityType.PIG, this.level);
            pig.setPos(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ());
            this.level.addFreshEntity(pig);
        }
    }

    //Сохранение прогресса машинки
    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.progress = nbt.getInt("Progress");
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putInt("Progress", this.progress);
    }
}

