package com.curvu.farmingutils.render;

import com.curvu.farmingutils.mixins.BlockAccessor;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * This class is used to render all (full-grown) crops with a full block size.
 */
public class CropsHitBox {
  // crops: wheat, carrots, potatoes, nether wart, cocoa beans, mushrooms, sugar cane, cactus
  private static final AxisAlignedBB FULL_BLOCK = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
  private static final AxisAlignedBB DEFAULT = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);

  public static void updateCropsMaxY(World world, BlockPos pos, Block block) {
    final IBlockState blockState = world.getBlockState(pos);
    final Integer age = blockState.getValue(BlockCrops.AGE);
    BlockAccessor accessor = (BlockAccessor) block;

    // if age != 7, set maxY to his normal value, else set maxY to 1.0D
    accessor.setMaxY(age != 7 ? DEFAULT.maxY : FULL_BLOCK.maxY);
  }
}

