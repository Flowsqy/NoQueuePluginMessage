package fr.flowsqy.noqueuepluginmessage.task;

import fr.flowsqy.noqueuepluginmessage.api.NoQueuePluginMessageAPI;
import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.protocol.PluginMessageWriter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class SendDataTask implements NoQueuePluginMessageAPI {

    private final Plugin plugin;

    public SendDataTask(@NotNull Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void sendPluginMessage(@NotNull Player sender, @NotNull String[] serverNames, @NotNull String channel, byte @NotNull [] data) {
        if (serverNames.length == 0) {
            return;
        }
        final PluginMessageWriter pluginMessageWriter = new PluginMessageWriter();
        sender.sendPluginMessage(plugin, ChannelRegistry.CHANNEL, pluginMessageWriter.write(serverNames, channel, data));
    }

}
