package com.curvu.farmingutils.features;

import org.lwjgl.input.Mouse;
import net.minecraft.util.MouseHelper;
import net.minecraft.client.Minecraft;

/**
 * Un-focus the game window (keeping the game running normally in the background)
 */
public class UngrabFeature {
  private static Minecraft mc;
  public static boolean isUngrabbed;
  private static MouseHelper oldMouseHelper;
  private static boolean doesGameWantUngrab;


  public static void ungrabMouse() {
    if (!UngrabFeature.mc.inGameHasFocus || UngrabFeature.isUngrabbed) {
      regrabMouse(); //TODO - this will not be needed in the future
      return;
    }

    if (UngrabFeature.oldMouseHelper == null) {
      UngrabFeature.oldMouseHelper = UngrabFeature.mc.mouseHelper;
    }
    UngrabFeature.mc.gameSettings.pauseOnLostFocus = false;
    UngrabFeature.doesGameWantUngrab = !Mouse.isGrabbed();
    UngrabFeature.oldMouseHelper.ungrabMouseCursor();
    UngrabFeature.mc.inGameHasFocus = true;
    UngrabFeature.mc.mouseHelper = new MouseHelper() {
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
    UngrabFeature.mc.mouseHelper = UngrabFeature.oldMouseHelper;
    if (!UngrabFeature.doesGameWantUngrab) {
      UngrabFeature.mc.mouseHelper.grabMouseCursor();
    }
    UngrabFeature.oldMouseHelper = null;
  }

  static {
    UngrabFeature.mc = Minecraft.getMinecraft();
    UngrabFeature.isUngrabbed = false;
    UngrabFeature.doesGameWantUngrab = true;
  }
}
