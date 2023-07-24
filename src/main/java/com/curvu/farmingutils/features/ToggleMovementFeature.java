package com.curvu.farmingutils.features;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.client.settings.KeyBinding;

/**
 * This class allow to toggle wasd movement of the player
 */
public class ToggleMovementFeature {
  /**
   * Toggle Left
   */
  public void toggleLeft() {
    KeyBinding.setKeyBindState(FarmingUtils.mc.gameSettings.keyBindLeft.getKeyCode(), !FarmingUtils.mc.gameSettings.keyBindLeft.isKeyDown());
  }

  /**
   * Toggle Right
   */
  public void toggleRight() {
    KeyBinding.setKeyBindState(FarmingUtils.mc.gameSettings.keyBindRight.getKeyCode(), !FarmingUtils.mc.gameSettings.keyBindRight.isKeyDown());
  }

  /**
   * Toggle Forward
   */
  public void toggleForward() {
    KeyBinding.setKeyBindState(FarmingUtils.mc.gameSettings.keyBindForward.getKeyCode(), !FarmingUtils.mc.gameSettings.keyBindForward.isKeyDown());
  }

  /**
   * Toggle Back
   */
  public void toggleBackward() {
    KeyBinding.setKeyBindState(FarmingUtils.mc.gameSettings.keyBindBack.getKeyCode(), !FarmingUtils.mc.gameSettings.keyBindBack.isKeyDown());
  }
}
