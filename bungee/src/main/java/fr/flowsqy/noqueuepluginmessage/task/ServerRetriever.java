package fr.flowsqy.noqueuepluginmessage.task;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerRetriever {

    @NotNull
    public List<ServerInfo> getServers(@NotNull String[] serverNames) {
        final List<ServerInfo> servers = new LinkedList<>();
        final Map<String, ServerInfo> serverInfoMap = ProxyServer.getInstance().getServers();
        for (String serverName : serverNames) {
            final ServerInfo serverInfo = serverInfoMap.get(serverName);
            if (serverInfo == null) {
                continue;
            }
            servers.add(serverInfo);
        }
        return servers;
    }

}
