package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import me.hsgamer.bettergui.object.Command;
import me.hsgamer.bettergui.util.BukkitUtils;
import net.kyori.text.Component;
import net.kyori.text.adapter.bukkit.TextAdapter;
import net.kyori.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;

public class LegacyBroadcastActionCommand extends Command {

  public LegacyBroadcastActionCommand(String string) {
    super(string);
  }

  @Override
  public void addToTaskChain(Player player, TaskChain<?> taskChain) {
    Component component = LegacyComponentSerializer.INSTANCE.deserialize(getParsedCommand(player));
    taskChain.sync(() -> TextAdapter.sendActionBar(BukkitUtils.getOnlinePlayers(), component));
  }
}