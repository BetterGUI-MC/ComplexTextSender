package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import me.hsgamer.bettergui.util.BukkitUtils;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import org.bukkit.entity.Player;

public class JSONBroadcastCommand extends Command {

  public JSONBroadcastCommand(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    BaseComponent[] component = ComponentSerializer.parse(getParsedCommand(player));
    taskChain.sync(() -> BukkitUtils.getOnlinePlayers()
        .forEach(oPlayer -> oPlayer.spigot().sendMessage(component)));
  }
}
