package fr.foacs.mc.lyschest;

import fr.foacs.mc.lyschest.command.LysChestCommandExecutor;
import fr.foacs.mc.lyschest.listener.ChestOpenListener;
import fr.foacs.mc.lyscore.api.LysPlugin;
import org.bukkit.plugin.PluginManager;

import static java.util.Objects.requireNonNull;

public final class Lyschest extends LysPlugin {

  public Lyschest() {
    super("LysChest", true);
  }

  @Override
  public void onEnable() {
    super.onEnable();
    addData("chests");
  }

  @Override
  protected void registerListener(PluginManager pluginManager) {
    pluginManager.registerEvents(new ChestOpenListener(), this);
  }

  @Override
  protected void registerCommands() {
    requireNonNull(this.getCommand(LysChestCommandExecutor.COMMAND_NAME)).setExecutor(new LysChestCommandExecutor(this));
  }
}
