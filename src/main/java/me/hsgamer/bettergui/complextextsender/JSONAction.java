package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.BetterGUI;
import me.hsgamer.bettergui.api.action.BaseAction;
import me.hsgamer.bettergui.builder.ActionBuilder;
import me.hsgamer.hscore.task.BatchRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.Bukkit;

import java.util.UUID;

public class JSONAction extends BaseAction {
    protected JSONAction(ActionBuilder.Input input) {
        super(input);
    }

    @Override
    public void accept(UUID uuid, BatchRunnable.Process process) {
        Component component = GsonComponentSerializer.colorDownsamplingGson().deserialize(getReplacedString(uuid));
        Bukkit.getScheduler().runTask(BetterGUI.getInstance(), () -> {
            Main.getBukkitAudiences().player(uuid).sendMessage(component);
            process.next();
        });
    }
}
