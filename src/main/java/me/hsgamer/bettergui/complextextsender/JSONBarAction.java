package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.api.action.BaseAction;
import me.hsgamer.bettergui.lib.taskchain.TaskChain;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

import java.util.UUID;

public class JSONBarAction extends BaseAction {

    public JSONBarAction(String string) {
        super(string);
    }

    @Override
    public void addToTaskChain(UUID uuid, TaskChain<?> taskChain) {
        Component component = GsonComponentSerializer.colorDownsamplingGson().deserialize(getReplacedString(uuid));
        taskChain.sync(() -> Main.getBukkitAudiences().player(uuid).sendActionBar(component));
    }
}
