package com.curvu.farmingutils.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.net.URI;

public class StartGui extends GuiScreen {
  public boolean doesGuiPauseGame() {
    return false;
  }

  public void initGui() {
    super.initGui();
    this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 - 24, "Start"));
  }

  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    this.drawDefaultBackground();
    super.drawScreen(mouseX, mouseY, partialTicks);
  }

  protected void actionPerformed(GuiButton button) {
    if (button.id == 0) {
      try {
        Desktop.getDesktop().browse(new URI("https://google.com"));
      }  catch (Exception exception) {
        exception.printStackTrace();
      }
    }
  }
}
