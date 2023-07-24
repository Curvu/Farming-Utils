package com.curvu.farmingutils.gui;

import com.curvu.farmingutils.FarmingUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiClient extends GuiScreen {
  final ResourceLocation texture = new ResourceLocation(FarmingUtils.MODID, "textures/gui/book.png");
  int guiWidth = 175;
  int guiHeight = 228;

  @Override
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    drawDefaultBackground();
    FarmingUtils.mc.renderEngine.bindTexture(texture);
    int centerX = (width - guiWidth) / 2;
    int centerY = (height - guiHeight) / 2;
    drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);

    drawString(fontRendererObj, "Farming Utils", centerX + 10, centerY + 10, 0x56AEFF);

    super.drawScreen(mouseX, mouseY, partialTicks);
  }

  @Override
  public void initGui() {
    super.initGui();
  }

  @Override
  protected void actionPerformed(GuiButton button) throws IOException {
    super.actionPerformed(button);
  }

  @Override
  protected void keyTyped(char typedChar, int keyCode) throws IOException {
    super.keyTyped(typedChar, keyCode);
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
