package fr.flowsqy.noqueuepluginmessage.channel;

import net.md_5.bungee.api.ProxyServer;

public class ChannelRegistry {

    public final static String CHANNEL = "noqueuepluginchannel:main";

    public void register() {
        ProxyServer.getInstance().registerChannel(CHANNEL);
    }

    public void unregister() {
        ProxyServer.getInstance().unregisterChannel(CHANNEL);
    }

}
