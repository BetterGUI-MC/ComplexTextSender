package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import me.hsgamer.bettergui.util.BukkitUtils;
import net.kyori.text.Component;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.entity.Player;

public class JSONBroadcastActionCommand extends Command {

  public JSONBroadcastActionCommand(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    Component component = GsonComponentSerializer.INSTANCE.deserialize(getParsedCommand(player));
    taskChain.sync(() -> TextAdapter.sendActionBar(BukkitUtils.getOnlinePlayers(), component));
  }
}
