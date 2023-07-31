package com.curvu.farmingutils.gui;

import com.curvu.farmingutils.FarmingUtils;
import com.curvu.farmingutils.utils.Utils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;

import java.io.IOException;

public class GuiClient extends GuiScreen {
  int guiWidth = 600;
  int guiHeight = 400;
  String title = FarmingUtils.NAME + " " + FarmingUtils.VERSION;

  GuiButton button0;
  final int BUTTON0 = 0; // btn_id
  GuiTextField textField;

  @Override
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    drawDefaultBackground();

    int centerX = (width - guiWidth) / 2;
    int centerY = (height - guiHeight) / 2;
    drawRect(centerX, centerY, centerX + guiWidth, centerY + guiHeight, 0x80FFFFFF);

    GlStateManager.pushMatrix();
    {
      GlStateManager.translate((float) ((width / 2) - fontRendererObj.getStringWidth(title)), centerY + 20, 0);
      GlStateManager.scale(2, 2, 2);
      fontRendererObj.drawString(title, 0, 0, 0x56AEFF);
    }
    GlStateManager.popMatrix();

    textField.drawTextBox();

    super.drawScreen(mouseX, mouseY, partialTicks);
  }

  @Override
  public void initGui() {
    buttonList.clear();
    buttonList.add(button0 = new GuiButton(BUTTON0, (width / 2), (height / 2) - 10, fontRendererObj.getStringWidth("Click me")+20, 20,"Click me"));
    // text field
    textField = new GuiTextField(0, fontRendererObj, (width / 2) - 100, (height / 2) - 10, 100, 20);
    textField.setMaxStringLength(100);
    textField.setText("Text field");
    textField.setFocused(true);

    super.initGui();
  }

  public void updateButtons() {
    button0.enabled = false;
    button0.displayString = "Clicked";

    Utils.scheduleTask(() -> {
      button0.enabled = true;
      button0.displayString = "Click me";
    }, 1);
  }

  @Override
  protected void actionPerformed(GuiButton button) throws IOException {
    if (button.id == BUTTON0) {
      updateButtons();
    }
    super.actionPerformed(button);
  }

  @Override
  protected void keyTyped(char typedChar, int keyCode) throws IOException {
    textField.textboxKeyTyped(typedChar, keyCode);
    super.keyTyped(typedChar, keyCode);
  }

  @Override
  protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
    textField.mouseClicked(mouseX, mouseY, mouseButton);
    super.mouseClicked(mouseX, mouseY, mouseButton);
  }

  @Override
  public boolean doesGuiPauseGame() {
    return false;
  }

  @Override
  public void onGuiClosed() {
    super.onGuiClosed();
  }
}
