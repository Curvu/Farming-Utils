package com.curvu.farmingutils;

import com.curvu.farmingutils.misc.ClassTransformer;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@IFMLLoadingPlugin.MCVersion("1.8.9")
public class FMLCorePlugin implements IFMLLoadingPlugin {

  // Add the mixin configuration here
  public FMLCorePlugin() {
    MixinBootstrap.init();
    Mixins.addConfiguration("mixins.farmingutils.json");
    MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
  }

  @Override
  public String[] getASMTransformerClass() {
    return new String[]{ClassTransformer.class.getName()};
  }

  @Override
  public String getModContainerClass() {
    return null;
  }

  @Override
  public String getSetupClass() {
    return null;
  }

  @Override
  public void injectData(Map<String, Object> data) { }

  @Override
  public String getAccessTransformerClass() {
    return null;
  }
}