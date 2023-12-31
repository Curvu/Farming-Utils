package com.curvu.farmingutils.features;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.Minecraft;

/**
 * This class allow to toggle wasd movement of the player
 */
public class ToggleMovementFeature {

  private final Minecraft mc = Minecraft.getMinecraft();

  /**
   * Toggle Left
   */
  public void toggleLeft() {
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), !mc.gameSettings.keyBindLeft.isKeyDown());
  }

  /**
   * Toggle Right
   */
  public void toggleRight() {
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), !mc.gameSettings.keyBindRight.isKeyDown());
  }

  /**
   * Toggle Forward
   */
  public void toggleForward() {
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), !mc.gameSettings.keyBindForward.isKeyDown());
  }

  /**
   * Toggle Back
   */
  public void toggleBackward() {
    KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), !mc.gameSettings.keyBindBack.isKeyDown());
  }
}
