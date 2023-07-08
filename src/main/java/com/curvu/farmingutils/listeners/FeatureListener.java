package com.curvu.farmingutils.listeners;

import com.curvu.farmingutils.features.ToggleMovementFeature;
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
  private final ToggleLeftClickFeature toggleLeftClickFeature = new ToggleLeftClickFeature();
  private final ToggleSneakFeature toggleSneakFeature = new ToggleSneakFeature();
  private final ToggleMovementFeature toggleMovementFeature = new ToggleMovementFeature();

  public FeatureListener() {
    init();
  }

  private void init() {
    keyBindings.add(new RegisterKeyBind("Toggle Left Click", Keyboard.KEY_RETURN));
    keyBindings.add(new RegisterKeyBind("Toggle Sneak", Keyboard.KEY_NONE));
    keyBindings.add(new RegisterKeyBind("Toggle Walk Left", Keyboard.KEY_LEFT));
    keyBindings.add(new RegisterKeyBind("Toggle Walk Right", Keyboard.KEY_RIGHT));
    keyBindings.add(new RegisterKeyBind("Toggle Walk Forward", Keyboard.KEY_UP));
    keyBindings.add(new RegisterKeyBind("Toggle Walk Backward", Keyboard.KEY_DOWN));
    keyBindings.add(new RegisterKeyBind("0º Yaw", Keyboard.KEY_NUMPAD5));
    keyBindings.add(new RegisterKeyBind("90º Yaw", Keyboard.KEY_NUMPAD8));
    keyBindings.add(new RegisterKeyBind("135º Yaw", Keyboard.KEY_NUMPAD4));
    keyBindings.add(new RegisterKeyBind("180º Yaw", Keyboard.KEY_NUMPAD2));
    keyBindings.add(new RegisterKeyBind("0º Pitch", Keyboard.KEY_NUMPAD6));
    keyBindings.add(new RegisterKeyBind("27º Pitch", Keyboard.KEY_NUMPAD3));
    keyBindings.add(new RegisterKeyBind("-45º Pitch", Keyboard.KEY_NUMPAD9));

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

  @SubscribeEvent
  public void onEvent(KeyInputEvent event) {
    if (keyBindings.get(0).isPressed()) toggleLeftClickFeature.toggle();
    if (keyBindings.get(1).isPressed()) toggleSneakFeature.toggle();
    if (keyBindings.get(2).isPressed()) toggleMovementFeature.toggleLeft();
    if (keyBindings.get(3).isPressed()) toggleMovementFeature.toggleRight();
    if (keyBindings.get(4).isPressed()) toggleMovementFeature.toggleForward();
    if (keyBindings.get(5).isPressed()) toggleMovementFeature.toggleBackward();
    if (keyBindings.get(6).isPressed()) featureYawPitch.setYaw(0);
    if (keyBindings.get(7).isPressed()) featureYawPitch.setYaw(90);
    if (keyBindings.get(8).isPressed()) featureYawPitch.setYaw(135);
    if (keyBindings.get(9).isPressed()) featureYawPitch.setYaw(180);
    if (keyBindings.get(10).isPressed()) featureYawPitch.setPitch(0);
    if (keyBindings.get(11).isPressed()) featureYawPitch.setPitch(27);
    if (keyBindings.get(12).isPressed()) featureYawPitch.setPitch(-45);
  }
}
