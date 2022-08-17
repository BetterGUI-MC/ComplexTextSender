package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.BetterGUI;
import me.hsgamer.bettergui.api.action.BaseAction;
import me.hsgamer.bettergui.builder.ActionBuilder;
import me.hsgamer.hscore.task.BatchRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;

import java.util.UUID;

public class LegacyBroadcastBarAction extends BaseAction {
    protected LegacyBroadcastBarAction(ActionBuilder.Input input) {
        super(input);
    }

    @Override
    public void accept(UUID uuid, BatchRunnable.Process process) {
        Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(getReplacedString(uuid));
        Bukkit.getScheduler().runTask(BetterGUI.getInstance(), () -> {
            Main.getBukkitAudiences().players().sendActionBar(component);
            process.next();
        });
    }
}
