package fr.zom.csmm.blocks;

import fr.zom.csmm.tileentity.TileEntityTest;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockTestEntityBlock extends Block{
    public BlockTestEntityBlock() {
        super(AbstractBlock.Properties.create(Material.IRON).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresTool().hardnessAndResistance(5f, 20f));
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityTest();
    }

    @Override
    public ActionResultType onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(worldIn.getTileEntity(pos) instanceof TileEntityTest)
        {
            TileEntityTest tileEntity = ((TileEntityTest) worldIn.getTileEntity(pos));
            player.sendStatusMessage(new StringTextComponent("Counter : " + tileEntity.getCounter()), true);
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
