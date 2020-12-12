package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.api.action.BaseAction;
import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.UUID;

public class LegacyBroadcastBarAction extends BaseAction {

    public LegacyBroadcastBarAction(String string) {
        super(string);
    }

    @Override
    public void addToTaskChain(UUID uuid, TaskChain<?> taskChain) {
        Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(getReplacedString(uuid));
        taskChain.sync(() -> Main.getBukkitAudiences().players().sendActionBar(component));
    }
}
