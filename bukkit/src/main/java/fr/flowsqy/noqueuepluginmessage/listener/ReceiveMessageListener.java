package fr.flowsqy.noqueuepluginmessage.listener;

import fr.flowsqy.noqueuepluginmessage.api.event.DataReceiveEvent;
import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.protocol.PluginMessageReader;
import fr.flowsqy.noqueuepluginmessage.protocol.SentData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public class ReceiveMessageListener implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, byte @NotNull [] message) {
        if (!ChannelRegistry.CHANNEL.equals(channel)) {
            return;
        }
        final PluginMessageReader reader = new PluginMessageReader();
        final SentData sentData = reader.read(message);
        Bukkit.getPluginManager().callEvent(new DataReceiveEvent(Bukkit.isPrimaryThread(), player, sentData.channel(), sentData.data()));
    }

}
