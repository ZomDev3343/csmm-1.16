package fr.zom.csmm.tileentity;

import fr.zom.csmm.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTest extends TileEntity implements ITickableTileEntity {

    private int counter = 0;


    public TileEntityTest() {
        super(ModTileEntities.TEST_TILE_ENTITY.get());
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);

        compound.putInt("counter", this.counter);

        return compound;
    }

    @Override
    public void fromTag(BlockState state, CompoundNBT nbt) {
        super.fromTag(state, nbt);

        this.counter = nbt.getInt("counter");
    }

    @Override
    public void tick() {
        this.counter++;
    }

    public int getCounter()
    {
        return this.counter;
    }

    
}
