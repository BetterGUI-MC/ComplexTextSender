package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.entity.Player;

public class JSONActionBarCommand extends Command {

  public JSONActionBarCommand(String string) {
    super(string);
  }

  @SuppressWarnings("deprecated")
  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    BaseComponent[] component = ComponentSerializer.parse(getParsedCommand(player));
    taskChain.sync(() -> player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component));
  }
}
