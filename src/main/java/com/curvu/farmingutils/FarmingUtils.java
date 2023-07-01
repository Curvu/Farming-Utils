package com.curvu.farmingutils;

import com.curvu.farmingutils.listeners.FeatureListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = FarmingUtils.MODID, name = FarmingUtils.NAME, version = FarmingUtils.VERSION)
public class FarmingUtils {
  public static final String MODID = "farmingutils";
  public static final String NAME = "FarmingUtils";
  public static final String VERSION = "1.0.0";

  @EventHandler
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(new FeatureListener());
  }
}