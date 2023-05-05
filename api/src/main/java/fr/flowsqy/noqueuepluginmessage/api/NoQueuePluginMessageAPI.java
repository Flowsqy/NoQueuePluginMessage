package fr.flowsqy.noqueuepluginmessage.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface NoQueuePluginMessageAPI {

    void sendPluginMessage(@NotNull Player sender, @NotNull String[] serverNames, @NotNull String channel, byte @NotNull [] data);

}
