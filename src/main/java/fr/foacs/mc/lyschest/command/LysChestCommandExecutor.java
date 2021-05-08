package fr.foacs.mc.lyschest.command;

import fr.foacs.mc.lyschest.ChestFactory;
import fr.foacs.mc.lyschest.entity.LChest;
import fr.foacs.mc.lyscore.api.LysPlugin;
import fr.foacs.mc.lyscore.api.command.CommandHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class LysChestCommandExecutor extends CommandHandler {

  public static final String COMMAND_NAME = "lchest";

  public LysChestCommandExecutor(LysPlugin plugin) {
    super(plugin, COMMAND_NAME);
  }

  @Override
  protected boolean isMatchParamsNumber(String[] args) {
    return args.length >= 2 && args.length <= 3;
  }

  @Override
  protected boolean handle(CommandSender sender, Command command, String s, String[] args) {
    final String commandAction = args[0];
    final String id = args[1];
    final String name = args.length == 3?args[2]:null;

    if (commandAction.equalsIgnoreCase("create")) {
      handleCreateAction(sender, id, name);
    } else if (commandAction.equalsIgnoreCase("edit")) {
      handleEditAction(sender, id, name);
    } else {
      sendMessage(sender, "lchest-wrong-command-action", commandAction);
    }
    return true;
  }

  private void handleEditAction(CommandSender sender, String id, String name) {
    if (isNotBlank(name)) {
      sendMessage(sender, "lchest-edit-unnecessary-name");
    }
    if (ChestFactory.existsChest(id)) {
      ChestFactory.retrieveLChest(id).ifPresent(ChestFactory::saveLChest);
    } else {
      sendMessage(sender, "lchest-id-not-exists", id);
    }
  }

  private void handleCreateAction(CommandSender sender, String id, String name) {
    if (ChestFactory.existsChest(id)) {
      sendMessage(sender, "lchest-id-already-exists", id);
    } else  {
      final LChest lChest = new LChest(id, name);
      ChestFactory.saveLChest(lChest);
    }
  }

}
