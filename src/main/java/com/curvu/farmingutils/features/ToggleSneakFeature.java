package com.curvu.farmingutils.features;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

/**
 * This class allow to toggle the sneak movement of the player
 */
public class ToggleSneakFeature {
  private boolean toggled = false;
  private final Minecraft mc;

  public ToggleSneakFeature() {
    mc = Minecraft.getMinecraft();
  }

  public void toggle() {
    this.toggled = !this.toggled;
    // start sneaking (or stop) until is toggled again
    KeyBinding sneakKey = mc.gameSettings.keyBindSneak;
    KeyBinding.setKeyBindState(sneakKey.getKeyCode(), this.toggled);
  }
}
