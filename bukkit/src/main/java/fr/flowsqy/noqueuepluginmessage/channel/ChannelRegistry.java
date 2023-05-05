package fr.flowsqy.noqueuepluginmessage.channel;

import fr.flowsqy.noqueuepluginmessage.listener.ReceiveMessageListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.messaging.Messenger;
import org.jetbrains.annotations.NotNull;

public class ChannelRegistry {

    public final static String CHANNEL = "noqueuepluginchannel:main";

    public void register(@NotNull Plugin plugin) {
        final Messenger messenger = Bukkit.getMessenger();
        messenger.registerIncomingPluginChannel(plugin, CHANNEL, new ReceiveMessageListener());
        messenger.registerOutgoingPluginChannel(plugin, CHANNEL);
    }

    public void unregister(@NotNull Plugin plugin) {
        final Messenger messenger = Bukkit.getMessenger();
        messenger.unregisterIncomingPluginChannel(plugin, CHANNEL);
        messenger.unregisterOutgoingPluginChannel(plugin, CHANNEL);
    }

}
