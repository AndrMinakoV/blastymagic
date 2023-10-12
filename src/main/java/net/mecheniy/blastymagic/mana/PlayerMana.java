/*package net.mecheniy.blastymagic.mana;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {
    public int mana;
    public final int MIN_MANA = 0;
    public final int MAX_MANA = 100;

    public int getMana() {
        return mana;
    }
    public void addMana(int add){
        this.mana += add;
    }

    public void subMana(int sub){
        this.mana -= sub;
    }
    public void copyFrom(PlayerMana source){
        this.mana = source.mana;
    }
    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("mana", mana);
    }
    public void loadNBTData(CompoundTag nbt){
        mana = nbt.getInt("mana");
    }

}
*/