package com.curvu.farmingutils.features;

import net.minecraft.client.Minecraft;

/**
 * Un-focus the game window (keeping the game running normally in the background)
 */
public class UnFocusGameFeature {
  private static final Minecraft mc = Minecraft.getMinecraft();

  public void unFocusGame() {
    mc.mouseHelper.ungrabMouseCursor();

    // make that the mouse is not grabbed, the game senses that the mouse is not grabbed
    mc.inGameHasFocus = false;

    // when clicking outside the game window, the game doesn't pause
    mc.gameSettings.pauseOnLostFocus = false;
  }
}
