package com.curvu.farmingutils.features;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.util.MouseHelper;
import org.lwjgl.input.Mouse;

/**
 * Un-focus the game window (keeping the game running normally in the background)
 */
public class UngrabFeature {
  public static boolean isUngrabbed;
  private static MouseHelper oldMouseHelper;
  private static boolean doesGameWantUngrab;

  public static void ungrabMouse() {
    if (!FarmingUtils.mc.inGameHasFocus || UngrabFeature.isUngrabbed) {
      regrabMouse(); //TODO - this will not be needed in the future
      return;
    }

    if (UngrabFeature.oldMouseHelper == null) UngrabFeature.oldMouseHelper = FarmingUtils.mc.mouseHelper;

    FarmingUtils.mc.gameSettings.pauseOnLostFocus = false;
    UngrabFeature.doesGameWantUngrab = !Mouse.isGrabbed();
    UngrabFeature.oldMouseHelper.ungrabMouseCursor();
    FarmingUtils.mc.inGameHasFocus = true;
    FarmingUtils.mc.mouseHelper = new MouseHelper() {
      public void mouseXYChange() { }

      public void grabMouseCursor() {
        UngrabFeature.doesGameWantUngrab = false;
      }

      public void ungrabMouseCursor() {
        UngrabFeature.doesGameWantUngrab = true;
      }
    };
    UngrabFeature.isUngrabbed = true;
  }

  public static void regrabMouse() {
    if (!UngrabFeature.isUngrabbed) return;

    UngrabFeature.isUngrabbed = false;
    FarmingUtils.mc.mouseHelper = UngrabFeature.oldMouseHelper;
    if (!UngrabFeature.doesGameWantUngrab) FarmingUtils.mc.mouseHelper.grabMouseCursor();
    UngrabFeature.oldMouseHelper = null;
  }

  static {
    UngrabFeature.isUngrabbed = false;
    UngrabFeature.doesGameWantUngrab = true;
  }
}
