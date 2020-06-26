package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import net.kyori.text.Component;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class JSONBroadcastCommand extends Command {

  public JSONBroadcastCommand(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    Component component = GsonComponentSerializer.INSTANCE.deserialize(getParsedCommand(player));
    taskChain.sync(() -> TextAdapter.sendMessage(Bukkit.getOnlinePlayers(), component));
  }
}
