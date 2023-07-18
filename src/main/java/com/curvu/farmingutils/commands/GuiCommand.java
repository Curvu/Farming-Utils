package com.curvu.farmingutils.commands;

import com.curvu.farmingutils.FarmingUtils;
import com.curvu.farmingutils.gui.StartGui;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

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
      FarmingUtils.displayScreen = new StartGui();
    }
  }
}
