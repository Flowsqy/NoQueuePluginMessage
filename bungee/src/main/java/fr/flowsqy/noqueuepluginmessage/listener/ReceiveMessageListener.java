package fr.flowsqy.noqueuepluginmessage.listener;

import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.protocol.PluginMessageReader;
import fr.flowsqy.noqueuepluginmessage.protocol.SentData;
import fr.flowsqy.noqueuepluginmessage.task.SendDataTask;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ReceiveMessageListener implements Listener {

    @SuppressWarnings("unused")
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPluginMessageReceived(PluginMessageEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!ChannelRegistry.CHANNEL.equals(event.getTag())) {
            return;
        }
        event.setCancelled(true);
        final PluginMessageReader reader = new PluginMessageReader();
        final SentData sentData = reader.read(event.getData());
        final SendDataTask sendDataTask = new SendDataTask();
        sendDataTask.send(sentData);
    }

}
