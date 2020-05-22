package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.builder.CommandBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public void onEnable() {
    CommandBuilder.register("json:", JSONCommand.class);
    CommandBuilder.register("json-?broadcast:", JSONBroadcastCommand.class);
    CommandBuilder.register("json-?action:", JSONActionCommand.class);
    CommandBuilder.register("json-?broadcast-?action:", JSONBroadcastActionCommand.class);
    CommandBuilder.register("legacy-?action:", LegacyActionCommand.class);
    CommandBuilder.register("legacy-?broadcast-?action:", LegacyBroadcastActionCommand.class);
  }
}
