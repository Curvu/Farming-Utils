package com.curvu.farmingutils.listeners;

import com.curvu.farmingutils.features.ToggleSneakFeature;
import com.curvu.farmingutils.features.ToggleLeftClickFeature;
import com.curvu.farmingutils.features.YawPitchFeature;
import com.curvu.farmingutils.misc.RegisterKeyBind;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * Handle events related to features
 *
 * @see YawPitchFeature
 */
public class FeatureListener {
  private final List<RegisterKeyBind> keyBindings = new ArrayList<RegisterKeyBind>();
  private final YawPitchFeature featureYawPitch = new YawPitchFeature();
  private final float[] yaws = new float[]{0, 45, 90, 135, 180, -45, -90, -135};
  private final float[] pitches = new float[]{0, 26, -45};

  private final ToggleLeftClickFeature toggleLeftClickFeature = new ToggleLeftClickFeature();

  private final ToggleSneakFeature toggleSneakFeature = new ToggleSneakFeature();

  public FeatureListener() {
    init();
  }

  private void init() {
    keyBindings.add(new RegisterKeyBind("toggle_left_click", Keyboard.KEY_RETURN));
    keyBindings.add(new RegisterKeyBind("toggle_sneak", Keyboard.KEY_NONE));
    for (Float yaw : yaws) keyBindings.add(new RegisterKeyBind("yaw:"+yaw, Keyboard.KEY_NONE));
    for (Float pitch : pitches) keyBindings.add(new RegisterKeyBind("pitch:"+pitch, Keyboard.KEY_NONE));

    // register all key bindings
    for (RegisterKeyBind keyBinding : keyBindings) keyBinding.register();
  }

  /**
   * Get the list of key bindings.
   * @return The list of key bindings.
   */
  public List<RegisterKeyBind> getKeyBindings() {
    return keyBindings;
  }

  /**
   * Handle the event to change the yaw of the player
   */
  @SubscribeEvent
  public void onYawChanging(KeyInputEvent event) {
    System.out.println("onYawChanging");
    for (RegisterKeyBind key : keyBindings) {
      // if index of the bind <2, it means that the key binding is not a yaw key binding
      if (keyBindings.indexOf(key) < 2) return;

      // if the key is pressed, change the yaw of the player
      if (key.isPressed()) featureYawPitch.setYaw(yaws[keyBindings.indexOf(key) - 2]); // TODO: CHANGE THIS SO YOU CAN CONFIGURE THE YAW IN THE GUI
    }
  }

  /**
   * Handle the event to change the pitch of the player
   */
  @SubscribeEvent
  public void onPitchChanging(KeyInputEvent event) {
    for (RegisterKeyBind key : keyBindings) {
      // if index of the bind 2+yaws.length, it means that the key binding is not a pitch key binding
      if (keyBindings.indexOf(key) < 10) continue;

      // if the key is pressed, change the pitch of the player
      if (key.isPressed()) featureYawPitch.setPitch(pitches[keyBindings.indexOf(key) - 10]); // TODO: CHANGE THIS SO YOU CAN CONFIGURE THE PITCH IN THE GUI
    }
  }

  /**
   * Handle the event to toggle the left click
   */
  @SubscribeEvent
  public void onLeftClickToggling(KeyInputEvent event) {
    if (keyBindings.get(0).isPressed()) toggleLeftClickFeature.toggle();
  }

  /**
   * Handle the event to toggle the sneak
   */
  @SubscribeEvent
  public void onSneakToggling(KeyInputEvent event) {
    if (keyBindings.get(1).isPressed()) toggleSneakFeature.toggle();
  }
}
