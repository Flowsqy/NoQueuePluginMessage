package fr.flowsqy.noqueuepluginmessage.task;

import fr.flowsqy.noqueuepluginmessage.channel.ChannelRegistry;
import fr.flowsqy.noqueuepluginmessage.protocol.PluginMessageWriter;
import fr.flowsqy.noqueuepluginmessage.protocol.SentData;
import net.md_5.bungee.api.config.ServerInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SendDataTask {

    public void send(@NotNull SentData sentData) {
        final ServerRetriever serverRetriever = new ServerRetriever();
        final List<ServerInfo> servers = serverRetriever.getServers(sentData.serverNames());
        if (servers.isEmpty()) {
            return;
        }
        final PluginMessageWriter messageWriter = new PluginMessageWriter();
        final byte[] messageData = messageWriter.write(sentData.channel(), sentData.data());
        for (ServerInfo server : servers) {
            server.sendData(ChannelRegistry.CHANNEL, messageData, false);
        }
    }

}
