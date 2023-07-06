package com.curvu.farmingutils.misc;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static com.curvu.farmingutils.FarmingUtils.NAME;

public class RegisterKeyBind {
  private final KeyBinding keyBinding;
  private final String name;
  private final int defaultKeyCode;
  private boolean registered = false;


  public RegisterKeyBind(String name, int defaultKeyCode) {
    this.name = name;
    this.defaultKeyCode = defaultKeyCode;
    keyBinding = new KeyBinding(name, this.getDefaultKeyCode(), NAME);
  }

  /**
   * Get the default keyCode for this keybinding
   */
  public int getDefaultKeyCode() {
    return this.defaultKeyCode;
  }

  /**
   * Get current keyCode
   */
  public int getKeyCode() {
    return this.keyBinding.getKeyCode();
  }

  /**
   * isPressed
   * @return true if the key is pressed
   */
  public boolean isPressed() {
    return registered && this.keyBinding.isPressed();
  }

  /**
   * Register the keybinding
   */
  public void register() {
    if (registered) return;
    ClientRegistry.registerKeyBinding(this.keyBinding);
    registered = true;
  }

  /*
   * TODO: Unregister the keybinding (maybe lol)
   */

}