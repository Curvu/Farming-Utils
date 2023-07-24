package com.curvu.farmingutils.features;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.client.settings.KeyBinding;

/**
 * This class allow to toggle the sneak movement of the player
 */
public class ToggleSneakFeature {
  public void toggle() {
    // start sneaking (or stop) until is toggled again
    KeyBinding sneakKey = FarmingUtils.mc.gameSettings.keyBindSneak;
    KeyBinding.setKeyBindState(sneakKey.getKeyCode(), !sneakKey.isKeyDown());
  }
}
