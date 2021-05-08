package fr.foacs.mc.lyschest.listener;

import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class ChestOpenListener implements @NotNull Listener {

  public ChestOpenListener() {
    super();
  }

  @EventHandler
  public void onChestOpen(final InventoryOpenEvent event) {
    final InventoryHolder inventoryHolder = event.getInventory().getHolder();
    if (inventoryHolder instanceof Chest || inventoryHolder instanceof DoubleChest) {
      // Todo check chest config
    }
  }

}
