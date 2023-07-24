package com.curvu.farmingutils.commands;

import com.curvu.farmingutils.FarmingUtils;
import com.curvu.farmingutils.gui.GuiClient;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class GuiCommand extends CommandBase {
  public String getCommandName() {
    return "farmingutils";
  }

  public List<String> getCommandAliases() {
    return Lists.newArrayList(new String[] { "fu" });
  }

  public int getRequiredPermissionLevel() {
    return 0;
  }

  public String getCommandUsage(final ICommandSender sender) {
    return "/" + this.getCommandName();
  }

  public void processCommand(ICommandSender sender, String[] args) {
    if (args.length == 0) {
      sender.addChatMessage(new ChatComponentText("\u00A7e[Farming Utils] \u00A7fOpening GUI..."));
      FarmingUtils.displayScreen = new GuiClient();
    }
  }
}
