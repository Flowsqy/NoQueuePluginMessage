package fr.flowsqy.noqueuepluginmessage;

import fr.flowsqy.noqueuepluginmessage.api.NoQueuePluginMessage;
import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.task.SendDataTask;
import org.bukkit.plugin.java.JavaPlugin;

public class NoQueuePluginMessagePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ChannelRegistry channelRegistry = new ChannelRegistry();
        channelRegistry.register(this);

        NoQueuePluginMessage.setInstance(new SendDataTask(this));
    }

    @Override
    public void onDisable() {
        final ChannelRegistry channelRegistry = new ChannelRegistry();
        channelRegistry.unregister(this);
    }
}
