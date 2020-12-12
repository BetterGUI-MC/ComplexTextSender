package me.hsgamer.bettergui.complextextsender;

import me.hsgamer.bettergui.api.addon.BetterGUIAddon;
import me.hsgamer.bettergui.builder.ActionBuilder;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;

public final class Main extends BetterGUIAddon {
    private static BukkitAudiences bukkitAudiences;

    public static BukkitAudiences getBukkitAudiences() {
        return bukkitAudiences;
    }

    @Override
    public boolean onLoad() {
        bukkitAudiences = BukkitAudiences.create(getPlugin());
        return true;
    }

    @Override
    public void onEnable() {
        ActionBuilder.INSTANCE.register(JSONAction::new, "json");
        ActionBuilder.INSTANCE.register(JSONBroadcastAction::new, "json-broadcast", "jsonbroadcast");
        ActionBuilder.INSTANCE.register(JSONBarAction::new, "json-action", "jsonaction");
        ActionBuilder.INSTANCE.register(JSONBroadcastBarAction::new, "json-broadcast-action");
        ActionBuilder.INSTANCE.register(LegacyBarAction::new, "legacy-action", "legacyaction");
        ActionBuilder.INSTANCE.register(LegacyBroadcastBarAction::new, "legacy-broadcast-action");
    }
}
