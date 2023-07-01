package com.curvu.farmingutils.features;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

/**
 * This class allow to change the yaw and pitch of the player to a specific value.
 */
public class YawPitchFeature {

  private final Minecraft mc;

  public YawPitchFeature() {
    mc = Minecraft.getMinecraft();
  }

  /**
   * Change the yaw of the player to a specific value.
   * @param yaw The yaw to set the player to [-180, 180]
   */
  public void setYaw(float yaw) {
    this.mc.thePlayer.rotationYaw = MathHelper.wrapAngleTo180_float(yaw);
  }

  /**
   * Change the pitch of the player to a specific value.
   * @param pitch The pitch to set the player to [-90, 90]
   */
  public void setPitch(float pitch) {
    this.mc.thePlayer.rotationPitch = MathHelper.wrapAngleTo180_float(pitch);
  }

  /**
   * Get the current yaw and pitch of the player.
   */
  public float[] getYawPitch() {
    return new float[]{ this.mc.thePlayer.rotationYaw, this.mc.thePlayer.rotationPitch };
  }
}
