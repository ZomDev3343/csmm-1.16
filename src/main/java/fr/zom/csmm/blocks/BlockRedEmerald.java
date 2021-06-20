package fr.zom.csmm.blocks;

import fr.zom.csmm.tileentity.TileEntityRedEmerald;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockRedEmerald extends Block {
    public BlockRedEmerald() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(5f , 20f).harvestTool(ToolType.PICKAXE).harvestLevel(1).requiresCorrectToolForDrops());
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityRedEmerald();
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(worldIn.getBlockEntity(pos) instanceof TileEntityRedEmerald)
        {
            TileEntityRedEmerald te = (TileEntityRedEmerald) worldIn.getBlockEntity(pos);
            player.displayClientMessage(new StringTextComponent("Counter : " + te.getCounter()), true);
            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }

}
