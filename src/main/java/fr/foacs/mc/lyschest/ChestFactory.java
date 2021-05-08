package fr.foacs.mc.lyschest;

import fr.foacs.mc.lyschest.entity.LChest;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class ChestFactory {

  private ChestFactory() {}

  public static Optional<LChest> retrieveLChest(final String id) {
    final Optional<YamlConfiguration> optional =
        Lyschest.getPlugin(Lyschest.class).getData("chests");
    if (optional.isPresent()) {
      final YamlConfiguration chests = optional.get();
      final Object o = chests.get(id);
      if (isNull(o)) {
        return Optional.empty();
      }
      final String name = chests.getString(id + ".name");
      return Optional.of(new LChest(id, name));
    }
    return Optional.empty();
  }

  public static boolean existsChest(final String id) {
    return Lyschest.getPlugin(Lyschest.class).getData("chests")
            .map(chests -> nonNull(chests.get(id)))
            .orElse(false);
  }

  public static LChest retrieveOrCreate(final String id) {
    return retrieveLChest(id).orElse(new LChest(id));
  }

  public static void saveLChest(final LChest lChest) {
    Lyschest.getPlugin(Lyschest.class).getData("chests")
            .ifPresent(chests -> chests.set(lChest.getId() + ".name", chests.getName()));
  }

}
