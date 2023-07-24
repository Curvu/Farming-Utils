package com.curvu.farmingutils.features;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.util.MathHelper;

/**
 * This class allow to change the yaw and pitch of the player to a specific value.
 */
public class YawPitchFeature {
  /**
   * Change the yaw of the player to a specific value.
   * @param yaw The yaw to set the player to [-180, 180]
   */
  public void setYaw(float yaw) {
    FarmingUtils.mc.thePlayer.rotationYaw = MathHelper.wrapAngleTo180_float(yaw);
  }

  /**
   * Change the pitch of the player to a specific value.
   * @param pitch The pitch to set the player to [-90, 90]
   */
  public void setPitch(float pitch) {
    FarmingUtils.mc.thePlayer.rotationPitch = MathHelper.wrapAngleTo180_float(pitch);
  }

  /**
   * Get the current yaw and pitch of the player.
   * @return An array of size 2 containing the yaw and pitch of the player.
   */
  public float[] getYawPitch() {
    return new float[]{ FarmingUtils.mc.thePlayer.rotationYaw, FarmingUtils.mc.thePlayer.rotationPitch };
  }
}
