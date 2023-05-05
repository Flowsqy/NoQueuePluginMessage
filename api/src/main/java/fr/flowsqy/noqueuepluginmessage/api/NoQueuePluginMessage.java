package fr.flowsqy.noqueuepluginmessage.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NoQueuePluginMessage {

    private static NoQueuePluginMessageAPI instance;

    private NoQueuePluginMessage() {
    }

    @NotNull
    public static NoQueuePluginMessageAPI getInstance() {
        if (instance == null) {
            throw new IllegalStateException("NoQueuePluginMessageAPI instance is not set");
        }
        return instance;
    }

    public static void setInstance(@NotNull NoQueuePluginMessageAPI instance) {
        if (NoQueuePluginMessage.instance != null) {
            throw new IllegalStateException("NoQueuePluginMessageAPI instance is already set");
        }
        NoQueuePluginMessage.instance = instance;
    }

    public static void sendPluginMessage(@NotNull Player sender, @NotNull String[] serverNames, @NotNull String channel, byte @NotNull [] data) {
        instance.sendPluginMessage(sender, serverNames, channel, data);
    }

}
