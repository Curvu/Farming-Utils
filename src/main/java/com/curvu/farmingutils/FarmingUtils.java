package com.curvu.farmingutils;

import com.curvu.farmingutils.listeners.FeatureListener;
import net.minecraft.block.*;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FarmingUtils.MODID, name = FarmingUtils.NAME, version = FarmingUtils.VERSION)
public class FarmingUtils {
  public static final String MODID = "farmingutils";
  public static final String NAME = "FarmingUtils";
  public static final String VERSION = "1.1.4";

  @Mod.Instance
  public static FarmingUtils main;

  double[] WART_HEIGHTS = {0.125D, 0.125D, 0.125D, 1.0D};
  double[] FULL_HEIGHTS = {0.125D, 0.125D, 0.125D, 0.125D, 0.125D, 0.125D, 0.125D, 1.0D};

  public void extendHitbox(World world, BlockPos blockPos) {
    IBlockState blockState = world.getBlockState(blockPos);
    Block block = blockState.getBlock();

    double[] heights = WART_HEIGHTS;
    PropertyInteger age = null;

    if (block instanceof BlockNetherWart) {
      age = BlockNetherWart.AGE;
    } else if (block instanceof BlockCrops) {
      heights = FULL_HEIGHTS;
      age = BlockCrops.AGE;
    }

    if(age == null) return;

    try {
      ObfuscationReflectionHelper.setPrivateValue(Block.class, block, heights[blockState.getValue(age)], "maxY", "field_149756_F");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    main = this;
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
    MinecraftForge.EVENT_BUS.register(new FeatureListener());

    Blocks.brown_mushroom.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    Blocks.red_mushroom.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
  }
}