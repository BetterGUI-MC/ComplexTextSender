package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.builder.CommandBuilder;
import me.hsgamer.bettergui.object.addon.Addon;
import me.hsgamer.bettergui.util.BukkitUtils;

public final class Main extends Addon {

  @Override
  public boolean onLoad() {
    if (!BukkitUtils.isSpigot()) {
      getPlugin().getLogger().warning("This server is not an Spigot server. Disabled");
      return false;
    }
    return true;
  }

  @Override
  public void onEnable() {
    CommandBuilder.register("json:", JSONCommand.class);
    CommandBuilder.register("json-?broadcast:", JSONBroadcastCommand.class);
    CommandBuilder.register("json-?action", JSONActionBarCommand.class);
    CommandBuilder.register("json-?action-?broadcast", JSONActionBarBroadcastCommand.class);
    CommandBuilder.register("json-?broadcast-?action", JSONActionBarBroadcastCommand.class);
  }
}
