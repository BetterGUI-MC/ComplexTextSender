package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.builder.CommandBuilder;
import me.hsgamer.bettergui.object.addon.Addon;

public final class Main extends Addon {

  @Override
  public void onEnable() {
    CommandBuilder.register(JSONCommand::new, "json:");
    CommandBuilder.register(JSONBroadcastCommand::new, "json-?broadcast:");
    CommandBuilder.register(JSONActionCommand::new, "json-?action:");
    CommandBuilder.register(JSONBroadcastActionCommand::new, "json-?broadcast-?action:");
    CommandBuilder.register(LegacyActionCommand::new, "legacy-?action:");
    CommandBuilder.register(LegacyBroadcastActionCommand::new, "legacy-?broadcast-?action:");
  }
}
