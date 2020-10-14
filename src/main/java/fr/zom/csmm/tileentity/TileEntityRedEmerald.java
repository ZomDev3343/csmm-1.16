package fr.zom.csmm.tileentity;

import fr.zom.csmm.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityRedEmerald extends TileEntity implements ITickableTileEntity {

    private int counter = 0;

    public TileEntityRedEmerald() {
        super(ModTileEntities.RED_EMERALD_TILE_ENTITIY.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);

        this.setCounter(nbt.getInt("counter"));
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("counter", this.getCounter());

        return compound;
    }

    @Override
    public void tick() {
        this.setCounter(getCounter()+1);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
