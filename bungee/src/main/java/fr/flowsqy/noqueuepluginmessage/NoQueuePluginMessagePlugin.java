package fr.flowsqy.noqueuepluginmessage;

import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.listener.ReceiveMessageListener;
import net.md_5.bungee.api.plugin.Plugin;

@SuppressWarnings("unused")
public class NoQueuePluginMessagePlugin extends Plugin {

    @Override
    public void onEnable() {
        final ChannelRegistry channelRegistry = new ChannelRegistry();
        channelRegistry.register();

        getProxy().getPluginManager().registerListener(this, new ReceiveMessageListener());
    }

    @Override
    public void onDisable() {
        final ChannelRegistry channelRegistry = new ChannelRegistry();
        channelRegistry.unregister();
    }

}
