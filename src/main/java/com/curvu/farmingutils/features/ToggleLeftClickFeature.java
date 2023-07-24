package com.curvu.farmingutils.features;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.client.settings.KeyBinding;

/**
 * This class allow to toggle the left click of the player - so it's only needed to press the movement keys to farm
 */
public class ToggleLeftClickFeature {
  /**
   * Toggle the attack of the player.
   */
  public void toggle() {
    // start clicking (or stop) until is toggled again
    KeyBinding attackKey = FarmingUtils.mc.gameSettings.keyBindAttack;
    KeyBinding.setKeyBindState(attackKey.getKeyCode(), !attackKey.isKeyDown());
  }
}
