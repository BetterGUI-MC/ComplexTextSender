package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import me.hsgamer.bettergui.util.BukkitUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.entity.Player;

public class JSONActionBarBroadcastCommand extends Command {

  public JSONActionBarBroadcastCommand(String string) {
    super(string);
  }

  @SuppressWarnings("deprecated")
  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    BaseComponent[] component = ComponentSerializer.parse(getParsedCommand(player));
    taskChain.sync(() -> BukkitUtils.getOnlinePlayers()
        .forEach(oPlayer -> oPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR, component)));
  }
}
